/**
 * Created by eason.tse on 2017/5/22.
 */
public class Time {
    Integer HH, MM, SS, totalSec;

    public Time(String input) {
        String[] timeInText = input.split(":");
        HH = Integer.parseInt(timeInText[0]);
        MM = Integer.parseInt(timeInText[1]);
        SS = Integer.parseInt(timeInText[2]);
        totalSec = timeToSec();
    }

    private Integer timeToSec() {
        Integer mins = MM, sec = SS;

        mins += HH * 60;
        sec += mins * 60;
        return sec;
    }

    public static String secToTxt(Integer txtSec) {
        Integer ss = txtSec;
        Integer mm = 0, hh = 0;

        while (ss >= 60) {
            mm++;
            ss -= 60;
        }

        while (mm >= 60) {
            hh++;
            mm -= 60;
        }

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

    public Integer timeDiff(Integer sec) {
        Integer diff = totalSec - sec;
        if (totalSec > sec) return diff;
        else return 86400 - diff;
    }
}
