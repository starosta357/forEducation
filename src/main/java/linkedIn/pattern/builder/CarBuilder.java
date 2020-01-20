package linkedIn.pattern.builder;

public class CarBuilder implements Builder {

    private double weight;
    private int wheels;
    private String name;
    private String model;
    private int numberOfSeats;
    private String ownerName;
    private String color;
    private CarListBuilder carListBuilder;

    public CarBuilder() {
    }

    public CarBuilder(CarListBuilder carListBuilder) {
        this.carListBuilder = carListBuilder;
    }

    public CarListBuilder addCarToList(){
        Car car = createCar();
        this.carListBuilder.addCarToTheList(car);
        return this.carListBuilder;
    }

    @Override
    public CarBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public CarBuilder setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    @Override
    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public CarBuilder setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Car createCar() {
        return new Car(weight, wheels, name, model, numberOfSeats, ownerName, color);
    }
}