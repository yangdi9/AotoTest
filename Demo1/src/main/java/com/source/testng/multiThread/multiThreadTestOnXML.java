package com.source.testng.multiThread;

import org.testng.annotations.Test;

public class multiThreadTestOnXML {
    @Test
    public void test1(){
        System.out.printf("A Thread id : %s%n", Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("B Thread id : %s%n", Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("C Thread id : %s%n", Thread.currentThread().getId());
    }
}
