package sream;

import cars.Car;
import cars.Supercar;
import enam.WheelTypes;

import java.util.*;
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

    public int findAllSupercarWeight() {
        return listCar.stream().filter(e -> e.getClass() == Supercar.class)
                .mapToInt(e -> e.getWeight()).sum();
    }

    public Car findMaxCarEnginePower() {
        return listCar
                .stream()
                .max(Comparator.comparingInt(x -> x.getEngine().getHorsepower()))
                .get();
    }

    public double findAverageWeight() {
        return listCar.stream()
                .mapToInt(e -> e.getWeight())
                .average().orElseThrow(NoSuchElementException::new);
    }

    public Map<List<Car>, List<Car>> findMapCarWithKeyValue(WheelTypes wheelTypes) {
        Map<List<Car>, List<Car>> map = new HashMap<>();

        List<Car> correctCar = new ArrayList<>();
        List<Car> incorrectCar = new ArrayList<>();
        map.put(correctCar, incorrectCar);

        listCar.stream().forEach(
                e -> {
                    if (e.getWheelType() == wheelTypes) {
                        correctCar.add(e);
                    } else {
                        incorrectCar.add(e);
                    }
                });
        return map;
    }


}
