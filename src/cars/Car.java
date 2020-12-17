package cars;

import enam.WheelTypes;

public abstract class Car {
    private int weight;
    private String color;
    private Engine engine;
    private WheelTypes wheelType;

    public Car() {
    }

    public Car(int weight, String color, WheelTypes wheelType, Engine engine) {
        this.weight = weight;
        this.color = color;
        this.engine = engine;
        this.wheelType = wheelType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 100) {
            this.weight = weight;
            return;
        }
        throw new RuntimeException("Weight can't be less then 100");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public WheelTypes getWheelType() {
        return wheelType;
    }

    public void setWheelType(WheelTypes wheelType) {
        this.wheelType = wheelType;
    }

    public abstract void drive();

    public double accelerationTimeTo100() {
        int time = Math.round(weight / engine.getHorsepower());
        return wheelType.isForFastDriving() ? time : time * 1.2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderCar = new StringBuilder();
        stringBuilderCar.append(" weight=").append(weight).append(", color='").append(color).append("\'")
                .append(", engine=").append(engine).append(", wheelType=").append(wheelType).append('}');
        return stringBuilderCar.toString();
    }


}
