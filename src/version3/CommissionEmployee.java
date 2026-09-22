package version3;

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
        this(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
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
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        }
        if (totalSale < 100000) {
            return 0.10;
        }
        if (totalSale < 500000) {
            return 0.15;
        }
        return 0.20;
    }

    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    public double computeSalary(int currentMonth) {
        double bonusPay = 0;
        if (birthDate.getMonth() == currentMonth) {
            bonusPay = 5000;
        }
        return computeSalary() + bonusPay;
    }

    public void displayCommissionEmployye() {
        System.out.println("ID: " + empID
                            + " | Name: " + empName
                            + " | Birth Date: " + birthDate
                            + " | Date Hired: " + dateHired
                            + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
        );
    }

    @Override
    public String toString() {
        return "ID: " + empID
                + " | Name: " + empName
                + " | Birth Date: " + birthDate
                + " | Date Hired: " + dateHired
                + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
                + " | Computed Salary: P" + String.format(java.util.Locale.US, "%.2f", computeSalary());
    }
}
