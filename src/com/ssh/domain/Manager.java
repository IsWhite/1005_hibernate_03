package com.ssh.domain;

/**
 * Created by dllo on 18/1/9.
 */
public class Manager {
    private int id;//管理者id
    private  String name; //管理者名字

    //当前管理者管理的是哪一个部门
    private Department department;

    public Manager() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Manager(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

