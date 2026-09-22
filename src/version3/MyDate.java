package version3;

public class MyDate {
    private static final String[] MONTHS = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        this();
        if (month >= 1 && month <= 12 && day >= 1 && day <= daysInMonth(month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= daysInMonth(month, year)) {
            this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12 && day <= daysInMonth(month, year)) {
            this.month = month;
        }
    }

    public void setYear(int year) {
        if (day <= daysInMonth(month, year)) {
            this.year = year;
        }
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public void displayDate() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%02d %s %d", day, MONTHS[month - 1], year);
    }
}
