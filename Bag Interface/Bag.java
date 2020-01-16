/****************************************************************
 *      file: Bag.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 1
 *      date last modified: 9/14/19
 *
 *      purpose: This program shows how to implement a Bag interface
 *      and how to manipulate the ArrayList using various methods.
 ****************************************************************/

package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;
import java.util.InputMismatchException;

public class Bag<T> implements BagInterface<T> {

    ArrayList<T> bagImplemented = new ArrayList<>();

    // Method: getCurrentSize
    // Purpose: Get current number of entries in the bag.
    // @return the integer number of entries currently in bag.
    
    @Override
    public int getCurrentSize(){
     int sizeOfBag = bagImplemented.size();
     return sizeOfBag;
}
    
    // Method: isEmpty
    // Purpose: Checks if bag is empty.
    // @return true if bag is empty, false if not

    @Override
    public boolean isEmpty(){
      
        return bagImplemented.isEmpty();
    }

    // Method: add
    // Purpose: Adds a new entry to bag.
    // @param newEntry to be added as new entry.
    // @return true if addition is successful, false if not.

    @Override
    public boolean add(T newEntry) {
       int numberOfEntries = bagImplemented.size();
        int currentHeight = numberOfEntries-1;
        bagImplemented.add(newEntry);
        int newHeight = numberOfEntries-1;
        return newHeight > currentHeight;
    }

    // Method: remove
    // Purpose: Removes one unspecified entry from the bag, if possible.
    // @return Removed entry and if the removal was successful or null.
    //Note: Used random number generation to select index value.

    @Override
    public T remove(){
        Random Limit = new Random();
        int randomNum = Limit.nextInt(bagImplemented.size());
        T deletedEntry = bagImplemented.get(randomNum);
        bagImplemented.remove(randomNum);    
        return deletedEntry ;
    }
    
    // Method: remove(T anEntry);
    // Purpose: Remove a specific entry from the bag.
    // @param anEntry -User specifies which entry
    // @return true if the entry was removed successfully, or false if not.
    // Note: Uses Integer wrapper class to convert generic data type to int
    // This allows entering value to find index location to remove.

    @Override
    public boolean remove(T anEntry){
        int entry = (Integer) anEntry;
        T entryToBeRemoved = bagImplemented.get(entry);
       return bagImplemented.remove(entryToBeRemoved);
    }

    // Method: clear
    // Purpose: Remove every entry from the bag.

    @Override
    public void clear(){
        bagImplemented.removeAll(bagImplemented);
    }

    // Method: getFrequency
    // Purpose: Count number of times a specific entry appears in the bag.
    // @param anEntry -User specifies entry
    // @return Number of time anEntry appears

    @Override
    public int getFrequency(T anEntry){
        int frequencyOfEntry = Collections.frequency(bagImplemented, anEntry);
        return frequencyOfEntry;
    }

    // Method: contains
    // Purpose: Test if bag contains given entry.
    // @param anEntry -Entry to target
    // @return True if bag contains anEntry, or false if it doesn't

    @Override
    public boolean contains(T anEntry){
        return bagImplemented.indexOf(anEntry) >= 0;
        }
    // Method: toArray
    // Purpose: Retrieves every entry in the bag.
    // @return Newly allocated array with all entries in the bag.
    // Or empty array if bag empty.

    @Override
    public T[] toArray(){
       Integer copyList[] = new Integer[bagImplemented.size()];
       copyList = bagImplemented.toArray(copyList);
       System.out.println(Arrays.toString(copyList));
        return null;
    }

    public static void main(String[] args) {
    // Driver program to display menu choices
        BagInterface<Integer> bag = new Bag<>();
        Scanner scrn = new Scanner(System.in);
    //Added a loop to repeat menu once current switch statement is completed.    
        boolean startLoop = true;
        while(startLoop){
        System.out.println("\n--------------------\n" + "Get Current Size (1) \nCheck If Empty (2) \nAdd New Entry (3)" + "\nRemove One Unspecified Entry (4)" +
                "\nRemove Specific Entry (5) \nRemove All Entries (6) \nCheck Number of Times Entry Appears (7) \nCheck If Bag " +
                "Contains Specified Entry (8)\nPrint Bag Contents (9)\n--------------------\n(Any other number to quit) \nPlease choose the method's corresponding number");
        System.out.print("you would like to use: \n");
        int input = scrn.nextInt();
        switch (input) {
            case 1:
                int size = bag.getCurrentSize();
                System.out.println("\nCurrent Size of Bag: " + size + "." );
                break;
                
            case 2:
                if(bag.isEmpty() == true){
                System.out.println("\nBag is empty." );
                }
                else
                System.out.println("\nBag is not empty." );
                break;
    //Added a try-catch statement to confirm values entered are integers and 
    //wont crash program with InputMismatchException
            case 3:  
                try{
                System.out.println("Enter Integer value to add to Bag: ");
                int newEntry = scrn.nextInt();
                bag.add(newEntry);
                    System.out.println(newEntry + " was succesfully added to the Bag.");
                }
                catch(InputMismatchException e){
                    System.out.println("\nNot an integer, please start over. ");
                    scrn.nextLine();
                }
                break;
            case 4:
                  int entryRemoved = bag.remove();
                  String entRem = String.valueOf(entryRemoved);
                    if(entRem != null){
                        System.out.println("Value " + entryRemoved + " was removed successfully.");
                    }
                    else
                System.out.println("Nothing was removed. Unsuccessful Operation.");
                break;
                
            case 5:
                System.out.println("Enter index location of entry to be removed: ");
                int indexToBeRemoved = scrn.nextInt();
                if (bag.remove(indexToBeRemoved) == true) {
                    System.out.println("\nValue at index " + indexToBeRemoved + " was removed successfully.");
                }      
                else{
                    System.out.println("\nDid not remove, try again.");
                }
                break;
                
            case 6:
                bag.clear();
                System.out.println("\nBag is emptied.");
                break;
                
            case 7: 
                System.out.println("Enter desired value to check the frequency in Bag: ");
                int checkInt = scrn.nextInt();
                System.out.println("\nNumber " + checkInt + " was present " + bag.getFrequency(checkInt) + 
                        " time(s) in the Bag.");
                break;
                
            case 8:
                System.out.println("Enter desired value to check if Bag contains it: ");
                int containsInt = scrn.nextInt();
                if(bag.contains(containsInt) == true){
                    System.out.println("\nThe Bag contains " + containsInt + ".");
                }
                else{
                    System.out.println("\nThe Bag doesn't contain " + containsInt + ".");
                }
                break;
            case 9:
                System.out.println("\nThe Bag contains these values: ");
                bag.toArray();
                break;
            default:
                System.out.println("\nShutting down..");
            //Netbeans suggested try catch statement to catch errors when I added 2 second delay while quitting.
        {
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.exit(0);
                break;
        }
        }
    }

}
