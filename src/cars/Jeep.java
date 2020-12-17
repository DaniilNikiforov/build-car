package cars;

import enam.WheelTypes;
import interfaces.LiftingCapacity;
import interfaces.PassengerCapacity;

public class Jeep extends Car implements PassengerCapacity, LiftingCapacity {
    private int maxLiftingCapacity;
    private int numberOfPassenger;

    public Jeep() {
    }

    public Jeep(int weight, String color, Engine engine, WheelTypes wheelType, int maxLiftingCapacity, int numberOfPassenger) {
        super(weight, color, wheelType, engine);
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.numberOfPassenger = numberOfPassenger;
    }

    public void setMaxLiftingCapacity(int maxLiftingCapacity) {
        if (maxLiftingCapacity > 50) {
            this.maxLiftingCapacity = maxLiftingCapacity;
            return;
        }
        throw new RuntimeException("Max lifting capacity can;t be less then 50");
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        if (numberOfPassengers > 0) {
            this.numberOfPassenger = numberOfPassengers;
            return;
        }
        throw new RuntimeException("Number of passengers can't be less than 1");
    }

    @Override
    public int getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    @Override
    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    @Override
    public void drive() {
        System.out.println("Jeep is driving...");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderJeep = new StringBuilder().append("Jeep{").append("maxLiftingCapacity=")
                .append(maxLiftingCapacity).append(", numberOfPassenger=").append(numberOfPassenger)
                .append(super.toString());
        return stringBuilderJeep.toString();
    }
}
