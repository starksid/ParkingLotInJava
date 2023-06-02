package models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Bill {
    private List<Payment> payments;
    private int billAmount;
    private LocalDateTime exitTime;
    private Operator operator;
    private Gate gate;
    private Ticket ticket;
    public Bill(Ticket ticket, Gate gate, Operator operator, LocalDateTime exitTime, int billAmount){
        this.ticket = ticket;
        this.gate = gate;
        this.exitTime = exitTime;
        this.operator = operator;
        this.billAmount = billAmount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
