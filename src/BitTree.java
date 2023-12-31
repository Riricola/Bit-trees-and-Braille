
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Implements a BitTree where 0's indicate travsering to the left node and 1's indicate
 * traversing to the right. Only the node at the end of each branch contains a value.
 *
 * @author Maria Rodriguez
 * CSC207
 * November 16, 2023
 * 
 * AWcknowledgements: the dump() method was taken from class 31 lab "Binary search trees"
 */
public class BitTree {
    
/*---------------------------
 * Fields |
 * --------------------------
 */

  //the size of the tree (dependant on the length of the string of bits)
  int size;

  //creates the starter root
  BitTreeNode root;

  //the node we use to traverse the tree
  BitTreeNode current;


 /*--------------------------
  * Constructor
  --------------------------
  */

  //Creates a BitTree if size n
  BitTree(int n){
    //store mappinhgs of strings of n bits to strings
    size = n;
    root = new BitTreeNode();
    current = root;
  }//BitTree

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
    
    //sets current to the start of the tree
    current = root;

    for(int i = 0; i < (bits.length()); i++){
      //if 0, move to the left
      if(bits.charAt(i) == '0'){

        //if the left is empty, create a new node
        if(current.left == null){
          current.left = new BitTreeNode();
        }//if

        //move to the left
        current = current.left;

      } else if(bits.charAt(i) == '1'){
        //if 1, move to the right, make a new node if it's empty
        if(current.right == null){
          current.right = new BitTreeNode();
        }//if
        current = current.right;
      } else {
        System.err.println("Invalid input, only 0's or 1's allowed");
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

    current = root;

    //if 0, move left, if 1 move right
    for(int i = 0; i < (bits.length()); i++){
      if(bits.charAt(i) == '0'){
        current = current.left;
      } else if(bits.charAt(i) == '1'){
        current = current.right;
      } else {
        System.err.println("invalid input, must be 0's or 1's");
      }//if
    }//for

    //return value
    return current.val;

  }//get

  /*
   * dump(PrintWriter pen, Node node, String indent)
   * recursively prints out the contents of the tree in CVS format
   */
  void dump(PrintWriter pen, BitTreeNode node, String indent) {

    //if both left and right have nodes, rcursively call dump on both sides
    if((node.left != null) && (node.right != null)){
      dump(pen, node.left, indent + "0");
      dump(pen, node.right, indent + "1");
    } else if(node.left != null){ //if the left is empty, call dump on the right
      dump(pen, node.left, indent + "0");
    } else if(node.right != null){ //if the right is empty, call dump on the left
      dump(pen, node.right, indent + "1");
    }//if

    //once we reach the end on the branch, return the bits and the value
    if((node.left == null) && (node.right == null)){
      pen.println(indent + "," + node.val);
    }
  } // dump

  /*
   * dump(PrintWriter pen)
   * 
   * calls the recursive dump()
   */
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
        }//try
      } else {
        System.out.println("Invalid line format: " + line);
      }//if
    }//while
  }//load

/*---------------------------
 * Inner class
 * --------------------------
 */

  class BitTreeNode{
    /*---------------
     * Fields|
     * --------------
     */

    //holds the value at the end of the branch
    String val;

    //left node
    BitTreeNode left;

    //right node
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


}//BitTree