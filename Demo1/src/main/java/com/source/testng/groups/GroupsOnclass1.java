package com.source.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "techer")
public class GroupsOnclass1 {
    public void teacher1(){
        System.out.println("GroupsOnclass1中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnclass1中的teacher2运行");
    }
}
