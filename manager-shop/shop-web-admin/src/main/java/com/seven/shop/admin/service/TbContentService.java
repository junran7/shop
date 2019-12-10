package com.seven.shop.admin.service;

import com.seven.shop.commons.persistence.BaseService;
import com.seven.shop.domain.entity.TbContent;

/**
 * @Author JR
 * @Date 2019/12/9 16:18
 **/
public interface TbContentService extends BaseService<TbContent> {

    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     * @return
     */
    int deleteByCategoryId(String[] categoryIds);
}
