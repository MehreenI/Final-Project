package com.example.bookmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_main);


    }


    public void home(View view){

    }
    public void academic(View view){
        Intent intent = new Intent(this,AcademicActivity.class);
        startActivity(intent);
    }
    public void general(View view){

    }

}