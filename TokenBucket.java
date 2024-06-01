public class TokenBucket {
    private final long capacity;
    private final long refillRate;
    private long tokens;
    private long lastRefillTime;

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    private void refill() {
        long now = System.currentTimeMillis();
        tokens = Math.min(capacity, tokens + (now - lastRefillTime) * refillRate / 1000);
        lastRefillTime = now;
    }

    public boolean tryConsume(int numTokens) {
        refill();
        if (tokens >= numTokens) {
            tokens -= numTokens;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TokenBucket bucket = new TokenBucket(10, 5);

        Runnable task = () -> {
            while (true) {
                if (bucket.tryConsume(1)) {
                    System.out.println("Token consumed.");
                } else {
                    System.out.println("Not enough tokens. Waiting...");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(task).start();
    }
}

