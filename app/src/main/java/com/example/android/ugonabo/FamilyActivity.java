package com.example.android.ugonabo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FamilyActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FamilyFragment()).commit();
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.word_list);
//
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("Father", "Nna", R.drawable.family_father, R.raw.family_father));
//        words.add(new Word("Mother", "Nne", R.drawable.family_mother, R.raw.family_mother));
//        words.add(new Word("Son", "nwa nwoke", R.drawable.family_son, R.raw.family_son));
//        words.add(new Word("Daughter", "nwa nwanyi", R.drawable.family_daughter, R.raw.family_daughter));
//        words.add(new Word("Brother", "nwanne nwoke", R.drawable.family_older_brother, R.raw.family_older_brother));
//        words.add(new Word("Sister", "nwanne nwanyi", R.drawable.family_older_sister, R.raw.family_older_sister));
//        words.add(new Word("Younger Brother", "nwanne nwoke nta", R.drawable.family_younger_brother, R.raw.family_younger_brother));
//        words.add(new Word("Husband", "di", R.drawable.family_grandfather, R.raw.family_grandfather));
//        words.add(new Word("Wife", "nwunye", R.drawable.family_grandmother, R.raw.family_grandmother));
//        words.add(new Word("Uncle", "dede", R.drawable.family_younger_sister, R.raw.family_younger_sister));
//
//        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
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
//                    mp = MediaPlayer.create(FamilyActivity.this, sd);
//                    mp.start();
//                    mp.setOnCompletionListener(completionListener);
//                    //Toast.makeText(NumbersActivity.this, "hi", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }


}
