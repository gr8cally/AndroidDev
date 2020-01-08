package com.example.android.ugonabo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        UgonaboPagerAdapter adapter = new UgonaboPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

//        // Find view that shoes the number category
//        TextView numbersView = (TextView) findViewById(R.id.numbers);
//
//        //Set a click listener on that view
//        numbersView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openNumbersList(v);
//            }
//        });
//
//        TextView familyView = (TextView) findViewById(R.id.family);
//        familyView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openFamilyList(v);
//            }
//        });
//
//        TextView colorsView = (TextView) findViewById(R.id.colors);
//        colorsView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openColorsList(v);
//            }
//        });
//
//        TextView phrasesView = (TextView) findViewById(R.id.phrases);
//        phrasesView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPhrasesList(v);
//
//            }
//        });
//    }
//    public void openNumbersList(View view){
//        Intent intent = new Intent(this, NumbersActivity.class);
//        startActivity(intent);
//    }
//    public void openFamilyList(View view){
//        Intent intent = new Intent(this, FamilyActivity.class);
//        startActivity(intent);
//    }
//    public void openColorsList(View view){
//        Intent intent = new Intent(this, ColorsActivity.class);
//        startActivity(intent);
//    }
//    public void openPhrasesList(View view){
//        Intent intent = new Intent(this, PhrasesActivity.class);
//        startActivity(intent);
//    }

}
