package io.alphadevs.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("singleton")
public class ScannedSingletonComponent {
    public String name = "singleton Component";

    @Override
    public String toString() {
        return "ScannedSingletonComponent{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("singleton initialised");
    }
}
