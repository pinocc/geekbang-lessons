package com.pinocc.learn.spring.ioc.overview.lookup;

import com.pinocc.learn.spring.ioc.overview.annotation.Super;
import com.pinocc.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author wu on 2021/4/5
 * @version 1.0
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependence-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("getBeansWithAnnotation:" + beans);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("getBeansOfType:" + userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookup by type:" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> userFactory = (ObjectFactory<User>) beanFactory.getBean("userFactory");
        User user = userFactory.getObject();
        System.out.println(user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        Object user = beanFactory.getBean("user");
        System.out.println(user);
    }
}
