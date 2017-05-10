import java.util.Random;

/**
 * Created by Eason Tse on 17/4/2017.
 */
public class ID {
    private String idInNum;
    private String idTxt, gender, dist;
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

    public void validate() {

        if (!idTxt.matches("[A-Z][1-2]\\d{8}")) {
            System.out.println("格式不符");
            return;
        }

        if (String.valueOf(idInNum.charAt(2)).equals("1"))
            gender = "男性";
        else
            gender = "女性";

        if (isValidNum(idInNum)) {
            System.out.println("身份證字號正確");
            System.out.printf("是位出生在%s的%s朋友呢%n%n", dist, gender);
        } else
            System.out.println("身份證字號錯誤\n");

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

    public String distToNum(String txt) {
        for (distInfo d : distList)
            if (txt.equals(d.distName)) {
                dist = txt;
                return d.num;
            }

        System.out.println("縣市錯誤");
        return null;
    }

    public String genderToNum(String txt) {
        if (txt.matches("[男女MmFf]")) {
            switch (txt) {
                case "男":
                case "M":
                case "m":
                    gender = "男性";
                    return "1";
                case "女":
                case "F":
                case "f":
                    gender = "女性";
                    return "2";
            }
        }
        System.out.println("性別有誤");
        return null;
    }

    private String numToSymbol(String txt) {
        for (distInfo d : distList)
            if (txt.equals(d.num))
                return d.symbol;
        return null;
    }

    private String genRandomNum() {
        Random rand = new Random();
        Integer n = rand.nextInt(99999999) + 1;
        String result = n.toString();
        while (result.length() < 8) {
            result = "0".concat(result);
        }
        return result;
    }

    public String genId(String distNum, String genderNum) {

        String result;
        do {
            result = distNum + genderNum + genRandomNum();
        } while (!isValidNum(result));

        idInNum = result;

        String distSymbol = numToSymbol(result.substring(0, 2));
        result = distSymbol.concat(result.substring(2));

        this.idTxt = result;
        return result;
    }
}
