# radixSort

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
Note: To storage and process the bucket lists, use an ArrayList structure.
(b.2) What is the running time complexity of your radixSort method? Justify.