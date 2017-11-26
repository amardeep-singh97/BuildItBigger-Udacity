package com.example.android.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        boolean free = intent.getExtras().getBoolean("free");
        Log.v("Display","We are at display Activity");
        if(free){
            AdView adView = (AdView)findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("BDFAA0387B162131955540E2F8341B68")
                    .build();
            adView.loadAd(adRequest);
        }
        String joke = intent.getExtras().getString("joke");
        TextView textView = (TextView) findViewById(R.id.jokeTest);
        if(joke==null){
            textView.setText(R.string.no_joke_found);
        }else {
            textView.setText(joke);
        }
    }
}
