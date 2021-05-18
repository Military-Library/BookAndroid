package com.example.book.ui.Recycle;

import android.widget.ImageView;

public class BookItem {
    String imageViewUrl;
    String bookName;

    public BookItem(String imageViewUrl, String bookName) {
        this.imageViewUrl = imageViewUrl;
        this.bookName = bookName;
    }

    public String getImageViewUrl() {
        return imageViewUrl;
    }

    public void setImageViewUrl(String imageView) {
        this.imageViewUrl = imageViewUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
