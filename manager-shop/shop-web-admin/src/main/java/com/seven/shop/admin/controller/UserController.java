package com.seven.shop.admin.controller;

import com.seven.shop.admin.abstracts.AbstractBaseController;
import com.seven.shop.admin.service.TbUserService;
import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.commons.dto.PageInfo;
import com.seven.shop.domain.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author JR
 * @Date 2019/11/13 15:03
 **/
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser,TbUserService> {


    /**
     * ModelAttribute
     * 1.被@ModelAttribute注释的方法会在此controller每个方法执行前被执行
     * 2.将对象自动的封装 Model 兑对象中，用于视图页面展示时使用 @ModelAttribute等价于 model.addAttribute("attributeName", abc);
     *
     * @param id
     * @return
     */
    @ModelAttribute
    public TbUser getTbUser(Long id) {

        TbUser tbUser = null;
        if (!ObjectUtils.isEmpty(id)) {
            tbUser = service.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转用户列表 list
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "userlist";
    }

    /**
     * 跳转添加/修改用户页面
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "userform";
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult=BaseResult.success();
        List<String> list = Arrays.asList(ids.split(","));
        int i = 1;//tbUserService.deleteMulti(list);
        System.out.println("删除数据条数："+i);
        return baseResult;
    }

    /**
     * 保存用户
     *
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbUser);
        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "userform";
        }
    }

    /**
     * 显示用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail" , method = RequestMethod.GET)
    public String detail(){
        //返回详情的 html 页面
        return "userdetail";
    }


}
