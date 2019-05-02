package com.pojo;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    private Integer uId;

    private String uAccount;

    private String uPassage;

    private String uName;

    private String uTele;

    private Integer uAge;

    private String uSex;

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuPassage() {
        return uPassage;
    }

    public void setuPassage(String uPassage) {
        this.uPassage = uPassage;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuTele() {
        return uTele;
    }

    public void setuTele(String uTele) {
        this.uTele = uTele;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
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
        User other = (User) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuAccount() == null ? other.getuAccount() == null : this.getuAccount().equals(other.getuAccount()))
            && (this.getuPassage() == null ? other.getuPassage() == null : this.getuPassage().equals(other.getuPassage()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuTele() == null ? other.getuTele() == null : this.getuTele().equals(other.getuTele()))
            && (this.getuAge() == null ? other.getuAge() == null : this.getuAge().equals(other.getuAge()))
            && (this.getuSex() == null ? other.getuSex() == null : this.getuSex().equals(other.getuSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuAccount() == null) ? 0 : getuAccount().hashCode());
        result = prime * result + ((getuPassage() == null) ? 0 : getuPassage().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuTele() == null) ? 0 : getuTele().hashCode());
        result = prime * result + ((getuAge() == null) ? 0 : getuAge().hashCode());
        result = prime * result + ((getuSex() == null) ? 0 : getuSex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uAccount=").append(uAccount);
        sb.append(", uPassage=").append(uPassage);
        sb.append(", uName=").append(uName);
        sb.append(", uTele=").append(uTele);
        sb.append(", uAge=").append(uAge);
        sb.append(", uSex=").append(uSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}