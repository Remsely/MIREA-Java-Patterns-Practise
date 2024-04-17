package edu.remsely.java_patterns.pr7;

interface Formula1CarComponent {
    void start();
    void stop();
}

class Engine implements Formula1CarComponent {
    @Override
    public void start() {
        System.out.println("Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Engine stop");
    }
}

class Gearbox implements Formula1CarComponent {
    @Override
    public void start() {
        System.out.println("Gearbox start");
    }

    @Override
    public void stop() {
        System.out.println("Gearbox stop");
    }
}

class SteeringWheel implements Formula1CarComponent {
    @Override
    public void start() {
        System.out.println("SteeringWheel start");
    }

    @Override
    public void stop() {
        System.out.println("SteeringWheel stop");
    }
}

class Facade {
    private final Formula1CarComponent engine;
    private final Formula1CarComponent gearbox;
    private final Formula1CarComponent steeringWheel;

    public Facade() {
        engine = new Engine();
        gearbox = new Gearbox();
        steeringWheel = new SteeringWheel();
    }

    public void start() {
        engine.start();
        gearbox.start();
        steeringWheel.start();
    }

    public void stop() {
        steeringWheel.stop();
        gearbox.stop();
        engine.stop();
    }
}

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.start();
        System.out.println();
        facade.stop();
    }
}
