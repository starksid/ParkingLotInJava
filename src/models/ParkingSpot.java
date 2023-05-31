package models;

public class ParkingSpot {
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private VehicleType vehicleType;
    private Floor floor;
    public ParkingSpot(int spotNumber, Floor floor, ParkingSpotStatus parkingSpotStatus, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.parkingSpotStatus = parkingSpotStatus;
        this.floor = floor;
        this.vehicleType = vehicleType;
    }
    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
