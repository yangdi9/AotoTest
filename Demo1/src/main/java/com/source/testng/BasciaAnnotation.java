package com.source.testng;
import org.testng.annotations.*;

public class BasciaAnnotation {
    @Test
    public void test01(){
        System.out.println("2222222");
    }

    @BeforeMethod
    public void beformethod(){
        System.out.println("beformethod");
    }
    @AfterMethod
    public void afterrmethod(){
        System.out.println("aftermethod");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("afterclass");
    }
}
