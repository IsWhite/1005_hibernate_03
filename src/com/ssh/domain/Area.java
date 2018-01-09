package com.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class Area {
    private int aid;
    private String aname;

    private City city;

    public Area() {
    }

    public Area(String pname) {
        this.aname = pname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String pname) {
        this.aname = pname;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Area{" +
                "aid=" + aid +
                ", pname='" + aname + '\'' +
                '}';
    }
}
