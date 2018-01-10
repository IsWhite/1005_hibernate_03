package com.ssh.test;


import com.ssh.domain.Area;
import org.hibernate.Query;
import org.junit.Test;

import java.util.List;

/**
 * Created by dllo on 18/1/9.
 */
public class AreaTest extends BaseTest{
    @Test
    public void  add(){
        //,"中山区","沙河口区","甘井子区","旅顺口区","金州区","瓦房店市","普兰店市","庄河市","长海县","其他"
        Area area = new Area("西岗区");
        Area area1 = new Area("中山区");
        Area area2 = new Area("沙河口区");
        Area area3 = new Area("甘井子区");

        //{"name":"沈阳", "area":["沈河区","皇姑区","和平区","大东区","铁西区","苏家屯区","东陵区","于洪区","新民市","法库县","辽中县","康平县","新城子区","其他"]},
        Area area4 = new Area("沈河区");
        Area area5 = new Area("皇姑区");
        Area area6 = new Area("和平区");
        Area area7 = new Area("大东区");

        session.save(area);
        session.save(area1);
        session.save(area2);
        session.save(area3);
        session.save(area4);
        session.save(area5);
        session.save(area6);
        session.save(area7);
    }
    @Test
    public void delete(){
        /*先通过get获得要删除的对象 ,对象必须是持久化的*/
        Area area=session.get(Area.class,1);
        session.delete(area);//按对象删除

    }
    @Test
    public  void  update(){
        Area area= session.get(Area.class,2);//第2个对象
        //直接更新持久化对象的属性

        /*持久化对象即使不调用update,也会在事务commit提交时更新,而如果手动调update则会立即更新*/
        area.setAname("西岗区");
        session.update(area);
    }
    @Test
    public  void  query(){
        //创建一个查询对象
        Query query =session.createQuery("from  Area ");
        //要查询的最大条数(分页处理)
        query.setMaxResults(5);

        //要查询起始位置(分页处理)
        query.setFirstResult(2);
        //返回符合条件的结果集
        List<Area> areas =query.list();
        System.out.println(areas);



    }
    @Test
    public  void testCascade(){
        Area area =session.get(Area.class,18);
        System.out.println("区为"+area);
        System.out.println(area + "所属城市" + area.getCity());
        System.out.println("省"+area.getCity().getProvince());
    }
}
