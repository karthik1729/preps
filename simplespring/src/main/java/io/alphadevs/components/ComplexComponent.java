package io.alphadevs.components;

public class ComplexComponent {

    private AutowiredComponent autowiredComponent;

    private AutowiredPrototypeComponent autowiredPrototypeComponent;

    public void printAutoWiredComponent(){
        System.out.println(autowiredComponent);
    }

    public void printAutoWiredPrototypeComponent(){
        System.out.println(autowiredPrototypeComponent);
    }

    public void setAutowiredComponent(AutowiredComponent autowiredComponent) {
        this.autowiredComponent = autowiredComponent;
    }

    public AutowiredPrototypeComponent getAutowiredPrototypeComponent() {
        return autowiredPrototypeComponent;
    }

    public void setAutowiredPrototypeComponent(AutowiredPrototypeComponent autowiredPrototypeComponent) {
        this.autowiredPrototypeComponent = autowiredPrototypeComponent;
    }
}
