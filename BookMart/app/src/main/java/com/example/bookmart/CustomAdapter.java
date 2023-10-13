package com.example.bookmart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] schoolNames;

    public static final String MSG = "com.example.bookmart.MSG";

    public CustomAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.schoolNames = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_school_list, parent, false);
        TextView t = convertView.findViewById(R.id.school_name);
        t.setText(getItem(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AcademicBook.class);
                intent.putExtra(MSG, getItem(position));
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}