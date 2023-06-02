package services;

import feesCalculatorStrategy.FeesCalculatorStrategy;
import feesCalculatorStrategy.ParkingFeesCalcutlator;
import models.Bill;
import models.Gate;
import models.Operator;
import models.Ticket;
import repositories.GateRepository;
import repositories.OperatorRepository;
import repositories.TicketRepository;

import java.time.LocalDateTime;

public class BillService {
    GateRepository gateRepository;
    OperatorRepository operatorRepository;
    TicketRepository ticketRepository;
    public BillService(GateRepository gateRepository, OperatorRepository operatorRepository, TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.ticketRepository = ticketRepository;
    }


    public Bill issueBill(int ticketId, int gateId){
        Gate gate = gateRepository.findExitGateByID(gateId);
        Operator operator = gate.getOperator();
        LocalDateTime exitTime = LocalDateTime.now();
        FeesCalculatorStrategy feesCalculatorStrategy = new ParkingFeesCalcutlator();
        Ticket ticket = ticketRepository.findTicketByID(ticketId);
        int billAmount = feesCalculatorStrategy.parkingFeesCalculator(ticket.getEntryTime(), exitTime);

        Bill bill = new Bill(ticket, gate, operator, exitTime, billAmount);
        return bill;
    }
}
