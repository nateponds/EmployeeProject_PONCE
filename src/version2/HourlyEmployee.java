/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

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

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, float totalHoursWorked, double ratePerHour) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalHoursWorked, ratePerHour);
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

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
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

    public double computeSalary(int monthToday){
        double bonusPay = 0;
        if (this.birthDate.getMonth() == monthToday){
            bonusPay = 5000;
        }
        return this.computeSalary() + bonusPay;
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
