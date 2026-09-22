package version2;

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
        this(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
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
        if (birthDate.getMonth() == currentMonth) {
            birthdayBonus = 5000;
        }
        return computeSalary() + birthdayBonus;
    }

    public void displayPieceWorkerEmployee() {
        System.out.println("ID: " + empID
                            + " | Name: " + empName
                            + " | Birth Date: " + birthDate
                            + " | Date Hired: " + dateHired
                            + " | Total Pieces Finished: " + totalPiecesFinished
                            + " | Rate Per Piece: P" + String.format(java.util.Locale.US, "%.2f", ratePerPiece)
        );
    }

    @Override
    public String toString() {
        return "ID: " + empID
                + " | Name: " + empName
                + " | Birth Date: " + birthDate
                + " | Date Hired: " + dateHired
                + " | Total Pieces Finished: " + totalPiecesFinished
                + " | Rate Per Piece: P" + String.format(java.util.Locale.US, "%.2f", ratePerPiece)
                + " | Computed Salary: P" + String.format(java.util.Locale.US, "%.2f", computeSalary());
    }
}
