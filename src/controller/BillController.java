package controller;

import dto.BillDTORequest;
import dto.BillDTOResponse;
import dto.ResponseStatus;
import models.Bill;
import services.BillService;

public class BillController {
    BillService billService;
    public BillController(BillService billService){
        this.billService = billService;
    }
    public BillDTOResponse issueBill(BillDTORequest request){
        BillDTOResponse response = new BillDTOResponse();
        Bill bill = billService.issueBill(request.getTicketId(), request.getGateId());
        response.setBill(bill);
        response.setResponseStatus(ResponseStatus.SUCCESS);
        return response;
    }
}
