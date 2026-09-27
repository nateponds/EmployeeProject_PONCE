package version5;

public class Main {

    private static final String SEPARATOR =
        "======================================================================";

    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee alice = new HourlyEmployee(
            101,
            new Name("Alice", "Marie", "Smith"),
            new MyDate(18, 9, 2000),
            new MyDate(1, 6, 2022),
            45,
            200
        );
        PieceWorkerEmployee bob = new PieceWorkerEmployee(
            201,
            new Name("Bob", "Carlos", "Jones", "Jr."),
            new MyDate(5, 4, 1998),
            new MyDate(15, 1, 2023),
            250,
            15
        );
        CommissionEmployee maria = new CommissionEmployee(
            301,
            new Name("Maria", "L", "Reyes"),
            new MyDate(14, 9, 1992),
            new MyDate(20, 5, 2018),
            100000
        );
        BasePlusCommissionEmployee kevin = new BasePlusCommissionEmployee(
            401,
            new Name("Kevin", "S", "Tan"),
            new MyDate(8, 3, 1990),
            new MyDate(1, 4, 2017),
            100000,
            17000
        );

        System.out.println(SEPARATOR);
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println(SEPARATOR);
        enroll(roster, alice, "Hourly");
        enroll(roster, bob, "Piece Worker");
        enroll(roster, maria, "Commission");
        enroll(roster, kevin, "Base Plus Commission");
        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println();
        roster.displayPayroll(9);

        System.out.println("\n" + SEPARATOR);
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println(SEPARATOR);
        Employee removed = roster.removeEmployee(201);
        System.out.println(
            "Removing Employee ID 201... " +
            (removed == null ? "Employee not found." : "Successfully removed.")
        );
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println("\nCurrent Active Employees:");
        displayActiveEmployees(roster, 101, 301, 401);
        System.out.println(SEPARATOR);
    }

    private static void enroll(
        EmployeeRoster roster,
        Employee employee,
        String employeeType
    ) {
        if (roster.addEmployee(employee)) {
            System.out.println("Enrolled: " + employee.getEmpName() + " (" + employeeType + ")");
        }
    }

    private static void displayActiveEmployees(
        EmployeeRoster roster,
        int... employeeIds
    ) {
        int position = 1;
        for (int employeeId : employeeIds) {
            Employee employee = roster.searchEmployee(employeeId);
            if (employee != null) {
                System.out.printf(
                    "%d. %s [ID: %d, Name: %s, Total Salary: %s]%n",
                    position++,
                    employee.getClass().getSimpleName(),
                    employee.getEmpID(),
                    employee.getEmpName(),
                    Employee.money(employee.computeSalary())
                );
            }
        }
    }
}
