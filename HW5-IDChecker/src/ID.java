/**
 * Created by Eason Tse on 17/4/2017.
 */
public class ID {
    private String idInNum;
    private String idTxt, gender, dist, error;


    public ID(String Id) {
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

        Integer sum = 0;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(0)));
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(1))) * 9;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(2))) * 8;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(3))) * 7;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(4))) * 6;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(5))) * 5;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(6))) * 4;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(7))) * 3;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(8))) * 2;
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(9)));
        sum += Integer.parseInt(String.valueOf(idInNum.charAt(10)));


        if (sum % 10 == 0) {
            System.out.println("身份證字號正確");
            System.out.printf("是位出生在%s的%s朋友呢%n%n", dist, gender);
        } else {
            System.out.println("身份證字號錯誤\n");
        }

    }

    private String idToAllNum(String txt) {
        String result = "";
        result = result.concat(alphabetToNum(String.valueOf(txt.charAt(0))));
        result = result.concat(txt.substring(1));
        return result;
    }

    private String alphabetToNum(String txt) {
        switch (txt) {
            case "A":
                dist = "台北市";
                return "10";
            case "B":
                dist = "臺中市";
                return "11";
            case "C":
                dist = "基隆市";
                return "10";
            case "D":
                dist = "台南市";
                return "13";
            case "E":
                dist = "高雄市";
                return "14";
            case "F":
                dist = "台北縣";
                return "15";
            case "G":
                dist = "宜蘭縣";
                return "16";
            case "H":
                dist = "桃園縣";
                return "17";
            case "I":
                dist = "嘉義市";
                return "34";
            case "J":
                dist = "新竹縣";
                return "18";
            case "K":
                dist = "苗栗縣";
                return "19";
            case "L":
                dist = "臺中縣";
                return "20";
            case "M":
                dist = "南投縣";
                return "21";
            case "N":
                dist = "彰化縣";
                return "22";
            case "O":
                dist = "新竹市";
                return "35";
            case "P":
                dist = "雲林縣";
                return "23";
            case "Q":
                dist = "嘉義縣";
                return "24";
            case "R":
                dist = "台南縣";
                return "25";
            case "S":
                dist = "高雄縣";
                return "26";
            case "T":
                dist = "屏東縣";
                return "27";
            case "U":
                dist = "花蓮縣";
                return "28";
            case "V":
                dist = "台東縣";
                return "29";
            case "W":
                dist = "金門縣";
                return "32";
            case "X":
                dist = "澎湖縣";
                return "30";
            case "Y":
                dist = "陽明山管理局";
                return "31";
            case "Z":
                dist = "連江縣";
                return "33";
        }
        dist = null;
        return "00";
    }
}
