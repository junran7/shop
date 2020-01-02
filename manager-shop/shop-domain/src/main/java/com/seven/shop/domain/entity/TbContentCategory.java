package com.seven.shop.domain.entity;

import com.seven.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 分类管理
 *
 * @Author JR
 * @Date 2019/12/4 16:45
 **/
@Data
@EqualsAndHashCode(callSuper = false )
//@EqualsAndHashCode(exclude = {"name", "code"})  //排除一些属性
//@Accessors(chain = true) //使用链式设置属性，set方法返回的是this对象。例：userChain.setId("1").setName("chain").setAge(1);
//@Builder  //使用builder模式创建对象。 例：User user = User.builder().id("1").name("builder").age(1).build();
public class TbContentCategory extends BaseTreeEntity {

    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;

    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
