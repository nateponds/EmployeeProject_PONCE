package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public PieceWorkerEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public PieceWorkerEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, int totalPiecesFinished, double ratePerPiece) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalPiecesFinished, ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusPay = Math.floor(totalPiecesFinished / 100.0) * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    public double computeSalary(int currentMonth) {
        return computeSalary() + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        System.out.println("ID: " + getEmpID()
                            + " | Name: " + getEmpName()
                            + " | Birth Date: " + getBirthDate()
                            + " | Date Hired: " + getDateHired()
                            + " | Total Pieces Finished: " + totalPiecesFinished
                            + " | Rate Per Piece: " + money(ratePerPiece)
        );
    }

    @Override
    public String toString() {
        return "ID: " + getEmpID()
                + " | Name: " + getEmpName()
                + " | Birth Date: " + getBirthDate()
                + " | Date Hired: " + getDateHired()
                + " | Total Pieces Finished: " + totalPiecesFinished
                + " | Rate Per Piece: " + money(ratePerPiece)
                + " | Computed Salary: " + money(computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() throws CloneNotSupportedException {
        return (PieceWorkerEmployee) super.clone();
    }
}
