package com.seven.shop.admin.abstracts;

import com.seven.shop.commons.dto.PageInfo;
import com.seven.shop.commons.persistence.BaseDao;
import com.seven.shop.commons.persistence.BaseEntity;
import com.seven.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JR
 * @Date 2019/12/5 10:01
 **/
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 更新信息
     *
     * @param entity
     */
    @Override
    public int update(T entity) {
        return dao.update(entity);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public int deleteMulti(Long[] ids) {
       return dao.deleteMulti(ids);
    }

    /**
     * 查询总笔数
     *
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }
}
