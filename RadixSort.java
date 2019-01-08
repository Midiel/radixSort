/*********************************************************************
Purpose/Description: This program sorts two arrays of integers using two functions:
*                   (binarySort) sort a binary array in ascending order
*                   (radixSort) sort an array of integers using Radix Sort
Author’s Panther ID: xxxxxxx
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

/*
Problem #2:
(a) Given a binary array, implement in Java an algorithm to sort it in linear running time
complexity and constant space complexity.
Example:
    Input: [1,0,1,0,0,0,1,0,1,0,0,1]
    Output: [0,0,0,0,0,0,0,1,1,1,1,1]
(b.1) Implement (in Java) the RadixSort algorithm to sort (in increasing order) an array of
nonnegative integer keys.

public void radixSort(int arr[])

In your implementation you must consider that each key contains only even digits (0, 2, 4,
6, and 8). Your program must detect the case of odd digits in the keys, and, in this case,
your program must replace each odd digit by the greater even digit that is less than the odd
digit. Examples: 3 --> 2; 9 --> 8; 1 --> 0.
Example of the output of the program:
Input array
    13, 4680, 24062, 51, 86, 642, 51, 426, 888,
After preprocessing (convert odd digits into even digits)
    2, 4680, 24062, 40, 86, 642, 40, 426, 888,
Sorted array
    2, 40, 40, 86, 426, 642, 888, 4680, 24062,
Note: To storage and process the bucket lists, use an ArrayList structure

(b.2) What is the running time complexity of your radixSort method? Justify.
*/
package problem2;

/**
 *
 * @author Midiel
 */
public class RadixSort {
    
    /** (a)
     * It sorts a binary array in ascending order.
     * 
     * @param array the binary array to sort
     */
    static void binarySort(int[] array) {
        
        int leftP = 0;                              // left pointer initialized 0
        int rightP = array.length - 1;             // right pointer initialized with last element position
        
        // until there still digits between both pointers
        while (leftP < rightP) {
            if (array[leftP] > 0) {
                // swap left and right values
                array[rightP] = array[rightP]+ array[leftP];
                array[leftP] = array[rightP]-array[leftP];
                array[rightP] = array[rightP]-array[leftP];
                rightP--;           // decrease right pointer
            } else {
                leftP++;            // else increments keft position
            }
        }
    }
     
    /** (b.1)
     * 
     * Sorts an array of integers using radix sort
     * 
     * (b.2)
     * The running time complexity is O(d(n + k)), where:
     * 'n' is the number of integers
     * 'k' the range from "0 to k"
     * 'd' maximum number of integers
     * 
     * Each counting sort takes O(n + k), and the maximum number of digits in the
     * 'n' integer is 'd', the counting sort need to be executed 'd' times. So,
     * we end up with O(d(n + k)).
     * 
     * @param array the array to be sorted
     */
    public static void radixSort(int[] array) {
        int n = array.length;                   // length of array
        int maxDigits = 0;                      // maxDigits number of digits
        
        // find the maximum number of digits
        for (int i = 0; i < n; i++) {
            if (array[i] > maxDigits) {
                maxDigits = array[i];
            }
        }
  
        // counting sorts evey elemts by digit
        for (int exp = 1; maxDigits / exp > 0; exp *= 10) {         
            
            final int TENTH = 10;               // 10th place/digit
            int[] tempArr = new int[n];         // temporary array
            int count[] = new int[TENTH];       // to hold number of digits that repeat
            int i;

            // counts the number of digits 
            for (i = 0; i < n; i++) {

                // test if all digits are even, if not then reduce the digit
                // to next lower even digit
                if(((array[i] / exp) % TENTH)% 2 != 0) {
                    array[i] = array[i] - exp;
                }
                count[(array[i] / exp) % TENTH]++;
            }
            
            // arragen the count array with actual positions of temporary array
            for (i = 1; i < TENTH; i++) {
                count[i] += count[i - 1];
            }

            // fill the temporary array
            for (i = n - 1; i >= 0; i--) {
                tempArr[count[(array[i] / exp) % TENTH] - 1] = array[i];
                count[(array[i] / exp) % TENTH]--;
            }

            // copy temporary array to orginal array with sorted digits
            for (i = 0; i < n; i++) {
                array[i] = tempArr[i];
            }
        }   
    }
 
    // prints an array
    static void print(int arr[]) {
        int n = arr.length;
        System.out.print("[" + arr[0]+", ");
        for (int i=1; i < n - 1; i++) { 
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[n-1] + "]\n");
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // to test part A
        int[] arrayA = {1,0,1,0,0,0,1,0,1,0,0,1};
        
        System.out.print("\"Part A\"\n");
        System.out.print("Original:\t ");
        print(arrayA);
        
        // sort the array using binrary sort function
        binarySort(arrayA);
        
        // print sorted array
        System.out.print("Sorted:\t\t ");
        print(arrayA);
        
        
        // to test part B
        int[] arrayB = {13, 4680, 24062, 51, 86, 642, 51, 426, 888};
        
        System.out.print("\n\"Part B\"\n");
        System.out.print("Original:\t ");
        print(arrayB);
        radixSort(arrayB);
        System.out.print("Sorted:\t\t ");
        print(arrayB);
    }   
}
