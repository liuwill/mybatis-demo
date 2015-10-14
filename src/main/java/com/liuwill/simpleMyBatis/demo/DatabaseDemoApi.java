package com.liuwill.simpleMyBatis.demo;

import com.liuwill.simpleMyBatis.entity.CommonUserModel;
import com.liuwill.simpleMyBatis.mapper.CommonUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Administrator on 2015/9/28.
 */
public class DatabaseDemoApi {

    private SqlSessionFactory sqlSessionFactory;

    public DatabaseDemoApi(){
        // create a SqlSessionFactory
        Reader reader = null;
        SqlSession session = null;
        InputStream propInput = null;
        Properties properties = new Properties();
        try {
            propInput = Resources.getResourceAsStream("config/mybatis.properties");

            //input = new FileInputStream("classpath:config/selenium.properties");
            properties.load(propInput);

            reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,properties);
            reader.close();

            propInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNameUpCase(String name){
        return name.toUpperCase();
    }

    public CommonUserModel getUserByName(String name){
        SqlSession session = null;
        CommonUserModel resultStr = null;

        session = sqlSessionFactory.openSession();
        CommonUserDao commonUserDao = session.getMapper(CommonUserDao.class);
        resultStr = commonUserDao.getUserByName(name);
        session.close();

        return resultStr;
    }

    public int addDefaultUser(){
        CommonUserModel commonUserModel = new CommonUserModel();
        commonUserModel.setDisplayName("");
        commonUserModel.setUsername("liuwill");
        commonUserModel.setUserLogin("liuwill");
        commonUserModel.setPassword("123456");
        commonUserModel.setEmail("liuwill@liuwill.com");

        CommonUserModel newUserModel = new CommonUserModel();
        newUserModel.setDisplayName("fresh");
        newUserModel.setUsername("fresh");
        newUserModel.setUserLogin("fresh");
        newUserModel.setPassword("123456");
        newUserModel.setEmail("fresh@liuwill.com");

        /*DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);*/

        SqlSession session = null;
        int resultStr = 0;
        session = sqlSessionFactory.openSession();

        CommonUserDao commonUserDao = session.getMapper(CommonUserDao.class);
        resultStr = commonUserDao.createNewUser(commonUserModel);
        resultStr += commonUserDao.createNewUser(newUserModel);
        session.rollback();
        return resultStr;
    }
}
