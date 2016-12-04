package com.fanxl.shirostudy.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fanxl on 2016/11/30 0030.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(){

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        String msg = null;

        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            msg = "用户名错误";
        }catch (IncorrectCredentialsException e){
            msg = "密码错误";
        }catch (AuthenticationException e){
            msg = "其他异常"+e.getMessage();
        }

        if(msg==null){
            return "redirect:/";
        }else {
            model.addAttribute("msg", msg);
            logger.info("msg:"+msg);
            return "login";
        }
    }


}
