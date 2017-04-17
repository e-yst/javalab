import java.util.Date;

/**
 * Created by eason on 22/3/2017.
 */
public class TimeTool {
    public static void showCurrentTime() {
        Date now = new Date();
        System.out.println(now);
    }

    public static boolean isLeapYear(Integer year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0)
            return true;
        return false;
    }

    public static void showCalendar(Integer year, Integer month) {
        Integer first_day = count_first_day(year, month);
        Integer days = count_days(year, month);

        if (year < 0) {
            System.out.println("Year must be a positive number!");
        } else if (month < 1 || month > 12) {
            System.out.println("Invalid month!");
        } else {
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");
            for (Integer i = 0; i < first_day; i++) {
                System.out.print("    ");
            }

            for (Integer j = 0; j <= days; j++) {
                if (j != 0)
                    System.out.printf("%3d ", j);

                if ((first_day + j) % 7 == 0 && j != 0)
                    System.out.println();
            }
            System.out.printf("%n%n");
        }
    }

    public static Integer count_first_day(Integer year, Integer month) {
        Integer i, j, f_day = 0;
        if (year < 1752 || (year == 1752 && month <= 8)) {
            f_day = 6;
            for (i = 1; i < year; ++i) {
                if (i % 4 == 0)
                    f_day = (f_day + 366 % 7) % 7;
                else
                    f_day = (f_day + 365 % 7) % 7;
            }
            for (j = 1; j < month; ++j) {
                f_day = (f_day + count_days(year, j)) % 7;
            }
        } else if (year > 1752) {
            f_day = 1;
            for (i = 1753; i < year; ++i) {
                if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                    f_day = (f_day + 366 % 7) % 7;
                else
                    f_day = (f_day + 365 % 7) % 7;
            }
            for (j = 1; j < month; ++j)
                f_day = (f_day + count_days(year, j)) % 7;
        } else if (year == 1752 && month >= 10) {
            f_day = 0;
            for (j = 10; j < month; ++j)
                f_day = (f_day + count_days(year, j)) % 7;
        }
        return (f_day);
    }

    static Integer count_days(Integer year, Integer month) {
        Integer days;
        if (year <= 1752 && year % 4 == 0 && month == 2)
            days = 29;
        else if (year > 1752 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month == 2)
            days = 29;
        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            days = 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            days = 30;
        else
            days = 28;
        return (days);
    }
}