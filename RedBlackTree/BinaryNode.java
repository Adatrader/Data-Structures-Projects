/****************************************************************
 *      file: BinaryNode.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 4
 *      date last modified: 11/11/19
 *
 *      purpose: This program shows how to implement a Binary Search Tree
 *      and how to manipulate the Binary Search Tree using various methods.
 ****************************************************************/

public class BinaryNode<T> {

    //Declarations
    BinaryNode<T> left, right;
    T data;

    //Constructors
    public BinaryNode(){
        data = null;
    }
    public BinaryNode(T element){
        data = element;
        left = right = null;
    }

    //Methods
    /**
     Method: getData
     Purpose: Gets the data from respective node.
     @return data from node */
    public T getData(){
        return data;
    }

    /**
     Method: getLeftChild
     Purpose: Gets the left child from respective node.
     @return left child from node */
    public BinaryNode<T> getLeftChild(){
        return left;
    }

    /**
     Method: getRightChild
     Purpose: Gets the right child from respective node.
     @return Right child from node */
    public BinaryNode<T> getRightChild(){
        return right;
    }

    /**
     Method: setInfo
     Purpose: Sets the data for respective node.
     */
    public void setInfo(T data) {
        this.data = data;
    }

    /**
     Method: setLeft
     Purpose: Sets the left node.
     */
    public void setLeft (BinaryNode<T> n) {
        left = n;
    }
    /**
     Method: setRight
     Purpose: Sets the right node.
     */
    public void setRight (BinaryNode<T> n) {
        right = n;
    }

}
