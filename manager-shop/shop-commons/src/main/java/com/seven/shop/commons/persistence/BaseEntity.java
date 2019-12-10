package com.seven.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author JR
 * @Date 2019/12/4 16:51
 **/

@Data
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;
}
