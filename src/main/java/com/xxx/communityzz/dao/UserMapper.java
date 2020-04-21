package com.xxx.communityzz.dao;

import com.xxx.communityzz.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);
    //增加用户，返回成功插入的行数
    int insertUser(User user);
    //修改用户状态，返回修改的条数
    int updateStatus(int id, int status);
    //修改用户的头像，返回修改的条数
    int updateHeader(int id, String headerUrl);
    //修改用户的密码
    int updatePassword(int id, String password);
}
