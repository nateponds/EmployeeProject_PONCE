/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public PieceWorkerEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public PieceWorkerEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, int totalPiecesFinished, double ratePerPiece) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalPiecesFinished, ratePerPiece);
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
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

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    
    public double computeSalary(){
        double basePay = this.totalPiecesFinished * this.ratePerPiece;
        double bonusPay = Math.floor(this.totalPiecesFinished / 100) * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    public double computeSalary(int monthToday){
        double birthdayBonus = 0;
        if (this.birthDate.getMonth() == monthToday){
            birthdayBonus = 5000;
        }
        return this.computeSalary() + birthdayBonus;
    }
    
    public void displayPieceWorkerEmployee(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Birth Date: " + this.birthDate
                            + " | Date Hired: " + this.dateHired
                            + " | Total Pieces Finished: " + this.totalPiecesFinished
                            + " | Rate Per Piece: " + this.ratePerPiece
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID
                + " | Name: " + this.empName
                + " | Birth Date: " + this.birthDate
                + " | Date Hired: " + this.dateHired
                + " | Total Pieces Finished: " + this.totalPiecesFinished
                + " | Rate Per Piece: P" + this.ratePerPiece
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
    
    
}
