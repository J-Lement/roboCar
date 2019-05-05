package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * point
 * @author 
 */
public class Point implements Serializable {
    /**
     * 编号
     */
    @JsonProperty(value="id")
    private Integer pId;

    /**
     * 经度
     */
    @JsonProperty(value="lng")
    private double pLongitude;

    /**
     * 纬度
     */
    @JsonProperty(value="lat")
    private double pLatitude;

    /**
     * 点的名字
     */
    @JsonProperty("name")
    private String pName;

    public Point(){

    }

    public Point(int pid,double longitude,double latitude,String name){
        this.pId = pid;
        this.pLongitude = longitude ;
        this.pLatitude = latitude;
        this.pName = name;
    }

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public double getpLongitude() {
        return pLongitude;
    }

    public void setpLongitude(double pLongitude) {
        this.pLongitude = pLongitude;
    }

    public double getpLatitude() {
        return pLatitude;
    }

    public void setpLatitude(double pLatitude) {
        this.pLatitude = pLatitude;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}