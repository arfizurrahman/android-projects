package com.example.arfiz.mythings;

import android.app.Activity;
import android.app.LauncherActivity;
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
import java.util.List;

public class MyThingAdapter extends ArrayAdapter<MyThing> {

    public MyThingAdapter(@NonNull Activity context, List<MyThing> thingList) {
        super(context, 0, thingList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent,false);
        }

        MyThing currentThing = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.thing_name);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.thing_added_on_date);
        TextView categoryTextView = (TextView) listItemView.findViewById(R.id.thing_category);
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);



        int cT = Integer.valueOf(currentThing.getId());
        nameTextView.setText(currentThing.getThing_name());
        nameTextView.setTag(Integer.valueOf(currentThing.getId()));
        dateTextView.setText(currentThing.getDate());
        categoryTextView.setText(currentThing.getThing_category());
        iconView.setImageResource(currentThing.getmImageResourceId());

        return listItemView;
    }
}
