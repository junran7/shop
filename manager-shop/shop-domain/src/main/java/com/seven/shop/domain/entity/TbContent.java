package com.seven.shop.domain.entity;

import com.seven.shop.commons.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author JR
 * @Date 2019/12/4 16:41
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class TbContent extends BaseEntity {

    @Length(min = 1, max = 20, message = "标题长度介于 1 - 20 个字符之间")
    private String title;

    @Length(min = 1, max = 20, message = "子标题长度介于 1 - 20 个字符之间")
    private String subTitle;

    @Length(min = 1, max = 50, message = "标题描述长度介于 1 - 50 个字符之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1, message = "内容不能为空")
    private String content;

    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;

}
