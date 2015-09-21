package com.example.shuang.slideview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar;
    private int originprogress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.seekbar);
//        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, false);
//        seekBar.setThumb(new BitmapDrawable(newBitmap));
//        seekBar.setClickable(false);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        seekBar.setProgress(0);
        originprogress = 0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (fromUser) {
            if (progress - originprogress >= 30) {
                seekBar.setProgress(0);
            }else{
                originprogress = progress;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getProgress() < 80) {//判断小于80的不算unlock操作
            seekBar.setProgress(0);
            originprogress = 0;
        } else {
            seekBar.setProgress(100);
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivityForResult(intent, 111);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(MainActivity.this, "requestCode" + requestCode + "resultCode" + resultCode, Toast.LENGTH_SHORT).show();
    }


}
