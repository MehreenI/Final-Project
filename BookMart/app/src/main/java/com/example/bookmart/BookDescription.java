package com.example.bookmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class BookDescription extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

        TextView txt = findViewById(R.id.bookName_des);
        txt.setText(name);

        dialog = new Dialog(this);

        // Find the Interested button
        Button interestedButton = findViewById(R.id.button2);
        interestedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOfferDialog(); // Show the offer dialog when the Interested button is clicked
            }
        });
    }

    // Method to show the offer dialog
    private void showOfferDialog() {
        dialog.setContentView(R.layout.popup_offer);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        dialog.show();
    }
}
