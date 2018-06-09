package com.source.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class suiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite 运行");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite运行");
    }
}
