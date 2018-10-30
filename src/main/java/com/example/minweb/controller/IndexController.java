package com.example.minweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "redirect:/index";
    }

    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public ResData login() {
        System.out.println("login");
        //System.out.println(user.getUsername());
        //System.out.println(user.getPassword());
        Data data = new Data();
        data.setToken("admin");
        ResData resdata = new ResData();
        resdata.setData(data);
        resdata.setCode("000");
        resdata.setMessage("ok");

        String res = "{data:[{token:'admin',code:20000,message:'ere'}]}";

        return resdata;
    }

    @CrossOrigin
    @GetMapping("/info")
    @ResponseBody
    public ResData info() {
        System.out.println("info");

        Roles roles = new Roles();
        roles.setRoles("admin");
        Data data = new Data();
        data.setAvatar("");
        data.setName("admin");
        data.setRoles(roles);
        ResData resdata = new ResData();
        resdata.setData(data);
        resdata.setCode("000");
        resdata.setMessage("ok");
        return resdata;
    }

    @CrossOrigin
    @PostMapping("/buscenter/drivermange/findDriverInfoByPage")
    @ResponseBody
    public ResData testts(){
        System.out.println("table");
        return null;
    }

}
