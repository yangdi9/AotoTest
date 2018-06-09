package com.source.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试
 */
public class multiThreadTest {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread id : %s%n", Thread.currentThread().getId());
    }
}
