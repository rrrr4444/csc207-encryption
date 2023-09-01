import java.io.PrintWriter;

public class CeasarCipher {
    public static void main (String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out,true);
        if (args.length != 2) {
            pen.println("Incorrect number of parameters");
        }
        else if (args[0].equals("encode")) {
            shifts(args[1], pen, false);
        }
        else if (args[0].equals("decode")) {
            shifts(args[1], pen, true);
        }
        else {
            pen.println(args[0]);
            pen.println("Valid options are \"encode\" or \"decode\"");
        }
    } // main

    static void shifts (String msg, PrintWriter pen, boolean reverse) {
        int base = (int) "a".toCharArray()[0];

        for (int key = 0; key < 26; key++) {
            char[] letters = msg.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                int letter_val = (int) (letters[i]);
                letters[i] = calculate(letter_val, base, key, reverse);
            }
            String text = new String(letters);
            pen.println(text);
        }
    } // shift

    static char calculate (int letter_val, int base, int key, boolean reverse) {
        if (reverse) {
            int char_value = (letter_val - base - key);
            if (char_value < 0) {
                char_value = 26 + char_value;
            }
            return (char) (char_value % 26 + base);
        }
        else {
            return (char) ((letter_val - base + key) % 26 + base);
        }
    }

} // class Ceasar