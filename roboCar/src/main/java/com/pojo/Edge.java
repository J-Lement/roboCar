package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * edge
 * @author 
 */
public class Edge implements Serializable {
    /**
     * 有向图边的ID
     */
    private Integer eId;

    /**
     * 有向图边的起点
     */
    private Integer pFirstid;

    /**
     * 有相图边的终点
     */
    private Integer pSecondid;

    /**
     * 有向图变得值
     */
    private double eValue;

    public Edge(){

    }

    public Edge(int id,int f,int s,double v){
        this.eId = id;
        this.pFirstid = f;
        this.pSecondid = s;
        this.eValue = v;
    }
    public Edge(int f,int s,double v){
        this.pFirstid = f;
        this.pSecondid = s;
        this.eValue = v;
    }

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getpFirstid() {
        return pFirstid;
    }

    public void setpFirstid(Integer pFirstid) {
        this.pFirstid = pFirstid;
    }

    public Integer getpSecondid() {
        return pSecondid;
    }

    public void setpSecondid(Integer pSecondid) {
        this.pSecondid = pSecondid;
    }

    public double geteValue() {
        return eValue;
    }

    public void seteValue(double eValue) {
        this.eValue = eValue;
    }
}