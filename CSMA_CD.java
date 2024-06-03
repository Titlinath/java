import java.util.Random;

public class CSMA_CD_Simulation {
    private static final int MAX_BACKOFF_ATTEMPTS = 10;
    private static final int SLOT_TIME = 10; // Time taken by a signal to propagate through the network

    public static void main(String[] args) {
        // Simulate transmission attempt
        boolean collision = isCollisionDetected();
        if (collision) {
            System.out.println("Collision detected.");
            int backoffTime = generateBackoffTime();
            System.out.println("Backoff time: " + backoffTime + " milliseconds");
            // Wait for backoff time
            try {
                Thread.sleep(backoffTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Retry transmission after backoff time
            System.out.println("Retrying transmission...");
        } else {
            System.out.println("Transmission successful.");
        }
    }

    private static boolean isCollisionDetected() {
        // Simulate random occurrence of collision
        Random random = new Random();
        return random.nextDouble() < 0.1; // 10% chance of collision
    }

    private static int generateBackoffTime() {
        // Generate backoff time using exponential backoff algorithm
        Random random = new Random();
        int backoffAttempts = random.nextInt(MAX_BACKOFF_ATTEMPTS) + 1;
        return backoffAttempts * SLOT_TIME; // Backoff time = number of attempts * slot time
    }
}
