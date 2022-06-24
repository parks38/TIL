## minSwqp 
---
+++ arr, temp, left, mid: 0
+++ arr, temp, mid + 1, right: 0

###########
merge method count :0
merge method i : 0 j : 1 k : 0
---------
while loop i-mid : 0 0
while loop j-right : 1 1
temp[] = [4, 0, 0, 0]
count: 1

-------
i < mid - 1
temp[] = [4, 5, 0, 0]
-------
j <= right
temp[] = [4, 5, 0, 0]
-------
count !!!1
+++ arr, temp, left, mid+1, right: 1
+++ arr, temp, left, mid: 1
+++ arr, temp, left, mid: 0
+++ arr, temp, mid + 1, right: 0

###########
merge method count :0
merge method i : 2 j : 3 k : 2
---------
while loop i-mid : 2 2
while loop j-right : 3 3
temp[] = [4, 5, 1, 0]
count: 0

-------
i < mid - 1
temp[] = [4, 5, 1, 0]
-------
j <= right
temp[] = [4, 5, 1, 2]
-------
count !!!0
+++ arr, temp, left, mid+1, right: 0
+++ arr, temp, mid + 1, right: 1

###########
merge method count :0
merge method i : 0 j : 2 k : 0
---------
while loop i-mid : 0 1
while loop j-right : 2 3
temp[] = [1, 5, 1, 2]
count: 2

while loop i-mid : 0 1
while loop j-right : 3 3
temp[] = [1, 2, 1, 2]
count: 4

-------
i < mid - 1
temp[] = [1, 2, 5, 4]
-------
j <= right
temp[] = [1, 2, 5, 4]
-------
count !!!4
+++ arr, temp, left, mid+1, right: 5
Number of swaps is 5

```
// Java program to count number of
// swaps required to sort an array
// when only swapping of adjacent
// elements is allowed.

import java.io.*;
import java.util.Arrays;

public class test1 {

        static int merge(int arr[], int temp[],
                         int left, int mid, int right) {
            System.out.println();
            System.out.println("###########");
            int inv_count = 0;

            /* i is index for left subarray*/
            int i = left;

            /* j is index for right subarray*/
            int j = mid;

            /* k is index for resultant merged subarray*/
            int k = left;
            System.out.println("merge method count :" + inv_count);
            System.out.println("merge method i : " + i + " j : "+ j + " k : "+ k);
            System.out.println("---------");

            while ((i <= mid - 1) && (j <= right)) {

                System.out.println("while loop i-mid : " + i + " " + (mid - 1));
                System.out.println("while loop j-right : " + j + " " + right);
                if (arr[i] <= arr[j])
                    temp[k++] = arr[i++];
                else
                {
                    temp[k++] = arr[j++];

            /* this is tricky -- see above /
             explanation diagram for merge()*/
                    inv_count = inv_count + (mid - i);
                }
                System.out.println("temp[] = " + Arrays.toString(temp));
                System.out.println("count: " + inv_count);
                System.out.println();
            }
            System.out.println("-------");

    /* Copy the remaining elements of left
    subarray (if there are any) to temp*/
            while (i <= mid - 1)
                temp[k++] = arr[i++];
            System.out.println("i < mid - 1");
            System.out.println("temp[] = " + Arrays.toString(temp));
            System.out.println("-------");

    /* Copy the remaining elements of right
    subarray (if there are any) to temp*/
            while (j <= right)
                temp[k++] = arr[j++];
            System.out.println("j <= right");
            System.out.println("temp[] = " + Arrays.toString(temp));

            System.out.println("-------");

    /*Copy back the merged elements
    to original array*/
//            for (i=left; i <= right; i++){
//                arr[i] = temp[i];
//                System.out.println("for loop i: " + i + "  temp[] = " + Arrays.toString(temp));
//            }
            System.out.println("count !!!" + inv_count);
            return inv_count;
        }

        // An auxiliary recursive function that
// sorts the input array and returns
// the number of inversions in the array.
        static int _mergeSort(int arr[], int temp[],
                              int left, int right)
        {
            int mid, inv_count = 0;
            if (right > left)
            {
                // Divide the array into two parts and
                // call _mergeSortAndCountInv() for
                // each of the parts
                mid = (right + left)/2;

        /* Inversion count will be sum of
        inversions in left-part, right-part
        and number of inversions in merging */
                inv_count = _mergeSort(arr, temp,
                        left, mid);
                System.out.println("+++ arr, temp, left, mid: " + inv_count );

                inv_count += _mergeSort(arr, temp,
                        mid+1, right);
                System.out.println("+++ arr, temp, mid + 1, right: " + inv_count );

                /*Merge the two parts*/
                inv_count += merge(arr, temp,
                        left, mid+1, right);
                System.out.println("+++ arr, temp, left, mid+1, right: " + inv_count );
            }

            return inv_count;
        }

        // This function sorts the input
// array and returns the number
// of inversions in the array
        static int countSwaps(int arr[], int n)
        {
            int temp[] = new int[n];
            return _mergeSort(arr, temp, 0, n - 1);
        }

        // Driver Code
        public static void main (String[] args)
        {

            int arr[] = {5, 4, 1, 2};
            int n = arr.length;
            System.out.println("Number of swaps is "
                    + countSwaps(arr, n));
        }
    }
```
