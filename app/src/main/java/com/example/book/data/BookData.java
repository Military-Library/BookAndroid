package com.example.book.data;

import android.os.Parcel;
import android.os.Parcelable;
//parse는 이 객체안에 있는 데이터를 다른 데 전달 할 때 사용되는 객체
public class BookData implements Parcelable {

    public int number;
    public String message;

    public BookData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public BookData(Parcel in) {
        number = in.readInt();
        message = in.readString();
    }

    public static final Creator<BookData> CREATOR = new Creator<BookData>() {
        @Override
        public BookData createFromParcel(Parcel in) {
            return new BookData(in);
        }

        @Override
        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
