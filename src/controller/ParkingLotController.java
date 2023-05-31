package controller;

import dto.TicketIssueDTORequest;
import dto.TicketIssueDTOResponse;
import models.*;
import repositories.GateRepository;
import repositories.OperatorRepository;
import repositories.SpotRepository;
import repositories.VehicleRepository;
import services.TicketService;
import spotAssignmentStrategy.SpotAssign;
import spotAssignmentStrategy.SpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParkingLotController {
    SpotAssignmentStrategy spotAssignmentStrategy;
    Scanner sc = new Scanner(System.in);

    TicketIssueContoller ticketIssueContoller;
    public ParkingLotController(){
        this.spotAssignmentStrategy = new SpotAssign();

    }
    public ParkingLot createParkingLot(int numberOfFloor, int numberOfEntryGate, int numberOfExitGate){
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();
        OperatorRepository operatorRepository = new OperatorRepository();
        SpotRepository spotRepository = new SpotRepository();
        List<Floor> floors = new ArrayList<>();
        List<Gate> gates = new ArrayList<>();
        ParkingLot parkingLot = ParkingLot.getBuilder()
                .setFloors(floors)
                .setGateRepository(gateRepository)
                .setGates(gates)
                .setNumberofEntryGate(numberOfEntryGate)
                .setNumberofFloors(numberOfFloor)
                .setNumberofExitGate(numberOfExitGate)
                .setOperatorRepository(operatorRepository)
                .setSpotRepository(spotRepository)
                .setVehicleRepository(vehicleRepository)
                .build();

        TicketService ticketService = new TicketService(spotAssignmentStrategy, parkingLot);
        this.ticketIssueContoller = new TicketIssueContoller(ticketService);
        return parkingLot;

    }
    public TicketIssueDTOResponse issueTicket(ParkingLot parkingLot){
        TicketService ticketService = new TicketService(spotAssignmentStrategy, parkingLot);
        System.out.println("Please give input of vehicle Number ");
        String vehicleNumber = sc.next();
        System.out.println("Please give input of vehicle Owner Name ");
        String vehicleOwner = sc.next();
        System.out.println("Please give input of vehicle Type for Bike type B and for Car type C");
        String vehicleType = sc.next();
        VehicleType vehicleType1;
        if(vehicleType.charAt(0)=='B'){
            vehicleType1 = VehicleType.BIKE;
        }else{
            vehicleType1 = VehicleType.CAR;
        }
        System.out.println("Please give input of gateID ");
        int gateId = sc.nextInt();
        TicketIssueDTORequest ticketIssueDTORequest = new TicketIssueDTORequest(vehicleNumber, vehicleOwner, vehicleType1, gateId);
        TicketIssueDTOResponse ticketIssueDTOResponse1 = ticketIssueContoller.issueTicket(ticketIssueDTORequest);

        return ticketIssueDTOResponse1;





    }
    public void printTicket(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        String vehicleType;
        if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            vehicleType = "BIKE";
        }else{
            vehicleType = "CAR";
        }

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        Operator operator = ticket.getOperator();
        LocalDateTime entryTime = ticket.getEntryTime();
        Gate gate = ticket.getGate();
        System.out.println("Ticket Numebr " + ticket.getTicketNumber());
        System.out.println("Spot Number " + parkingSpot.getSpotNumber() + " Entry Time " + entryTime);
        System.out.println("From gate " + gate.getNumber());
        System.out.println("Vehicle Number " + vehicle.getVehicleNumber() + " Vehicle Type" + vehicleType);
        System.out.println("Operator Name " + operator.getName());

    }
}
