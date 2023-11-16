import java.io.InputStream;
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

    //traverse brings us to the length-1 node 
    traverse(bits);

    //set end value to value
    // if(bits.charAt(size-1) == 0){
      
    //   current.left.val = value;
    // }else if(bits.charAt(size-1) == 1){
    //   current.right.val = value;
    // }//if

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

    //traverses through the tree following the path in bits, stopping at the size-1 value
    traverse(bits);

    //if 0, get the left value, if 1 get the right value
    // if(bits.charAt(size-1) == '0'){
    //   current = current.left;
    // }else if(bits.charAt(size-1) == '1'){
    //   current = current.right;
    // }//if

    //return value
    return current.val;

  }//get

  /*
   * dump()
   * prints out the contents of the tree in CVS format
   */
  public void dump(PrintWriter pen){
    String path = "";
    current = root;
    for(int i = 0; i < size; i++){
      if(current.left == null){
      current = current.right;
      path = path + "1";
    }else if(current.right == null){
      current = current.left;
      path = path + "0";
    }
    }
    pen.println(path);
  }//dump

  /*
   * load()
   * reads a series of lines of the form 'bits,value' and stores them in the tree
   */
  public void load(InputStream source){

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