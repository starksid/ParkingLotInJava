package repositories;

import models.ParkingSpot;
import models.ParkingSpotStatus;
import models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class SpotRepository {
    Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
    public ParkingSpot findParkingSpotByID(int id, VehicleType vehicleType){
        if(parkingSpotMap.containsKey(id) && parkingSpotMap.get(id).getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
        && parkingSpotMap.get(id).getVehicleType().equals(vehicleType)){
            return parkingSpotMap.get(id);
        }
        return null;
    }
    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getSpotNumber(), parkingSpot);
    }
}
