// Name:    Elijah Iddings
// Class:   CS145
// Date:    10/20/2025
// File:    EIDisplayCalendar.java
// Source:  W3Schools / Oracle
// Purpose: Display an accurate calendar using the GregorianCalendar class

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class EIDisplayCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the month 1-12: ");
        int month = input.nextInt(); 
        displayCalendar(year, month);
    }

    public static String monthToString(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "";
    }

    public static void displayCalendar(int year, int month) {
        // creates GregorianCalendar object
        GregorianCalendar greg_calendar = new GregorianCalendar(year, month - 1, 1);
        // gets what day of the week it is (example: if it starts on sunday it'd be 1)
        int first_day = greg_calendar.get(Calendar.DAY_OF_WEEK) - 1;
        // gets the last day of the month
        int last_day = greg_calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day_count = 1;

        calendarHeader(year, month);
        // loops to get the accurate position of the first day of the month
        for (int i = 0; i < first_day; i++) {
            calendarBlankSpacing();
        }
        int j = first_day;
        // loops through the remaining 5 rows of the calendar
        for (int i = 0; i < 5; i++) {
            // j has to start at the beginning of the first day of the week otherwise the calendar breaks
            for (j = j; j < 7; j++) {
                calendarNumbers(day_count);
                day_count++;
                if (day_count > last_day) {
                    // loop to finish the grid if the last day isn't saturday
                    for (int k = 0; k < 35 - last_day - first_day; k++) {
                        calendarBlankSpacing();
                    }
                    break; // break because any day_count after last_day ruins calendar
                }
            }
            j = 0;
            calendarBottomRow();
        }
    }

    public static void calendarHeader(int year, int month) {
        System.out.printf("%s %d\n", monthToString(month), year);
        System.out.println("____________________________________");
        System.out.println("|Sun |Mon |Tue |Wed |Thu |Fri |Sat |");
        System.out.println("|____|____|____|____|____|____|____|");
    }

    public static void calendarBlankSpacing() {
        System.out.print("|    ");
    }

    // needs 2 spaces instead of 3 once day_count is > 9 otherwise spacing gets messed up
    public static void calendarNumbers(int day_count) {
        if (day_count > 9) {
            System.out.printf("|%d  ", day_count);
        } else {
            System.out.printf("|%d   ", day_count);
        }
    }

    public static void calendarBottomRow() {
        System.out.println("|");
        System.out.println("|____|____|____|____|____|____|____|");
    }
}