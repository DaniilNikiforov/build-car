package list;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public  class ListCars {
        private List<Car> listCars;

        public ListCars() {
            listCars = new ArrayList<>();
        }

        public void addCar(Car car) {
            listCars.add(car);
        }

        public void removeCar(Car car){
            listCars.remove(car);
        }

        public int getSize(){
            return listCars.size();
        }

        public void printAll() {
            for (Car car : listCars) {
                System.out.println(car);
            }
        }
    }