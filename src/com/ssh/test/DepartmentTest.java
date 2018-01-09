package com.ssh.test;

import com.ssh.domain.Department;
import com.ssh.domain.Manager;
import org.junit.Test;

/**
 * Created by dllo on 18/1/9.
 */
public class DepartmentTest extends BaseTest {
    @Test
    public  void save(){
        Department department =new Department("教学部");
        Manager manager =new Manager("老孟");
        //绑定关系
        department.setManager(manager);
        manager.setDepartment(department);
        //保存部门
        session.save(department);
        session.save(manager);
    }
}
