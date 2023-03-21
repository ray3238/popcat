package com.example.ray3238;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ConcurrentModificationException;

public class MainActivity extends AppCompatActivity {

    ImageView popcat;
    TextView raieso;
    Button catbutton;

    SoundPool sq;
    int popSoundId;

    Vibrator AB;
    long count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popcat = findViewById(R.id.popcat);
        raieso = findViewById(R.id.raieso);
        catbutton = findViewById(R.id.catbutton);

        sq = new SoundPool.Builder().build();
        popSoundId = sq.load(this, R.raw.cat_sound, 1);

        AB = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        popcat.setOnTouchListener((v, e) -> {
            switch(e.getAction()) {
                case (MotionEvent.ACTION_UP):
                    popcat.setImageResource(R.drawable.cat_close);

                    return true;
                    case(MotionEvent.ACTION_DOWN):
                        popcat.setImageResource(R.drawable.cat_open);
                        sq.play(popSoundId, 1f,1f,
                                0,0,1f );

                        AB.vibrate(50);

                        count++;
                        raieso.setText(String.valueOf(count));
                        return true;
            }

            return false;
        });

        catbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                raieso.setText(String.valueOf(count));
            }
        });


    }
}