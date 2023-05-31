package controller;

import dto.ResponseStatus;
import dto.TicketIssueDTORequest;
import dto.TicketIssueDTOResponse;
import models.Ticket;
import services.TicketService;

public class TicketIssueContoller {
    private TicketService ticketService;
    public TicketIssueContoller(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public TicketIssueDTOResponse issueTicket(TicketIssueDTORequest request){
        TicketIssueDTOResponse response = new TicketIssueDTOResponse();
        Ticket ticket = ticketService.issueTicket(
                request.getVehicleNumber(),
                request.getVehicleOwner(),
                request.getVehicleType(),
                request.getGateId()
        );
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);
        return response;
    }
}
