package com.xxx.communityzz.service;

import com.xxx.communityzz.dao.DiscussPostMapper;
import com.xxx.communityzz.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service//添加服务器注解
public class DiscussPostService {
    @Resource
    private DiscussPostMapper discussPostMapper;
    //当查询到DiscussPost对象时，在Controller层返回DiscussPost中的userId是不合理的
    //因此还需要将userId对应的用户对象信息也查询出来，在UserService.java中获得用户实体信息
    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int  findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
