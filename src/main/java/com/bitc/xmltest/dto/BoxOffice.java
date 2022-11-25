package com.bitc.xmltest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

//@Data 설정하면 getter/setter 만들지않아도 됨
@Generated("jsonschema2pojo")
public class BoxOffice {

    @SerializedName("boxOfficeResult")
    @Expose
    private BoxOfficeResult boxOfficeResult;

    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

}