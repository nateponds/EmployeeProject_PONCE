/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this.empID = empID;
        this.empName = new Name(firstName, middleName, lastName);
        this.birthDate = new MyDate(birthDay, birthMonth, birthYear);
        this.dateHired = new MyDate(hiredDay, hiredMonth, hiredYear);
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = new Name(firstName, middleName, lastName);
        this.birthDate = new MyDate(birthDay, birthMonth, birthYear);
        this.dateHired = new MyDate(hiredDay, hiredMonth, hiredYear);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() { return empName; }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public double computeSalary(){
        if(this.totalHoursWorked <= 40){
            return this.totalHoursWorked * this.ratePerHour;
        }
        double regPay = 40 * this.ratePerHour;
        double otPay = (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5);
        return regPay + otPay;
    }

    // TO DO - computeSalary(birthDate) -> bonus pay 5000
    public double computeSalary(int monthToday){
        if(this.totalHoursWorked <= 40){
            return this.totalHoursWorked * this.ratePerHour;
        }
        double regPay = 40 * this.ratePerHour;
        double otPay = (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5);
        double bonusPay = 0;
        if (this.birthDate.getMonth() == monthToday){
            bonusPay = 5000;
        }
            // TO DO - BIRTHDAY PAY

        return regPay + otPay + bonusPay;
    }

    
    public void displayHourEmployee(){
        System.out.println(
            "ID: " + this.empID 
            + " | Name: " + this.empName
            + " | Birth Date: " + this.birthDate
            + " | Date Hired: " + this.dateHired
            + " | Total Hours Worked: " + this.totalHoursWorked
            + " | Rate per hour: P" + this.ratePerHour
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID 
                + " | Name: " + this.empName
                + " | Birth Date: " + this.birthDate
                + " | Date Hired: " + this.dateHired
                + " | Total Hours Worked: " + this.totalHoursWorked
                + " | Rate per hour: P" + this.ratePerHour
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
}
