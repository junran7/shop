package com.seven.shop.admin.service;

import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.commons.persistence.BaseService;
import com.seven.shop.domain.entity.TbUser;

import java.util.List;

/**
 * @Author JR
 * @Date 2019/11/12 16:05
 **/
public interface TbUserService extends BaseService<TbUser> {
    /**
     * customer login
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);
}
