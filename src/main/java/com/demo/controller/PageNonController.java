package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageNonController {

    @RequestMapping(value = "/pageNon", method= RequestMethod.GET)
    public String pageNonView() {
        return "site.pageNon";
    }
}
