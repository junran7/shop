package com.seven.shop.commons.persistence;

import com.seven.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @Author JR
 * @Date 2019/12/4 17:31
 */
public interface BaseTreeService<T extends BaseEntity> {

    /**
     * 查询全部数据
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     *
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 查询信息
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);

}
