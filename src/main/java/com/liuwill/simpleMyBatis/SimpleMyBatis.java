package com.liuwill.simpleMyBatis;

import com.alibaba.fastjson.JSON;
import com.liuwill.simpleMyBatis.demo.DatabaseDemoApi;
import com.liuwill.simpleMyBatis.entity.CommonUserModel;
import com.liuwill.simpleMyBatis.mapper.CommonUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liuwill.simpleMyBatis.dao.CommonUserModelMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2015/10/14.
 */
public class SimpleMyBatis {

    public static void main(String[] argvs){
        SimpleMyBatis.runDbSession();
    }

    public static void runDbDemoApi(){
        DatabaseDemoApi demoApi = new DatabaseDemoApi();
        System.out.println(demoApi.addDefaultUser());
    }

    public static void runDbSession(){
        String resource = "config/mybatis-config.xml";

        Properties prop = new Properties();
        InputStream inputStream = null;
        InputStream propInput = null;
        SqlSession session = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            propInput = Resources.getResourceAsStream("config/mybatis.properties");
            //input = new FileInputStream("classpath:config/selenium.properties");
            prop.load(propInput);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,prop);
            session = sqlSessionFactory.openSession();

            CommonUserDao userMapper = session.getMapper(CommonUserDao.class);
            String resultStr = JSON.toJSONString(userMapper.getAllUser());
            System.out.println(resultStr);
            //CommonUserModel commonUser = userMapper.(101);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
