package controller;

import dto.*;
import models.*;
import repositories.*;
import services.BillService;
import services.TicketService;
import spotAssignmentStrategy.SpotAssign;
import spotAssignmentStrategy.SpotAssignmentStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParkingLotController {
    SpotAssignmentStrategy spotAssignmentStrategy;
    Scanner sc = new Scanner(System.in);

    TicketIssueContoller ticketIssueContoller;
    BillController billController;
    public ParkingLotController(){
        this.spotAssignmentStrategy = new SpotAssign();

    }
    public ParkingLot createParkingLot(int numberOfFloor, int numberOfEntryGate, int numberOfExitGate){
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();
        OperatorRepository operatorRepository = new OperatorRepository();
        SpotRepository spotRepository = new SpotRepository();
        TicketRepository ticketRepository = new TicketRepository();
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
                .setTicketRepository(ticketRepository)
                .build();

        TicketService ticketService = new TicketService(spotAssignmentStrategy, parkingLot);
        BillService billService = new BillService(gateRepository, operatorRepository, ticketRepository);
        this.ticketIssueContoller = new TicketIssueContoller(ticketService);
        this.billController = new BillController(billService);
        return parkingLot;

    }
    public TicketIssueDTOResponse issueTicket(ParkingLot parkingLot){
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

    public BillDTOResponse makePayment(ParkingLot parkingLot){
        System.out.println("Please give your parking ticketId ");
        int ticketId = sc.nextInt();
        System.out.println("Please insert your Gate number");
        int gateId = sc.nextInt();

        BillDTORequest request = new BillDTORequest();
        request.setGateId(gateId);
        request.setTicketId(ticketId);

        BillDTOResponse response = billController.issueBill(request);
        Bill bill = response.getBill();
        Duration duration = Duration.between(bill.getTicket().getEntryTime(), bill.getExitTime());
        int time = (int) (duration.toHours()+1);

        System.out.println("Your Parking fees is " + bill.getBillAmount() + " for " + time + " hour");
        System.out.println("Please make your payment via cash ");
        int amount = sc.nextInt();
        if(amount>=bill.getBillAmount()){
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setBill(bill);
            return response;
        }else{
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setBill(bill);
            return response;
        }

    }
    public void printBill(Bill bill){
        System.out.println("Bill Amount " + bill.getBillAmount());
        System.out.println("Exit Time " + bill.getExitTime());
        System.out.println("Your Ticket number " + bill.getTicket().getTicketNumber() + "Your Vehicle Number " + bill.getTicket().getVehicle().getVehicleNumber());
        System.out.println("Going from Exit Gate Number " + bill.getGate().getNumber());
        System.out.println("Exit Gate Operator Name " + bill.getOperator().getName());
        System.out.println("Thank You");
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
        System.out.println("Floor Number " + parkingSpot.getFloor().getNumber() + " Spot Number " + parkingSpot.getSpotNumber() + " Entry Time " + entryTime);
        System.out.println("From gate " + gate.getNumber());
        System.out.println("Vehicle Number " + vehicle.getVehicleNumber() + " Vehicle Type" + vehicleType);
        System.out.println("Operator Name " + operator.getName());

    }
}
