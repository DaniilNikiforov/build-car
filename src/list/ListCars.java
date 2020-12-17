package list;

import cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListCars {
    private List<Car> listCars;

    public ListCars() {
        listCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        listCars.add(car);
    }

    public void removeCar(Car car) {
        listCars.remove(car);
    }

    public int getSize() {
        return listCars.size();
    }

    public void printAll(List<Car> newListCars) {
        for (Car car : newListCars) {
            System.out.println(car);
        }
    }

    public void printAll(Set<Car> newListCars) {
        for (Car car : newListCars) {
            System.out.println(car);
        }
    }

    public void printAll() {
        for (Car car : listCars) {
            System.out.println(car);
        }
    }
}