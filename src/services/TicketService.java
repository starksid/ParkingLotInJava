package services;

import models.*;
import repositories.*;
import spotAssignmentStrategy.SpotAssign;
import spotAssignmentStrategy.SpotAssignmentStrategy;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketService {
    int ticketNumber = 1;
    VehicleRepository vehicleRepository;
    GateRepository gateRepository;
    SpotRepository spotRepository;
    OperatorRepository operatorRepository;
    SpotAssignmentStrategy spotAssign;
    ParkingLot parkingLot;
    TicketRepository ticketRepository;
    public TicketService(
                         SpotAssignmentStrategy spotAssign,
                         ParkingLot parkingLot
    ){
        this.gateRepository = parkingLot.getGateRepository();
        this.vehicleRepository = parkingLot.getVehicleRepository();
        this.operatorRepository = parkingLot.getOperatorRepository();
        this.spotRepository = parkingLot.getSpotRepository();
        this.spotAssign = spotAssign;
        this.parkingLot = parkingLot;
        this.ticketRepository = parkingLot.getTicketRepository();

    }
    private void ticketVehicleAssign(Ticket ticket, String vehicleNumber, String vehicleOwner, VehicleType vehicleType){
        if(vehicleRepository.findVehicleByNumber(vehicleNumber)!=null){
            ticket.setVehicle(vehicleRepository.findVehicleByNumber(vehicleNumber));
        }else{
            Vehicle vehicle = new Vehicle(vehicleNumber, vehicleOwner, vehicleType);
            ticket.setVehicle(vehicle);
            vehicleRepository.saveVehicle(vehicle);
        }
    }
    private void ticketGateAssign(Ticket ticket, int gateID){
        if(gateRepository.findEntryGateByID(gateID)!=null){
            ticket.setGate(gateRepository.findEntryGateByID(gateID));
        }

    }
    private void ticketSpotAssign(Ticket ticket, VehicleType vehicleType){
        ParkingSpot parkingSpot = spotAssign.assignTicketParkingSpot(parkingLot.getFloors(), vehicleType, spotRepository);
        ticket.setParkingSpot(parkingSpot);
        ticket.setFloor(parkingSpot.getFloor());

    }
    private void ticketOperatorAssign(Ticket ticket, int operatorID){
        if(operatorRepository.findOperatorByID(operatorID)!=null){
            ticket.setOperator(operatorRepository.findOperatorByID(operatorID));
        }
    }
    private void saveTicket(Ticket ticket){
        ticketRepository.saveTicket(ticket);
    }
    public Ticket issueTicket(String vehicleNumber, String vehicleOwner, VehicleType vehicleType, int gateId){
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(ticketNumber);
        ticketNumber+=1;
        LocalDateTime entryTime = LocalDateTime.now();
        ticket.setEntryTime(entryTime);
        ticketGateAssign(ticket, gateId);
        ticketVehicleAssign(ticket, vehicleNumber, vehicleOwner, vehicleType);
        ticketOperatorAssign(ticket, ticket.getGate().getOperator().getEmpID());
        ticketSpotAssign(ticket, vehicleType);
        saveTicket(ticket);
        return ticket;

    }
}
