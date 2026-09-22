/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
    
    public double computeSalary(){
        double salary = 0;
        if(this.totalSale < 50000){
            salary = this.totalSale * 0.05;
        }
        else if(this.totalSale >= 50000 && this.totalSale < 100000){
            salary = this.totalSale * 0.1;
        }
        else if(this.totalSale >= 100000 && this.totalSale < 500000){
            salary = this.totalSale * 0.15;
        }
        else if(this.totalSale >= 500000){
            salary = this.totalSale * 0.2;
        }
        return salary;
    }
    
    public void displayCommissionEmployye(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Total Sale: P" + this.totalSale
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID
                + " | Name: " + this.empName
                + " | Total Sale: P" + this.totalSale
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
}
