package dto;

import models.VehicleType;

public class TicketIssueDTORequest {
    private String vehicleNumber;
    private String vehicleOwner;
    private VehicleType vehicleType;
    private int gateId;
    public TicketIssueDTORequest(String vehicleNumber, String vehicleOwner, VehicleType vehicleType, int gateId){
        this.gateId = gateId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwner = vehicleOwner;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }
}
