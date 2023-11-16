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


 /*--------------------------
  * Constructor
  --------------------------
  */

  BitTree(int n){
    //store mappinhgs of strings of n bits to strings

  }



/*------------------------
* methods
* -------------------------
*/

/*
 * set()
 * follows the path through the tree given by bits, returning the value at the end
 * 
 * Exception thrown if bits is inappropriate length or contains vals other than 0 or 1
 */
  public set(String bits, String value){
    //check is bits is right length
    //

    for(int i = 0; i < bits.length(); i++){
        if(bits.charAt(i) == 0){
            //move left
        } else if(bits.charAt(i) == 1){
            //move right
        } else{
            //throw an exception
        }
    }

    //set end value to value
  }//set

  /*
   * get()
   * follows the path given by bits, returning the value at the end
   */
  public String get(String bits){
    //check is bits is right length
    //

    for(int i = 0; i < bits.length(); i++){
        if(bits.charAt(i) == 0){
            //move left
        } else if(bits.charAt(i) == 1){
            //move right
        } else{
            //throw an exception
        }
    }

    return endVal;
  }//get

  /*
   * dump()
   * prints out the contents of the tree in CVS format
   */
  public void dump(PrintWriter pen){
    
  }//dump

  /*
   * load()
   * reads a series of lines of the form 'bits,value' and stores them in the tree
   */
  public void load(InputStream source){

  }//load

/*---------------------------
 * Inner class
 * --------------------------
 */

  public class BitTreeNode{

    String node;

    
  }//bitTreeNode

}