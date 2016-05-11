package com.andtinder.demo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andtinder.view.CardStackAdapter;

public class MySimpleCardStackAdapter extends CardStackAdapter<MyCardModel>{

    public MySimpleCardStackAdapter(Context context) {
        super(context);
    }

    @Override
    protected View getCardView(int position, MyCardModel model, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(com.andtinder.R.layout.std_card_inner, parent, false);
            assert convertView != null;
        }

        ((ImageView) convertView.findViewById(com.andtinder.R.id.image)).setImageDrawable(model.getCardImageDrawable());
        ((TextView) convertView.findViewById(com.andtinder.R.id.title)).setText(model.getTitle());
        ((TextView) convertView.findViewById(com.andtinder.R.id.description)).setText(model.getMyValue());

        return convertView;
    }


}
