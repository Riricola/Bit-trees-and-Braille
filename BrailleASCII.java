
import java.io.PrintWriter;

/**
 * The main function that either translates from braille to ASCII, braille to unicode,
 * or ASCII to braille depending on what is in the command line
 *
 * @author Maria Rodriguez
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    String str = "";

    if(args.length != 2){
      System.err.println("Invalid input. Please input the translation and the code you want translated");
    }//if

    String translateType = args[0];
    String source = args[1];

    if(translateType.equals("braille")){
      //translate to braille from ASCII
      for(int i = 0; i < source.length(); i++){
        str = str + BrailleASCIITables.toBraille(source.charAt(i));

      }//for
      pen.println(str);
    }
    else if (translateType.equals("ascii")){
      //translate to ASCII from braille
      for(int i = 1; i <= (source.length() / 6); i++){
        str += BrailleASCIITables.toASCII(source.substring((i - 1) * 6, (i * 6)));
      }
      pen.println(str);
    } 
    else if (translateType.equals("unicode")){
      //turn from letters to bits
      for(int i = 0; i < source.length(); i++){
        str = str + BrailleASCIITables.toBraille(source.charAt(i));
      }//for
      String unicode = "";
      //from bits to unicode
      for(int i = 1; i <= (str.length() / 6); i++){
        unicode = BrailleASCIITables.toUnicode(str.substring((i - 1) * 6, (i * 6)));
        pen.print(unicode);
      }
      pen.println();
      
    }//if
    
    pen.flush();
  }//main
}//BrailleASCII
