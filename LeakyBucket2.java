public class LeakyBucket2 {
    public static void main(String[] args) {
        int no_of_queries = 4;       // Total number of times bucket content is checked
        int bucket_size = 10;        // Total number of packets that can be accommodated in the bucket
        int input_pkt_size = 4;      // Number of packets that enter the bucket at a time
        int output_pkt_size = 1;     // Number of packets that exit the bucket at a time
        int storage = 0;             // Initial packets in the bucket

        for (int i = 0; i < no_of_queries; i++) {
            int size_left = bucket_size - storage; // Space left in the bucket

            if (input_pkt_size <= size_left) {
                storage += input_pkt_size;
            } else {
                System.out.println("Packet loss = " + (input_pkt_size - size_left));
                storage = bucket_size; // Bucket is full
            }

            System.out.println("Buffer size = " + storage + " out of bucket size = " + bucket_size);
            storage = Math.max(0, storage - output_pkt_size); // Ensure storage doesn't go below zero
        }
    }
}
