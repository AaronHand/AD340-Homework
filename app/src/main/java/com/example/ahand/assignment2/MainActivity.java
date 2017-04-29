package com.example.ahand.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{


    Button btnTL, btnTR, btnBL, btnBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTL = (Button) findViewById(R.id.btnTL);
        btnTR = (Button) findViewById(R.id.btnTR);
        btnBL = (Button) findViewById(R.id.btnBL);
        btnBR = (Button) findViewById(R.id.btnBR);

        btnTL.setOnClickListener(this);
        btnTR.setOnClickListener(this);
        btnBL.setOnClickListener(this);
        btnBR.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if(btn.getId() == R.id.btnTL){
            Intent intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);

        }else {
            makeToast(btn.getText().toString());
        }
    }

    private void makeToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
