package com.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class Province {
    private int pid;
    private String pname;
    //当前省份所包含的city集合
    private Set<City> cities =new HashSet<>();

    public Province() {
    }

    public Province(String pname) {
        this.pname = pname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
