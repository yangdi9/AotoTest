package com.source.testng;

import org.testng.annotations.Test;

public class ExpectException {
    /**
     * 在期望结果为某个异常的时候，比如传入不合法参数，程序抛出异常
     * 预期结果就是这个异常
     */
   @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSucess(){
        System.out.println("这是一个异常的测试");
       throw new RuntimeException();
    }
}
