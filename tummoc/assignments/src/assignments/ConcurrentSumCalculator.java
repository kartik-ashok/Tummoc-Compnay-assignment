package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcurrentSumCalculator {

    public static class SumThread extends Thread {
        private final long start;
        private final long end;
        private long result;

        public SumThread(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            result = 0;
            for (long i = start; i <= end; i++) {
                result += i;
            }
        }

        public long getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        // Get the limit of the sum from the user
        int limit = getLimitFromUser();

        // Specify the number of threads to use
        int numThreads = 3; // You can adjust this based on your requirements

        // Divide the work among threads
        List<SumThread> threads = new ArrayList<>();
        long chunkSize = (long) Math.ceil((double) limit / numThreads);

        for (int i = 0; i < numThreads; i++) {
            long start = i * chunkSize + 1;
            long end = Math.min((i + 1) * chunkSize, limit);
            SumThread thread = new SumThread(start, end);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (SumThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Collect the results
        long totalSum = 0;
        for (SumThread thread : threads) {
            totalSum += thread.getResult();
        }

        // Print the result
        System.out.println("The sum of numbers from 1 to " + limit + " is: " + totalSum);
    }

    private static int getLimitFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit for the sum: ");
        int limit = scanner.nextInt();
        scanner.close();
        return limit;
    }
}
