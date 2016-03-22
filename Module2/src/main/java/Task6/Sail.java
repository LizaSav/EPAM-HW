package Task6;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class Sail {
    private NuclearBoat boat;
    private double distance;
    private double cargoWeight;

    public Sail(NuclearBoat boat, double distance, double cargoWeight) {
        this.boat = boat;
        this.distance = distance;
        this.cargoWeight = cargoWeight;
    }

    public boolean getResultSail(){
        if (!isSaveSail()) {
            System.out.println("Our boat sank!=(");
            return false;
        }
        System.out.println("Boat reached the  destination after "+ distance/boat.getSpeed(cargoWeight)+" hours! =)");
        return true;
    }

    public boolean isSaveSail(){
        if (cargoWeight>=boat.getMaxCapacity()){
            System.out.println("The maximum capacity of this boat is "+boat.getMaxCapacity()+ "ton");
            return false;
        }
        if (distance>boat.getDistance(cargoWeight)) {
            System.out.println("The maximum distance that this boat can sail (with cargo weight "+ cargoWeight+" ton ) is " +boat.getDistance(cargoWeight)+"km");
            return false;
        }
        return true;
    }
}
