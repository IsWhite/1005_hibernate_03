package com.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class Item {
    private  int id ;//子项id
    private  String name;//子项名称

    //item子项包含分类集合
    private Set<Category> categories =new HashSet<>();

    public Item() {
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
