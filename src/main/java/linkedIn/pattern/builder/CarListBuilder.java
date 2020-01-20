package linkedIn.pattern.builder;

import java.util.ArrayList;

public class CarListBuilder {

    private ArrayList<Car> listOfCars;

    public CarListBuilder addList(){
        this.listOfCars = new ArrayList<>();
        return this;
    }

    public CarListBuilder addCarToTheList(Car car){
        listOfCars.add(car);
        return this;
    }

    public CarBuilder addCarToTheList(){
        return new CarBuilder(this);
    }

    public ArrayList<Car> build(){
        return listOfCars;
    }

}
