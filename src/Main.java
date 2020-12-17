import cars.*;
import enam.WheelTypes;
import exception.IncorrectEnteredValueException;
import list.ListCars;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String newSupercar = "1250,Red,Sports,370,280,5,true,2";
        Car supercar = parseStringToSupercar(newSupercar);
        Car copyOfSupercar = parseStringToSupercar(newSupercar);
        if (supercar.equals(copyOfSupercar)) {  //equals() and hashCode() are not override
            System.out.println("supercar and copyOfSupercar are equal");
        }

        Engine truckEngine = new Engine(500, 140, 10);
        Car truck = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Car copyOfTruck = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        if (truck.equals(copyOfTruck)) {  // Overrode equals() and hashCode()
            System.out.println("truck and copyOfTruck are equal");
        }

        testTruckException((Truck) truck);
        ListCars listCars = new ListCars();
        listCars.addCar(supercar);
        listCars.addCar(truck);
        listCars.printAll();
    }

    public static void testTruckException(Truck truck) {
        try {
            double money = truck.moneyForGasolineOnTrip(100);
           System.out.println(money + " grn");
        } catch (IncorrectEnteredValueException e) {
            System.out.println(e.getMessage());

        } finally {

        }
    }

    public static Supercar parseStringToSupercar(String newSupercar) {
        String[] values = newSupercar.split(",");
        Engine supercarEngine = new Engine();
        supercarEngine.setHorsepower(Integer.parseInt(values[3]));
        supercarEngine.setMaxSpeed(Integer.parseInt(values[4]));
        supercarEngine.setNumberOfGears(Integer.parseInt(values[5]));

        return new Supercar.Builder()
                .setWeight(Integer.parseInt(values[0])) //Builder
                .setColor(values[1])
                .setWheelType(WheelTypes.valueOf(values[2].toUpperCase()))
                .setCabriolet(Boolean.valueOf(values[6]))
                .setNumberOfPassengers(Integer.parseInt(values[7]))
                .setEngine(supercarEngine)
                .build();
    }
}
