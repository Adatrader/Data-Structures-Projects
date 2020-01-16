/****************************************************************
 *      file: Driver.java
 *      author: Adam VanRiper
 *      class: CS 2400 - Data Structures and Algorithms
 *
 *      assignment: Program 5
 *      date last modified: 11/27/19
 *
 *      purpose: This program shows how to implement a MaxHeap
 *      using two different sorting methods.
 ****************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double swapSumSequential = 0;
        double swapSumOptimal = 0;

        //User Menu
        System.out.println("Please select how to test the program:\n(1) 20 sets of 100 randomly " +
                "generated integers\n(2) Fixed integer values 1-100\nEnter Choice: ");

        //Verify input is correct integer & not a char
        int userIn = 0;
            String temp = input.next();
        try{
            userIn = Integer.parseInt(temp);
            if(userIn != 1 && userIn != 2){
                System.out.println("\nNot an correct value, please try again: ");
                userIn = input.nextInt();
            }
        }
        catch(NumberFormatException e){
            System.out.println("\nNot an integer, please try again: ");
            userIn = input.nextInt();
        }

        //#1 User choice
        switch (userIn) {
            case 1:

                for (int i = 0; i < 20; i++) {
                    //Create random numbers and add them to arrayList
                    ArrayList<Integer> randNums = new ArrayList<>();
                    for (int f = 1; f < 101; f++) {
                        randNums.add(f);
                    }
                    Collections.shuffle(randNums);


                    //Sequential Round
                    MaxHeap optionOneSequential = new MaxHeap(101);
                    //Insert values from array list
                    optionOneSequential.insert(0);
                    for (int g = 1; g < 100; g++) {
                        optionOneSequential.insert(randNums.get(g));
                    }

                    //Sum up swaps then reset MaxHeap class swap value
                    swapSumSequential += optionOneSequential.swaps;
                    optionOneSequential.swaps = 0;
                    optionOneSequential.clearHeap();

                    //Optimal Round

                    //Convert to int array
                    int[] intNums = new int[100];
                    for (int p = 0; p < intNums.length; p++) {
                        intNums[p] = randNums.get(p);
                    }

                    MaxHeap optionOneOptimal = new MaxHeap(intNums);
                    optionOneOptimal.optimalSort();

                    //Sum up swaps then reset MaxHeap class swap value
                    swapSumOptimal += optionOneOptimal.swaps;

                    optionOneOptimal.swaps = 0;

                    //Clear values in random number array and the 2 heaps to reset for each of 20 rounds (loop back to top)
                    randNums.clear();
                    optionOneOptimal.clearHeap();
                }

                //Print out averages
                System.out.println("\nAverage swaps for series of insertions: " + swapSumSequential / 20 +
                        "\nAverage swaps for optimal method: " + swapSumOptimal / 20);
                break;
            //#2 User choice
            case 2:
                int[] oneToHundred = new int[100];
                for (int i = 1; i < 101; i++) {
                    oneToHundred[i - 1] = i;
                }

                //Sequential
                MaxHeap roundTwoSequential = new MaxHeap(101);

                roundTwoSequential.insert(0);
                for (int g = 1; g < 100; g++) {
                    roundTwoSequential.insert(oneToHundred[g]);
                }
                System.out.print("\nHeap built using series of insertions: ");
                roundTwoSequential.print();

                System.out.println("\nNumber of swaps: " + roundTwoSequential.swaps);

                System.out.print("Heap after 10 removals: ");
                roundTwoSequential.removeTen();
                roundTwoSequential.print();

                roundTwoSequential.clearHeap();
                roundTwoSequential.swaps = 0;

                //Optimal
                MaxHeap roundTwoOptimal = new MaxHeap(oneToHundred);

                roundTwoOptimal.optimalSort();
                System.out.print("\n\nHeap built using optimal method: ");
                roundTwoOptimal.print();

                System.out.println("\nNumber of swaps: " + roundTwoOptimal.swaps);
                System.out.print("Heap after 10 removals: ");
                roundTwoOptimal.removeTen();
                roundTwoOptimal.print();
                System.out.println("\n");

                break;

            default:
                System.out.println("\nNot an correct value, please start over.");
                break;

        }

    }

}
