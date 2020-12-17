package cars;

import list.ListCars;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void setWeightNormalWeight() {
        int weight = 1000;
        Car car = new Jeep();
        car.setWeight(weight);
        Assert.assertEquals(car.getWeight(), weight);
    }

    @Test(expected = RuntimeException.class)
    public void setWeightWrongWeight() {
        Car car = new Jeep();
        car.setWeight(-100);
    }

    @Test
    public void addListCarToListCars() {
        ListCars list = new ListCars();
        Jeep jeep = new Jeep();
        Car truck = new Truck();
        Supercar supercar = new Supercar.Builder().build();
        list.addCar(jeep);
        list.addCar(truck);
        list.addCar(supercar);
        Assert.assertEquals(3, list.getSize());
        list.removeCar(jeep);
        list.removeCar(supercar);
        Assert.assertEquals(1,list.getSize());
    }
}
