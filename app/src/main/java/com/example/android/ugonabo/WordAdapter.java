package com.example.android.ugonabo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 6/11/2019.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    int colorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int color)
    {
        super(context, 0, words);
        this.colorResourceId = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        TextView igbo_text_view = (TextView) listItem.findViewById(R.id.igbo_text_view);
        igbo_text_view.setText(currentWord.getIgboTranslation());

        TextView english_text_view = (TextView) listItem.findViewById(R.id.english_text_view);
        english_text_view.setText(currentWord.getEnglishTranslation());

        View textContainer = listItem.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        ImageView visual_image_view = (ImageView) listItem.findViewById(R.id.visual_image);

        if (currentWord.hasImage()) {
            visual_image_view.setImageResource(currentWord.getImageResourceId());
            visual_image_view.setVisibility(View.VISIBLE);
        }
        else {
            visual_image_view.setVisibility(View.GONE);
        }



        return listItem;
    }
}
