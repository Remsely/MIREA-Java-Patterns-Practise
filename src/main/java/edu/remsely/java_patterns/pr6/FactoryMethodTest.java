package edu.remsely.java_patterns.pr6;

abstract class Product {
    public abstract void use();
}

class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("ConcreteProductA");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("ConcreteProductB");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();

    public void anOperation() {
        Product product = factoryMethod();
        product.use();
    }
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Creator creatorB = new ConcreteCreatorB();

        creatorA.anOperation();
        creatorB.anOperation();
    }
}
