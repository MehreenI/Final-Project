package com.example.bookmart;

public class BookList {
    String BookName;
    String Price;
    String Condition;

    int image;

    public BookList(String bookName, String price, String condition,int image) {
        BookName = bookName;
        Price = price;
        Condition = condition;
        this.image = image;
    }

    public String getBookName() {
        return BookName;
    }

    public String getPrice() {
        return Price;
    }

    public String getCondition() {
        return Condition;
    }

    public int getImage() {
        return image;
    }
}
