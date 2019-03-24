/*
Given an array A[] of n integers, the task is to find a subsequence of size k whose product is maximum among all
possible k sized subsequences of given array.

Input : A[] = {1, 2, 0, 3},
          k = 2
Output : 6
Explanation : Subsequence containing elements
{2, 3} gives maximum product : 2*3 = 6


Input : A[] = {1, 2, -1, -3, -6, 4},
          k = 4
Output : 144
Explanation : Subsequence containing {2, -3,
-6, 4} gives maximum product : 2*(-3)*(-6)*4
= 144


# Solution

- Sort the array
- Take product of first k elements in the array
- In order to avoid calculating product of next k elements on each iteration.
    * Divide the product with the first element in the array.
    * Multiply the resultant with the next element
- This cannot be done if the product is 0. In that case recalculate the product of entire window of length k.
- Lastly start rotating the window of k elements. Taking k-1 elements from the end of array and 1 element from start
of array. Repeat this until one element from end of array is taken and k-1 elements from start of array are taken.
- Space complexity = O(1)
- Time complexity = O(n*k) //where n is the length of array

 */

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -1, -3, -6, 4};
        System.out.println(maximumProductOfSubArray(arr1, 4));

        int[] arr2 = {1, 2, 3};
        System.out.println(maximumProductOfSubArray(arr2, 2));

        int[] arr3 = {-9,-9, 2, 3};
        System.out.println(maximumProductOfSubArray(arr3, 2));

        int[] arr4 = {1, 2, 0, 3};
        System.out.println(maximumProductOfSubArray(arr4, 2));

    }

    public static int maximumProductOfSubArray(int[] arr, int k) {
        if (arr.length == 0)
            return 0;

        Arrays.sort(arr);
        int prod =1;
        int j = 0;
        int maxProd = Integer.MIN_VALUE;

        while (j < k) {
            prod *= arr[j];
            ++j;
        }

        maxProd = Math.max(prod, maxProd);
        j = 1;

        for(int i=k; i<arr.length; i++, j++){
            if (arr[j-1] != 0) {
                prod /= arr[j-1];
                prod *= arr[i];
            }
            else {
                int m = j;
                while (m <= i) {
                    prod = 1;
                    prod *= arr[m];
                    ++m;
                }
            }

            maxProd = Math.max(prod, maxProd);
        }

        int m = k;
        int count=1;
        int n = 1;
        while (n < k) {
            prod = 1;
            for (int i=arr.length-1; count<m; i--, count++) {
                prod *= arr[i];
            }

            for (int i=0; i<n; i++) {
                prod *= arr[i];
            }

            ++n;
            --m;
            count = 1;
            maxProd = Math.max(prod, maxProd);
        }


        return maxProd;
    }
}