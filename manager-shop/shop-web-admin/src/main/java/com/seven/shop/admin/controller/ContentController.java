package com.seven.shop.admin.controller;

import com.seven.shop.admin.abstracts.AbstractBaseController;
import com.seven.shop.admin.service.TbContentService;
import com.seven.shop.commons.dto.BaseResult;
import com.seven.shop.commons.persistence.BaseEntity;
import com.seven.shop.domain.entity.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 内容管理
 *
 * @Author JR
 * @Date 2019/12/9 16:15
 **/
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent,TbContentService> {

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbContent = service.getById(id);
        } else {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 跳转内容列表页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list() {
        return "contentlist";
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "contentform";
    }

    /**
     * 保存
     *
     * @param entity
     * @param model
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent entity, Model model,RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(entity);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    /**
     *
     *
     * @param ids
     * @return
     */
    @Override
    public BaseResult delete(String ids) {
        return null;
    }

    @Override
    public String detail() {
        return null;
    }
}
