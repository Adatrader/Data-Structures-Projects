/****************************************************************
 *      file: ArrayStack.java
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

import java.util.Arrays;


public class ArrayStack<T> implements StackADT<T> {

    private T[] stack; //container for the data
    private int top; //indicates the next open slot
    private final int DEFAULT_CAPACITY=50;

    
    //Constructors
    
    //Empty stack using 100 capacity
    public ArrayStack(){
        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    
    //Empty stack using specified capacity
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }
    
    //Methods
    
    // Method: push
    // Purpose: Adds an element to the top of stack.
    // @return    
    @Override
    public void push(T element) {
        if (top ==stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    // Method: pop
    // Purpose: Removes the top element from stack
    // @return the top element from the stack.
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    // Method: front
    // Purpose: Returns without removing top element from stack.
    // @return the top element in stack.    
    @Override
    public T front() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        else
            return stack[top];
    }

    // Method: peek
    // Purpose: Returns without removing next element after top from stack.
    // @return the next element after top in stack.        
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        else
            return stack[top+1];
    }

    // Method: isEmpty
    // Purpose: Returns if stack is empty or not.
    // @return true if stack is empty.  
    @Override
    public boolean isEmpty() {
        return (top ==0);
    }

    // Method: size
    // Purpose: Get current number of elements in the stack.
    // @return the number of elements currently in stack.    
    @Override
    public int size() {
        return top;
    }

    // Method: toString
    // Purpose: Returns a string of the elements in stack.
    // @return elements in string format of the stack.        
    @Override
    public String toString( ) { 
        String result = "";
        for (int index = 1; index < top; index++){
          
            result = result + stack[index-1].toString() +", ";
          if(index % 20 == 0){
              result = result + "\n";
          }
        }
            result = result + stack[top-1].toString() + ".\n";
        
        return result;
    }
    // Method: sort
    // Purpose: Sorts the stack using the array sort method.
    // @return     
    @Override
    public void sort(){
        Arrays.sort(stack);
    }
    
    // Method: expandCapacity
    // Purpose: Helper method to double the capacity of the array if array is full
    // @return     
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[stack.length*2]);
        
        for(int index=0; index <stack.length; index++)
            larger[index] = stack[index];
        
        stack = larger;
    }
    
    // Method: print
    // Purpose: Unused in this class
    @Override
    public String print() {
        throw new UnsupportedOperationException("Not used in this class.");
    }
 
}
