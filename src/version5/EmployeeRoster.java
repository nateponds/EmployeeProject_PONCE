package version4;

public class EmployeeRoster {

    private static final String SEPARATOR =
            "======================================================================";

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        int i;
        for (i = 0; i < count && empList[i].getEmpID() != empID; i++) {}
        if (i == count) {
            return null;
        }

        Employee removed = empList[i];
        for (int j = i; j < count - 1; j++) {
            empList[j] = empList[j + 1];
        }

        count--;
        empList[count] = null;
        return removed;
    }

    public Employee searchEmployee(int empID) {
        int i;
        for (i = 0; i < count && empList[i].getEmpID() != empID; i++) {}
        return i < count ? empList[i] : null;
    }

    public int countHE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) total++;
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) total++;
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) total++;
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) total++;
        }
        return total;
    }

    public void displayHE() {
        System.out.println("\n--- HOURLY EMPLOYEES ---");
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        System.out.println("\n--- PIECE WORKER EMPLOYEES ---");
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        System.out.println("\n--- COMMISSION EMPLOYEES ---");
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        System.out.println("\n--- BASE PLUS COMMISSION EMPLOYEES ---");
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            System.out.println((i + 1) + ". ID: " + emp.getEmpID()
                    + " | Name: " + emp.getEmpName()
                    + " | Type: " + emp.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println("\n" + SEPARATOR);
        System.out.println("ROSTER PAYROLL REPORT (Target Month: " + monthName(currentMonth) + ")");
        System.out.println(SEPARATOR);
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            double basePay;
            double totalPay;
            String type;

            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) emp;
                basePay = employee.computeSalary();
                totalPay = employee.computeSalary(currentMonth);
                type = "Base Plus Commission";
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee employee = (CommissionEmployee) emp;
                basePay = employee.computeSalary();
                totalPay = employee.computeSalary(currentMonth);
                type = "Commission";
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee employee = (HourlyEmployee) emp;
                basePay = employee.computeSalary();
                totalPay = employee.computeSalary(currentMonth);
                type = "Hourly";
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee employee = (PieceWorkerEmployee) emp;
                basePay = employee.computeSalary();
                totalPay = employee.computeSalary(currentMonth);
                type = "Piece Worker";
            } else {
                System.out.println("Unsupported employee type: " + emp.getClass().getSimpleName());
                continue;
            }

            boolean birthdayMonth = emp.getBirthDate().getMonth() == currentMonth;
            System.out.println("[" + type + "] ID: " + emp.getEmpID()
                    + " | Name: " + emp.getEmpName()
                    + " | Salary: " + Employee.money(totalPay)
                    + (birthdayMonth ? " (Birthday Bonus Applied)" : ""));
        }
    }

    private static String monthName(int month) {
        String[] names = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return month >= 1 && month <= 12 ? names[month - 1] : String.valueOf(month);
    }
}
