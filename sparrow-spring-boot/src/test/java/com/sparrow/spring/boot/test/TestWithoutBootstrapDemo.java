package com.sparrow.spring.boot.test;

import com.sparrow.spring.starter.test.TestWithoutBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@TestWithoutBootstrap
public class TestWithoutBootstrapDemo {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testSpring() {
        System.out.println(dataSource);
    }
}
