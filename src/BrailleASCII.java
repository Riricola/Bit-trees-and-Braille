package src;

import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    BitTree tester = new BitTree(6);

    tester.set("110010", "H");
    tester.set("100000", "A");
    tester.set("010111", "W");

    pen.println(tester.get("110010"));
    pen.println(tester.get("100000"));

    
    tester.dump(pen);
  }
}
