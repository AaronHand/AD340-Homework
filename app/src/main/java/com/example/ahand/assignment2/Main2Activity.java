package com.example.ahand.assignment2;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends Activity {

    TextView textView;
    final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView = (TextView) findViewById(R.id.textView2);

        textView.setText(getIntent().getStringExtra("editText value"));

        log("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }
    

    private void log(String lifecycleEvent){
        Log.i(TAG, lifecycleEvent);
    }
}
