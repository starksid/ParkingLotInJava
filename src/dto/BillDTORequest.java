package dto;

import models.Gate;
import models.Ticket;

public class BillDTORequest {
    int ticketId;
    int gateId;

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(int ticketID) {
        this.ticketId = ticketID;
    }
}
