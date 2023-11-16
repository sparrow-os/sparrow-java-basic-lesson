package com.sparrow.spring.boot.test;

import com.sparrow.passport.SparrowApplication;
import com.sparrow.spring.starter.test.SparrowTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SparrowApplication.class})
@TestExecutionListeners(listeners = {SparrowTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class TestWithBoostrap {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testSpring() {
        System.out.println(dataSource);
    }
}
