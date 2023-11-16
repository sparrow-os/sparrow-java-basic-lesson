package com.sparrow.spring.starter.test;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class SparrowTestExecutionListener implements TestExecutionListener {
    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("prepareTestInstance");

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("beforeTestMethod");

    }

    @Override
    public void beforeTestExecution(TestContext testContext) throws Exception {
        System.out.println("beforeTestExecution");

    }

    @Override
    public void afterTestExecution(TestContext testContext) throws Exception {
        System.out.println("afterTestExecution");

    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("afterTestMethod");

    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println("afterTestClass");

    }
}
