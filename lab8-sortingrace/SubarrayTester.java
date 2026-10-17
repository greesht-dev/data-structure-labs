import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // TODO: Generate a random array and time both algorithms.
            int[] arr = generateRandomArrayWithNegatives(n);

            long start = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            System.out.printf("  Brute Force: %.3f ms (sum = %d)%n", (end - start) / 1_000_000.0, bruteResult);

            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            System.out.printf("  Kadane's:    %.3f ms (sum = %d)%n", (end - start) / 1_000_000.0, kadaneResult);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(201) - 100; // random number from -100 to 100
        }
        return arr;
    }
}