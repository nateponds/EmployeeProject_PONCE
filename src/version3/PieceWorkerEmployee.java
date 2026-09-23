package version3;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {}

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {}

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {}

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
        double birthdayBonus = 0;
        if (getBirthDate().getMonth() == currentMonth) {
            birthdayBonus = 5000;
        }
        return computeSalary() + birthdayBonus;
    }

    public void displayPieceWorkerEmployee() {
        System.out.println("ID: " + getEmpID()
                            + " | Name: " + getEmpName()
                            + " | Birth Date: " + getBirthDate()
                            + " | Date Hired: " + getDateHired()
                            + " | Total Pieces Finished: " + totalPiecesFinished
                            + " | Rate Per Piece: P" + String.format(java.util.Locale.US, "%.2f", ratePerPiece)
        );
    }

    @Override
    public String toString() {
        return "ID: " + getEmpID()
                + " | Name: " + getEmpName()
                + " | Birth Date: " + getBirthDate()
                + " | Date Hired: " + getDateHired()
                + " | Total Pieces Finished: " + totalPiecesFinished
                + " | Rate Per Piece: P" + String.format(java.util.Locale.US, "%.2f", ratePerPiece)
                + " | Computed Salary: P" + String.format(java.util.Locale.US, "%.2f", computeSalary());
    }
}
