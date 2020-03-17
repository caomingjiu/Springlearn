package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTeacher {
    private static Logger logger = LoggerFactory.getLogger(TestTeacher.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Teacher teacher = (Teacher) ac.getBean("teacher");
        logger.info(teacher.toString());
    }
}
