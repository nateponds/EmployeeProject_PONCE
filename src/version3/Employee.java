package version3;

import java.util.Objects;

public class Employee implements Cloneable{
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    /** Returns only the birthday bonus (₱5,000) or 0. Subclasses add this via super. */
    public double computeSalary(int currentMonth) {
        if (getBirthDate().getMonth() == currentMonth) {
            return 5000;
        }
        return 0;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        if (empName != null) {
            cloned.empName = empName.clone();
        }
        if (birthDate != null) {
            cloned.birthDate = birthDate.clone();
        }
        if (dateHired != null) {
            cloned.dateHired = dateHired.clone();
        }
        return cloned;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return empID == other.empID
                && Objects.equals(empName, other.empName)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dateHired, other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return "Employee ID: " + empID + "\n Employee Name: " + empName + "\n Birth Date: " + birthDate + "\n Date Hired: " + dateHired;
    }

    @Override
    public void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Date Hired: " + dateHired);
    }

    
}
