package com.jd.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
        List<Cookie>cookielist = cookieStore.getCookies();
        for (Cookie cookie : cookielist){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+ name+"cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("get.get/with/cookies");
        String testurl = this.url+uri;
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应状态码="+statusCode);
        if(statusCode==200){
            result = EntityUtils.toString( response.getEntity(),"UTF-8");
            System.out.println(result);
        }

    }
}
