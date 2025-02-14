package parking_lot_system;

//import java.util.Calendar;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents the parking lot system that the user interacts with
 */
public class ParkingSystem {
    private ParkingGarage garage;
    private Map<Integer, LocalDateTime> duration = new HashMap<>(); //key:driverId, value:entryTime
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int hourRate;


    public ParkingSystem(ParkingGarage garage, int hourRate) {
        this.garage = garage;
        this.hourRate = hourRate;
    }

    public boolean parkVehicle(Driver driver) {
        int driverId = driver.getId();
        LocalDateTime entryTime = LocalDateTime.now();
        boolean isParked = garage.parkingVehicle(driver.getVehicle());

        // record the entry time
        if(isParked){
            duration.put(driverId, entryTime);
            System.out.println("Driver " + driverId + " parked at " + entryTime.format(FORMATTER) + ".");
        }

        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
        int driverId = driver.getId();
        if(!duration.containsKey(driverId)) {
            return false;
        }

        // for testing purpose, generate random hours between 1-24 to simulate hours in real-world
        Random random = new Random();
        int gapHours = random.nextInt(24) + 1;

        // calculate parking fee
        LocalDateTime entryTime = duration.get(driverId);
        LocalDateTime exitTime = entryTime.plusHours(gapHours);
        //        LocalDateTime exitTime = LocalDateTime.now();
        Duration timeParked = Duration.between(entryTime, exitTime);
        Long hours = timeParked.toHours();
        Long minutes = timeParked.toMinutes();
        double parkingFee = (minutes / 60.0) * hourRate;

        System.out.println("Driver " + driverId + " exited at " + exitTime.format(FORMATTER) +
                           ". Total time parked: " + hours + " hours, " + minutes % 60 + " minutes. Parking fee: $" + parkingFee + ".");
        duration.remove(driverId);

        return garage.removeVehicle(driver.getVehicle());
    }
}
