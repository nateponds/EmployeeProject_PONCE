/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
    
    public double computeSalary(){
        if(this.totalHoursWorked <= 40){
            return this.totalHoursWorked * this.ratePerHour;
        }
        double regPay = 40 * this.ratePerHour;
        double otPay = (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5);
        return regPay + otPay;
    }
    
    public void displayHourEmployee(){
        System.out.println(
            "ID: " + this.empID 
            + " | Name: " + this.empName 
            + " | Total Hours Worked: " + this.totalHoursWorked 
            + " | Rate per hour: P" + this.ratePerHour
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID 
                + " | Name: " + this.empName 
                + " | Total Hours Worked: " + this.totalHoursWorked 
                + " | Rate per hour: P" + this.ratePerHour
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
}
