package com.seven.shop.admin.controller;

import com.seven.shop.admin.service.TbUserService;
import com.seven.shop.commons.constant.ConstantUtils;
import com.seven.shop.domain.entity.TbUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author JR
 * @Date 2019/11/1 11:09
 **/
@Controller
public class LoginController/* extends HttpServlet */ {

    @Autowired
    TbUserService tbUserService;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();

    /**
     * 登录页
     *
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    /**
     * 登录
     *
     * @param email
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, Model model, HttpServletRequest request, HttpServletResponse response) {

        TbUser tbUser = tbUserService.login(email, password);
        if (ObjectUtils.isEmpty(tbUser)) {
            model.addAttribute("message", "用户名或密码输入错误");
            return login();
        } else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "main";
        }


        //获取session信息
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpSession session = servletRequestAttributes.getRequest().getSession();
//        Object attribute1 = session.getAttribute(ConstantUtils.SESSION_USER);
//
//        ServletContext servletContext = webApplicationContext.getServletContext();
//        Object attribute = servletContext.getAttribute(ConstantUtils.SESSION_USER);
    }

    /**
     * 注销功能
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return login();
    }


}
