import java.io.*;
import java.util.ArrayList;

/**
 * Created by Eason Tse on 21/4/2017.
 */

public class ID {
    private String idInNum, idTxt, gender, dist;

    public distInfo[] distList = {
            new distInfo("A", "台北市", "10"),
            new distInfo("B", "臺中市", "11"),
            new distInfo("C", "基隆市", "12"),
            new distInfo("D", "台南市", "13"),
            new distInfo("E", "高雄市", "14"),
            new distInfo("F", "台北市", "15"),
            new distInfo("G", "宜蘭縣", "16"),
            new distInfo("H", "桃園縣", "17"),
            new distInfo("I", "嘉義市", "34"),
            new distInfo("J", "新竹縣", "18"),
            new distInfo("K", "苗栗縣", "19"),
            new distInfo("L", "臺中縣", "20"),
            new distInfo("M", "南投縣", "21"),
            new distInfo("N", "彰化縣", "22"),
            new distInfo("O", "新竹市", "35"),
            new distInfo("P", "雲林縣", "23"),
            new distInfo("Q", "嘉義縣", "24"),
            new distInfo("R", "台南縣", "25"),
            new distInfo("S", "高雄縣", "26"),
            new distInfo("T", "屏東縣", "27"),
            new distInfo("U", "花蓮縣", "28"),
            new distInfo("V", "台東縣", "29"),
            new distInfo("W", "金門縣", "32"),
            new distInfo("X", "澎湖縣", "30"),
            new distInfo("Y", "陽明山", "31"),
            new distInfo("Z", "連江縣", "33"),
    };

    public void newId(String Id) {
        idTxt = Id;
        idInNum = idToAllNum(idTxt);
    }

    public String validate(String txt) {

        if (!txt.matches("[A-Z][1-2]\\d{8}"))
            return "格式不符";

        String toNum = idToAllNum(txt);

        if (String.valueOf(toNum.charAt(2)).equals("1"))
            gender = "男性";
        else
            gender = "女性";

        if (isValidNum(toNum))
            return dist + " " + gender;

        return "身份證字號錯誤";
    }

    private boolean isValidNum(String txt) {
        Integer sum = 0;
        sum += Integer.parseInt(String.valueOf(txt.charAt(0)));
        sum += Integer.parseInt(String.valueOf(txt.charAt(1))) * 9;
        sum += Integer.parseInt(String.valueOf(txt.charAt(2))) * 8;
        sum += Integer.parseInt(String.valueOf(txt.charAt(3))) * 7;
        sum += Integer.parseInt(String.valueOf(txt.charAt(4))) * 6;
        sum += Integer.parseInt(String.valueOf(txt.charAt(5))) * 5;
        sum += Integer.parseInt(String.valueOf(txt.charAt(6))) * 4;
        sum += Integer.parseInt(String.valueOf(txt.charAt(7))) * 3;
        sum += Integer.parseInt(String.valueOf(txt.charAt(8))) * 2;
        sum += Integer.parseInt(String.valueOf(txt.charAt(9)));
        sum += Integer.parseInt(String.valueOf(txt.charAt(10)));

        if (sum % 10 == 0) return true;
        else return false;
    }

    private class distInfo {
        protected String symbol, distName, num;

        public distInfo(String symbol, String distName, String num) {
            this.symbol = symbol;
            this.distName = distName;
            this.num = num;
        }
    }

    private String idToAllNum(String txt) {
        String result = "";
        result = result.concat(alphabetToNum(String.valueOf(txt.charAt(0))));
        result = result.concat(txt.substring(1));
        return result;
    }

    private String alphabetToNum(String txt) {
        for (distInfo d : distList)
            if (txt.equals(d.symbol)) {
                dist = d.distName;
                return d.num;
            }
        return null;
    }

    public String[] readFile(String fileName) {
        ArrayList<String> data = new ArrayList<String>();
        try {
//            File file = new File(fileName);
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

    public void writeFile(String fileName, ArrayList<String> data) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String i: data) {
                bw.write(i);
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
