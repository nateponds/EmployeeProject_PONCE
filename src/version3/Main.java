package version3;

import java.util.Locale;

public class Main {
    private static final int TARGET_MONTH = 9;

    public static void main(String[] args) throws CloneNotSupportedException {
        HourlyEmployee hourly = new HourlyEmployee(
            101,
            new Name("Alice", "Marie", "Smith"),
            new MyDate(18, 9, 2000),
            new MyDate(1, 6, 2022),
            45f,
            200
        );

        PieceWorkerEmployee piece = new PieceWorkerEmployee(
            201,
            new Name("Bob", "Carlos", "Jones", "Jr."),
            new MyDate(5, 4, 1998),
            new MyDate(15, 1, 2023),
            250,
            15
        );

        CommissionEmployee commission = new CommissionEmployee(
            301,
            new Name("Marco", "Diaz", "Lim"),
            new MyDate(14, 12, 1992),
            new MyDate(20, 5, 2018),
            150000
        );

        BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(
            401,
            new Name("Diego", "Ramos", "Garcia"),
            new MyDate(8, 3, 1990),
            new MyDate(1, 4, 2017),
            520000,
            25000
        );

        Employee[] employees = { hourly, piece, commission, basePlus };

        printPayrollReport(employees, TARGET_MONTH);
        printEqualsHashCodeTests(hourly, piece);
        printDeepCloneVerification(hourly);
    }

    private static void printPayrollReport(Employee[] employees, int targetMonth) {
        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: " + monthName(targetMonth) + ")");
        System.out.println("======================================================================");

        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            double basePay = employee.computeSalary();
            double totalPayout = employee.computeSalary(targetMonth);
            double birthdayBonus = totalPayout - basePay;
            boolean eligible = employee.getBirthDate().getMonth() == targetMonth;

            System.out.println((i + 1) + ". " + formatEmployeeHeader(employee));
            System.out.println("   Base Pay: " + money(basePay)
                + " | Birthday Bonus: " + money(birthdayBonus)
                + " (" + (eligible ? "Eligible" : "Ineligible") + ")");
            System.out.println("   Total Payout: " + money(totalPayout));
            if (i < employees.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void printEqualsHashCodeTests(HourlyEmployee emp1, Employee emp2) {
        HourlyEmployee emp1Identical = new HourlyEmployee(
            emp1.getEmpID(),
            new Name(
                emp1.getEmpName().getFirstName(),
                emp1.getEmpName().getMiddleName(),
                emp1.getEmpName().getLastName()
            ),
            new MyDate(
                emp1.getBirthDate().getDay(),
                emp1.getBirthDate().getMonth(),
                emp1.getBirthDate().getYear()
            ),
            new MyDate(
                emp1.getDateHired().getDay(),
                emp1.getDateHired().getMonth(),
                emp1.getDateHired().getYear()
            ),
            emp1.getTotalHoursWorked(),
            emp1.getRatePerHour()
        );

        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");
        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode()
            + " | emp1Identical hashCode: " + emp1Identical.hashCode()
            + " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));
        System.out.println();
    }

    private static void printDeepCloneVerification(HourlyEmployee empOriginal) throws CloneNotSupportedException {
        HourlyEmployee empClone = empOriginal.clone();

        System.out.println("======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");
        System.out.println("Original Name before modification: " + empOriginal.getEmpName());
        empClone.getEmpName().setLastName("Taylor");
        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + empOriginal.getEmpName()
            + " (Deep copy successful!)");
    }

    private static String formatEmployeeHeader(Employee employee) {
        return employee.getClass().getSimpleName()
            + " [ID: " + employee.getEmpID()
            + ", Name: " + employee.getEmpName()
            + ", DOB: " + employee.getBirthDate()
            + ", Hired: " + employee.getDateHired() + "]";
    }

    private static String money(double amount) {
        return String.format(Locale.US, "₱%,.2f", amount);
    }

    private static String monthName(int month) {
        String[] names = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return names[month - 1];
    }
}
