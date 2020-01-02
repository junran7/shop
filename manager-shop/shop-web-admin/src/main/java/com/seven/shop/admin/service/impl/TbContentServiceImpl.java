package com.seven.shop.admin.service.impl;

import com.seven.shop.admin.abstracts.AbstractBaseServiceImpl;
import com.seven.shop.admin.dao.TbContentDao;
import com.seven.shop.admin.service.TbContentService;
import com.seven.shop.admin.validator.BeanValidator;
import com.seven.shop.admin.validator.TestValidate;
import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.domain.entity.TbContent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @Author JR
 * @Date 2019/12/9 16:39
 **/
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
//        TestValidate testValidate=new TestValidate();
//        String aaaa = TestValidate.aaaa;
//        TestValidate.validator("aa");
//        String validator = BeanValidator.validator(tbContent);
//        if (!StringUtils.isBlank(validator)) {
//            return BaseResult.fail(validator);
//        }

        // 验证通过
//        else {
            tbContent.setUpdated(new Date());

            if(tbContent.getId() == null){
                // 密码需要加密处理
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }
            // 编辑用户
            else {
                update(tbContent);
            }
//        }
        return BaseResult.success("保存内容信息成功");
    }

    @Override
    @Transactional(readOnly = false)
    public int  deleteByCategoryId(String[] categoryIds) {
        return dao.deleteByCategoryId(categoryIds);
    }
}
