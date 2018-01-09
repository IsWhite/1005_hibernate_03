package com.ssh.test;

import com.ssh.domain.Category;
import com.ssh.domain.Item;
import org.junit.Test;

/**
 * Created by dllo on 18/1/9.
 */
public class CategoryTest extends BaseTest {
    @Test
    public void save() {
        Category category = new Category("图书");
        Item item = new Item("教育类");
        Item item1 = new Item("少儿类");


        //将item子项对象绑定大鹏分类对象中
        category.getItems().add(item);
        category.getItems().add(item1);

        //保存分类对象
        session.save(category);

    }
    @Test
    public  void save2(){
        /*一个item可以属于多个分类*/
        Item item =new Item("畅销");
        Category category =new Category("水果类");
        Category category1 =new Category("蔬菜类");

        //将畅销的item添加到两个分类对象中
        category.getItems().add(item);
        category1.getItems().add(item);
        //保存分类对象
        session.save(category);
        session.save(category1);
    }
}
