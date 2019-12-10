package com.seven.shop.commons.persistence;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author JR
 * @Date 2019/12/4 16:50
 **/
public interface BaseDao<T extends BaseEntity> {


    List<T> selectAll();

    T getById(Long id);

    int insert(T entity);

    int delete(Long id);

    int update(T entity);

    int deleteMulti(Long[] ids);

    /**
     * 分页
     *
     * @param params
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    int count(T entity);

}
