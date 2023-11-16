import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    BitTree tester = new BitTree(6);

    tester.set("110010", "H");
    pen.println(tester.get("110010"));
    tester.dump(pen);
  }
}
