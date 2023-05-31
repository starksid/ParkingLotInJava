package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicle findVehicleByNumber(String vehicleNumber){
        if(vehicleMap.containsKey(vehicleNumber)){
            return vehicleMap.get(vehicleNumber);
        }
        return null;
    }
    public void saveVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
    }

}
