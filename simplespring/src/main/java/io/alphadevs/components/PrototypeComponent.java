package io.alphadevs.components;

public class PrototypeComponent {

    private String componentProperty;

    public void setComponentProperty(String componentProperty) {
        this.componentProperty = componentProperty;
    }

    public String getComponentProperty() {
        return componentProperty;
    }

    public void init(){
        System.out.println("prototype initialised");
    }
}
