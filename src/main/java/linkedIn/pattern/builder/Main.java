package linkedIn.pattern.builder;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();

        //simple constructions:
        simpleCarBuilder(carBuilder);

        // complex constructions:
        // 1) general approach
        generalApproach(carBuilder);

        // 2) better approach
        betterApproach(carBuilder);

        // 3) the best
        bestApproach();

    }

    private static void simpleCarBuilder(CarBuilder carBuilder) {
        Car newCar = carBuilder.setColor("Green").setModel("S").createCar();
        System.out.println(newCar);
    }

    private static void generalApproach(CarBuilder carBuilder) {
        Car car1 = carBuilder.setColor("Green").setModel("S").createCar();
        Car car2 = carBuilder.setColor("Green").setModel("S").createCar();

        ArrayList<Car> listOfCars = new ArrayList<>();
        listOfCars.add(car1);
        listOfCars.add(car2);

        CarPark park = new CarPark(listOfCars);
    }

    private static void betterApproach(CarBuilder carBuilder) {
        Car car1 = carBuilder.setColor("Green").setModel("S").createCar();
        Car car2 = carBuilder.setColor("Green").setModel("S").createCar();

        ArrayList<Car> listOfCars = new CarListBuilder().addList()
                .addCarToTheList(car1)
                .addCarToTheList(car2)
                .build();

        CarPark park = new CarPark(listOfCars);
    }

    private static void bestApproach() {
        ArrayList<Car> listOfCars = new CarListBuilder().addList()
                .addCarToTheList().setModel("E").addCarToList()
                .addCarToTheList().setName("BMW").addCarToList()
                .build();

        CarPark park = new CarPark(listOfCars);
    }

}
