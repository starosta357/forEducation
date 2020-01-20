package linkedIn.pattern.builder;

public interface Builder {

    Builder setWeight(double weight);

    Builder setWheels(int wheels);

    Builder setName(String name);

    Builder setModel(String model);

    Builder setNumberOfSeats(int numberOfSeats);

    Builder setColor(String color);
}
