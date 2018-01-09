package com.ssh.test;

import com.ssh.domain.Area;
import com.ssh.domain.City;
import com.ssh.domain.Province;
import org.hibernate.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 18/1/9.
 */
public class ProvinceTest extends  BaseTest{
    @Test
    public void add(){
        Province province =new Province("辽宁省");
        Province province1 =new Province("吉林省");
        Province province2 =new Province("黑龙江省");
        Province province3 =new Province("泰国省");
        session.save(province);
        session.save(province1);
        session.save(province2);
        session.save(province3);

    }
    @Test
    public void delete(){

    }
    @Test
    public void update(){

    }
    @Test
    public void query(){

    }

    @Test//
    public  void testCascade(){
        Province province =new Province("越南省");
        //取出来再绑定 或new出来再绑定
        City city =new City("长春");

        province.getCities().add(city);
        session.save(province);
    }

    @Test
    public void  testCascade2(){
        Province province =new Province("辽宁省");

        //获取城市表中没有绑定 若city表中没有对应的id则无法添加
        City city =session.get(City.class,3);
        City city1 =session.get(City.class,4);
        City city2 =session.get(City.class,6);

        //将城市列表加入到对应的省份中
        province.getCities().add(city);
        province.getCities().add(city1);
        province.getCities().add(city2);

        session.save(province);
    }

    /*
    * 查询所有省份列表
    * 三级联动的第一层数据
    * */
    @Test
    public void queryProvince(){
        Query query =session.createQuery("from  Province ");
        //得到所有省份集合
        List<Province> provinces=query.list();

        /*遍历省份*/
        for (Province pro : provinces) {
            System.out.println("当前省份" + pro);

            /*从省份对象中获取城市列表
            * 2.三级联动中的第二层 城市获取
            * */

            Set<City> cities =pro.getCities();
            //遍历城市
            Iterator<City> iterator =cities.iterator();
            while (iterator.hasNext()){
                //当前遍历的城市对象
                City city =iterator.next();
                System.out.println(" "+city);
                /*遍历城市对应区域集合*/
                Set<Area> areas =city.getAreas();

                Iterator<Area> iterator1 =areas.iterator();
                while (iterator1.hasNext()){
                    Area area =iterator1.next();
                    System.out.println(area);
                }
            }
            System.out.println("*********************");

        }
    }
}
