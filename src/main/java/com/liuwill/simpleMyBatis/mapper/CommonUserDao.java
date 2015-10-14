package com.liuwill.simpleMyBatis.mapper;

import com.liuwill.simpleMyBatis.entity.CommonUserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/10/14.
 */
public interface CommonUserDao {
    @Select("SELECT * FROM common_user")
    public List<HashMap> getAllUser();

    @Select("SELECT * FROM common_user WHERE username= #{username}")
    public CommonUserModel getUserByName(String username);

    @Insert("INSERT INTO common_user(user_login,username,display_name,password,email,reg_time)VALUES(#{userLogin},#{username},#{displayName},#{password},#{email},NOW())")
    public int createNewUser(CommonUserModel commonUser);
}
