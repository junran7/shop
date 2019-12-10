package com.seven.shop.commons.persistence;

import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.commons.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author JR
 * @Date 2019/12/4 17:03
 **/
public interface BaseService<T extends BaseEntity> {

    List<T> selectAll();

    BaseResult save(T entity);

    T getById(Long id);

    int delete(Long id);

    int update(T entity);

    int deleteMulti(Long[] ids);

    /**
     * 分页
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    int count(T entity);


}
