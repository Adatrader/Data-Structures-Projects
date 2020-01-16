/****************************************************************
 *      file: LinkedListQueue.java
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


public class LinkedListQueue<T> implements QueueADT<T> {
    
    private int counter;
    private Node<T> front, rear;
    
    //Constructor (creates an empty queue)
    public LinkedListQueue() {
        counter = 0;
        front = null;
        rear = null;
    }
    
    //Methods

    // Method: enqueue
    // Purpose: Adds an element to the rear of the queue.
    //@return
    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (isEmpty())
            front = newNode;
        else
            rear.setNext(newNode);
        
        rear = newNode;
        counter++;
    }
    
    // Method: dequeue
    // Purpose: Removes and returns element at the front of the queue.
    // @return the element at the front of the queue
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty( ))
            throw new EmptyCollectionException ("Queue");
         T result = front.getInfo( );
         front = front.getNext( );
            counter--;
        if (isEmpty( ))
          rear = null;
        return result;
    } 
    
    // Method: isEmpty
    // Purpose: Returns boolean as true if queue doesn't contain elements.
    // @return    
    @Override
    public boolean isEmpty() {
        return (counter == 0);
    }

    // Method: size
    // Purpose: Returns number of elements in the queue.
    // @return number of elements in queue    
    @Override
    public int size() {
        return counter;
        }

    // Method: front
    // Purpose: Returns element at the front of the queue without removing it.
    // @return    
    @Override
    public T front() throws EmptyCollectionException {
                        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        else
            return front.entry;
    }

    // Method: peek
    // Purpose: Returns element at the behind front of the queue without removing it.
    // @return    
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        else
            return front.nextLink.getInfo();    }

    // Method: sort
    // Purpose: Sorts the queue in respective methods.
    // @return 
    @Override
    public void sort() {
        //check if empty
        if (counter > 1) {
            boolean ifMoved;
        //assign active, prior, and future node while future node is empty
            do {
                Node active = front;
                Node before = null;
                Node future = front.getNext();
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
                            front = future;
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
    
    // Method: toString
    // Purpose: Returns the queue in string representation.
    // @return string of queue    
    @Override
    public String toString( ) { 
        String result = front.getInfo().toString() + "->";                    
           Node<T> tmp = front.nextLink;           
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
    
    
}
