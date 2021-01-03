package com.smbms.controller;

import com.mysql.jdbc.StringUtils;
import com.smbms.pojo.SmbmsUser;
import com.smbms.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam String userCode, @RequestParam String userPassword){

        /*进行判空 Spring 提供了判空的类 */
        if(!StringUtils.isNullOrEmpty(userCode) && !StringUtils.isNullOrEmpty(userPassword)){
            /*进行查询*/
            SmbmsUser user = userLoginService.login(userCode,userPassword);
            if (user != null){
                // 登录成功 跳转
                request.getSession().setAttribute("userSession",user);
                return "redirect:/jsp/frame.jsp";
            }else{
                request.setAttribute("error","用户名或者密码错误!");
            }
        }else{
            request.setAttribute("error","用户名或者密码不能为空!");
        }
        return "../login";
    }
}
