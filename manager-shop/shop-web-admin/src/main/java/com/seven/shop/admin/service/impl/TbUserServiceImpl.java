package com.seven.shop.admin.service.impl;

import com.seven.shop.admin.abstracts.AbstractBaseServiceImpl;
import com.seven.shop.admin.dao.TbUserDao;
import com.seven.shop.admin.service.TbUserService;
import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.commons.dto.PageInfo;
import com.seven.shop.commons.utils.RegexpUtils;
import com.seven.shop.commons.validator.BeanValidator;
import com.seven.shop.domain.entity.TbUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JR
 * @Date 2019/11/12 16:06
 **/
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(String email, String password) {

        TbUser tbUser = tbUserDao.getByEmail(email);
        if (!ObjectUtils.isEmpty(tbUser)) {
            //明文密码加密
//            String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
            //与数据库匹配
            if (password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 保存用户
     *
     * @param tbUser
     */
    @Override
    public BaseResult save(TbUser tbUser) {
        // Hibernate validator 校验
        String validator = BeanValidator.validator(tbUser);
        if (!StringUtils.isEmpty(validator)) {
            return BaseResult.fail(validator);
        }

        //通过验证
        tbUser.setUpdated(new Date());
        //新增
        if (ObjectUtils.isEmpty(tbUser.getId())) {
            //加密处理
            //tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            tbUser.setPassword(tbUser.getPassword());
            tbUser.setCreated(new Date());
            tbUserDao.insert(tbUser);
        }
        //编辑
        else {
            // 编辑用户时如果没有输入密码则沿用原来的密码
            if (StringUtils.isBlank(tbUser.getPassword())) {
                TbUser oldTbUser = getById(tbUser.getId());
                tbUser.setPassword(oldTbUser.getPassword());
            } else {
                // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
                if (StringUtils.length(tbUser.getPassword()) < 6 || StringUtils.length(tbUser.getPassword()) > 20) {
                    return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
                }

                // 设置密码加密
                tbUser.setPassword(tbUser.getPassword()/*DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes())*/);
            }
            update(tbUser);
        }
        return BaseResult.success("用户保存成功");
    }


}
