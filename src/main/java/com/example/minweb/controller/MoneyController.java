package com.example.minweb.controller;

import com.example.minweb.service.MoneyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DecimalFormat;

@Controller
@RequestMapping("/money")
public class MoneyController {

    @Resource
    private MoneyService moneyService;

    @GetMapping("/mtmView/{fromid}")
    public ModelAndView mtmView(@PathVariable("fromid") Integer fromid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("fromId",fromid);
        mav.setViewName("view");
        return mav;
    }

    @PostMapping("/mtm")
    public String mTom(Integer fromId, Integer toId, Float money,Integer gender){
        System.out.println(fromId + " - " + toId + " - " + money);
        if (gender == 0) {
            System.out.println("正常");
            try {
                moneyService.mTom(fromId,toId,money);
                return "redirect:/student/list";
            }catch (Exception e){
                return "No";
            }
        } else {
            System.out.println("异常");
            try {
                moneyService.mTomX(fromId,toId,money);
                return "redirect:/student/list";
            }catch (Exception e){
                return "redirect:/student/list";
            }
        }

    }


}
