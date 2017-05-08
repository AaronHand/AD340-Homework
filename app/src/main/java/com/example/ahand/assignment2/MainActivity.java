package com.example.ahand.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnTL, btnTR, btnBL, btnBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_info:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
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
