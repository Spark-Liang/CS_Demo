package org.sparkliang.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "hello, world";
    }



}
