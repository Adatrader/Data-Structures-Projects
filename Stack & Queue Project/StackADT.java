/****************************************************************
 *      file: StackADT.java
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

public interface StackADT<T> {

    // Method: push
    // Purpose: Adds an element to the top of stack.
    // @return 
    public void push (T element);

    // Method: pop
    // Purpose: Removes the top element from stack
    // @return the top element from the stack.
    public T pop( ) throws EmptyCollectionException;

    // Method: peek
    // Purpose: Returns without removing second to top element from stack.
    // @return the next element after top in stack.
    public T peek( ) throws EmptyCollectionException;

    // Method: front
    // Purpose: Returns without removing top element from stack.
    // @return the top element in stack.
    public T front( ) throws EmptyCollectionException;

    // Method: isEmpty
    // Purpose: Returns if stack is empty or not.
    // @return true if stack is empty.
    public boolean isEmpty( );

    // Method: size
    // Purpose: Get current number of elements in the stack.
    // @return the number of elements currently in stack.
    public int size( );

    // Method: toString
    // Purpose: Returns a string of the elements in stack.
    // @return elements in string format of the stack.
    public String toString( );

    // Method: print
    // Purpose: Returns a string of the unsorted elements in stack.
    // @return elements in string format of the stack.
    public String print( );

    // Method: sort
    // Purpose: Sorts the stack in respective methods.
    // @return 
    public void sort();
}
