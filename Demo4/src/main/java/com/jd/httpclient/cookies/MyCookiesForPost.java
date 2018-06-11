package com.jd.httpclient.cookies;


import com.sun.deploy.nativesandbox.comm.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookie信息的变量
    private CookieStore cookieStore;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void  testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接测试url
        String uri = bundle.getString("getCookies.url");
        String testurl = this.url+uri;
        //测试逻辑代码书写
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString( response.getEntity(),"UTF-8");
        System.out.println(result);
        //获取cookie信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookielist = cookieStore.getCookies();
        for (Cookie cookie : cookielist){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+ name+"cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("post./post/with/cookies");
        String testUrl = this.url+uri;
        //声明client对象，用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"UTF-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果存储
        String result;
        //设置cookie信息
        client.setCookieStore(this.cookieStore);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果转化成json对象
        JSONObject resultjson = new JSONObject(result);
        //具体的判断返回结果的值
        //获取结果值
        String success = (String) resultjson.get("huhansan");
        String status = (String) resultjson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
