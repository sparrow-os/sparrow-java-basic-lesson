package com.sparrow.spring.clazz.reader;

//import com.lesson.commons.config.wrong.ClassNotFoundConfig;
//import com.lesson.commons.config.wrong.ExistingClass;

import com.lesson.commons.config.wrong.ClassNotFoundConfig;
import com.lesson.commons.config.wrong.ExistingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * 以下代码模拟以下源码实现:
 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 * 方法: 通过反射获取方法
 * protected Class<?> getTypeForFactoryMethod(String beanName, RootBeanDefinition mbd, Class<?>... typesToMatch)
 */
public class ClassReaderTest {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //ClassNotFoundConfig.class.getDeclaredAnnotations();
        //Method method = ClassNotFoundConfig.class.getMethod("existingClass", null);
        //method.getDeclaredAnnotations();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(ClassNotFoundConfig.class.getName());

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        MergedAnnotations mergedAnnotations = annotationMetadata.getAnnotations();

//        MergedAnnotation<ConditionalOnClass> conditionalOnClass = mergedAnnotations.get(ConditionalOnClass.class);
//conditionalOnClass.getValue("value");


        for (MethodMetadata methodMetadata : annotationMetadata.getAnnotatedMethods(Bean.class.getName())) {
            System.out.println(methodMetadata.getMethodName());
            //if (methodMetadata.getMethodName().equalsIgnoreCase("existingClass")) {
            System.out.println(methodMetadata.getReturnTypeName());
            MergedAnnotation mergedAnnotation = methodMetadata.getAnnotations().get(ConditionalOnClass.class).getRoot();

            //AnnotatedElementUtils.hasAnnotation(methodMetadata,ConditionalOnClass.class)

            mergedAnnotation.getValue("value");
            //Class[] clazz2= conditionalOnClass.value();
            System.out.println(methodMetadata.getAnnotationAttributes("ConditionalOnClass"));
            //ClassUtils.getExistingClass()
            ClassNotFoundConfig configuration = new ClassNotFoundConfig();
            ClassNotFoundConfig.class.getMethods();
            Method method2 = ClassNotFoundConfig.class.getMethod("existingClass");
            method2.getAnnotation(ConditionalOnClass.class);
            ExistingClass existingClass = (ExistingClass) method2.invoke(configuration);
            System.out.println(existingClass);
            //}
        }
//        Resource resource = metadataReader.getResource();
//        ClassMetadata classMetadata = metadataReader.getClassMetadata();
    }
}
