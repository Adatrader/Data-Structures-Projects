/****************************************************************
 *      file: ArrayQueue.java
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



public class ArrayQueue<T> implements QueueADT<T> {
    
    private T[] arrayQueue;
    private int frontIndex;
    private int backIndex;
    private static final int SIZE_DEFAULT = 50;
    private int currentSize;
    
    //Constructors
    
    //Empty Queue using 100 capacity
    public ArrayQueue(){
        arrayQueue = (T[]) new Object[SIZE_DEFAULT];
    }
    //Queue using specified capacity
    public ArrayQueue(int capacity) {
       T[] temp = (T[]) new Object[capacity+1];
       arrayQueue = temp;
       frontIndex = 0;
       backIndex = capacity;
    }
    //Methods
    
    // Method: enqueue
    // Purpose: Adds an element to the rear of the queue.
    //@return    
    @Override
    public void enqueue(T element) {

        if (currentSize == arrayQueue.length){
            expandCapacity();
        }
        if (arrayQueue[currentSize] == null)
        {
            arrayQueue[currentSize] = element;
            currentSize++;
        }
        else{
            for(int index = 0; index<currentSize; index++){
                if(arrayQueue[index] == null){
                    currentSize = index;
                    break;
                }
            }
        }

    }

    // Method: dequeue
    // Purpose: Removes and returns element at the front of the queue.
    // @return the element at the front of the queue    
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) 
            throw new EmptyCollectionException("Queue");
        else {
            T frontData = arrayQueue[frontIndex];
        arrayQueue[frontIndex] = null;
        for(int index = 0, next = 1; index<backIndex && next<backIndex; index++, next++){
                arrayQueue[index] = arrayQueue[next];
        }
            arrayQueue[backIndex] = null;
            currentSize--;
            return frontData;
        }
    }

    // Method: front
    // Purpose: Returns element at the front of the queue without removing it.
    // @return    
    @Override
    public T front() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");
        else
            return arrayQueue[frontIndex];    
    }
    
    // Method: peek
    // Purpose: Returns element at the behind front of the queue without removing it.
    // @return
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");
        else
            return arrayQueue[frontIndex+1]; 
    }

    // Method: isEmpty
    // Purpose: Returns boolean as true if queue doesn't contain elements.
    // @return    
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method: size
    // Purpose: Returns number of elements in the queue.
    // @return number of elements in queue    
    @Override
    public int size() {
        return currentSize;
    }
    
    // Method: sort
    // Purpose: Sorts the queue in array sort methods.
    // @return     
    @Override
    public void sort(){
        Arrays.sort(arrayQueue);

    }
            
    // Method: toString
    // Purpose: Returns the queue in string representation.
    // @return string of queue    
    @Override
    public String toString( ) { 
        String result = "";
        result = result + arrayQueue[backIndex].toString() + ", "; 
        for (int index = 1; index < 99; index++){          
            result = result + arrayQueue[index].toString() +", ";
          if(index % 20 == 0){
              result = result + "\n";
          }
        }
            result = result + arrayQueue[99] + ".\n";
        
        return result;
    }

    // Method: expandCapacity
    // Purpose: Helper method to double the capacity of the array if array is full
    // @return    
    private void expandCapacity()
    {    
        arrayQueue = Arrays.copyOf(arrayQueue, 2*arrayQueue.length);
    }
    
}
