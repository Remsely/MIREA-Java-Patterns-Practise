package edu.remsely.java_patterns.pr6;

import lombok.ToString;

interface Prototype {
    Prototype clone();
}

@ToString
class ConcretePrototype implements Prototype {
    private final String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }
}

public class PrototypeTest {
    public static void main(String[] args) {
        Prototype original = new ConcretePrototype("original");
        Prototype clone = original.clone();

        System.out.println(original);
        System.out.println(clone);
    }
}
