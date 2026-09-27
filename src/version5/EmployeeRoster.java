package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {

    private static final String SEPARATOR =
        "======================================================================";

    private final List<Employee> empList;

    public EmployeeRoster() {
        empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }

        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        int i;
        for (
            i = 0;
            i < empList.size() && empList.get(i).getEmpID() != empID;
            i++
        ) {}
        if (i == empList.size()) {
            return null;
        }
        return empList.remove(i);
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int total = 0;
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof HourlyEmployee) total++;
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof PieceWorkerEmployee) total++;
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (Employee emp : empList) {
            if (
                emp instanceof CommissionEmployee &&
                !(emp instanceof BasePlusCommissionEmployee)
            ) total++;
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof BasePlusCommissionEmployee) total++;
        }
        return total;
    }

    public void displayHE() {
        System.out.println("\n--- HOURLY EMPLOYEES ---");
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof HourlyEmployee) {
                ((HourlyEmployee) empList.get(i)).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        System.out.println("\n--- PIECE WORKER EMPLOYEES ---");
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof PieceWorkerEmployee) {
                (
                    (PieceWorkerEmployee) empList.get(i)
                ).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        System.out.println("\n--- COMMISSION EMPLOYEES ---");
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getClass() == CommissionEmployee.class) {
                (
                    (CommissionEmployee) empList.get(i)
                ).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        System.out.println("\n--- BASE PLUS COMMISSION EMPLOYEES ---");
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof BasePlusCommissionEmployee) {
                (
                    (BasePlusCommissionEmployee) empList.get(i)
                ).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println("\n" + SEPARATOR);
        System.out.println(
            "PURE POLYMORPHIC PAYROLL REPORT (Target Month: " +
                monthName(currentMonth) +
                ")"
        );
        System.out.println(
            "[No downcasting; dynamic dispatch via Employee.computeSalary()]"
        );
        System.out.println(SEPARATOR);
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean birthdayBonusApplied =
                emp.getBirthDate().getMonth() == currentMonth;

            System.out.printf(
                "ID: %d | Name: %-24s | Payout: %s%s%n",
                emp.getEmpID(),
                emp.getEmpName(),
                Employee.money(salary),
                birthdayBonusApplied ? " (Birthday Bonus Applied)" : ""
            );
        }
    }

    private static String monthName(int month) {
        String[] names = {
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec",
        };
        return month >= 1 && month <= 12
            ? names[month - 1]
            : String.valueOf(month);
    }
}
