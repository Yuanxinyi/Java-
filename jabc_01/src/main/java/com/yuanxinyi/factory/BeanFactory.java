package com.yuanxinyi.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂  ：创建service和到对象的
 * bean：在计算机英语中有可重用组件的含义
 * Javabean: 用java语言编写的可重用组件
 * JavaBean 》 实体类
 * 第一步：需要一个配置文件来配置service和dao
 *       配置的内容：唯一标识=全限定类名（key=value）
 * 第二步：通过读取配置文件中配置的内容，反射创建对象
 * 配置文件xml或properties
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个Map用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //创建反射对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);  //有了静态代码块可以直接return（这个对象是单例的）
//        Object bean = null;
//        try{
//        String beanPath = props.getProperty(beanName);
//        bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
    }
}
