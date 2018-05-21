package com.hunter.spittr.controller;

import com.hunter.spittr.service.SpitterService;
import com.hunter.spittr.meta.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    public String register(HttpServletRequest request,
                           @RequestPart("icon") MultipartFile icon,
                           @Valid Spitter spitter,
                           Errors errors) throws IOException {
        //如果校验出现错误，则重新返回表单
        if (errors.hasErrors()) {

            return "registerForm";
        }
        //需要检验用户名是否已存在（需要改进为通过validator实现），若用户名未存在，将新用户的相关信息插入数据库
        boolean isRegistered = spitterService.isRegistered(spitter);
        if (isRegistered == true) {
            return "registerForm";
        }

        //判断是否有上传图片
        if (!icon.isEmpty()) {
            //获取webapp部署的目录，函数的参数 是根目录下的子目录路径
            String contextPath = request.getSession().getServletContext().getRealPath("/");
            //创建图片目录
            File dir = new File(contextPath + "images/headIcon");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            /**
             * 以 上传时间+文件原名 为名保存图片，
             * getTime 方法返回 代表从1970年1月1日开始（unix系统的时间戳起点）计算到Date对象中的时间之间的毫秒数。
             */
            icon.transferTo(new File(dir.getAbsolutePath() + "/" +
                    new Date().getTime() + icon.getOriginalFilename()));
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