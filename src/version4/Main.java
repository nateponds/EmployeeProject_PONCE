package version4;

public class Main {
    private static final String SEPARATOR =
            "======================================================================";

    public static void main(String[] args) {
        final int rosterCapacity = 6;
        final int currentMonth = 9;
        EmployeeRoster roster = new EmployeeRoster(rosterCapacity);

        HourlyEmployee alice = new HourlyEmployee(
                101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45f,
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

        HourlyEmployee david = new HourlyEmployee(
                102,
                new Name("David", "A", "White"),
                new MyDate(10, 1, 1995),
                new MyDate(12, 8, 2021),
                32f,
                250
        );

        System.out.println(SEPARATOR);
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println(SEPARATOR);

        printAddition(roster.addEmployee(alice), alice, "Hourly");
        printAddition(roster.addEmployee(bob), bob, "Piece Worker");
        printAddition(roster.addEmployee(maria), maria, "Commission");
        printAddition(roster.addEmployee(kevin), kevin, "Base Plus Commission");
        printAddition(roster.addEmployee(david), david, "Hourly");

        EmployeeRoster capacityCheck = new EmployeeRoster(1);
        capacityCheck.addEmployee(alice);
        boolean rejectedWhenFull = !capacityCheck.addEmployee(bob);
        System.out.println("Capacity Check: Attempt beyond full roster -> "
                + (rejectedWhenFull ? "Rejected (Passed)" : "Accepted (Failed)"));

        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: 5 / " + rosterCapacity);
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println("\n--- CATEGORICAL EMPLOYEE DISPLAYS ---");
        roster.displayHE();
        roster.displayPWE();
        roster.displayCE();
        roster.displayBPCE();

        System.out.println("\n--- EMPLOYEE SEARCH ---");
        Employee searchResult = roster.searchEmployee(301);
        System.out.println("Search Employee ID 301: "
                + (searchResult == null
                ? "Not Found"
                : "Found - " + searchResult.getEmpName()));

        roster.displayPayroll(currentMonth);

        System.out.println("\n" + SEPARATOR);
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println(SEPARATOR);
        System.out.println("Removing Employee ID 201 (" + bob.getEmpName() + ")...");

        Employee removed = roster.removeEmployee(201);
        System.out.println(removed == null
                ? "Employee not found."
                : "Successfully removed.");
        System.out.println("Current Employee Count: 4");
        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println(SEPARATOR);
    }

    private static void printAddition(boolean added, Employee employee, String type) {
        System.out.println("Added: " + employee.getEmpName()
                + " (" + type + ") -> "
                + (added ? "Success" : "Failed"));
    }
}
