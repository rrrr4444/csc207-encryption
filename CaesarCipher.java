import java.io.PrintWriter;
/**
 * A command line Caesar Cipher.
 *
 * @author Reed Colloton
 * @version 2 of October 2023
 */
public class CaesarCipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println("Incorrect number of parameters");
    } else if (args[0].equals("encode")) {
      shift(args[1], pen, false);
    } else if (args[0].equals("decode")) {
      shift(args[1], pen, true);
    } else {
      pen.println(args[0]);
      pen.println("Valid options are \"encode\" or \"decode\"");
    } // if
  } // main(String[] args)

  static void shift(String msg, PrintWriter pen, boolean reverse) {
    int base = "a".toCharArray()[0];
    for (int key = 0; key < 26; key++) {
      char[] letters = msg.toCharArray();
      for (int i = 0; i < letters.length; i++) {
        int letter_val = letters[i];
        letters[i] = calculate(letter_val, base, key, reverse);
      } // for
      String text = new String(letters);
      pen.println(text);
    } // for
  } // shift(String msg, PrintWriter pen, boolean reverse)

  static char calculate(int letter_val, int base, int key, boolean reverse) {
    if (reverse) {
      key *= -1;
    } // if
    int char_value = (letter_val - base + key) % 26;
    if (char_value < 0) {
      char_value = 26 + char_value;
    } // if
    return (char) (char_value + base);
  } // calculate(int letter_val, int base, int key, boolean reverse)
} // class CaesarCipher