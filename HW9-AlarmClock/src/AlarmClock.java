import java.util.Date;
import java.util.Scanner;

/**
 * Created by eason.tse on 2017/5/22.
 */
public class AlarmClock {
    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.start();
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        Date now;
        Time mTimeNow, inputTime;
        do {
            now = new Date();
            mTimeNow = new Time(String.format("%1$tT", now));
            try {
                System.out.printf("%1$tY-%1$tm-%1$td %1$tT%n", now);
                System.out.print("請設定鬧鐘時(HH:mm:ss): ");
                String keyInTime = input.nextLine();

                if (!keyInTime.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]"))
                    if (keyInTime.matches(".+:[0-5][0-9]:[0-5][0-9]"))
                        throw new TimeFormatException("Hour格式錯誤\n");
                    else if (keyInTime.matches("(([0-1][0-9])|(2[0-3])):.+:[0-5][0-9]"))
                        throw new TimeFormatException("Minute格式錯誤\n");
                    else if (keyInTime.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]:.+"))
                        throw new TimeFormatException("Second格式錯誤\n");
                    else
                        throw new TimeFormatException("格式錯誤\n");
                else
                    inputTime = new Time(keyInTime);
                    break;
            } catch (TimeFormatException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        Integer diffInSec = inputTime.timeDiff(mTimeNow.totalSec);
        String timeInTxt = Time.secToTxt(diffInSec);
        String[] splitTime = timeInTxt.split(":");
        String timeInChinese = splitTime[0] + "小時" + splitTime[1] + "分鐘";

        System.out.printf("已將鬧鐘設定在%s後啟動", timeInChinese);

    }

}
