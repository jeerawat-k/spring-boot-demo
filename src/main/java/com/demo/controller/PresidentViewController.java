package com.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PresidentViewController {
    private Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/president", method= RequestMethod.GET)
    public String presidentview() {
        return "site.president";
    }
}
