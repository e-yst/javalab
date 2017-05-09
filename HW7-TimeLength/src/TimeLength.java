/**
 * Created by eason.tse on 9/5/2017.
 */
public class TimeLength {

    private String timeInTxt;
    private Integer timeInSec;

    public void setup(String txt) {
        if (txt.matches("\\d+")) {
            this.timeInSec = Integer.parseInt(txt);
            this.timeInTxt = secToTxt(txt);
        } else if (txt.matches("\\d+:[0-5]\\d:[0-5]\\d")) {
            this.timeInSec = txtToSec(txt);
            this.timeInTxt = txt;
        }
    }


    public static String secToTxt(String txtSec) {
        Integer ss = Integer.parseInt(txtSec);
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

    public static Integer txtToSec(String txt) {
        String[] times = txt.split(":");
        Integer hh, mm, ss;
        hh = Integer.parseInt(times[0]);

        mm = Integer.parseInt(times[1]);
        ss = Integer.parseInt(times[2]);

        mm += hh * 60;
        ss += mm * 60;

        return ss;
    }

    public void addTime(String txt) {
        Integer sec;

        if (txt.matches("\\+\\d+")) {
            sec = Integer.parseInt(txt.substring(1));
            this.timeInSec += sec;
        } else if (txt.matches("\\+\\d+:[0-5]\\d:[0-5]\\d")) {
            sec = txtToSec(txt.substring(1));
            this.timeInSec += sec;
        } else {
            System.out.println("WTF?");
            return;
        }

        if (this.timeInSec < 0) {
            this.timeInTxt = "-" + secToTxt(String.valueOf(Math.abs(this.timeInSec)));
        } else {
            this.timeInTxt = secToTxt(this.timeInSec.toString());
        }
    }

    public void minusTime(String txt) {
        Integer sec;

        if (txt.matches("\\-\\d+")) {
            sec = Integer.parseInt(txt.substring(1));
            this.timeInSec -= sec;
        } else if (txt.matches("\\-\\d+:[0-5]\\d:[0-5]\\d")) {
            sec = txtToSec(txt.substring(1));
            this.timeInSec -= sec;
        } else {
            System.out.println("WTF?");
            return;
        }

        if (this.timeInSec < 0) {
            this.timeInTxt = "-" + secToTxt(String.valueOf(Math.abs(this.timeInSec)));
        } else {
            this.timeInTxt = secToTxt(this.timeInSec.toString());
        }
    }

    public String getTimeInTxt() {
        return timeInTxt;
    }

    public Integer getTimeInSec() {
        return timeInSec;
    }
}
