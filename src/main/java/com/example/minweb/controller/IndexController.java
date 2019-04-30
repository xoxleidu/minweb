package com.example.minweb.controller;

import com.example.minweb.utils.CookieUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "redirect:/index";
    }

    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public ResData login(HttpServletRequest request) {
        System.out.println("login");
        request.getSession().setAttribute("token","aabbcc0");
        Object token = request.getSession().getAttribute("token");
        System.out.println(token.toString());
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
    public ResData info(HttpServletRequest request) {
        System.out.println("info");
        String token = (String)request.getSession().getAttribute("token");
        System.out.println(token);
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
    public ResData testts() {
        System.out.println("table");
        return null;
    }

    @RequestMapping(value = "/setSession", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object setSession(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam("key") String key
            , @RequestParam("value") String value) {
        System.out.println(session);
        Map<String, Object> result = new HashMap<>();
        request.getSession().setAttribute(key, value);
        result.put("setSession-session_id", session.getId());
        result.put("session_key", key);
        result.put("session_value", value);
        CookieUtils.writeCookie(response, key, value);
        //return ResultUtil.success(result);
        return result;
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public Object getSession(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam("key") String key) {
        System.out.println(session);
        Map<String, Object> result = new HashMap<>();
        result.put("getSession-session_id", session.getId());
        result.put("session_key", key);
        result.put("cookie获取session_value", CookieUtils.getCookie(request, key));
        //return ResultUtil.success(result);
        return result;
    }

}
