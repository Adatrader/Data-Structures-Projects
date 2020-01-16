/****************************************************************
 *      file: BinarySearchTree.java
 *      author: Adam VanRiper, Anthony Sepulveda, Ashley Kang
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 6
 *      date last modified: 12/03/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree &
 *      Red Black Tree. Manipulate the BST and RBTree using various methods.
 ****************************************************************/
public class Node
{


    //Declarations
    Node left, right, parent;
    int value;
    int color; // 1 = Red, 0 = Black


    //Constructors
    public Node(){

    }
    public Node(int element){
        value = element;
        left = right = null;
    }

    //Methods
    /**
     Method: getvalue
     Purpose: Gets the value from respective node.
     @return value from node */
    public int getvalue(){
        return value;
    }

    /**
     Method: getLeftChild
     Purpose: Gets the left child from respective node.
     @return left child from node */
    public Node getLeftChild(){
        return left;
    }

    /**
     Method: getRightChild
     Purpose: Gets the right child from respective node.
     @return Right child from node */
    public Node getRightChild(){
        return right;
    }

    /**
     Method: setInfo
     Purpose: Sets the value for respective node.
     */
    public void setNode(int value) {
        this.value = value;
    }

    /**
     Method: setLeft
     Purpose: Sets the left node.
     */
    public void setLeft (Node n) {
        left = n;
    }
    /**
     Method: setRight
     Purpose: Sets the right node.
     */
    public void setRight (Node n) {
        right = n;
    }

}

