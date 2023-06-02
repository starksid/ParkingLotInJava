package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Integer, Ticket> ticketMap = new HashMap<>();
    public Ticket findTicketByID(int ticketId){
        if(ticketMap.containsKey(ticketId)){
            return ticketMap.get(ticketId);
        }
        return null;
    }
    public void saveTicket(Ticket ticket){
        ticketMap.put(ticket.getTicketNumber(), ticket);
    }
}
