package version2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Alice", "Marie", "Smith");
        MyDate sampleDate = new MyDate(18, 9, 2026);
        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();

        Name alice = new Name("Alice", "Marie", "Smith");
        MyDate aliceBirth = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);

        HourlyEmployee hourlyPartial = new HourlyEmployee();
        hourlyPartial.setEmpID(100);
        hourlyPartial.setEmpName(new Name("Liam", "Owen", "Cruz"));
        hourlyPartial.setBirthDate(new MyDate(3, 1, 1999));
        hourlyPartial.setDateHired(new MyDate(10, 3, 2021));
        hourlyPartial.setTotalHoursWorked(30);
        hourlyPartial.setRatePerHour(150);

        HourlyEmployee hourlyFull = new HourlyEmployee(101, alice, aliceBirth, aliceHired, 45f, 200);

        PieceWorkerEmployee piecePartial = new PieceWorkerEmployee();
        piecePartial.setEmpID(200);
        piecePartial.setEmpName(new Name("Bob", "Carlos", "Jones", "Jr."));
        piecePartial.setBirthDate(new MyDate(5, 4, 1998));
        piecePartial.setDateHired(new MyDate(15, 1, 2023));
        piecePartial.setTotalPiecesFinished(250);
        piecePartial.setRatePerPiece(15);

        PieceWorkerEmployee pieceFull = new PieceWorkerEmployee(
            201,
            new Name("Nina", "Paz", "Reyes"),
            new MyDate(22, 11, 1997),
            new MyDate(2, 8, 2020),
            120,
            20
        );

        CommissionEmployee commissionPartial = new CommissionEmployee();
        commissionPartial.setEmpID(300);
        commissionPartial.setEmpName(new Name("Eva", "Luna", "Santos"));
        commissionPartial.setBirthDate(new MyDate(9, 2, 1995));
        commissionPartial.setDateHired(new MyDate(4, 7, 2019));
        commissionPartial.setTotalSale(80000);

        CommissionEmployee commissionFull = new CommissionEmployee(
            301,
            new Name("Marco", "Diaz", "Lim"),
            new MyDate(14, 12, 1992),
            new MyDate(20, 5, 2018),
            150000
        );

        BasePlusCommissionEmployee basePartial = new BasePlusCommissionEmployee();
        basePartial.setEmpID(400);
        basePartial.setEmpName(new Name("Sofia", "Grace", "Tan"));
        basePartial.setBirthDate(new MyDate(30, 6, 1994));
        basePartial.setDateHired(new MyDate(11, 10, 2021));
        basePartial.setTotalSale(60000);
        basePartial.setBaseSalary(10000);

        BasePlusCommissionEmployee baseFull = new BasePlusCommissionEmployee(
            401,
            new Name("Diego", "Ramos", "Garcia"),
            new MyDate(8, 3, 1990),
            new MyDate(1, 4, 2017),
            520000,
            25000
        );

        System.out.println("\n---------------------------------------------------------------------------------------\nDISPLAY EXECUTION\n---------------------------------------------------------------------------------------\n");

        hourlyPartial.displayHourEmployee();
        hourlyFull.displayHourEmployee();
        System.out.println("");

        piecePartial.displayPieceWorkerEmployee();
        pieceFull.displayPieceWorkerEmployee();
        System.out.println("");

        commissionPartial.displayCommissionEmployye();
        commissionFull.displayCommissionEmployye();
        System.out.println("");

        basePartial.displayBasePlusCommissionEmployee();
        baseFull.displayBasePlusCommissionEmployee();

        System.out.println("\n---------------------------------------------------------------------------------------\n");

        System.out.println("\n---------------------------------------------------------------------------------------\nSTRING CONVERSION EXECUTION\n---------------------------------------------------------------------------------------\n");

        System.out.println(hourlyPartial);
        System.out.println(hourlyFull);
        System.out.println("");

        System.out.println(piecePartial);
        System.out.println(pieceFull);
        System.out.println("");

        System.out.println(commissionPartial);
        System.out.println(commissionFull);
        System.out.println("");

        System.out.println(basePartial);
        System.out.println(baseFull);

        System.out.println("\n---------------------------------------------------------------------------------------\n");

        System.out.println("\n---------------------------------------------------------------------------------------\nBIRTHDAY INCENTIVE CHECK\n---------------------------------------------------------------------------------------\n");
        printBirthdayCheck(hourlyFull);
        printBirthdayCheck(pieceFull);
        printBirthdayCheck(commissionFull);
        printBirthdayCheck(baseFull);
        System.out.println("\n---------------------------------------------------------------------------------------\n");
    }

    private static void printBirthdayCheck(HourlyEmployee employee) {
        printBirthdayLine(employee.getEmpName().toString(), employee.getBirthDate().getMonth(), employee);
    }

    private static void printBirthdayCheck(PieceWorkerEmployee employee) {
        int birthMonth = employee.getBirthDate().getMonth();
        int otherMonth = birthMonth == 12 ? 1 : birthMonth + 1;
        System.out.println(employee.getEmpName());
        System.out.printf("Regular Month (%s) Salary: %s%n", monthName(otherMonth), HourlyEmployee.money(employee.computeSalary(otherMonth)));
        System.out.printf("Birth Month (%s) Salary (+P5,000.00): %s%n%n", monthName(birthMonth), HourlyEmployee.money(employee.computeSalary(birthMonth)));
    }

    private static void printBirthdayCheck(CommissionEmployee employee) {
        int birthMonth = employee.getBirthDate().getMonth();
        int otherMonth = birthMonth == 12 ? 1 : birthMonth + 1;
        System.out.println(employee.getEmpName());
        System.out.printf("Regular Month (%s) Salary: %s%n", monthName(otherMonth), HourlyEmployee.money(employee.computeSalary(otherMonth)));
        System.out.printf("Birth Month (%s) Salary (+P5,000.00): %s%n%n", monthName(birthMonth), HourlyEmployee.money(employee.computeSalary(birthMonth)));
    }

    private static void printBirthdayCheck(BasePlusCommissionEmployee employee) {
        int birthMonth = employee.getBirthDate().getMonth();
        int otherMonth = birthMonth == 12 ? 1 : birthMonth + 1;
        System.out.println(employee.getEmpName());
        System.out.printf("Regular Month (%s) Salary: %s%n", monthName(otherMonth), HourlyEmployee.money(employee.computeSalary(otherMonth)));
        System.out.printf("Birth Month (%s) Salary (+P5,000.00): %s%n%n", monthName(birthMonth), HourlyEmployee.money(employee.computeSalary(birthMonth)));
    }

    private static void printBirthdayLine(String name, int birthMonth, HourlyEmployee employee) {
        int otherMonth = birthMonth == 12 ? 1 : birthMonth + 1;
        System.out.println(name);
        System.out.printf("Regular Month (%s) Salary: %s%n", monthName(otherMonth), HourlyEmployee.money(employee.computeSalary(otherMonth)));
        System.out.printf("Birth Month (%s) Salary (+P5,000.00): %s%n%n", monthName(birthMonth), HourlyEmployee.money(employee.computeSalary(birthMonth)));
    }

    private static String monthName(int month) {
        String[] names = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return names[month - 1];
    }
}
