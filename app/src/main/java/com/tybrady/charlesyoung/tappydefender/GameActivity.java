package com.tybrady.charlesyoung.tappydefender;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {

    //Our object to handle the view
    private TDView gameView;

    //This is where the "play" button frmo HomeActivity sends us
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create an instance of our Tappy Defender View (TDView)
        //Also passing in "this" which is the Context of our app
        gameView = new TDView(this);

        //Make our gameView the view for the Activity
        setContentView(gameView);
    }


    //iF Activity is paused make sure to pause our thread
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    //If the Actiivty is resumed make sure to resume our thread
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}
