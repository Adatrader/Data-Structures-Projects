/****************************************************************
 *      file: MaxHeap.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 5
 *      date last modified: 11/27/19
 *
 *      purpose: This program shows how to implement a MaxHeap
 *      using two different sorting methods.
 ****************************************************************/

import java.util.*;

public class MaxHeap {
    private int heapSize;
    private int[] heapArray;
    public double swaps = 0;

    //Constructor
    public MaxHeap(int size) {
        heapSize = 0;
        heapArray = new int[size];

    }
    public MaxHeap(int[] temp){
        heapSize = temp.length;
        heapArray = temp;
    }


    //Methods

    // Method: isEmpty
    // Purpose: Checks if heap is empty.
    public boolean isEmpty(){
        return heapSize==0;
    }

    // Method: swap
    // Purpose: Swap values between two indexes.
    public void swap(int first, int second) {
        int element = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = element;
    }

    // Method: insert
    // Purpose: Inserts value in heap, used with the sequential method.
    public void insert(int passed){
        heapArray[heapSize+1] = passed;
        heapSize++;
        int current = heapSize;
        while(heapArray[current] > heapArray[getPIndex(current)])
        {
            swap(current, getPIndex(current));
            swaps++;
            current = getPIndex(current);
        }
    }


    // Method: removeTen
    // Purpose: Removes ten values in max heap using loop of deleteRoot method.
    public void removeTen(){
        //Loop removing max 10 times using deleteRoot method
        for(int i=0; i<10; i++) {
            deleteRoot(heapArray, heapSize);
        }
    }

    // Method: deleteRoot
    // Purpose: Removes the root element in max heap.
    public void deleteRoot(int passedArray[], int length)
    {
        int finalValue = passedArray[length - 1];
        passedArray[0] = finalValue;
        heapSize--;
        heapify(passedArray, length, 0);
    }

    // Method: optimalSort
    // Purpose: Sorts the max heap using heapify, only used for optimal insertion.
    public void optimalSort(){
        int n = heapArray.length;
        // Run through entire heap using Heapify method when called
        for (int i = n/2 - 1; i>= 0; i--)
        {
            heapify(heapArray, heapSize, i);
        }
    }

    // Method: heapify
    // Purpose: Rearranges the elements of an array where the left and right sub-tree of element
    // obeys heap property.
    private void heapify(int arrayPassed[], int heapLength, int count)
    {
        int max = count;
        int lC = 2*count + 1;
        int rC = 2*count + 2;
        if (lC < heapLength && arrayPassed[lC] > arrayPassed[max])
            max = lC;
        if (rC < heapLength && arrayPassed[rC] > arrayPassed[max])
            max = rC;
        if (max != count)
        {   int temp = arrayPassed[count];
            arrayPassed[count] = arrayPassed[max];
            arrayPassed[max] = temp;

        //Increase counter
            swaps++;
            heapify(arrayPassed, heapLength, max);
        }}


    // Method: clearHeap
    // Purpose: Resets heap to null to confirm before starting again.
    // Clear once round is complete.
    public void clearHeap(){
       heapArray = null;
        }

    public void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(heapArray[i] + ", ");
        }
        System.out.print(heapArray[9] +",...");

    }

    //Helper Methods
    //Booleans

    // Method: thereIsParent
    // Purpose: Check if there is a parent.
    public boolean thereIsParent(int i){
        return getPIndex(i) < heapSize;
    }

    // Method: thereIsLC
    // Purpose: Check if there is a left child.
    public boolean thereIsLC(int i){
        return getLCIndex(i) < heapSize;
    }

    // Method: thereIsRC
    // Purpose: Check if there is a right child.
    public boolean thereIsRC(int i){
        return getRCIndex(i) < heapSize;
    }

    // Method: isALeaf
    // Purpose: Check if index is a leaf.
    private boolean isALeaf(int index)
    {
        if (index >= (heapSize / 2) && index <= heapSize) {
            return true;
        }
        return false;
    }

    //Index Locations

    // Method: getPIndex
    // Purpose: Get the index of the parent.
    public int getPIndex(int cIndex){
        return cIndex/2;
    }

    // Method: getLCIndex
    // Purpose: Get the index of the left child.
    public int getLCIndex(int pIndex){
        return 2*pIndex;
    }

    // Method: getRCIndex
    // Purpose: Get the index of the right child.
    public int getRCIndex(int pIndex){
        return 2*pIndex+1;
    }

    //Elements at index

    // Method: p
    // Purpose: Get the element of parent.
    public int p(int cIndex){
        return heapArray[getPIndex(cIndex)]; }

    // Method: lc
    // Purpose: Get the element of left child.
    public int lC(int pIndex){
        return heapArray[getLCIndex(pIndex)];
    }

    // Method: rC
    // Purpose: Get the element of right child.
    public int rC(int pIndex){
        return heapArray[getRCIndex(pIndex)];
    }

}
