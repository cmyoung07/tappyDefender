package com.tybrady.charlesyoung.tappydefender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    //this is the entry point to our game
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Here  we set our UI layout as the view
        setContentView(R.layout.activity_main);

        //Get a reference to the button in our layout
        final Button buttonPLay =
                (Button) findViewById(R.id.buttonPlay);

        //Listen for click
        buttonPLay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //must be the Play button
        //Create a new intent object
        Intent i = new Intent(this, GameActivity.class);
        //Start our GaqmeActivity class via the intent
        startActivity(i);
        //now shut thus activity down
        finish();

    }
}