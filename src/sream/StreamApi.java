package sream;

import cars.Car;
import cars.Supercar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    List<Car> listCar;

    public StreamApi(List<Car> listCar) {
        this.listCar = listCar;
    }

    public List findAllSupercar() {
        return Arrays.stream(listCar.toArray()).filter(e -> e.getClass() == Supercar.class)
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
