/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public double computeSalary(){
        double commission = 0;
        if(this.totalSale < 50000){
            commission = this.totalSale * 0.05;
        }
        else if(this.totalSale >= 50000 && this.totalSale < 100000){
            commission = this.totalSale * 0.1;
        }
        else if(this.totalSale >= 100000 && this.totalSale < 500000){
            commission = this.totalSale * 0.15;
        }
        else if(this.totalSale >= 500000){
            commission = this.totalSale * 0.2;
        }
        return this.baseSalary + commission;
    }
    
    public void displayBasePlusCommissionEmployee(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Total Sale: " + this.totalSale
                            + " | Base Salary: " + this.baseSalary
        );
    }

    @Override
    public String toString() {
        double commission = 0;
        if(this.totalSale < 50000){
            commission = 0.05;
        }
        else if(this.totalSale >= 50000 && this.totalSale < 100000){
            commission = 0.1;
        }
        else if(this.totalSale >= 100000 && this.totalSale < 500000){
            commission = 0.15;
        }
        else if(this.totalSale >= 500000){
            commission = 0.2;
        }
        return "ID: " + this.empID
                + " | Name: " + this.empName
                + " | Total Sale: P" + this.totalSale
                + " | Base Salary: P" + this.baseSalary
                + " | Commission Rate: " + commission * 100 + "%"
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
    
}
