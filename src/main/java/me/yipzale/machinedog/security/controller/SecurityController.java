package me.yipzale.machinedog.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping(value = "/security")
public class SecurityController {
    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }
}
