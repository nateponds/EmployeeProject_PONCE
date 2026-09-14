/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labactivity1;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
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

    public void setEmpName(String empName) {
        this.empName = empName;
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
    
    public void displayPieceWorkerEmployee(){
        System.out.println("ID: " + this.empID
                            + " | Name: " + this.empName
                            + " | Total Pieces Finished: " + this.totalPiecesFinished
                            + " | Rate Per Piece: " + this.ratePerPiece
        );
    }

    @Override
    public String toString() {
        return "ID: " + this.empID
                + " | Name: " + this.empName
                + " | Total Pieces Finished: " + this.totalPiecesFinished
                + " | Rate Per Piece: P" + this.ratePerPiece
                + " | Computed Salary: P" + this.computeSalary();
    }
    
    
    
    
    
}
