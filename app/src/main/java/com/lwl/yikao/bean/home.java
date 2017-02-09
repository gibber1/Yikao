package com.lwl.yikao.bean;

import java.io.Serializable;

/**
 * Created by liu on 2016/11/19.
 */
public class home implements Serializable {
    private String title;
    private String digest;
    private String body;
    private String imgpath;
    private String type;
    private String time;
    private int imgRes;


    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public int getImgRes() {
        return imgRes;
    }


    public home() {
    }

    public home(String title, int imgRes) {
        this.title = title;
        this.imgRes = imgRes;
    }

    public home(String title, String time,String digest,int imgRes) {
        this.title = title;
        this.time=time;
        this.digest=digest;
        this.imgRes = imgRes;
    }


    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public String getDigest() {
        return digest;
    }

    public String getBody() {
        return body;
    }

    public String getImgpath() {
        return imgpath;
    }

    public String getType() {
        return type;
    }
}
