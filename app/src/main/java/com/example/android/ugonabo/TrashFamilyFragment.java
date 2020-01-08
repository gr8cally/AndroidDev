package com.example.android.ugonabo;

import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 6/22/2019.
 */

public class TrashFamilyFragment extends Fragment {
    MediaPlayer mp;
    private AudioManager audioManager;

    public TrashFamilyFragment() {
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        //setContentView(R.layout.word_list);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);



        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "Nna", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother", "Nne", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Son", "nwa nwoke", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Daughter", "nwa nwanyi", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Brother", "nwanne nwoke", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Sister", "nwanne nwanyi", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Younger Brother", "nwanne nwoke nta", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Husband", "di", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Wife", "nwunye", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Uncle", "dede", R.drawable.family_younger_sister, R.raw.family_younger_sister));
//

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_family);
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
