package edu.remsely.java_patterns.pr8;


import lombok.Setter;

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague1 received Message: " + message);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague2 received Message: " + message);
    }
}

@Setter
class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague1.receiveMessage(message);
        } else if (colleague == colleague2) {
            colleague2.receiveMessage(message);
        }
    }
}

public class MediatorTest {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(c1);
        mediator.setColleague2(c2);

        c1.sendMessage("Hello!");
        c2.sendMessage("Buy!");
    }
}
