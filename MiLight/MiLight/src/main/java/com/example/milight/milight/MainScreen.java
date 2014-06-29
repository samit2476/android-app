package com.example.milight.milight;

import com.example.milight.milight.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainScreen extends Activity {

    private static float values[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        ImageView screen = (ImageView) findViewById(R.id.screen);
        final ImageView glow = (ImageView) findViewById(R.id.glow);

        screen.setOnTouchListener(new View.OnTouchListener() {
            @Override //visibility of glow image
            public boolean onTouch(View v, MotionEvent event) {
                glow.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        glow.setVisibility(View.INVISIBLE);
                    }
                }, 20);

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    values[0] = event.getX();

                }

                return true;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
