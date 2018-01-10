package com.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class City {
    private int cid;
    private String cname;

    private  Province province; //当前城市对应省份

   /* 用于存放当前城市对象中的区域集合 一对多关系中的1考虑*/
    private Set<Area> areas=new HashSet<>();//1中有n的集合

    public City() {
    }

    public City(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
