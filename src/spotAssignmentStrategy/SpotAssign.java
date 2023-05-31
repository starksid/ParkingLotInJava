package spotAssignmentStrategy;

import models.Floor;
import models.ParkingSpot;
import models.VehicleType;
import repositories.SpotRepository;

import java.util.List;

public class SpotAssign implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignTicketParkingSpot(List<Floor> floors, VehicleType vehicleType, SpotRepository spotRepository) {
        for(int i=0; i<floors.size(); i++){
            List<ParkingSpot> parkingSpot = floors.get(i).getParkingSpots();
            for(int j=0; j<parkingSpot.size(); j++){
                if(spotRepository.findParkingSpotByID(parkingSpot.get(j).getSpotNumber(), vehicleType)!=null){
                    return spotRepository.findParkingSpotByID(parkingSpot.get(j).getSpotNumber(), vehicleType);
                }
            }
        }



        return null;
    }
}
