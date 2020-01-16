/****************************************************************
 *      file: Node.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 2
 *      date last modified: 10/06/19
 *
 *      purpose: This program shows how to implement a stack and queue
 *      Also compares the time between the different data structures.
 * 
 * @param <T>
 ****************************************************************/

package stackqueueproject;

public class Node<T> {
    public T entry;
    public Node <T>nextLink;
    
    //Constructors
    public Node(){
        
    }
    public Node(T element){
    entry = element;
}
    
    //Methods
    
    // Method: getInfo
    // Purpose: Returns data in node.
    // @return node data
    public T getInfo(){
        return entry;
    }
    // Method: getNext
    // Purpose: Returns the next node in linked list.
    // @return next node
    public Node<T> getNext() {
        return nextLink;
    }
    // Method: setInfo
    // Purpose: Set the data for node.
    // @return     
    public void setInfo(T data) {
        entry = data;
    }
    // Method: setNext
    // Purpose: Sets the next node in linked list.
    // @return 
    public void setNext (Node<T> n) {
        nextLink = n;
    }
     
  
}
