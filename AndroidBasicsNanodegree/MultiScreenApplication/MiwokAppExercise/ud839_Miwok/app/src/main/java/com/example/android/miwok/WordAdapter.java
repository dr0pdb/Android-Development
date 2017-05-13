package com.example.android.miwok;

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

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceid;
    public WordAdapter(Context context , ArrayList<Word> words, int colorResourceid){
        super(context,0,words);
        this.colorResourceid=colorResourceid;
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

        TextView miokview = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miokview.setText(currentWord.getMioktranslation());

        TextView defView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defView.setText(currentWord.getDefaulttranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageresourceid());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),colorResourceid);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
