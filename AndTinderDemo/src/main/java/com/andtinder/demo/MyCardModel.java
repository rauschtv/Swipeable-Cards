package com.andtinder.demo;

import android.graphics.drawable.Drawable;

import com.andtinder.model.CardModel;

public class MyCardModel extends CardModel {
    private String myValue = null;

    public MyCardModel(){
        super();
    }

    public MyCardModel(String title, String description, String myValue, Drawable cardImage) {
        super(title,description,cardImage);
        this.myValue = myValue;
    }

    public void setMyValue(String myValue){
        this.myValue = myValue;
    }

    public String getMyValue(){
        return this.myValue;
    }
}
