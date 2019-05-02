package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * travel
 * @author 
 */
public class Travel implements Serializable {
    /**
     * 行驶路径的ID
     */
    private Integer tId;

    /**
     * 行驶到该点的经度
     */
    private BigDecimal tLongitude;

    /**
     * 行驶到该点的纬度
     */
    private BigDecimal tLatitude;

    /**
     * 行驶的速度
     */
    private BigDecimal tSpeed;

    /**
     * 记录的时间
     */
    private Date tTime;

    /**
     * 车子的电量
     */
    private BigDecimal tQuantity;

    private int c_id;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    private static final long serialVersionUID = 1L;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public BigDecimal gettLongitude() {
        return tLongitude;
    }

    public void settLongitude(BigDecimal tLongitude) {
        this.tLongitude = tLongitude;
    }

    public BigDecimal gettLatitude() {
        return tLatitude;
    }

    public void settLatitude(BigDecimal tLatitude) {
        this.tLatitude = tLatitude;
    }

    public BigDecimal gettSpeed() {
        return tSpeed;
    }

    public void settSpeed(BigDecimal tSpeed) {
        this.tSpeed = tSpeed;
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tTime) {
        this.tTime = tTime;
    }

    public BigDecimal gettQuantity() {
        return tQuantity;
    }

    public void settQuantity(BigDecimal tQuantity) {
        this.tQuantity = tQuantity;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Travel other = (Travel) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.gettLongitude() == null ? other.gettLongitude() == null : this.gettLongitude().equals(other.gettLongitude()))
            && (this.gettLatitude() == null ? other.gettLatitude() == null : this.gettLatitude().equals(other.gettLatitude()))
            && (this.gettSpeed() == null ? other.gettSpeed() == null : this.gettSpeed().equals(other.gettSpeed()))
            && (this.gettTime() == null ? other.gettTime() == null : this.gettTime().equals(other.gettTime()))
            && (this.gettQuantity() == null ? other.gettQuantity() == null : this.gettQuantity().equals(other.gettQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((gettLongitude() == null) ? 0 : gettLongitude().hashCode());
        result = prime * result + ((gettLatitude() == null) ? 0 : gettLatitude().hashCode());
        result = prime * result + ((gettSpeed() == null) ? 0 : gettSpeed().hashCode());
        result = prime * result + ((gettTime() == null) ? 0 : gettTime().hashCode());
        result = prime * result + ((gettQuantity() == null) ? 0 : gettQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tLongitude=").append(tLongitude);
        sb.append(", tLatitude=").append(tLatitude);
        sb.append(", tSpeed=").append(tSpeed);
        sb.append(", tTime=").append(tTime);
        sb.append(", tQuantity=").append(tQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}