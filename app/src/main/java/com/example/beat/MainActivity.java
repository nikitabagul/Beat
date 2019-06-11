package com.example.beat;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    SoundPool soundPool;
    MediaPlayer mediaPlayer;
    MediaPlayer player;
    int explode = 0;//
    Random crazy = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //commenting it disconnect the activity.xml and gives error to this in next statements.To solve the error click on this then on red bulb and select the Make option press OK
        //you will get 3 overridden methods
        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic);
        mediaPlayer.start();
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);//maxStream -how many times it should run
        explode = soundPool.load(this,R.raw.explosion,1);//if another sound is playing then priority is checked and accordingly sound is played
        player=MediaPlayer.create(this,R.raw.soundtrack);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(256),crazy.nextInt(246)));
    }

    @Override
    public void onClick(View v) {

        if(explode!=0)
        {
            soundPool.play(explode,1,1,0,0,1);
        }

    }

    @Override
    public boolean onLongClick(View v) {
        mediaPlayer.stop();
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        v.setBackgroundColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(256),crazy.nextInt(246)));
        player.start();
        return true;
    }
}
