package parkingLotApplication;

import controller.ParkingLotController;
import dto.ResponseStatus;
import dto.TicketIssueDTOResponse;
import models.ParkingLot;
import models.ParkingLotStatus;
import models.Ticket;

import java.util.Scanner;

public class ParkingLotApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLotController parkingLotController = new ParkingLotController();
        System.out.println("Please Give input of number of floors you have in your parking lot ");
        int numberOfFloors = sc.nextInt();

        System.out.println("Please Give input of number of Entry Gates you have in your parking lot ");
        int numberofEntryGate = sc.nextInt();

        System.out.println("Please Give input of number of Exit Gates you have in your parking lot ");
        int numberOfExitGate = sc.nextInt();
        ParkingLot parkingLot = parkingLotController.createParkingLot(numberOfFloors,numberofEntryGate, numberOfExitGate);
        while(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.OPENED)){
            System.out.println("Is vehicle entering in the Gate");
            char Bool = sc.next().charAt(0);
            TicketIssueDTOResponse ticketIssueDTOResponse;
            if(Bool=='y'){
                ticketIssueDTOResponse = parkingLotController.issueTicket(parkingLot);
                if (ticketIssueDTOResponse.getResponseStatus().equals(ResponseStatus.SUCCESS)){
                    Ticket ticket = ticketIssueDTOResponse.getTicket();
                    parkingLotController.printTicket(ticket);
                }

            }
        }

    }
}
