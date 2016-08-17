package com.tybrady.charlesyoung.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Charles Young on 8/16/2016.
 */
public class PlayerShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;

    //Constructor
    public PlayerShip (Context context) {
        x = 50;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
    }

    public void upadate() {
        x++;
    }

    //Getters
    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX () {
        return x;
    }

    public int getY() {
        return y;
    }

}
