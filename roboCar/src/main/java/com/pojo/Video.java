package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * video
 * @author 
 */
public class Video implements Serializable {
    /**
     * 视频的id
     */
    private Integer vId;

    /**
     * 视频存储的时间
     */
    private Date vData;

    /**
     * 视屏存储的路径
     */
    private String vRoute;

    /**
     * 小车的编号
     */
    private Integer cId;

    private static final long serialVersionUID = 1L;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Date getvData() {
        return vData;
    }

    public void setvData(Date vData) {
        this.vData = vData;
    }

    public String getvRoute() {
        return vRoute;
    }

    public void setvRoute(String vRoute) {
        this.vRoute = vRoute;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

}