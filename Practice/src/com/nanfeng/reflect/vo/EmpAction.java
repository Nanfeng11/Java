package com.nanfeng.reflect.vo;


import java.lang.reflect.InvocationTargetException;

/**
 * 操作简单Java类
 * Author：nanfeng
 * Created:2019/8/4
 */
//EmpAction类设计
public class EmpAction {
    private Emp emp = new Emp();
    public void setValue(String value) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        BeanOperation.setBeanValue(this,value);
    }
    public Emp getEmp(){
        return emp;
    }
}
