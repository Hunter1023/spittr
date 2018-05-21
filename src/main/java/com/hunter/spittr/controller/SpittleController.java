package com.hunter.spittr.controller;

import com.hunter.spittr.controller.exception.SpittleNotFoundException;
import com.hunter.spittr.meta.Spitter;
import com.hunter.spittr.service.SpittleService;
import com.hunter.spittr.meta.Spittle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Resource
    private SpittleService spittleService;
    //分页展示相关
    private final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    //获取动态列表
    @RequestMapping(method = RequestMethod.GET)
    public String getSpittleList(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                 @RequestParam(value = "count", defaultValue = "20") int count,
                                 Model model) {
        model.addAttribute("spittle", new Spittle(null, null));
        model.addAttribute("spittleList", spittleService.getSpittleList(max, count));
        return "spittleList";
    }

    //获取单条动态
//    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
//    public String getSpittle(@PathVariable("spittleId") long spittleId,
//                             Model model) {
//
//        Spittle spittle = spittleService.getSpittle(spittleId);
//
//        if (spittle == null) {
//
//            throw new SpittleNotFoundException();
//        }
//
//        model.addAttribute("spittle", spittle);
//        return "spittle";
//    }

    //发送动态
    @RequestMapping(method = RequestMethod.POST)
    public String publishSpittle(@Valid Spittle spittle,
                                 Errors errors,
                                 Model model) {
        //如果校验出现错误，则重新返回表单
        if (errors.hasErrors()) {
            return "/spittles";
        }

        spittleService.publishSpittle(new Spittle(spittle.getMessage(), new Date()));
        return "redirect:/spittles";
    }
}
