package models;

public class Operator {
    char name;
    int EmpID;
    public Operator(char name, int EmpID){
        this.name = name;
        this.EmpID = EmpID;
    }
    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        EmpID = empID;
    }
}
