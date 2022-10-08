package com.sparrow.passport.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        logger.info("info");
        div(1, 0);
        System.out.println("end");
    }

    public static int div(int a, int b) throws Exception {
        try {
            return a / b;
        } catch (RuntimeException e) {
            System.err.println("error ");
//            return 0;
             throw new Exception("aaa");
        }
    }
}
