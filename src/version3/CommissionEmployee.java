package version3;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {}

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {}

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {}

    public CommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public CommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, double totalSale) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalSale);
    }

    public double getTotalSale() {
        return totalSale;
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
        if (getBirthDate().getMonth() == currentMonth) {
            bonusPay = 5000;
        }
        return computeSalary() + bonusPay;
    }

    public void displayCommissionEmployye() {
        System.out.println("ID: " + getEmpID()
                            + " | Name: " + getEmpName()
                            + " | Birth Date: " + getBirthDate()
                            + " | Date Hired: " + getDateHired()
                            + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
        );
    }

    @Override
    public String toString() {
        return "ID: " + getEmpID()
                + " | Name: " + getEmpName()
                + " | Birth Date: " + getBirthDate()
                + " | Date Hired: " + getDateHired()
                + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
                + " | Computed Salary: P" + String.format(java.util.Locale.US, "%.2f", computeSalary());
    }
}
