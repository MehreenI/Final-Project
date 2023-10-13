package com.example.bookmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class AcademicActivity extends AppCompatActivity {

    ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        String[] schoolNames = {"School 1", "School 2", "School 3","School 4","School 5","School 6","School 7","School 8","School 9","School 10"}; // Replace with your data
        lw = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_school_list,schoolNames);
        lw.setAdapter(adapter);
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
