package com.yuanxinyi.ui;


import com.yuanxinyi.service.IAccountService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
  //      ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象(两种方式均可以)
        IAccountService as1 = (IAccountService)ac.getBean("accountService");
      as1.saveAccount();
        //要想销毁对象
        //手动关闭容器
    //    ((ClassPathXmlApplicationContext) ac).close();
        ac.close();
    }
}
