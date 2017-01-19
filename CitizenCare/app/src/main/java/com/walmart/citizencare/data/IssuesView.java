package com.walmart.citizencare.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by akanksha on 13/11/16.
 */

public class IssuesView implements Parcelable {

    private String title;
    private String date;
    private String location;
    private String description;
    private int categoryType;
    private int mediaCount;
    private int watchCount;
    private int likeCount;
    //Improvement in this ratio,

    /**
     * TODO Remove
     */
    public IssuesView(String title, String date, String location, String description, int categoryType, int mediaCount, int watchCount, int likeCount) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.description = description;
        this.categoryType = categoryType;
        this.mediaCount = mediaCount;
        this.watchCount = watchCount;
        this.likeCount = likeCount;
    }

    protected IssuesView(Parcel in) {
        title = in.readString();
        date = in.readString();
        location = in.readString();
        description = in.readString();
        categoryType = in.readInt();
        mediaCount = in.readInt();
        watchCount = in.readInt();
        likeCount = in.readInt();
    }


    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return new Date(date);
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public int getMediaCount() {
        return mediaCount;
    }

    public int getWatchCount() {
        return watchCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeInt(categoryType);
        dest.writeInt(mediaCount);
        dest.writeInt(watchCount);
        dest.writeInt(likeCount);
    }

    public static final Creator<IssuesView> CREATOR = new Creator<IssuesView>() {
        @Override
        public IssuesView createFromParcel(Parcel in) {
            return new IssuesView(in);
        }

        @Override
        public IssuesView[] newArray(int size) {
            return new IssuesView[size];
        }
    };
}
