package com.hunter.spittr.controller;

import com.hunter.spittr.meta.Spitter;
import com.hunter.spittr.service.SpitterService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            model.addAttribute("nickname", spitter.getNickname());
            return "redirect:/{nickname} ";
        }
        model.addAttribute("spitter", new Spitter());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid Spitter spitter,
                        Model model,
                        HttpSession session,
                        HttpServletResponse response) {

        //验证用户名和密码是否正确
        spitter = spitterService.verifySpitter(spitter);
        if (spitter != null) {
            Cookie userId = new Cookie("userId", String.valueOf(spitter.getId()));
            if(spitter.isAutoLogin()){//如果勾选了自动登录，则有效期跟session保持一致
                userId.setMaxAge(30*60);
            }
            response.addCookie(userId);
            model.addAttribute("nickname", spitter.getNickname());
            session.setAttribute("spitter", spitter);
            return "redirect:/{nickname}";
        }

        model.addAttribute("msg","用户名或密码错误！");
        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("spitter");

        return "redirect:/login";
    }
}
