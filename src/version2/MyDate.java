package version2;

import java.time.LocalDate;

public class MyDate {
    // dateHired int int int
    // birthDate int int int
    // if it is the employee's birthmonth then they will have an added salary of 5000

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void display(){
        System.out.printf("%1d-%1d-%1d", this.day, this.month, this.year);
    }

    @Override
    public String toString() {
        return this.day + "-" + this.month + "-" + this.year;
    }

}
