package repositories;

import models.Gate;
import models.GateType;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    public Map<Integer, Gate> gateEntryMap = new HashMap<>();

    public Map<Integer, Gate> gateExitMap = new HashMap<>();

    public Gate findEntryGateByID(int gateId){
        if(gateEntryMap.containsKey(gateId)){
            return gateEntryMap.get(gateId);
        }
        return null;
    }
    public void savenewGate(Gate gate){
        if(gate.getGateType().equals(GateType.ENTRY)){
            gateEntryMap.put(gate.getNumber(), gate);
        }else{
            gateExitMap.put(gate.getNumber(), gate);
        }

    }
    public Gate findExitGateByID(int gateId){
        if(gateExitMap.containsKey(gateId)){
            return gateExitMap.get(gateId);
        }
        return null;
    }
}
