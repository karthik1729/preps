package io.alphadevs;

import io.alphadevs.components.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    // Load using XML
    // Showing singleton and prototype scopes
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        SingletonComponent singletonComponent = applicationContext.getBean(SingletonComponent.class);
        singletonComponent.setComponentProperty("Hello");
        System.out.println(singletonComponent.getComponentProperty());

        SingletonComponent singletonComponent2 = applicationContext.getBean(SingletonComponent.class);
        System.out.println(singletonComponent2.getComponentProperty());


        PrototypeComponent prototypeComponent = applicationContext.getBean(PrototypeComponent.class);
        prototypeComponent.setComponentProperty("Hello");
        System.out.println(prototypeComponent.getComponentProperty());

        PrototypeComponent prototypeComponent2 = applicationContext.getBean(PrototypeComponent.class);
        prototypeComponent2.setComponentProperty("Hello2");
        System.out.println(prototypeComponent2.getComponentProperty());


        ComplexComponent bean = applicationContext.getBean(ComplexComponent.class);
        System.out.println(applicationContext.getBean(AutowiredComponent.class));
        bean.printAutoWiredComponent();


        System.out.println(applicationContext.getBean(AutowiredPrototypeComponent.class));
        bean.printAutoWiredPrototypeComponent();


    }
}
