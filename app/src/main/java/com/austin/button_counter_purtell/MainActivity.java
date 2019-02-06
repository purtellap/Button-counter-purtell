package com.austin.button_counter_purtell;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {

    private int num = 0;
    private TextView counter;

    private final int[] colors = new int[] {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
    private MediaPlayer wack = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wack = MediaPlayer.create(this, R.raw.wack);
        counter = (TextView) findViewById(R.id.counter);
        counter.setText(String.valueOf(num));
        counter.setTextColor(colors[0]);
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNum(v);
            }
        });
        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(v);
            }
        });
        Button sub = (Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subNum(v);
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("numKey", num);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);

        num = bundle.getInt("numKey");
        counter.setText(String.valueOf(num));
        counter.setTextColor(colors[abs(num%colors.length)]);

    }

    public void addNum (View view) {
        num++;
        counter.setText(String.valueOf(num));
        wowFactor();
    }

    public void subNum(View view){
        num--;
        counter.setText(String.valueOf(num));
        wowFactor();
    }

    public void resetNum(View view){
        num = 0;
        counter.setText(String.valueOf(num));
        wowFactor();
    }

    private void wowFactor(){
        counter.setTextColor(colors[abs(num%colors.length)]);
        wack.start();
    }

}
