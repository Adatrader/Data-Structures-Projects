/****************************************************************
 *      file: BagInterface.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 1
 *      date last modified: 9/14/19
 *
 *      purpose: This program shows how to implement a Bag interface
 *      and how to manipulate the ArrayList using various methods.
 * 
 * @param <T>
 ****************************************************************/
package bag;

public interface BagInterface<T> {
    //Omitted 'public' from methods, redundant in interface

    // Method: getCurrentSize
    // Purpose: Get current number of entries in the bag.
    // @return the integer number of entries currently in bag.

    int getCurrentSize();

    // Method: isEmpty
    // Purpose: Checks if bag is empty.
    // @return true if bag is empty, false if not

    boolean isEmpty();

    // Method: add
    // Purpose: Adds a new entry to bag.
    // @param newEntry to be added as new entry.
    // @return true if addition is successful, false if not.

    boolean add(T newEntry);

    // Method: remove
    // Purpose: Removes one unspecified entry from the bag, if possible.
    // @return Removed entry and if the removal was successful or null.

    T remove();

    // Method: remove(T anEntry);
    // Purpose: Remove a specific entry from the bag.
    // @param anEntry -User specifies which entry
    // @return true if the entry was removed successfully, or false if not.

    boolean remove(T anEntry);

    // Method: clear
    // Purpose: Remove every entry from the bag.

    void clear();

    // Method: getFrequency
    // Purpose: Count number of times a specific entry appears in the bag.
    // @param anEntry -User specifies entry
    // @return Number of time anEntry appears

    int getFrequency(T anEntry);

    // Method: contains
    // Purpose: Test if bag contains given entry.
    // @param anEntry -Entry to target
    // @return True if bag contains anEntry, or false if it doesn't

    boolean contains(T anEntry);

    // Method: toArray
    // Purpose: Retrieves every entry in the bag.
    // @return Newly allocated array with all entries in the bag.
    // Or empty array if bag empty.
    
    T[] toArray();

}
