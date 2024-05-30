import java.util.Scanner;

class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for various parameters
        System.out.println("Enter the number of queries:");
        int no_of_queries = sc.nextInt();
        
        System.out.println("Enter the bucket size:");
        int bucket_size = sc.nextInt();
        
        System.out.println("Enter the input packet size:");
        int input_pkt_size = sc.nextInt();
        
        System.out.println("Enter the output packet size:");
        int output_pkt_size = sc.nextInt();

        int storage = 0; // Initial packets in the bucket
        
        for (int i = 0; i < no_of_queries; i++) {
            int size_left = bucket_size - storage; // Space left in the bucket

            if (input_pkt_size <= size_left) {
                storage += input_pkt_size;
                System.out.println("Input packet of size " + input_pkt_size + " added to the bucket.");
            } else {
                System.out.println("Packet loss = " + (input_pkt_size - size_left) + " (input packet size: " + input_pkt_size + ", size left: " + size_left + ")");
                storage = bucket_size; // Bucket is full
            }

            System.out.println("Buffer size = " + storage + " out of bucket size = " + bucket_size);

            storage -= output_pkt_size;
            if (storage < 0) {
                storage = 0; // Ensure storage doesn't go below zero
            }
            System.out.println("Buffer size after output = " + storage + " out of bucket size = " + bucket_size);
        }

        sc.close();
    }
}
