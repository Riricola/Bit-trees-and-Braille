package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * <Description>
 *
 * @author Maria Rodriguez
 */
public class BitTree {
    
/*---------------------------
 * Fields |
 * --------------------------
 */

  int size;

  BitTreeNode root;

  BitTreeNode current;


 /*--------------------------
  * Constructor
  --------------------------
  */

  BitTree(int n){
    //store mappinhgs of strings of n bits to strings
    size = n;
    root = new BitTreeNode();
    current = root;
  }



/*------------------------
* methods
* -------------------------
*/

/*
 * set()
 * follows the path through the tree given by bits, returning the value at the end, adding nodes
 * as appropriate, and adds or replaces the val at the end with value
 * 
 * Exception thrown if bits is inappropriate length or contains vals other than 0 or 1
 */
  public void set(String bits, String value) throws Exception{
    //check is bits is right length or contains vals other than 0 or 1
    if(bits.length() != size){
      throw new Exception("Invalid string, please input a string of " + size + " length. \n");
    }//if
    //if(checkBits(bits) == false){
    //  throw new Exception("String bits must include 1s and 0s. \n");
    //}//if

    current = root;

    for(int i = 0; i < (bits.length()); i++){
      if(bits.charAt(i) == '0'){
        if(current.left == null){
          current.left = new BitTreeNode();
        }//if
        current = current.left;
      } else if(bits.charAt(i) == '1'){
        if(current.right == null){
          current.right = new BitTreeNode();
        }//if
        current = current.right;
      }//if
    }//for
    
    current.val = value;
   
  }//set

  /*
   * get()
   * follows the path given by bits, returning the value at the end
   */
  public String get(String bits) throws Exception{

    //check if bits is right length
    if(bits.length() != size){
      throw new Exception("Invalid string, please input a string of " + size + " length. \n");
    }//if
    //if(checkBits(bits) == false){
    //  throw new Exception("String bits must include 1s and 0s. \n");
    //}//if

    current = root;

    //if 0, get the left value, if 1 get the right value
    for(int i = 0; i < (bits.length()); i++){
      if(bits.charAt(i) == '0'){
        current = current.left;
      } else if(bits.charAt(i) == '1'){
        current = current.right;
      }//if
    }//for

    //return value
    return current.val;

  }//get

  /*
   * dump()
   * prints out the contents of the tree in CVS format
   */
  void dump(PrintWriter pen, BitTreeNode node, String indent) {

    if((node.left != null) && (node.right != null)){
      dump(pen, node.left, indent + "0");
      dump(pen, node.right, indent + "1");
    } else if(node.left != null){
      dump(pen, node.left, indent + "0");
    } else if(node.right != null){
      dump(pen, node.right, indent + "1");
    }

    if((node.left == null) && (node.right == null)){
      pen.println(indent + "," + node.val);
    }
  } // dump

  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)

  /*
   * load()
   * reads a series of lines of the form 'bits,value' and stores them in the tree
   */
  public void load(InputStream source) throws NumberFormatException, IOException{
    InputStreamReader reader = new InputStreamReader(source);
    BufferedReader bufferedReader = new BufferedReader(reader);

    String line;

    while((line = bufferedReader.readLine()) != null){
       // Split the line into bitTree path and character equivalent
       String[] parts = line.split(",");
       if (parts.length == 2) {
           String bits = parts[0];
           String value = parts[1];
           try {
            set(bits, value);
          } catch (Exception e) {
            e.printStackTrace();
          }
       } else {
           System.out.println("Invalid line format: " + line);
       }
    }
  }//load

/*------------------
 * Helper functions|
 * -----------------
 */

 /*
  * checkBits(String bits)
  checks if the string contains bits other than 0 or 1
  */
  public boolean checkBits(String bits){
    for(int i = 0; i < (bits.length()-1); i++){
      if(bits.charAt(i) != '0' || bits.charAt(i) != '1'){
        return false;
      }//if
    }//for

    return true;
  }//checkBits

  /*
   * traverse(String bits)
   */
  public void traverse(String bits){
    current = root;
    //if(checkBits(bits)){
      for(int i = 0; i < (bits.length()); i++){
        if(bits.charAt(i) == '0'){
          current.left = new BitTreeNode();
          current = current.left;
        } else if(bits.charAt(i) == '1'){
          current.right = new BitTreeNode();
          current = current.right;
        }//if
      }//for
    //}//if checkBits
  }//traverse

/*---------------------------
 * Inner class
 * --------------------------
 */

  class BitTreeNode{
    /*---------------
     * Fields|
     * --------------
     */

    String val;
    BitTreeNode left;
    BitTreeNode right;

    /*---------------
     * Constructor|
     * --------------
     */

     public BitTreeNode(){
      left = null;
      right = null;
      val = null;
     }//BitTreeNode

  }//bitTreeNode'


}