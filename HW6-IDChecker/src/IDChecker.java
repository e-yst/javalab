
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Eason Tse on 22/4/2017.
 */
public class IDChecker {
    public static void main(String[] args) {

        ID id = new ID();
        String[] dataset = id.readFile("input.txt");
        ArrayList<String> correct = new ArrayList<String>();
        ArrayList<String> error = new ArrayList<String>();

        String validateResult;
        for (String i: dataset) {
            validateResult = id.validate(i);
            switch (validateResult) {
                case "格式不符":
                case "身份證字號錯誤":
                    error.add(i + ", " + validateResult);
                    break;
                default:
                    correct.add(i + ", " + validateResult);
                    break;
            }
        }

        id.writeFile("correct.txt", correct);
        id.writeFile("error.txt", error);
        System.out.println("Done");
    }
}
