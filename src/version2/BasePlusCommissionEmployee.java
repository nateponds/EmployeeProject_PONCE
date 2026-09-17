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
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, double totalSale, double baseSalary) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalSale, baseSalary);
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
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

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
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

    public double computeSalary(int monthToday){
        double bonusPay = 0;
        if (this.birthDate.getMonth() == monthToday){
            bonusPay = 5000;
        }
        return this.computeSalary() + bonusPay;
    }
    
    public void displayBasePlusCommissionEmployee(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Birth Date: " + this.birthDate
                            + " | Date Hired: " + this.dateHired
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
                + " | Birth Date: " + this.birthDate
                + " | Date Hired: " + this.dateHired
                + " | Total Sale: P" + this.totalSale
                + " | Base Salary: P" + this.baseSalary
                + " | Commission Rate: " + commission * 100 + "%"
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
    
}
