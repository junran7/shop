package com.seven.shop.admin.dao;

import com.seven.shop.commons.persistence.BaseDao;
import com.seven.shop.domain.entity.TbContent;

/**
 * @Author JR
 * @Date 2019/12/9 16:40
 **/
public interface TbContentDao extends BaseDao<TbContent> {

    int deleteByCategoryId(String[] categoryIds);
}
