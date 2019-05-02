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
    private BigDecimal pLongitude;

    /**
     * 纬度
     */
    private BigDecimal pLatitude;

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

    public BigDecimal getpLongitude() {
        return pLongitude;
    }

    public void setpLongitude(BigDecimal pLongitude) {
        this.pLongitude = pLongitude;
    }

    public BigDecimal getpLatitude() {
        return pLatitude;
    }

    public void setpLatitude(BigDecimal pLatitude) {
        this.pLatitude = pLatitude;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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
        Point other = (Point) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpLongitude() == null ? other.getpLongitude() == null : this.getpLongitude().equals(other.getpLongitude()))
            && (this.getpLatitude() == null ? other.getpLatitude() == null : this.getpLatitude().equals(other.getpLatitude()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpLongitude() == null) ? 0 : getpLongitude().hashCode());
        result = prime * result + ((getpLatitude() == null) ? 0 : getpLatitude().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pLongitude=").append(pLongitude);
        sb.append(", pLatitude=").append(pLatitude);
        sb.append(", pName=").append(pName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}