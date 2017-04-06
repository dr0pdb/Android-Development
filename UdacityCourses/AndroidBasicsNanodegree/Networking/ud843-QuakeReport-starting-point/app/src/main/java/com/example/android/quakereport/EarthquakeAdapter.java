package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;

        if (listitemview == null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listitemview.findViewById(R.id.tv_magnitude);
        magnitude.setText(currentEarthquake.getMagnitude());

        TextView location = (TextView) listitemview.findViewById(R.id.tv_location);
        location.setText(currentEarthquake.getLocation());

        TextView date = (TextView) listitemview.findViewById(R.id.tv_date);
        date.setText(currentEarthquake.getDate());

        return listitemview;
    }
}
