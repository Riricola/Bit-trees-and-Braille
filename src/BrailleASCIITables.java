package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Creates trees that store all the translations from braille to ASCII, braille to unicode,
 * and ASCII to braille
 *
 * @author Maria Rodriguez
 */
public class BrailleASCIITables {

  BrailleASCIITables(){}
/*---------------------------
 * Methods |
 * --------------------------
 */

 /*
  * toBraille()
  * converts an ASCII char to a string of bits representing the cooresponding braille char
  */
  static String toBraille(char letter) throws Exception{
    //create the bitTree
    BitTree tree_braille = new BitTree(8);
    String brailleAscii = "src/asciiBraille.txt";
    try {
      InputStream braille_file = new FileInputStream(brailleAscii);
      tree_braille.load(braille_file);
    } catch (NumberFormatException | IOException e) {
      System.err.println("Braille to ASCII file not found");
    }//try


    int asciiVal = (int) letter;
    String braille = Integer.toBinaryString(asciiVal);
    return tree_braille.get("0" + braille);
  }//toBraille
  
  /*
   * toASCII()
   * converts a string of bits representing a braille character to the corresponding ASCII character
   */
  static String toASCII(String bits) throws Exception{
    //create the bitTree
    BitTree tree_ASCII = new BitTree(bits.length());
    String ascii = "src/brailleASCII.txt";  
    try {
      InputStream ascii_file = new FileInputStream(ascii);
      tree_ASCII.load(ascii_file);
    } catch (NumberFormatException | IOException e) {
      System.err.println("ASCII to braille file not found");
    }//try

    return tree_ASCII.get(bits);
  }//toASCII

  /*
   * toUnicode()
   * converts a string of bits representing a braille character to the corresponding Unicode braille 
   * character for those bits. You need only support six-bit braille characters.
   */
  static String toUnicode(String bits) throws Exception{
    //create the tree
    BitTree tree_unicode = new BitTree(bits.length());
    String unicode = "src/brailleUnicode.txt";
    try {
      InputStream unicode_file = new FileInputStream(unicode);
      tree_unicode.load(unicode_file);
    } catch (NumberFormatException | IOException e) {
      System.err.println("Braille to unicode file not found");
    }//try

    return tree_unicode.get(bits);
  }//toUnicode

}//BrailleASCIITables