package com.seven.shop.domain.entity;

import com.seven.shop.commons.persistence.BaseEntity;
import com.seven.shop.commons.utils.RegexpUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper=false)
public class TbUser extends BaseEntity {

    @NotNull
    @Length(min = 6, max = 20, message = "姓名的长度必须介于 6 - 20 位之间")
    private String username;

    private String password;

    /**
     * 自定义 regexp 校验
     */
    @NotNull
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;

    @NotNull
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;


}
