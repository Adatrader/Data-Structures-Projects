/****************************************************************
 *      file: EmptyCollectionException.java
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


public class EmptyCollectionException extends Exception {
    
    //Pass String from respective class and print out exception.
    public EmptyCollectionException(String type) {
        super( type + " is empty.");
    }
    
}
