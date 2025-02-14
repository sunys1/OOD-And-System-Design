package parking_lot_system;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private int balance;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.balance = 0; //negative balance means insufficient funds
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getBalance() {
        return balance;
    }
}
