package com.example.laundryku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickInput(View view){
        Intent i = new Intent(MainActivity.this, input_data.class);
        startActivity(i);
    }
    public void clickStock(View view){
        Intent i = new Intent(MainActivity.this, tampilData.class);
        startActivity(i);
    }
}