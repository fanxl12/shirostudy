package com.fanxl.shirostudy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fanxl on 2016/11/30 0030.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(Model model){


        return "login";
    }


}
