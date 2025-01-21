package com.casestudy1.webapp.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ErrorHandlingController {

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "404";
    }
}

