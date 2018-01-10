package com.ssh.test;

import com.ssh.domain.Area;
import com.ssh.domain.City;
import org.hibernate.Query;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 放弃维护关系权限后,添加数据就不会更新外键
 */
public class CityTest extends BaseTest {
    @Test
    public void add(){

        City city =new City("沈阳");
        City city2 =new City("大连");
        City city3 =new City("本溪");
        City city4 =new City("鞍山");

        session.save(city);
        session.save(city2);
        session.save(city3);
        session.save(city4);




    }
    @Test
    public void delete(){ //从数据库得到属性才能删除
      City city=session.get(City.class,1);
        session.delete(city);

    }


    @Test
    public void update(){//得到属性再替值
        City city =session.get(City.class,2);
        city.setCname("丹东");
        session.update(city);

    }

    @Test
    public void query(){

        Query query =session.createQuery("from City ");
        query.setMaxResults(3);
        query.setFirstResult(2);
        List<City> cities=query.list();
        System.out.println(cities);

    }



    /*
    * 针对1~n关系的保存1这方的单元测试
    * */
    @Test
    public void  save(){
        City city =new City("大连");
//        Area area =new Area("东京"); 错误

        Area area= session.get(Area.class,3); //找出一个"位置"

        /*城市与区域绑定关系,即将区域添加到城市列表中*/
        city.getAreas().add(area); //主表.get附表属性.add(附表对象):集合中加数据
        session.save(city);//保存主关系的对象-城市
    }

    /*
    * 测试级联操作
    * */
    @Test
    public void  testCascade(){
        /*1,cascade=save-update*/
        City city =new City("抚顺");

        Area area =new Area("顺城区");

        //绑定关系
        city.getAreas().add(area);
        session.save(city);//保存城市
        /*到这 city和area都是持久化对象*/
        //从城市city对象获得区域对象 更改区域的名称
        //检查是否区域表中的数据修改

        Set<Area>  areas =city.getAreas(); //
        if (areas!=null&&!areas.isEmpty()){
            //取set集合中的第一个元素
            Area area1 =areas.iterator().next();//集合.迭代器

            //更新城市对象中的区域第一个区域对象的名称
            area1.setAname("新抚区");
            session.update(city);//更新城市级联区,却改变的是area表


        }

    }


    @Test
    public void  testCascade2(){
        /*2.cascade="delete"*/

        //获得的城市对象 最好是有外键引用的

        //删除城市
        City city =session.get(City.class,9);
        session.delete(city);
    }

    @Test
    public  void  testCascade3(){
        /*1~n双向 在省份中能获得城市列表
        * 在城市中能获取所属省份*/
        City city =session.get(City.class,2);
        System.out.println("城市" + city);
        System.out.println(city + "所属省份" + city.getProvince());
    }


}
