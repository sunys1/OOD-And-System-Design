package parking_lot_system;

public class Main {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(1, 2);
        ParkingSystem system = new ParkingSystem(garage, 10);
        Driver d1 = new Driver(1, new Car(1));
        Driver d2 = new Driver(2, new Car(2));
        Driver d3 = new Driver(3, new Car(3));

        System.out.println(system.parkVehicle(d1));
        System.out.println(system.parkVehicle(d2));
        System.out.println(system.parkVehicle(d3));

        System.out.println(system.removeVehicle(d1));
        System.out.println(system.removeVehicle(d2));
        System.out.println(system.removeVehicle(d3));
    }
}
