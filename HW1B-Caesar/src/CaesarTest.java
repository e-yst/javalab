import java.util.Scanner;

/**
 * Created by Eason Tse on 1/3/2017.
 */
public class CaesarTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Plaintext: ");
        String text = input.next();

        System.out.print("Key: ");
        int key = input.nextInt();

        Caesar encoded = new Caesar(text, key);
        System.out.printf("Ciphertext: %s%n", encoded.getCiphertext());
    }
}
