package com.xxx.communityzz;

import com.xxx.communityzz.dao.DiscussPostMapper;
import com.xxx.communityzz.dao.UserMapper;
import com.xxx.communityzz.entity.DiscussPost;
import com.xxx.communityzz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityzzApplication.class)
public class MapperTests {
    @Resource
    private UserMapper userMapper;

    @Resource
    private DiscussPostMapper discussPostMapper;
    //测试用户相关功能
    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println("根据用户id查询："+user);
        User user1=userMapper.selectByName("liubei");
        System.out.println("根据用户名查询:"+user1);
        User user2=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println("根据用户邮箱查询："+user2);
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(151, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(151, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(151, "hello");
        System.out.println(rows);
    }

    //测试帖子的首页查询
    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPostList= discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost post:discussPostList
             ) {
            System.out.println(post);
        }
        int num= discussPostMapper.selectDiscussPostRows(149);
        System.out.println("用户Id为149的发帖数为"+num);
    }
}
