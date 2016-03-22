package Task6;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class NuclearBoat {
    private  Engine engine;
    private double weight;
    private double maxCapacity;
    private double fuelSupply;

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public NuclearBoat(double weight, double maxCapacity, double fuelSupply) {
        this.engine = new Engine(200, 1, 10000);
        this.weight = weight;
        this.maxCapacity = maxCapacity;
        this.fuelSupply = fuelSupply;
    }

    private class Engine{
        double flueCapacity;
        double fuelConsumption;
        private int horsepower; //допустим, что моряки тоже измеряют мощность двигателя в лошадиных силах

        public Engine(double flueCapacity, double fuelConsumption, int horsepower ) {
            this.flueCapacity = flueCapacity;
            this.fuelConsumption = fuelConsumption;
            this.horsepower=horsepower;
        }
    }

    public double getSpeed(double cargoWeight){
        return engine.horsepower/(weight+cargoWeight)*10;
    }
    public double getDistance(double cargoWeight){
        return getMaxDistance()-cargoWeight/engine.horsepower*100;
    }
    public double getMaxSpeed(){
        return  engine.horsepower/(weight)*10;
    }
    public double getMaxDistance(){
        return (engine.flueCapacity+fuelSupply)/engine.fuelConsumption*getMaxSpeed()/100;
    }


}
