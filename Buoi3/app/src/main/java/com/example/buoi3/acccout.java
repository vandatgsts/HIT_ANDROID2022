package com.example.buoi3;

import android.os.Parcel;
import android.os.Parcelable;

public class acccout implements Parcelable {
    String tk;
    String mk;
    public acccout(){};
    public acccout(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    protected acccout(Parcel in) {
        tk = in.readString();
        mk = in.readString();
    }

    public static final Creator<acccout> CREATOR = new Creator<acccout>() {
        @Override
        public acccout createFromParcel(Parcel in) {
            return new acccout(in);
        }

        @Override
        public acccout[] newArray(int size) {
            return new acccout[size];
        }
    };


    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tk);
        parcel.writeString(mk);
    }
}
