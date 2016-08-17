package com.tybrady.charlesyoung.tappydefender;

/**
 * Created by Charles Young on 8/15/2016.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TDView extends SurfaceView implements Runnable  {
    volatile boolean playing;
    Thread gameThread = null;

    //Game Objects
    private PlayerShip player;

    //For drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    public TDView(Context context) {

        super(context);

        //Initialize our drawing objects
        ourHolder = getHolder();
        paint = new Paint();

        //Initialize our player ship
        player = new PlayerShip(context);
    }

    @Override
    public void run() {
        while (playing){
            update();
            draw();
            control();
        }
    }

    private void update() {
        //Update the player
        player.upadate();
    }

    private void draw() {
        if (ourHolder.getSurface().isValid()) {

            //First we lock the area of memory we will be drawing
            canvas = ourHolder.lockCanvas();

            //Rub ou the last frame
            canvas.drawColor(Color.argb(255,0,0,0));

            //Draw the player
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);

            //unlock and draw the scene
            ourHolder  .unlockCanvasAndPost(canvas);

        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {

        }
    }

    //Clean up our thread if the game is interrupted or the player quits
    public void pause() {
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){

        }
    }

    //Make a new thread and start it
    //Execution moves to R
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


}





