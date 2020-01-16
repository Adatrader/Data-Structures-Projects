/****************************************************************
 *      file: LinkedListStack.java
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

public class LinkedListStack<T> implements StackADT<T> {
        private Node<T> nodeTop;
        private int counter;

        //Constructor
    public LinkedListStack(){
        nodeTop = null;
        counter = 0;
    }
    
        //Methods
    
    // Method: push
    // Purpose: Adds an element to the top of stack.
    // @return 
    @Override
    public void push(T newElement) {

        Node<T> oldTop = nodeTop;
        nodeTop = new Node();
        nodeTop.entry = newElement;
        nodeTop.nextLink = oldTop;
        counter++;        
    }
    
    // Method: pop
    // Purpose: Removes the top element from stack
    // @return the top element from the stack.
    @Override
    public T pop() throws EmptyCollectionException {
       T entry = nodeTop.entry;
       nodeTop = nodeTop.getNext();
       counter--;
       return entry;
    }
    
    // Method: front
    // Purpose: Returns without removing top element from stack.
    // @return the top element in stack.
    @Override
    public T front() throws EmptyCollectionException {
                if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        else
            return nodeTop.entry;
    }

    // Method: peek
    // Purpose: Returns without removing next element after top from stack.
    // @return the next element after top in stack.    
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        else
            return nodeTop.getNext().getInfo();
    }

    // Method: isEmpty
    // Purpose: Returns if stack is empty or not.
    // @return true if stack is empty.    
    @Override
    public boolean isEmpty() {
        return (counter == 0);
    }

    // Method: size
    // Purpose: Get current number of elements in the stack.
    // @return the number of elements currently in stack.
    @Override
    public int size() {
        return counter;
    }

    // Method: toString
    // Purpose: Returns a string of the elements in stack.
    // @return elements in string format of the stack.    
    @Override
    public String toString( ) { 
        String result = nodeTop.getInfo().toString() + "->";                    
           Node<T> tmp = nodeTop.nextLink;           
           int count = 1;    
           while (tmp != null){
               
               result = result + tmp.getInfo().toString() + "->";
               count++;
               if(count % 20 == 0){
                   result = result + "\n";
               }
               tmp = tmp.getNext(); 
          
           }
            return result;
    }

    // Method: print
    // Purpose: Returns a string of the unsorted elements in stack.
    // @return elements in string format of the stack.    
    @Override
    public String print( ) { 
        String result = nodeTop.getInfo().toString() + "->";                    
           Node<T> tmp = nodeTop.nextLink;           
           int count = 1;    
           while (tmp != null){
               
               result = tmp.getInfo().toString() + "->" +result ;
               count++;
               if(count % 20 == 0){
                   result =  "\n" +result;
               }
               tmp = tmp.getNext(); 
          
           }
            return result;
    }

    // Method: sort
    // Purpose: Sorts the stack using the bubble sort method.
    // @return     
    @Override
    public void sort() {
        //check if empty
        if (counter > 1) {
            boolean ifMoved;
        //assign active, prior, and future node while future node is empty
            do {
                Node active = nodeTop;
                Node before = null;
                Node future = nodeTop.getNext();
                ifMoved = false;

                while ( future != null ) {
                //Convert objects to integers to compare values
                    int i = (int) active.entry;
                    int j = (int) future.entry;
                if (i > j) {
                    //swap pointers and data
                        ifMoved = true;
                        if ( before != null ) {
                            Node tmp = future.getNext();
                            before.nextLink = future;
                            future.nextLink = active;                            
                            active.nextLink = tmp;
                   
                        } else {
                            Node tmp = future.nextLink;
                            nodeTop = future;
                            future.nextLink = active;
                            future.nextLink = tmp;
                        }
                        before = future;
                        future = active.nextLink;
                } else { 
                    before = active;
                    active = future;
                    future = future.nextLink;                 
                    }
                } 
            } while( ifMoved );
        }
    }
    
}
