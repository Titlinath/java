public class SimpleRateLimiter {
    private final long maxTokens;     // Maximum tokens the bucket can hold
    private final long refillRate;    // Tokens added per second
    private long availableTokens;     // Current number of tokens in the bucket
    private long lastCheckedTime;     // Last time tokens were added

    public SimpleRateLimiter(long maxTokens, long refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.availableTokens = maxTokens;    // Start with a full bucket
        this.lastCheckedTime = System.currentTimeMillis();
    }

    private void addTokens() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastCheckedTime;
        long tokensToAdd = (elapsedTime * refillRate) / 1000;  // Calculate tokens to add

        if (tokensToAdd > 0) {
            availableTokens = Math.min(maxTokens, availableTokens + tokensToAdd);
            lastCheckedTime = currentTime;
        }
    }

    public boolean requestTokens(int tokens) {
        addTokens();
        if (availableTokens >= tokens) {
            availableTokens -= tokens;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleRateLimiter limiter = new SimpleRateLimiter(10, 5);  // Bucket capacity: 10 tokens, Refill rate: 5 tokens/second

        Runnable task = () -> {
            while (true) {
                if (limiter.requestTokens(1)) {
                    System.out.println("Token consumed.");
                } else {
                    System.out.println("Not enough tokens. Waiting...");
                }
                try {
                    Thread.sleep(200);  // Simulate work interval
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(task).start();
    }
}
