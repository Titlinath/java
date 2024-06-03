public class SimpleHamming {

    // Encode a 4-bit data word using Hamming (7,4) code
    public static int[] encode(int[] data) {
        // Initialize codeword with 3 parity bits and 4 data bits
        int[] codeword = new int[7];
        
        // Calculate parity bits (P1, P2, P3)
        codeword[2] = data[0] ^ data[1] ^ data[3];
        codeword[4] = data[0] ^ data[2] ^ data[3];
        codeword[5] = data[1] ^ data[2] ^ data[3];
        
        // Copy data bits and parity bits to codeword
        System.arraycopy(data, 0, codeword, 0, 4);
        
        return codeword;
    }

    // Decode a 7-bit codeword using Hamming (7,4) code
    public static int[] decode(int[] codeword) {
        // Initialize data with 4 bits
        int[] data = new int[4];
        
        // Calculate syndrome bits (S1, S2, S3)
        int s1 = codeword[2] ^ codeword[0] ^ codeword[1] ^ codeword[3];
        int s2 = codeword[4] ^ codeword[0] ^ codeword[2] ^ codeword[3];
        int s3 = codeword[5] ^ codeword[1] ^ codeword[2] ^ codeword[3];
        
        // Calculate error bit index based on syndrome bits
        int errorIndex = s1 | (s2 << 1) | (s3 << 2);
        
        // Correct error bit if present
        if (errorIndex != 0) {
            codeword[errorIndex - 1] ^= 1;
        }
        
        // Extract data bits from codeword
        System.arraycopy(codeword, 0, data, 0, 4);
        
        return data;
    }

    public static void main(String[] args) {
        // Original 4-bit data word
        int[] data = {1, 0, 1, 1};

        // Encode the data word
        int[] codeword = encode(data);

        // Introduce an error in the codeword
        codeword[2] = 1 - codeword[2];

        // Decode the codeword
        int[] decodedData = decode(codeword);

        // Display original data and decoded data
        System.out.println("Original Data: " + arrayToString(data));
        System.out.println("Codeword:      " + arrayToString(codeword));
        System.out.println("Decoded Data:  " + arrayToString(decodedData));
    }

    // Helper method to convert an array to a string
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int bit : arr) {
            sb.append(bit);
        }
        return sb.toString();
    }
}
