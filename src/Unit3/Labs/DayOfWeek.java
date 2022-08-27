package Unit3.Labs;

import java.util.Scanner;
class DayOfWeek {

    public static String dayOfWeek(int m, int d, int y)
    {

        //own formula
        int ycode = getYearCode(y);
        int mcode = getMonthCode(m);
        int ccode = getCenturyCode(y);
        int isLeapYear = isLeapYear(y);


        int day = (ycode + mcode + ccode + d - isLeapYear) % 7;

        // 2. convert to a day using an if statement
        if (day == 1){
            return "Monday";
        } else if (day == 2){
            return "Tuesday";
        } else if (day == 3){
            return "Wednesday";
        } else if (day == 4){
            return "Thursday";
        } else if (day == 5){
            return "Friday";
        } else if (day == 6){
            return "Saturday";
        } else {
            return "Sunday";
        }

    }
    public static int getCenturyCode(int y){
        if (y >= 2300 && y < 2400){
            return 0;
        } else if (y >= 2200 && y < 2300){
            return 2;
        } else if (y >= 2100 && y < 2200){
            return 4;
        } else if (y >= 2000 && y < 2100){
            return 6;
        } else if (y >= 1900 && y < 2000){
            return 0;
        } else if (y >= 1800 && y < 1900){
            return 2;
        } else if (y >= 1700 && y < 1800){
            return 4;
        }

        return 3170123;

    }

    public static int getYearCode(int y){
        int yy = y % 100;


        int result = (yy + (yy/4)) % 7;
        return result;
    }

    public static int isLeapYear(int y){
        if (y % 400 == 0){
            return 1;
        }

        if (y % 100 == 0){
            return 0;
        }

        if (y % 4 == 0){
            return 1;
        }

        return 0;
    }
    public static int getMonthCode(int m){
        int mcode = 0;
        switch (m){
            case 1:
                mcode = 0;
                break;
            case 2:
                mcode = 3;
                break;
            case 3:
                mcode = 3;
                break;
            case 4:
                mcode = 6;
                break;
            case 5:
                mcode = 1;
                break;
            case 6:
                mcode = 4;
                break;
            case 7:
                mcode = 6;
                break;
            case 8:
                mcode = 2;
                break;
            case 9:
                mcode = 5;
                break;
            case 10:
                mcode = 0;
                break;
            case 11:
                mcode = 3;
                break;
            case 12:
                mcode = 5;
                break;
            default:
                mcode = 2170298;
        }

        return mcode;
    }

    public static void main(String[] args)
    {
        // 1. Ask user for month, day and year
        Scanner s = new Scanner(System.in);

        //System.out.println("Enter month: ");
        int month = s.nextInt();
        //System.out.println("Enter day: ");
        int day = s.nextInt();
        //System.out.println("Enter year: ");
        int year = s.nextInt();
        // 2. Call dayOfWeek

        System.out.println("Day of the week: " + dayOfWeek(month, day, year));
        // 3. Output result
    }
}
