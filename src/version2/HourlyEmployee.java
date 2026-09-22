package version2;

import java.util.Locale;

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
        this(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
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
        double bonusPay = 0;
        if (birthDate.getMonth() == currentMonth) {
            bonusPay = 5000;
        }
        return computeSalary() + bonusPay;
    }

    public void displayHourEmployee() {
        System.out.println(
            "ID: " + empID
            + " | Name: " + empName
            + " | Birth Date: " + birthDate
            + " | Date Hired: " + dateHired
            + " | Total Hours Worked: " + totalHoursWorked
            + " | Rate per hour: P" + String.format(Locale.US, "%.2f", ratePerHour)
        );
    }

    @Override
    public String toString() {
        return "ID: " + empID
                + " | Name: " + empName
                + " | Birth Date: " + birthDate
                + " | Date Hired: " + dateHired
                + " | Total Hours Worked: " + totalHoursWorked
                + " | Rate per hour: P" + String.format(Locale.US, "%.2f", ratePerHour)
                + " | Computed Salary: P" + String.format(Locale.US, "%.2f", computeSalary());
    }

    static String money(double amount) {
        return String.format(Locale.US, "₱%,.2f", amount);
    }
}
