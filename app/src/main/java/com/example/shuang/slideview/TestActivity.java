package com.example.shuang.slideview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class TestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    public void onClick(View view) {
        Intent intent = new Intent(TestActivity.this,MainActivity.class);
        this.setResult(123456,intent);
        finish();
    }
}
