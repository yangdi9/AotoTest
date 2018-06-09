package com.source.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupOnMethod {
    @Test(groups="server")
    public void test01(){
        System.out.println("服务端测试1");
    }
    @Test(groups="server")
    public void test02(){
        System.out.println("服务端测试2");
    }

    @Test(groups="client")
    public void test03(){
        System.out.println("客户端测试1");
    }
    @Test(groups="client")
    public void test04(){
        System.out.println("客户端测试2");
    }
    @BeforeGroups("server")
    public void test05(){
        System.out.println("服务端组运行之前");
    }
    @AfterGroups("server")
    public void test06(){
        System.out.println("服务端组运行之后");
    }

    @BeforeGroups("client")
    public void test07(){
        System.out.println("客户端组运行之前");
    }
    @AfterGroups("client")
    public void test08(){
        System.out.println("客户端组运行之后");
    }
}
