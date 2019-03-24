# MaximumProductOfSubArray
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
