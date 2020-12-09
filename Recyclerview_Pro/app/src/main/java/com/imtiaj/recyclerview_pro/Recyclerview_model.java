package com.imtiaj.recyclerview_pro;

import android.content.Context;

import com.imtiaj.recyclerview_pro.model.ChildItem;

import java.util.List;

public class Recyclerview_model{

    public static final int TEXT_FILE = 0;
    public static final int IMAGE_FILE = 1;
    public static final int RECYCLER = 2;
    public static final int VIDEOVIEW = 3;
    public static final int SLIDER = 4;



    private String Caption ;
    private int image;
    Context ctx;
    private int viewType;
    private String ParentItemTitle;
    private String VideoURL;
    private List<ChildItem> ChildItemList;
    private int Image_slider;
    private int allIgameArray[];

    public Recyclerview_model() {
    }



    public Recyclerview_model(String caption, int viewType) {
        Caption = caption;
        this.viewType = viewType;
    }

    public Recyclerview_model(int image, int viewType) {
        this.image = image;
        this.viewType = viewType;
    }

    public Recyclerview_model(String parentItemTitle, List<ChildItem> childItemList,int viewType) {
        ParentItemTitle = parentItemTitle;
        ChildItemList = childItemList;
        this.viewType = viewType;
    }

    public Recyclerview_model(int viewType, String videoURL) {
        this.viewType = viewType;
        VideoURL = videoURL;
    }

    public Recyclerview_model(int viewType, int[] array) {
        this.viewType = viewType;
        this.allIgameArray = array;
    }

    public int[] getImage_slider() {
        return allIgameArray;
    }

    public void setImage_slider(int[] image_slider_array) {
        allIgameArray = image_slider_array;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    public String getParentItemTitle() {
        return ParentItemTitle;
    }

    public void setParentItemTitle(String parentItemTitle) {
        ParentItemTitle = parentItemTitle;
    }

    public List<ChildItem> getChildItemList() {
        return ChildItemList;
    }

    public void setChildItemList(List<ChildItem> childItemList) {
        ChildItemList = childItemList;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
