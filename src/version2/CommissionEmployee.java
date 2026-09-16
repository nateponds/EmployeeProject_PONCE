/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
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

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
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

    public double computeSalary(MyDate dateToday){
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

        int bonusPay = 0;
        // TO DO - BIRTHDAY PAY

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
