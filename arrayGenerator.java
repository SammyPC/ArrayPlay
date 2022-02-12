/**
 * Sammy Paris Cheaton
 * CSCI 112 900 15A Spring 22
 * ---------------------------------
 * Instructions:
 * Write a program that will generate an array with 1K positions filled with random values between 1-10,
 * It should then print the original array
 * Sort the Array (bubble sort)
 * Display the sorted Array
 * Add the total of all numbers within, and then average it.
 * Print the total and average for the user, and store in a txt
 *----------------------------------
 */

import java.security.PublicKey;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class arrayGenerator {

    public static void main(String[] args){ //main
    int[] arrayCurrent = arrayGen(); //create blank and generate a filled 1k element array
    arrayPrint(arrayCurrent); //Print unsorted array
    arrayBubSort(arrayCurrent); //Sort the stored array
    arrayPrint(arrayCurrent); //Print the Sorted array
    double[] logData = arrayArit(arrayCurrent); //Create small array to transport log data,
                                                // then preforms arithmetic for sum and average
    arrayLog(logData); //Writes data sent from the arithmetic function to a file
    } // end main

    /**
     * Generates and fills the array
     * @return the array
     */
    public static int[] arrayGen() {
        Random random = new Random(); //init Random
        int[] origArray = new int[999]; //init 1k slot array
        for (int i = 0; i < 999; i++) { //used magic number instead of .length when writing loop
            origArray[i] = random.nextInt(10) + 1; //Set limit on range for each value 1-10
        } //end FOR
        return origArray;
    } //end arrayGen()

    /**
     * sorts the array into ascending order "in place"
     * @param a the reference to the array to be sorted
     * @return the sorted array
     */
    public static int[] arrayBubSort(int[] a) {
        boolean swappa; // Set flag for if a switch occurred
        int c; // Init an extra space to store data while swapping positions
        do {
            swappa = false;
            for (int i = 0; i < (999 - 1); i++) { //used magic number instead of .length when writing the loop
                // Sorting code
                if (a[i + 1] < a[i]) {
                    c = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = c;
                    swappa = true;
                }
            }
        }  while (swappa);
        return a; //return sorted array
    } // end arrayBubSort

    /**
     * Prints the Array to the screen, uses a new line every 10 characters
     * @param a the array
     */
    public static void arrayPrint(int[] a) {
        int lnCount = 1;
        System.out.print("\n1. (" + a[0]);
        for (int i = 0; i < 999; i++) { //used magic number instead of .length
            // Carriage return every 10 numbers
            System.out.print(", ");
            if (((i + 1) % 10) == 0) { // triggers every 10 numbers displayed
                lnCount++;
                System.out.print(")\n" + lnCount + ": ("); // new line break and formatting for line count
            }
            System.out.print(a[i]);
        }
        System.out.println(")"); // insert closing parenthesis at the end of each line
    } // end arrayPrint

    /**
     * Preforms Sum and Average calculations, print results to screen, and then return the calculated values
     * @param a int array
     * @return  array containing sum and average data
     */
    public static double[] arrayArit(int[] a) {
        double[] ResLog = new double[2]; //Array to store sum and average
        int count = 0; // accumulator for sum
        for (int i = 0; i < 999; i++) { //used magic number instead of .length when writing loop
            count += a[i]; // Adds each value to the accumulator
        }
        double avg = count / 999; // Averaging division, used number instead of .length here as well
        // Print to screen Data about the Array
        System.out.println("The total sum the elements in the Array is: " + count);
        System.out.println("\n The average for all of the array elements is: " + avg);
        ResLog[0] = count; //Insert sum into transport array
        ResLog[1] = avg; //insert avg into transport array
        return ResLog; // send out the transport array
    } // end resLog

    /**
     * Create, write to, and save log file txt of results from sum and average data
     * @param a array containing sum and average data
     */
    public static void arrayLog(double[] a){
        //Creates and saves logfiles
    try { // attempts to create a log file
        File aLog = new File("SPC_ArrayLog.txt");
        if (aLog.createNewFile()) {
            System.out.println("File created: " + aLog.getName()); //success message after making new file
            try {
                FileWriter myScribe = new FileWriter("SPC_ArrayLog.txt"); //Generate new file with this name
                // First-line message for text log
                myScribe.write("Sammy Paris Cheaton\n" +
                                   "This file stores the results of arithmetic preformed on the generated arrays.");
                myScribe.write("Sum: " + a[0] + " Average: " + a[1]); // Data Write
                myScribe.close();
                System.out.println("Logging successful!"); // Print to screen if successful!
            } catch (IOException e) { // Catches error if it cannot write to log file
                System.out.println("Could not write results to the log");
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists. Updating values."); //If there is already a file this portion procs
            // This block will attempt to write new records into an existing file
            try {
                FileWriter myScribe = new FileWriter("SPC_ArrayLog.txt", true);
                myScribe.write("\nSum: " + a[0] + " Average: " + a[1]);
                myScribe.close();
                System.out.println("Logging successful!");
            } catch (IOException e) {
                System.out.println("Could not write results to the log");
                e.printStackTrace();
            }
        }
    } catch (IOException e) { // Catches Error if cannot CREATE log file
        System.out.println("Could not create log file");
        e.printStackTrace();
    }
    } // end arrayLog
} //End arrayGenerator






