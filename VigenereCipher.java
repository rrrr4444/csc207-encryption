import java.io.PrintWriter;

public class VigenereCipher {
    public static void main (String[] args) {
        PrintWriter pen = new PrintWriter(System.out,true);
        if (args.length != 3) {
            pen.println("Incorrect number of parameters");
        } else if (args[0].equals("encode")) {
            String ciphertext = encode(args[1], args[2], false);
            pen.println(ciphertext);
        } else if (args[0].equals("decode")) {
            String plaintext = encode(args[1], args[2], true);
            pen.println(plaintext);
        } else {
            pen.println("Valid options are \"encode\" or \"decode\"");
        } // if
    } //
    static String encode (String msg, String keyword, boolean reverse) {
        if (keyword.isEmpty()) {
            return msg;
        } // if
        int base = "a".toCharArray()[0];
        char[] letters = msg.toCharArray();
        char[] keys = keyword.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int letter_val = (int) letters[i] - base;
            int key_val = (int) keys[(i % keys.length)] - base;
            if (reverse) {
                key_val *= -1;
            } // if
            letter_val = (letter_val + key_val);
            if (letter_val < 0) {
                letter_val = 26 + letter_val;
            } // if
            letter_val = letter_val % 26;
            letters[i] = (char) (letter_val + base);
        } // for
        return new String(letters);
    } //
}