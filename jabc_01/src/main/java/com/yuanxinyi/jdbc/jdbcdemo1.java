package com.yuanxinyi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 */
public class jdbcdemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo1","root","ysl197208");
        //3.获取操作数据库的与处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet resultSet = pstm.executeQuery();
        //5.遍历结果集
        while(resultSet.next()){
            System.out.printf(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        pstm.close();
        connection.close();
    }
}
