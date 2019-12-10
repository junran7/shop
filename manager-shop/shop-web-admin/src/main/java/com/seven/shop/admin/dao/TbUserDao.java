package com.seven.shop.admin.dao;

import com.seven.shop.commons.persistence.BaseDao;
import com.seven.shop.domain.entity.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author JR
 * @Date 2019/11/12 14:35
 **/
public interface TbUserDao extends BaseDao<TbUser> {


    /**
     * 通过 Email 获得TbUser
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

}
