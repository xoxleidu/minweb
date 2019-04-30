package com.example.minweb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter
public class CrosXssFilter implements Filter {
    // 多个跨域域名设置
    public static final String[] ALLOW_DOMAIN = {"http://localhost:8070",
            "http://localhost:8080", "http://localhost:8090"};

    private static final Logger logger = LoggerFactory.getLogger(CrosXssFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        //request.setCharacterEncoding("utf-8");
        //response.setContentType("application/json;charset=UTF-8");

        System.out.println("過濾器");

        //跨域设置
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String originHeader = req.getHeader("Origin");
        if (Arrays.asList(ALLOW_DOMAIN).contains(originHeader)) {
            //通过在响应 header 中设置 ‘*’ 来允许来自所有域的跨域请求访问。
            res.setHeader("Access-Control-Allow-Origin", originHeader);
            //通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
            //设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
            res.setHeader("Access-Control-Allow-Credentials", "true");
            //请求方式
            res.setHeader("Access-Control-Allow-Methods", "*");
            //（预检请求）的返回结果（即 Access-Control-Allow-Methods 和Access-Control-Allow-Headers 提供的信息） 可以被缓存多久
            res.setHeader("Access-Control-Max-Age", "86400");
            //首部字段用于预检请求的响应。其指明了实际请求中允许携带的首部字段
            //res.setHeader("Access-Control-Allow-Headers", "*");
            res.setHeader("Access-Control-Allow-Headers", "Timestamp,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy(){

    }
}
