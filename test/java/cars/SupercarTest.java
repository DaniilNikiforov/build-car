package cars;

import enam.WheelTypes;
import org.junit.Assert;
import org.junit.Test;

public class SupercarTest {

    @Test(expected = RuntimeException.class)
    public void setNumberOfPassengers_InvalidValue_RuntimeException(){
        Supercar supercar = new Supercar.Builder()
                .setNumberOfPassengers(-5)
                .build();
    }

    @Test
    public void setNumberOfPassengers_CorrectValues_True(){
        Supercar supercar = new Supercar.Builder()
                .setWeight(1200)
                .setColor("Red")
                .setWheelType(WheelTypes.SPORTS)
                .setNumberOfPassengers(2)
                .setCabriolet(true)
                .setEngine(null)
                .build();
        Assert.assertEquals(supercar.getWeight(), 1200);
        Assert.assertEquals(supercar.getColor(), "Red");
        Assert.assertEquals(supercar.getWheelType(), WheelTypes.SPORTS);
        Assert.assertEquals(supercar.isCabriolet(), true);
        Assert.assertEquals(supercar.getEngine(), null);
        Assert.assertEquals(supercar.getNumberOfPassenger(), 2);
    }

}
