package com.ssh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * 基类
 */
public class BaseTest {
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;
    @Before
    public  void  init(){
        Configuration configuration=new Configuration(); //配置
        configuration.configure(); //配置安装

        sessionFactory= configuration.buildSessionFactory(); //建立会话工厂
        session=sessionFactory.openSession();//打开会话
        transaction=session.beginTransaction();//开始事务

    }
    @After
    public  void destroy(){
        transaction.commit();//事务提交
        session.close();//会话关闭
        sessionFactory.close();//关闭工厂

    }
}
