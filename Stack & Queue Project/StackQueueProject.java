/****************************************************************
 *      file: StackQueueProject (driver program).java
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
import java.util.Random;

public class StackQueueProject {


	  // Driver Program
    public static void main(String[] args) throws EmptyCollectionException {
      
    	//Create 100 Random numbers and place in temporary array
    	Random intValues = new Random();
    	int [] arrayOfNumbers = new int[100];
    	for (int i = 0; i < arrayOfNumbers.length; i++) {
    	int intValues_current = intValues.nextInt(100000);
    	arrayOfNumbers[i] = intValues_current;
    	}

    	//Stack Array
        StackADT<Integer> sArray = new ArrayStack<>(50);
        //Start timer
    	long startArrayStack = System.nanoTime();
        //Adding Values
        for (int i = 0; i < arrayOfNumbers.length; i++) {
        sArray.push(arrayOfNumbers[i]);
        }
        //Printing Values then sort and print again
        System.out.println("Stack Array Elements:");
        System.out.println("Unsorted (Current Size: " + sArray.size() + ")\n" + sArray.toString());
        sArray.sort();
        System.out.println( "Sorted (Current Size: " + sArray.size() + ")\n" + sArray.toString());
        
        //Removing Values
        System.out.println("Pop off each value...");
        while(sArray.isEmpty() == false){
       
            sArray.pop();
        }
        System.out.println("Current Size: " + sArray.size());
        System.out.println("Removal Complete.");

        //End timer and print time in nanoseconds
        long endArrayStack = System.nanoTime();
        long totalArrayStack = (endArrayStack-startArrayStack);
        System.out.println("Time Elasped (in nanoseconds): " + totalArrayStack);
        System.out.println("---------------------------------------------");
        
        //LinkedListStack 
        StackADT <Integer> sList = new LinkedListStack <>();
        long startLinkedStack = System.nanoTime();
        //Adding Values
        for (int i = 0; i < arrayOfNumbers.length; i++) {
        int pushValue = arrayOfNumbers[i];
            sList.push(pushValue);
        }
        //Printing Values then sort and print again
        System.out.println("\nStack Linked List Elements:");
        System.out.println("Unsorted (Current Size: " + sList.size() + ")\n" + sList.print());
        sList.sort();
        System.out.print("\n");
        System.out.println( "Sorted (Current Size: " + sList.size() + ")\n" + sList.toString());
        while(sList.isEmpty() == false){
            sList.pop(); 
        }
            System.out.println("Pop off each value...");
            System.out.println("Current Size: " + sList.size());
            System.out.println("Removal Complete.");
            long endLinkedStack = System.nanoTime();
            long totalLinkedStack = (endLinkedStack - startLinkedStack);
            System.out.println("Time Elasped (in nanoseconds): " + totalLinkedStack);
            System.out.println("---------------------------------------------");
        
        //ArrayQueue
        QueueADT<Integer> aQueue = new ArrayQueue<>();
        long startArrayQueue = System.nanoTime();

        //Enqueue array values
        for (int i = 0; i < arrayOfNumbers.length; i++) {
        int queueValue = arrayOfNumbers[i];
            aQueue.enqueue(queueValue);
        }
        //Print Values then sort and print again
        System.out.println("\nQueue Array Elements:");
        System.out.println("Unsorted (Current Size: " + aQueue.size() + ")\n" + aQueue.toString());
        aQueue.sort();
        System.out.println( "Sorted (Current Size: " + aQueue.size() + ")\n" + aQueue.toString());
        
        //Removing Values
        System.out.println("Dequeue each value...");
        while(aQueue.isEmpty() == false){
       
            aQueue.dequeue();
        }
        System.out.println("Current Size: " + aQueue.size());
        System.out.println("Removal Complete.");
        long endArrayQueue = System.nanoTime();
            long totalArrayQueue = (endArrayQueue - startArrayQueue);
            System.out.println("Time Elasped (in nanoseconds): " + totalArrayQueue);
            System.out.println("---------------------------------------------");
            
        //LinkedQueue
        QueueADT<Integer> lQueue = new LinkedListQueue<>();
        long startLLQueue = System.nanoTime();    
        
        //Adding Values
        for (int i = 0; i < arrayOfNumbers.length; i++) {
        int enqueueValue = arrayOfNumbers[i];
            lQueue.enqueue(enqueueValue);
        }
        //Printing Values then sort and print again
        System.out.println("\nQueue Linked List Elements:");
        System.out.println("Unsorted (Current Size: " + lQueue.size() + ")\n" + lQueue.toString());
        lQueue.sort();
        System.out.println( "Sorted (Current Size: " + lQueue.size() + ")\n" + lQueue.toString());
        while(lQueue.isEmpty() == false){
            lQueue.dequeue(); 
        }
            System.out.println("Dequeue each value...");
            System.out.println("Current Size: " + lQueue.size());
            System.out.println("Removal Complete.");
            long endLLQueue = System.nanoTime();
            long totalLLQueue = (endLLQueue - startLLQueue);
            System.out.println("Time Elasped (in nanoseconds): " + totalLLQueue);
            System.out.println("---------------------------------------------");
        }
        

    }

   
