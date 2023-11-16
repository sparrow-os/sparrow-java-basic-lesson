package com.sparrow.spring.starter.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication(scanBasePackages = "com.sparrow.*")
@TestPropertySource("classpath:application.properties")  //配置文件注入
@TestExecutionListeners(listeners = {SparrowTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public @interface TestWithoutBootstrap {
    /**
     * @RunWith(SpringJUnit4ClassRunner.class)
     * 与
     * @RunWith(SpringRunner.class) 相同
     * @RunWith(SpringRunner.class) 是@RunWith(SpringJUnit4ClassRunner.class)
     * 的子类
     *
     * 工具类中单元测试使用 TestWithoutBootstrap 类，不需要使用
     * @SpringBootTest(classes = {Application.class})
     * 但需要配置
     *
     * @SpringBootApplication(scanBasePackages = "com.sparrow.*")
     * @TestPropertySource("classpath:application.properties")  //配置文件注入
     */

    /**
     * DependencyInjectionTestExecutionListener
     * 在测试类中 在容器启动前执行需要定义一个TestExecutionListener
     * SparrowTestExecutionListener
     * 但在测试类中使用@Autowired注入的bean为null
     * 需要配置DependencyInjectionTestExecutionListener 提供支持
     */
}
