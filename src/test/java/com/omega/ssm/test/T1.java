package com.omega.ssm.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Class Test
 *
 * @author KennySo
 * @date 2024/9/2
 */
public class T1 {

    @Test
    public void t1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取Bean
        DruidDataSource druidDataSource = (DruidDataSource) ioc.getBean("poolDataSource");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(druidDataSource);
        System.out.println(connection);
        System.out.println(ioc.getBean("sqlSessionFactory"));
    }
}
