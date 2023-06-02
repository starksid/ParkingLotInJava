package models;

import repositories.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Floor> floors;
    private List<Gate> gates;
    private TicketRepository ticketRepository;


    private ParkingLotStatus parkingLotStatus;
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private SpotRepository spotRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLot(){}
    public List<Floor> getFloors() {
        return floors;
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        int numberofFloors;
        int numberofEntryGate;
        int numberofExitGate;
        List<Floor> floors;
        List<Gate> gates;
        SpotRepository spotRepository;
        VehicleRepository vehicleRepository;
        TicketRepository ticketRepository;
        OperatorRepository operatorRepository;
        GateRepository gateRepository;

        private Builder(){}
        public void createFloors(){
            for(int i=0; i<numberofFloors; i++){
                Floor floor = new Floor(i+1);
                List<ParkingSpot> parkingSpots = new ArrayList<>();
                for(int j=0; j<10; j++){
                    ParkingSpot parkingSpot = new ParkingSpot(j+1, floor, ParkingSpotStatus.EMPTY, VehicleType.CAR);

                    spotRepository.addParkingSpot(parkingSpot);
                    parkingSpots.add(parkingSpot);
                }
                for(int k=10; k<20; k++){
                    ParkingSpot parkingSpot = new ParkingSpot(k+1, floor, ParkingSpotStatus.EMPTY, VehicleType.BIKE);
                    spotRepository.addParkingSpot(parkingSpot);
                    parkingSpots.add(parkingSpot);

                }
                floor.setParkingSpots(parkingSpots);
                floors.add(floor);
            }

        }
        public void createEntryGate(){
            for(int i=0; i<numberofEntryGate; i++){
                char character = (char) ((char) i+65);
                Operator operator = new Operator(character, i+1);
                Gate gate = new Gate(i+1, GateType.ENTRY, GateStatus.OPENED, operator);
                operatorRepository.addOperator(operator);
                gateRepository.savenewGate(gate);

                gates.add(gate);
            }
        }
        public void createExitGate(){


            for(int i=numberofEntryGate; i<numberofExitGate+numberofEntryGate; i++){
                char c = (char) ((char) i+65);
                Operator operator = new Operator(c, i+1);
                Gate gate = new Gate(i+1, GateType.EXIT, GateStatus.OPENED, operator);
                operatorRepository.addOperator(operator);
                gates.add(gate);
                gateRepository.savenewGate(gate);

            }
        }
        public ParkingLot build(){
            ParkingLot parkingLot = new ParkingLot();
            createEntryGate();
            createFloors();
            createExitGate();
            System.out.println(gateRepository.gateEntryMap);
            System.out.println(gateRepository.gateExitMap);
            parkingLot.setFloors(floors);
            parkingLot.setGates(gates);
            parkingLot.setParkingLotStatus(ParkingLotStatus.OPENED);
            parkingLot.setVehicleRepository(vehicleRepository);
            parkingLot.setGateRepository(gateRepository);
            parkingLot.setTicketRepository(ticketRepository);

            parkingLot.setOperatorRepository(operatorRepository);
            parkingLot.setSpotRepository(spotRepository);
            return parkingLot;
        }

        public int getNumberofFloors() {
            return numberofFloors;
        }

        public Builder setNumberofFloors(int numberofFloors) {
            this.numberofFloors = numberofFloors;
            return this;
        }

        public int getNumberofEntryGate() {
            return numberofEntryGate;
        }

        public Builder setNumberofEntryGate(int numberofEntryGate) {
            this.numberofEntryGate = numberofEntryGate;
            return this;
        }

        public int getNumberofExitGate() {
            return numberofExitGate;
        }

        public Builder setNumberofExitGate(int numberofExitGate) {
            this.numberofExitGate = numberofExitGate;
            return this;
        }

        public List<Floor> getFloors() {
            return floors;
        }

        public Builder setFloors(List<Floor> floors) {
            this.floors = floors;
            return this;
        }

        public List<Gate> getGates() {
            return gates;
        }

        public Builder setGates(List<Gate> gates) {
            this.gates = gates;
            return this;
        }

        public TicketRepository getTicketRepository() {
            return ticketRepository;
        }

        public Builder setTicketRepository(TicketRepository ticketRepository) {
            this.ticketRepository = ticketRepository;
            return this;
        }

        public SpotRepository getSpotRepository() {
            return spotRepository;
        }

        public Builder setSpotRepository(SpotRepository spotRepository) {
            this.spotRepository = spotRepository;
            return this;
        }

        public VehicleRepository getVehicleRepository() {
            return vehicleRepository;
        }

        public Builder setVehicleRepository(VehicleRepository vehicleRepository) {
            this.vehicleRepository = vehicleRepository;
            return this;
        }

        public OperatorRepository getOperatorRepository() {
            return operatorRepository;
        }

        public Builder setOperatorRepository(OperatorRepository operatorRepository) {
            this.operatorRepository = operatorRepository;
            return this;
        }

        public GateRepository getGateRepository() {
            return gateRepository;
        }

        public Builder setGateRepository(GateRepository gateRepository) {
            this.gateRepository = gateRepository;
            return this;
        }
    }
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public GateRepository getGateRepository() {
        return gateRepository;
    }

    public void setGateRepository(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public OperatorRepository getOperatorRepository() {
        return operatorRepository;
    }

    public void setOperatorRepository(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public SpotRepository getSpotRepository() {
        return spotRepository;
    }

    public void setSpotRepository(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

}
