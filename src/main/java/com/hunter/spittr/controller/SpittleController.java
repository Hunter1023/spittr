package com.hunter.spittr.controller;

import com.hunter.spittr.Service.SpittleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Resource
    private SpittleService spittleService;


    private final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    @RequestMapping(method = RequestMethod.GET)
    public String getSpittleList(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                 @RequestParam(value = "count", defaultValue = "20") int count,
                                 Model model) {
        model.addAttribute("spittleList", spittleService.getSpittleList(max, count));
        return "spittleList";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String getSpittle(@PathVariable("spittleId") long spittleId,
                             Model model) {
        model.addAttribute(spittleService.getSpittle(spittleId));
        return "spittle";
    }
}
