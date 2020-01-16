/****************************************************************
 *      file: QueueADT.java
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


public interface QueueADT<T> {

    // Method: enqueue
    // Purpose: Adds an element to the rear of the queue.
    //@return
    public void enqueue (T element);
    
    // Method: dequeue
    // Purpose: Removes and returns element at the front of the queue.
    // @return the element at the front of the queue
    public T dequeue( ) throws EmptyCollectionException;
    
    // Method: front
    // Purpose: Returns element at the front of the queue without removing it.
    // @return
    public T front( ) throws EmptyCollectionException;
    
    // Method: isEmpty
    // Purpose: Returns boolean as true if queue doesn't contain elements.
    // @return
    public boolean isEmpty( );
    
    // Method: peek
    // Purpose: Returns element at the behind front of the queue without removing it.
    // @return
    public T peek( ) throws EmptyCollectionException;
   
    // Method: size
    // Purpose: Returns number of elements in the queue.
    // @return number of elements in queue
    public int size( );
    
    // Method: toString
    // Purpose: Returns the queue in string representation.
    // @return string of queue
    public String toString( );
    
    // Method: sort
    // Purpose: Sorts the queue in respective methods.
    // @return     
    public void sort();


}
