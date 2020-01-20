package linkedIn.pattern.builder;

public class Car {

    private double weight;
    private int wheels;
    private String name;
    private String model;
    private int numberOfSeats;
    private String ownerName;
    private String color;

    public Car(double weight, int wheels, String name, String model, int numberOfSeats,
            String ownerName, String color) {
        this.weight = weight;
        this.wheels = wheels;
        this.name = name;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.ownerName = ownerName;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", wheels=" + wheels +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", ownerName='" + ownerName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
