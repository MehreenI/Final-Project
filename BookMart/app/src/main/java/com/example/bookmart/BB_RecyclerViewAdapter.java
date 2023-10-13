package com.example.bookmart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BB_RecyclerViewAdapter extends RecyclerView.Adapter<BB_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<BookList> bookList;

    private final RecyclerViewInterface recyclerViewInterface;
    public BB_RecyclerViewAdapter(Context context, ArrayList<BookList> bookList,RecyclerViewInterface recyclerViewInterface){
        this.bookList = bookList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public BB_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // THis is where we inflate the layout

        LayoutInflater infaltor = LayoutInflater.from(context);
        View view = infaltor.inflate(R.layout.row_search,parent,false);
        return new BB_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BB_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assign values to the views ike each of the rows
        // based on the position

        holder.name.setText(bookList.get(position).getBookName());
        holder.price.setText(bookList.get(position).getPrice());
        holder.img.setImageResource(bookList.get(position).getImage());
        holder.location.setText(bookList.get(position).getCondition());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    //Grab all the views from the recycleer view


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;

        TextView price;
        TextView location;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.bookname);
            price = itemView.findViewById(R.id.price);
            location = itemView.findViewById(R.id.location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int post = getAdapterPosition();
                        if(post != RecyclerView.NO_POSITION){
                            recyclerViewInterface.clickedBook(post);
                        }
                    }
                }
            });
        }
    }
}
