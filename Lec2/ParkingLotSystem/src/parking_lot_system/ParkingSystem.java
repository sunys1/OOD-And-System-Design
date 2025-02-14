package parking_lot_system;

import java.util.Calendar;
/**
 * Represents the parking lot system that the user interacts with
 */
public class ParkingSystem {
    private ParkingGarage garage;
//    Map<Integer, Integer>:key:driverId, value:startTime
//    private Map<Integer, Integer> timeParked;
    private int hourRate;

    public ParkingSystem(ParkingGarage garage, int hourRate) {
        this.garage = garage;
        this.hourRate = hourRate;
    }

    public boolean parkVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        boolean isParked = garage.parkingVehicle(driver.getVehicle());

//        if(isParked){
//            timeParked.put(driver.getId(), currentHour);
//        }
        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
//        Todo: calculate parking fee
//        if(!timeParked.containsKey(driver.getId())) {
//            return false;
//        }
//
//        timeParked.remove(driver.getId());

//        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        return garage.removeVehicle(driver.getVehicle());
    }
}
