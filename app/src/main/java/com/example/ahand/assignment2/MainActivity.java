package com.example.ahand.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    String editTextData;

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main2Activity.class);

        editTextData = (!editText.getText().toString().equals("Enter Text"))?editText.getText().toString():"Nothing was entered";

        intent.putExtra("editText value",editTextData);
        startActivity(intent);

    }
}
