package com.seven.shop.admin.intercepter;

import com.seven.shop.commons.constant.ConstantUtils;
import com.seven.shop.domain.entity.TbUser;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author JR
 * @Date 2019/11/8 16:29
 **/
public class MyIntercepter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        TbUser tbUser = (TbUser) request.getSession().getAttribute(ConstantUtils.SESSION_USER);

//        if(ObjectUtils.isEmpty(tbUser)){
//            response.sendRedirect("login");
//        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
