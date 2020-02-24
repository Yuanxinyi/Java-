package com.yuanxinyi.service.impl;

import com.yuanxinyi.dao.IAccountDao;
import com.yuanxinyi.factory.BeanFactory;
import com.yuanxinyi.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

//    private int i = 1;//类成员

    public void  saveAccount(){
        int i = 1;   //方法成员
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
