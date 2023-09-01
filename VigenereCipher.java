import java.io.PrintWriter;

public class VigenereCipher {
    public static void main (String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out,true);
        if (args.length != 3) {
            pen.println("Incorrect number of parameters");
        }
        else if (args[0].equals("encode")) {
            String ciphertext = encode(args[1], args[2]);
            pen.println(ciphertext);
        }
        else if (args[0].equals("decode")) {
            String plaintext = decode(args[1], args[2]);
            pen.println(plaintext);
        }
        else {
            pen.println("Valid options are \"encode\" or \"decode\"");
        }
    }
    static String encode (String msg, String keyword) {
        int base = (int) "a".toCharArray()[0];
        char[] letters = msg.toCharArray();
        char[] keys = keyword.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int letter_val = (int) letters[i] - base;
            int key_val = (int) keys[(i % keys.length)] - base;
            letter_val = (letter_val + key_val) % 26;
            letters[i] = (char) (letter_val + base);
        }
        String ciphertext = new String(letters);
        return ciphertext;
    }
    static String decode (String msg, String keyword) {
        int base = (int) "a".toCharArray()[0];
        char[] letters = msg.toCharArray();
        char[] keys = keyword.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int letter_val = (int) letters[i] - base;
            int key_val = (int) keys[(i % keys.length)] - base;
            letter_val = (letter_val - key_val);
            if (letter_val < 0) {
                letter_val = 26 + letter_val;
            }
            letter_val = letter_val % 26;
            letters[i] = (char) (letter_val + base);
        }
        String plaintext = new String(letters);
        return plaintext;
    }
}
