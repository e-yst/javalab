import java.io.File;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        File f = new File("test.txt");

        try {

            FileReader fr = new FileReader(f);
            int charCount = fr.read();
            while (charCount != -1) {
                System.out.print((char)charCount);
                charCount = fr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
