package io.alphadevs.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class ScannedPrototypeComponent {
    public String name = "prototype Component";

    @Override
    public String toString() {
        return "ScannedPrototypeComponent{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("prototype initialised");
    }
}
