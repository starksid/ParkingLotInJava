package repositories;

import models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    Map<Integer, Operator> operatorMap = new HashMap<>();

    public Operator findOperatorByID(int id){
        if(operatorMap.containsKey(id)){
            return operatorMap.get(id);
        }
        return null;
    }
    public void addOperator(Operator operator){
        operatorMap.put(operator.getEmpID(), operator);
    }
}
