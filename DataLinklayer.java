import java.util.Arrays;

public class DataLinkLayer {

    public static void main(String[] args) {
        String data = "Hello, OSI Model!";
        byte[] frame = createFrame(data);
        
        System.out.println("Original Data: " + data);
        System.out.println("Frame: " + Arrays.toString(frame));
        
        boolean isErrorFree = checkFrame(frame);
        System.out.println("Is frame error-free? " + isErrorFree);
    }

    private static byte[] createFrame(String data) {
        byte[] dataBytes = data.getBytes();
        byte[] crc = calculateCRC(dataBytes);
        
        byte[] frame = new byte[dataBytes.length + crc.length];
        System.arraycopy(dataBytes, 0, frame, 0, dataBytes.length);
        System.arraycopy(crc, 0, frame, dataBytes.length, crc.length);
        
        return frame;
    }

    private static byte[] calculateCRC(byte[] data) {
        // Simple CRC calculation (for demonstration purposes)
        byte crc = 0;
        for (byte b : data) {
            crc ^= b;
        }
        return new byte[]{crc};
    }

    private static boolean checkFrame(byte[] frame) {
        int dataLength = frame.length - 1;
        byte[] data = Arrays.copyOfRange(frame, 0, dataLength);
        byte receivedCRC = frame[dataLength];
        
        byte[] calculatedCRC = calculateCRC(data);
        return receivedCRC == calculatedCRC[0];
    }
}

DataLinkLayer.java