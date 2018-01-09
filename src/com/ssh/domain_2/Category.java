package com.ssh.domain_2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class Category {
    private int cid;//分类id
    private String cname;//分类名称

    private Set<Item> items=new HashSet<>();//分类对象中存放item子项集合

    public Category() {
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Category(String cname) {
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
}
