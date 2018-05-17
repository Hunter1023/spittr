package com.hunter.spittr.controller;

import com.hunter.spittr.Service.SpitterService;
import com.hunter.spittr.meta.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @Resource
    private SpitterService spitterService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        /**
         jsp页面的<sf:form>通过modelAttribute(旧用commandName)构建针对某个模型对象"spitter"的上下文信息，
         其他的表单绑定标签中会引用这个模型对象的属性
         在模型中必须要有一个key为"spitter"的对象，否则表单无法正常渲染
         因此往视图模型中添加一个key为"spitter"的Spitter对象
         */
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid Spitter spitter,
                           Errors errors) {
        //如果校验出现错误，则重新返回表单
        if (errors.hasErrors()) {

            return "registerForm";
        }
        //需要检验用户名是否已存在
        boolean isRegistered = spitterService.isRegistered(spitter);
        if(isRegistered == true){
            return "registerForm";
        }
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username,
                                     Model model) {
        Spitter spitter = spitterService.getByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }
}