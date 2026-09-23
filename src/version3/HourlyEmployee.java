package version3;

import java.util.Locale;

public class HourlyEmployee extends Employee{
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = 0f;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear));
    }

    public HourlyEmployee(int empID, String firstName, String middleName, String lastName, int birthDay, int birthMonth, int birthYear, int hiredDay, int hiredMonth, int hiredYear, float totalHoursWorked, double ratePerHour) {
        this(empID, new Name(firstName, middleName, lastName), new MyDate(birthDay, birthMonth, birthYear), new MyDate(hiredDay, hiredMonth, hiredYear), totalHoursWorked, ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }
        double regPay = 40 * ratePerHour;
        double otPay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        return regPay + otPay;
    }

    public double computeSalary(int currentMonth) {
        return computeSalary() + super.computeSalary(currentMonth);
    }

    public void displayHourEmployee() {
        System.out.println(
            "ID: " + getEmpID()
            + " | Name: " + getEmpName()
            + " | Birth Date: " + getBirthDate()
            + " | Date Hired: " + getDateHired()
            + " | Total Hours Worked: " + totalHoursWorked
            + " | Rate per hour: P" + String.format(Locale.US, "%.2f", ratePerHour)
        );
    }

    @Override
    public String toString() {
        return "ID: " + getEmpID()
                + " | Name: " + getEmpName()
                + " | Birth Date: " + getBirthDate()
                + " | Date Hired: " + getDateHired()
                + " | Total Hours Worked: " + totalHoursWorked
                + " | Rate per hour: P" + String.format(Locale.US, "%.2f", ratePerHour)
                + " | Computed Salary: P" + String.format(Locale.US, "%.2f", computeSalary());
    }

    static String money(double amount) {
        return String.format(Locale.US, "₱%,.2f", amount);
    }
}
