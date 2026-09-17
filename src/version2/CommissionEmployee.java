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

    public CommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public CommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, double totalSale) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalSale);
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

    public double computeSalary(int monthToday){
        double bonusPay = 0;
        if (this.birthDate.getMonth() == monthToday){
            bonusPay = 5000;
        }
        return this.computeSalary() + bonusPay;
    }
    
    public void displayCommissionEmployye(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Birth Date: " + this.birthDate
                            + " | Date Hired: " + this.dateHired
                            + " | Total Sale: P" + this.totalSale
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID
                + " | Name: " + this.empName
                + " | Birth Date: " + this.birthDate
                + " | Date Hired: " + this.dateHired
                + " | Total Sale: P" + this.totalSale
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
}
