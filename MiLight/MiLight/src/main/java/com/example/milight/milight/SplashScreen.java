package com.example.milight.milight;

import com.example.milight.milight.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 4 seconds
                    sleep(4*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),MainScreen.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
