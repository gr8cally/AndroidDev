package com.example.android.ugonabo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PhrasesFragment())
                .commit();
    }
}
//
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("How are you?", "Kedu ka i mere", R.raw.phrase_where_are_you_going));
//        words.add(new Word("two", "abuo", R.raw.phrase_what_is_your_name));
//        words.add(new Word("three", "Ato", R.raw.phrase_my_name_is));
//        words.add(new Word("four", "Ano", R.raw.phrase_how_are_you_feeling));
//        words.add(new Word("five", "Ise", R.raw.phrase_im_feeling_good));
//        words.add(new Word("six", "Isii", R.raw.phrase_are_you_coming));
//        words.add(new Word("seven", "Asaa", R.raw.phrase_yes_im_coming));
//        words.add(new Word("eight", "Asato", R.raw.phrase_come_here));
//        words.add(new Word("nine", "Itoolu", R.raw.phrase_im_coming));
//        words.add(new Word("ten", "Iri", R.raw.phrase_lets_go));
//
//        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
//        ListView listView = (ListView) findViewById(R.id.root_view);
//        listView.setAdapter(itemsAdapter);
//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Word currentWord = words.get(position);
//                int sd =currentWord.getSoundResourceId();
//                releaseMediaPlayer();
//                int result = audioManager.requestAudioFocus(MonAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
//                    //When we recieve audio focus
//                    mp = MediaPlayer.create(PhrasesActivity.this, sd);
//                    mp.start();
//                    mp.setOnCompletionListener(completionListener);
//                    //Toast.makeText(NumbersActivity.this, "hi", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }
//
//
//}
