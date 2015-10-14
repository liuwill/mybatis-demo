package com.liuwill.testng;

import com.alibaba.fastjson.JSON;
import com.liuwill.simpleMyBatis.mapper.CommonUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Administrator on 2015/10/14.
 */
public class TestMybatis {

    private SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public void initDb(){
        System.out.println("MyBatis Test");

        // create a SqlSessionFactory
        Reader reader = null;
        SqlSession session = null;
        InputStream propInput = null;
        Properties properties = new Properties();
        try {
            propInput = Resources.getResourceAsStream("config/mybatis.properties");

            Assert.assertNotNull(propInput);
            //input = new FileInputStream("classpath:config/selenium.properties");
            properties.load(propInput);

            reader = Resources.getResourceAsReader("config/mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,properties);
            reader.close();

            // populate in-memory database
            session = sqlSessionFactory.openSession();
            Connection conn = session.getConnection();
            reader = Resources.getResourceAsReader("scripts/schema_create.sql");
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setLogWriter(null);
            runner.runScript(reader);
            reader.close();

            reader = Resources.getResourceAsReader("scripts/init_data.sql");
            runner.setLogWriter(null);
            runner.runScript(reader);
            reader.close();
            session.close();
            propInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = "string")
    public void testPrint(){
        System.out.println("汉字");
    }

    @Test(groups = "db")
    public void testMyBatis(){
        SqlSession session = sqlSessionFactory.openSession();

        CommonUserDao userMapper = session.getMapper(CommonUserDao.class);
        String resultStr = JSON.toJSONString(userMapper.getAllUser());
        System.out.println(resultStr);
        //CommonUserModel commonUser = userMapper.(101);
        session.close();
    }
}
