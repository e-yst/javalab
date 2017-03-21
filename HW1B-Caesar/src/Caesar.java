/**
 * Created by Eason Tse on 1/3/2017.
 */
public class Caesar {
    private String codes = "qwertyuiopasdfghjklzxcvbnm";
    private String plaintext;
    private String ciphertext = "";
    private int key;

    public Caesar(String text, int offset) {
        this.plaintext = text;
        this.key = offset;

        int index;
        char newCh;

        for (char c: text.toCharArray()) {
            index = codes.indexOf(Character.toLowerCase(c)) + offset;
            if (index > 25) index -= 26;
            else if (index < 0) index += 26;

            newCh = codes.charAt(index);
            this.ciphertext += newCh;
        }
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getPlaintext() {
        return this.plaintext;
    }

    public String getCiphertext() {
        return this.ciphertext;
    }

    public void setKey(int key) { this.key = key; }

    private char numToChar(int n) { return codes.toCharArray()[n]; }

}
