package io.alphadevs;

import io.alphadevs.components.PrototypeComponent;
import io.alphadevs.components.ScannedPrototypeComponent;
import io.alphadevs.components.ScannedSingletonComponent;
import io.alphadevs.components.SingletonComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUsingAnnotations {


    // Load using XML and annotations from xml
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        ScannedPrototypeComponent prototypeComponent = applicationContext.getBean(ScannedPrototypeComponent.class);
        ScannedSingletonComponent singletonComponent = applicationContext.getBean(ScannedSingletonComponent.class);
        System.out.println(prototypeComponent);
        System.out.println(singletonComponent);
    }
}
