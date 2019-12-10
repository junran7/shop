package com.seven.shop.admin.controller;

import com.seven.shop.commons.constant.ConstantUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author JR
 * @Date 2019/11/11 15:28
 **/
@Controller
public class MainController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        String id = session.getId();

        Object attribute1 = session.getAttribute(ConstantUtils.SESSION_USER);

        return "main";
    }
}
