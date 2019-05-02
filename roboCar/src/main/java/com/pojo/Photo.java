package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * photo
 * @author 
 */
public class Photo implements Serializable {
    /**
     * 编号
     */
    private Integer phId;

    /**
     * 存储时间
     */
    private Date phTime;

    /**
     * 图片的路径
     */
    private String phRoute;

    /**
     * 小车的编号
     */
    private Integer cId;

    private static final long serialVersionUID = 1L;

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public Date getPhTime() {
        return phTime;
    }

    public void setPhTime(Date phTime) {
        this.phTime = phTime;
    }

    public String getPhRoute() {
        return phRoute;
    }

    public void setPhRoute(String phRoute) {
        this.phRoute = phRoute;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
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
        Photo other = (Photo) that;
        return (this.getPhId() == null ? other.getPhId() == null : this.getPhId().equals(other.getPhId()))
            && (this.getPhTime() == null ? other.getPhTime() == null : this.getPhTime().equals(other.getPhTime()))
            && (this.getPhRoute() == null ? other.getPhRoute() == null : this.getPhRoute().equals(other.getPhRoute()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPhId() == null) ? 0 : getPhId().hashCode());
        result = prime * result + ((getPhTime() == null) ? 0 : getPhTime().hashCode());
        result = prime * result + ((getPhRoute() == null) ? 0 : getPhRoute().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", phId=").append(phId);
        sb.append(", phTime=").append(phTime);
        sb.append(", phRoute=").append(phRoute);
        sb.append(", cId=").append(cId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}