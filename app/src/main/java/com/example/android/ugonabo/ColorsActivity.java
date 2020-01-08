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

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ColorsFragment())
                .commit();
    }
}

//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("Black", "oji", R.drawable.color_black, R.raw.color_black));
//        words.add(new Word("Blue", "amaloji", R.drawable.color_black, R.raw.color_black));
//        words.add(new Word("Brown", "uri", R.drawable.color_brown, R.raw.color_brown));
//        words.add(new Word("Green", "ndu-ndu", R.drawable.color_green, R.raw.color_green));
//        words.add(new Word("Gray", "ntu-ntu", R.drawable.color_gray, R.raw.color_gray));
//        words.add(new Word("Yellow", "edo", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
//        words.add(new Word("Pink", "uhie ocha", R.drawable.color_red, R.raw.color_red));
//        words.add(new Word("Red", "mme mme", R.drawable.color_red, R.raw.color_red));
//        words.add(new Word("White", "ocha", R.drawable.color_white, R.raw.color_white));
//        words.add(new Word("Purple", "ododo", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
//
//        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
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
//                    mp = MediaPlayer.create(ColorsActivity.this, sd);
//                    mp.start();
//                    mp.setOnCompletionListener(completionListener);
//                    //Toast.makeText(NumbersActivity.this, "hi", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//
//}
