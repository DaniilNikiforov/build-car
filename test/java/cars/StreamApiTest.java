package cars;

import enam.WheelTypes;
import org.junit.Assert;
import org.junit.Test;
import sream.StreamApi;

import java.util.List;
import java.util.Map;

public class StreamApiTest {

    private StreamApi streamApi;
    private Car truck1;
    private Car truck2;
    private Jeep jeep;
    private Supercar supercar;
    private int actualSum;
    private double actualAverageWeight;


    public StreamApiTest() {
        Engine truckEngine = new Engine(500, 140, 10);
        Engine supercarEngine = new Engine(700, 340, 7);
        Engine jeepEngine = new Engine(250, 160, 5);
        truck1 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        truck2 = new Truck(5000, "White", truckEngine, WheelTypes.SUMMER, 10000, true);
        jeep = new Jeep(2500, "Black", jeepEngine, WheelTypes.ROADLESS, 500, 5);
        supercar = new Supercar.Builder()
                .setWeight(1300)
                .setColor("Red")
                .setWheelType(WheelTypes.SPORTS)
                .setEngine(supercarEngine)
                .setNumberOfPassengers(2)
                .setCabriolet(true)
                .build();

        streamApi = new StreamApi(List.of(truck1, truck2, jeep, supercar));
        actualSum = supercar.getWeight();
        actualAverageWeight = (truck1.getWeight() + truck2.getWeight() + supercar.getWeight() + jeep.getWeight()) / 4;
    }

    @Test
    public void findAllSupercar_ListOfCars_CorrectValue() {
        List<Car> expected = streamApi.findAllSupercar();
        Assert.assertEquals(expected.size(), 1);
        Assert.assertEquals(expected.get(0), supercar);
    }

    @Test
    public void findAllSupercarWeight_ListOfCars_CorrectValue() {
        int expectedSum = streamApi.findAllSupercarWeight();
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void findMaxCarEnginePower_ListOfCars_CorrectValue() {
        Car expectedCar = streamApi.findMaxCarEnginePower();
        Assert.assertEquals(expectedCar, supercar);
    }

    @Test
    public void findAverageWeight_ListOfCars_CorrectValue() {
        double expectedValue = streamApi.findAverageWeight();
        Assert.assertEquals(expectedValue, actualAverageWeight, 0.001);
    }

    @Test
    public void findMapCarWithKeyValue_ListOfCars_CorrectValue() {
        Map<List<Car>, List<Car>> expectedMap = streamApi.findMapCarWithKeyValue(WheelTypes.SUMMER);
        List<Car> actualCorrectCar = List.of(truck1,truck2);
        List<Car> actualIncorrectCar = List.of(supercar,jeep);
        List<Car> expectedCorrectCar = null;
        List<Car> expectedIncorrectCar = null;
        for(Map.Entry<List<Car>, List<Car>> entry : expectedMap.entrySet()){
            expectedCorrectCar = entry.getKey();
            expectedIncorrectCar = entry.getValue();
        }
        Assert.assertEquals(expectedCorrectCar.size(), actualCorrectCar.size());
        Assert.assertEquals(expectedIncorrectCar.size(), actualIncorrectCar.size());
        for(Car car: expectedCorrectCar){
            Assert.assertTrue(actualCorrectCar.contains(car));
        }
        for(Car car: expectedIncorrectCar){
            Assert.assertTrue(actualIncorrectCar.contains(car));
        }
    }

}
