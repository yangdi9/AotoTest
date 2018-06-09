package com.source.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass3 {
    public void stu1(){
        System.out.println("GroupOnClass3中的sut1111运行");
    }
    public void stu2(){
        System.out.println("GroupOnClass3中的sut2222运行");
    }
}
