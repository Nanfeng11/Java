package com.nanfeng.reflect.vo;

import java.lang.reflect.InvocationTargetException;

/**
 * Author：nanfeng
 * Created:2019/8/4
 */
public class TestDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        String value = "emp.ename:Nanfeng|emp.job:Java Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
