package com.seven.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * 树形结构的 BaseEntity
 *
 * @Author JR
 * @Date 2019/12/4 17:31
 **/
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {

    private T parent;

    private Boolean isParent;

}
