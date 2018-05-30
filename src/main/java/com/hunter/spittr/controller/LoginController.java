package com.hunter.spittr.controller;

import com.hunter.spittr.meta.Spitter;
import com.hunter.spittr.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String login(@Valid Spitter spitter,
                        Errors errors,
                        Model model,
                        HttpSession session) {

        if (errors.hasErrors()) {
            return "login";
        }

        //验证用户名和密码是否正确
        Spitter spitter1 = spitterService.verifySpitter(spitter);
        if (spitter1 != null) {
            model.addAttribute("username", spitter1.getUsername());
            session.setAttribute("spitter", spitter1);
            return "redirect:/{username} ";
        }

        model.addAttribute("msg","用户名或密码错误！");
        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("spitter");
        return "redirect:/register";
    }
}
