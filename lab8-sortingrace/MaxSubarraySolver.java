public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.

        // Primitive operation count:
        // - The outer loop runs n times (i = 0 to n-1).
        // - For each i, the inner loop runs (n - i) times.
        // - Total inner loop runs = n + (n-1) + ... + 1 = n(n+1)/2.
        // - Each inner loop run does about 4 primitive operations
        //   (1 addition, 1 comparison, 1 possible assignment, 1 increment).
        // - So T(n) is about 4 * n(n+1)/2 = 2n^2 + 2n, plus a few ops per outer loop.
        // - The n^2 term dominates, so this is O(n^2).
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.

        // Analysis:
        // - There is only one loop, and it goes through the array once (n - 1 times).
        // - Each iteration does a constant amount of work: 1 addition,
        //   2 Math.max comparisons, 2 assignments, and 1 increment.
        // - So T(n) is about c * n for some constant c, which is O(n).
        // - At each index we decide whether to extend the current subarray
        //   or start a new one at arr[i], so we never recheck old subarrays.
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}