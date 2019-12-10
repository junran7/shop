package com.seven.shop.commons.dto;

import com.seven.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author JR
 * @Date 2019/12/5 10:10
 **/
@Data
public class PageInfo<T extends BaseEntity> implements Serializable {

    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

}
