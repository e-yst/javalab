import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File f = new File("test.txt");

        try  {

            FileWriter fw = new FileWriter(f, true);
            fw.write("Testing file written by Java!\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
