package com.xxx.communityzz.dao;

import com.xxx.communityzz.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //分表查询帖子，如果userId=0表示首页查询，等于具体的数值表示查询当前用户自己发的帖子
    //offset表示数据库分页查询中limit关键字所需的参数1即开始的位置，limit表示参数2即一页查询的行数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    // 未添加该注解，SQL语句中只能使用#{},添加上能使用${}和#{}
    int selectDiscussPostRows(@Param("userId") int userId);
}
