package edu.remsely.java_patterns.pr6;

import lombok.Setter;
import lombok.ToString;

interface Builder {
    Builder buildWheels();

    Builder buildEngine();

    Builder buildTransmission();

    Car build();
}

@Setter
@ToString
class Car {
    private String wheels;
    private String engine;
    private String transmission;
}

class CarBuilder implements Builder {
    private final Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    @Override
    public Builder buildWheels() {
        car.setWheels("Wheels");
        return this;
    }

    @Override
    public Builder buildEngine() {
        car.setEngine("Engine");
        return this;
    }

    @Override
    public Builder buildTransmission() {
        car.setTransmission("Transmission");
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}

class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        return builder.buildWheels().buildEngine().buildTransmission().build();
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new CarBuilder();
        Director director = new Director(builder);

        Car car = director.constructCar();
        System.out.println(car.toString());

        Car car2 = builder.buildWheels().buildEngine().buildTransmission().build();
        System.out.println(car2.toString());
    }
}
