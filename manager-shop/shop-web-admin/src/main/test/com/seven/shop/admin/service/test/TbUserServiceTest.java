package com.seven.shop.admin.service.test;

import com.seven.shop.admin.service.TbUserService;
import com.seven.shop.domain.entity.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author JR
 * @Date 2019/11/12 15:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testGetById(){
//        TbUser tbUser = tbUserService.getById(1L);
//        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testInsert(){
//        TbUser tbUser = new TbUser();
//        tbUser.setUsername("Lusifer");
//        tbUser.setPhone("15888888888");
//        tbUser.setEmail("seven@funtl.com");
//        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        tbUser.setCreated(new Date());
//        tbUser.setUpdated(new Date());
//        int insert = tbUserService.insert(tbUser);
//        System.out.println("插入数量："+String.valueOf(insert));
    }

    @Test
    public void testGetByEmail(){
//        TbUser email = tbUserService.getByEmail("1@1");
//        System.out.println(email);
    }

    @Test
    public void testSelectAll(){
//        List<TbUser> tbUsers = tbUserService.selectAll();
//        System.out.println(tbUsers);
    }

    @Test
    public void testDelete(){
//        int delete = tbUserService.delete(5l);
//        System.out.println(delete);
    }

    @Test
    public void testDeleteMulti(){
//        tbUserService.deleteMulti(new ArrayList<Long>(){{add(3L);add(4L);}});
    }

    @Test
    public void testUpdate(){
//        TbUser tbUser = tbUserService.getById(1L);
//        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        int update = tbUserService.update(tbUser);
//        System.out.println(update);
    }



}
