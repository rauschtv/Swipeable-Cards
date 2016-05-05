/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 *
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 *
 * AndTinder is compatible with API Level 13 and upwards
 *
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends Activity {

    private CardContainer mCardContainer;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainlayout);

		/*
      This variable is the container that will host our cards
     */
        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
		Resources r = getResources();
		SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1, null)));
			adapter.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2, null)));
			adapter.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3, null)));
			adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1, null)));
		}

        mCardContainer.setOnCardstackEmptyListener(new CardContainer.OnCardstackEmptyListener() {

            @Override
            public void OnEmpty(Object obj){
                CardModel cm = (CardModel) obj;
                Log.i("Swipeable Cards", "This was the last card. Do something!");
                Log.i("Swipeable Cards", "Last card's title: " + cm.getTitle());
            }
        });

        mCardContainer.setOnClickListener(new CardContainer.OnClickListener() {
           @Override
           public void OnClick(Object cm) {
               Log.i("Swipeable Cards","I am pressing the card");
           }
        });

        mCardContainer.setOnCardDismissedListener(new CardContainer.OnCardDismissedListener() {
            @Override
            public void onLike(Object cm) {
                Log.i("Swipeable Cards","I like the card");
            }

            @Override
            public void onDislike(Object cm) {
                Log.i("Swipeable Cards","I dislike the card");
            }
        });

		mCardContainer.setAdapter(adapter);
	}
}
