package spotAssignmentStrategy;

import models.Floor;
import models.ParkingSpot;
import models.VehicleType;
import repositories.SpotRepository;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot assignTicketParkingSpot(List<Floor> floors, VehicleType vehicleType, SpotRepository spotRepository);

}
