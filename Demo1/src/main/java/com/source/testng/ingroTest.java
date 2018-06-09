package com.source.testng;

import org.testng.annotations.Test;

public class ingroTest {
   @Test
    public void ingrotest(){
       System.out.println("执行");
    }

    @Test(enabled = true)
    public void ingrotest02(){
        System.out.println("2执行");
    }
}
