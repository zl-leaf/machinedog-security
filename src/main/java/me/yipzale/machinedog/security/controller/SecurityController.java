package me.yipzale.machinedog.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
    @RequestMapping(value = "/security/login")
    public String login(Model model) {
        return "login";
    }
}
