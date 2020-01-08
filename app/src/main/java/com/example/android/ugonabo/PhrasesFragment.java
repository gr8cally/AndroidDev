package com.example.android.ugonabo;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {
    MediaPlayer mp;
    private AudioManager audioManager;


    public PhrasesFragment() {
        // Required empty public constructor
    }

    AudioManager.OnAudioFocusChangeListener MonAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                //When we lose focus for a little amount of time(Shortly)
                mp.pause();
                mp.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                // When we regain focus and can resume playback
                mp.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                // When we permanently lose audio focus
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public void releaseMediaPlayer(){
        if(mp != null){
            mp.release();
            mp = null;
            audioManager.abandonAudioFocus(MonAudioFocusChange);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        //setContentView(R.layout.word_list);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);



        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("How are you?", "Kedu ka i mere", R.raw.phrase_where_are_you_going));
        words.add(new Word("two", "abuo", R.raw.phrase_what_is_your_name));
        words.add(new Word("three", "Ato", R.raw.phrase_my_name_is));
        words.add(new Word("four", "Ano", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("five", "Ise", R.raw.phrase_im_feeling_good));
        words.add(new Word("six", "Isii", R.raw.phrase_are_you_coming));
        words.add(new Word("seven", "Asaa", R.raw.phrase_yes_im_coming));
        words.add(new Word("eight", "Asato", R.raw.phrase_come_here));
        words.add(new Word("nine", "Itoolu", R.raw.phrase_im_coming));
        words.add(new Word("ten", "Iri", R.raw.phrase_lets_go));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.root_view);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = words.get(position);
                int sd =currentWord.getSoundResourceId();
                releaseMediaPlayer();

                //int result = audioManager.requestAudioFocus(xxy, STREAM)
                int result = audioManager.requestAudioFocus(MonAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //When we recieve audio focus
                    mp = MediaPlayer.create(getActivity(), sd);
                    mp.start();
                    mp.setOnCompletionListener(completionListener);
                }
            }

        });

        return rootView;}

}
