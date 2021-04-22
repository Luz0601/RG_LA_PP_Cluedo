package com.example.rg_la_pp_cluedo;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class ActivityPerder extends AppCompatActivity {

    private SoundPool sp;
    int sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perder);

        //Reproducimos el audio aplausos
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            sp = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            sp= new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
        sonido = sp.load(this, R.raw.trompeta_militar, 1);
        sonido();

        //Si pulsa el boton Back le llevará al ActivityMain
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent inicio = new Intent(ActivityPerder.this, ActivityMain.class);
                startActivity(inicio);
            }
        };
        getOnBackPressedDispatcher().addCallback(callback);
    }

    private void sonido() {
        sp.play(sonido, 1, 1, 1, 0, 0);
    }

    public void tapScreen(View view) {
        //sp.release();
        //sp = null;
        //sonido();
        Intent inicio = new Intent(this, ActivityMain.class);
        startActivity(inicio);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sp.release();
        sp = null;
    }
}