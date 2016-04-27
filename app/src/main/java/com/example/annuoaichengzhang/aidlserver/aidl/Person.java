package com.example.annuoaichengzhang.aidlserver.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niehongtao on 16/4/27.
 */
public class Person implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
