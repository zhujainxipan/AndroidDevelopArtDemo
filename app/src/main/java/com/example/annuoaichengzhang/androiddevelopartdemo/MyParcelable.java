package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niehongtao on 16/4/17.
 */
public class MyParcelable implements Parcelable {
    private int mData;
    protected MyParcelable(Parcel in) {
        mData = in.readInt();
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mData);
    }
}
