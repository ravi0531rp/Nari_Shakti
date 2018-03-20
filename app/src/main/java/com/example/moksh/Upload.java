package com.example.moksh;

/**
 * Created by moksh on 21/3/18.
 */

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload() {
    }

    public Upload(String mName, String mImageUrl) {
        if (mName.trim().equals("")) {
            mName = "No name";
        }
        this.mName = mName;
        this.mImageUrl = mImageUrl;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
}