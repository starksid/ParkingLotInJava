package models;

public class Gate {
    private int number;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;
    public Gate(int number, GateType gateType, GateStatus gateStatus, Operator operator){
        this.number = number;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
        this.operator = operator;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
