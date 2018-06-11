package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过该方法可以获取cookies",httpMethod = "Get")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息
        //HttpServerletResponse 装响应信息
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }
    /**
     * 要求客户端携带cookies访问
     */
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "Get")
    @RequestMapping(value = "get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies来";
    }
    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式 url: key=value&key=value
     * 我们来模拟获取商品列表
     */
    @ApiOperation(value = "发一个需要携带参数才能访问的get请求",httpMethod = "Get")
    @RequestMapping(value = "get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getlist(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("鞋",400);
        mylist.put("干脆面",1);
        mylist.put("衬衫",300);
        return mylist;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url:id:port/get/with/param/10/20
     */
    @ApiOperation(value = "第二种需要携带参数访问的get请求",httpMethod = "Get")
    @RequestMapping(value = "get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("鞋",400);
        mylist.put("干脆面",1);
        mylist.put("衬衫",300);
        return mylist;
    }
}
