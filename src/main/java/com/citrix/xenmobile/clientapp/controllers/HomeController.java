package com.citrix.xenmobile.clientapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Value("${client.fqdn}")
    private String clientFQDN;


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ModelAndView returnIndexPage(Model model){

        model.addAttribute("clientfqdn", clientFQDN);
        return new ModelAndView("index");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public ModelAndView returnHomePage(){
        return new ModelAndView("home");
    }
}
