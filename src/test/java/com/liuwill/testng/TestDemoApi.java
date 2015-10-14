package com.liuwill.testng;

import com.alibaba.fastjson.JSON;
import com.liuwill.simpleMyBatis.demo.DatabaseDemoApi;
import com.liuwill.simpleMyBatis.entity.CommonUserModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2015/10/14.
 */
public class TestDemoApi {
    private DatabaseDemoApi demoApi;

    @BeforeClass(groups = "db")
    public void setUp(){
        demoApi = new DatabaseDemoApi();
    }

    @Test(groups = "string")
    public void testUpperName(){
        String name = "test";
        String upperName = demoApi.getNameUpCase(name);

        System.out.println(name+":"+upperName);
        Assert.assertEquals(upperName,name.toUpperCase());
    }

    @Test(groups = "db")
    public void testGetUserByName(){
        String name = "test";
        CommonUserModel commonUser = demoApi.getUserByName(name);

        System.out.println(JSON.toJSONString(commonUser));
        Assert.assertEquals(commonUser.getUsername(),name);
    }

    @Test(groups = "transaction")
    public void testAddDefault(){
        String name = "test";
        int commonUser = demoApi.addDefaultUser();

        System.out.println(JSON.toJSONString(commonUser));
        Assert.assertEquals(2,2);
    }
}
