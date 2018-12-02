package org.learing.spring.beanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(bean.getTestStr());
    }
}
