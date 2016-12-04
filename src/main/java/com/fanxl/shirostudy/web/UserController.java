package com.fanxl.shirostudy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fanxl on 2016/11/30 0030.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(){
        logger.info("to list");
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(){
        logger.info("to add");
        return "user/add";
    }
}
