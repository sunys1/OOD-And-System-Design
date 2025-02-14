package parking_lot_system;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private int paymentDue;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentDue = 0;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getPaymentDue() {
        return paymentDue;
    }
}
