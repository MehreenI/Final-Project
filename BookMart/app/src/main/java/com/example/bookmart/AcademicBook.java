package com.example.bookmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AcademicBook extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<BookList> book = new ArrayList<>();

    int book_image = R.drawable.book_img;



    RecyclerView rw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_book);


        Intent intent = getIntent();
        String school_name = intent.getStringExtra(CustomAdapter.MSG);

        TextView txt = findViewById(R.id.schoolName);
        txt.setText(school_name);

        rw = findViewById(R.id.recyclerview);
        setUpBookDetail();

        rw.setLayoutManager(new LinearLayoutManager(this));

        BB_RecyclerViewAdapter adp = new BB_RecyclerViewAdapter(this,book,this);
        rw.setAdapter(adp);
    }

    public void back(View view){
        Intent intent = new Intent(this,AcademicActivity.class);
        startActivity(intent);
    }

    private void setUpBookDetail(){
        String[] bookDetail = getResources().getStringArray(R.array.book_name);
        String[] price = getResources().getStringArray(R.array.book_price);
        String[] location = getResources().getStringArray(R.array.location);

        for(int i=0;i<bookDetail.length;i++){
            book.add(new BookList(bookDetail[i],price[i],location[i],book_image));
        }

    }

    @Override
    public void clickedBook(int position) {
        Intent intent = new Intent(this,BookDescription.class);
        intent.putExtra("Name",book.get(position).getBookName());
        startActivity(intent);
    }
}