package com.pojo;

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
    private Integer pId;

    /**
     * 经度
     */
    private double pLongitude;

    /**
     * 纬度
     */
    private double pLatitude;

    /**
     * 点的名字
     */
    private String pName;

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