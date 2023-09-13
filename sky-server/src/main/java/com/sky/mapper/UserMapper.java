package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.jws.soap.SOAPBinding;

@Mapper
public interface UserMapper {
    //根据openid来查询用户
    @Select("select * from sky_take_out.user where openid =#{openid}")
    User getByOpenid(String openid);

    void insert(User user);

}
