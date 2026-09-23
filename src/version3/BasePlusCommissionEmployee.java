package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends Employee {
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, double totalSale, double baseSalary) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalSale, baseSalary);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    private double getCommissionRate() {
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
        return baseSalary + (totalSale * getCommissionRate());
    }

    public double computeSalary(int currentMonth) {
        return computeSalary() + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println("ID: " + getEmpID()
                            + " | Name: " + getEmpName()
                            + " | Birth Date: " + getBirthDate()
                            + " | Date Hired: " + getDateHired()
                            + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
                            + " | Base Salary: P" + String.format(java.util.Locale.US, "%.2f", baseSalary)
        );
    }

    @Override
    public String toString() {
        return "ID: " + getEmpID()
                + " | Name: " + getEmpName()
                + " | Birth Date: " + getBirthDate()
                + " | Date Hired: " + getDateHired()
                + " | Total Sale: P" + String.format(java.util.Locale.US, "%.2f", totalSale)
                + " | Base Salary: P" + String.format(java.util.Locale.US, "%.2f", baseSalary)
                + " | Commission Rate: " + (getCommissionRate() * 100) + "%"
                + " | Computed Salary: P" + String.format(java.util.Locale.US, "%.2f", computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0
                && Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale, baseSalary);
    }
}
