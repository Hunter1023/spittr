package com.hunter.spittr.controller;

import com.hunter.spittr.meta.Spitter;
import com.hunter.spittr.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    SpitterService spitterService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        HttpSession session) {

        //判断session中是否已有用户对象
        Spitter spitter = (Spitter)session.getAttribute("spitter");
        if (spitter != null){
            model.addAttribute("username", spitter.getUsername());
            return "redirect:/{username} ";
        }
        model.addAttribute("spitter", new Spitter());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username,
                        String password,
                        Model model,
                        HttpSession session) {
        Spitter spitter = spitterService.verifySpitter(username, password);
        if (spitter != null) {
            model.addAttribute("username", spitter.getUsername());
            session.setAttribute("spitter", spitter);
            return "redirect:/{username} ";
        }

        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("spitter");
        return "redirect:/login";
    }
}
