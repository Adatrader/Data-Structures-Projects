/****************************************************************
 *      file: BinaryNode.java
 *      author: Adam VanRiper, Anthony Sepulveda, Ashley Kang
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 6
 *      date last modified: 12/03/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree &
 *      Red Black Tree. Manipulate the BST and RBTree using various methods.
 ****************************************************************/
public class BinaryNode
{


    //Declarations
    BinaryNode left, right, parent;
    int value;
    int color;
    // color -> 1 = Red
    // color -> 0 = Black


    //Constructors
    public BinaryNode(){

    }
    public BinaryNode(int element){
        value = element;
        left = right = null;
    }

    //Methods
    /**
     Method: getvalue
     Purpose: Gets the value from respective BinaryNode.
     @return value from BinaryNode */
    public int getvalue(){
        return value;
    }

    /**
     Method: getLeftChild
     Purpose: Gets the left child from respective BinaryNode.
     @return left child from BinaryNode */
    public BinaryNode getLeftChild(){
        return left;
    }

    /**
     Method: getRightChild
     Purpose: Gets the right child from respective BinaryNode.
     @return Right child from BinaryNode */
    public BinaryNode getRightChild(){
        return right;
    }

    /**
     Method: setInfo
     Purpose: Sets the value for respective BinaryNode.
     */
    public void setBinaryNode(int value) {
        this.value = value;
    }

    /**
     Method: setLeft
     Purpose: Sets the left BinaryNode.
     */
    public void setLeft (BinaryNode n) {
        left = n;
    }
    /**
     Method: setRight
     Purpose: Sets the right BinaryNode.
     */
    public void setRight (BinaryNode n) {
        right = n;
    }

}
