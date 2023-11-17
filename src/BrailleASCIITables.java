package src;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * <Description>
 *
 * @author Maria Rodriguez
 */
public class BrailleASCIITables {
    
/*---------------------------
 * Fields |
 * --------------------------
 */

  BitTree tree_braille;

  BitTree tree_ASCII;

  BitTree tree_unicode;

 /*--------------------------
  * Constructor
  --------------------------
  */

  BrailleASCIITables(){
    String braille = "src/asciiBraille.txt";
    String unicode = "src/brailleUnicode.txt";
    String ascii = "src/brailleASCII.txt";

    
      InputStream braille_file;
      try {
        braille_file = new FileInputStream(braille);
      } catch (FileNotFoundException e) {
        System.err("Braille to ASCII file not found");
      }
      InputStream unicode_file = new FileInputStream(unicode);
      InputStream ascii_file = new FileInputStream(ascii);

    

    tree_braille.load(braille_file);
  }


/*---------------------------
 * Methods |
 * --------------------------
 */

 /*
  * toBraille()
  * converts an ASCII char to a string of bits representing the cooresponding braille char
  */
  static String toBraille(char letter){

  }

  /*
   * toASCII()
   * converts a string of bits representing a braille character to the corresponding ASCII character
   */
  static String toASCII(String bits){

  }

  /*
   * toUnicode()
   * converts a string of bits representing a braille character to the corresponding Unicode braille 
   * character for those bits. You need only support six-bit braille characters.
   */
  static String toUnicode(String bits){

  }
}