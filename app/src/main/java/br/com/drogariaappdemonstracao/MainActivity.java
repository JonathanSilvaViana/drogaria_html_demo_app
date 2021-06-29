package br.com.drogariaappdemonstracao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    final static int SPLASH_TIME_OUT = 2665;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent saidasplashscreen = new Intent(MainActivity.this,
                                                  NavegadorLocalActivity.class );
                                          startActivity(saidasplashscreen);
                                          finish();
                                      }
                                  },
                //encerra o tempo de exibição
                SPLASH_TIME_OUT);
    }
}