package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context , ArrayList<Word> words){
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent,false);
        }

        Word currentWord = getItem(position);

        TextView miokview = (TextView) listItemView.findViewById(R.id.tv_miwok_word);
        miokview.setText(currentWord.getMioktranslation());

        TextView defView = (TextView) listItemView.findViewById(R.id.tv_default_word);
        defView.setText(currentWord.getDefaulttranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageresourceid());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
