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
    private Integer eFirstid;

    /**
     * 有相图边的终点
     */
    private Integer pSecondid;

    /**
     * 有向图变得值
     */
    private BigDecimal eValue;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer geteFirstid() {
        return eFirstid;
    }

    public void seteFirstid(Integer eFirstid) {
        this.eFirstid = eFirstid;
    }

    public Integer getpSecondid() {
        return pSecondid;
    }

    public void setpSecondid(Integer pSecondid) {
        this.pSecondid = pSecondid;
    }

    public BigDecimal geteValue() {
        return eValue;
    }

    public void seteValue(BigDecimal eValue) {
        this.eValue = eValue;
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
        Edge other = (Edge) that;
        return (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
            && (this.geteFirstid() == null ? other.geteFirstid() == null : this.geteFirstid().equals(other.geteFirstid()))
            && (this.getpSecondid() == null ? other.getpSecondid() == null : this.getpSecondid().equals(other.getpSecondid()))
            && (this.geteValue() == null ? other.geteValue() == null : this.geteValue().equals(other.geteValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((geteFirstid() == null) ? 0 : geteFirstid().hashCode());
        result = prime * result + ((getpSecondid() == null) ? 0 : getpSecondid().hashCode());
        result = prime * result + ((geteValue() == null) ? 0 : geteValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", eFirstid=").append(eFirstid);
        sb.append(", pSecondid=").append(pSecondid);
        sb.append(", eValue=").append(eValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}