import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTroubleshooter {

    public static void main(String[] args) {
        String hostname = "example.com";

        try {
            // Get InetAddress object for the specified host
            InetAddress inetAddress = InetAddress.getByName(hostname);

            // Check if the host is reachable
            boolean isReachable = inetAddress.isReachable(5000); // Timeout: 5000 milliseconds

            if (isReachable) {
                System.out.println(hostname + " is reachable.");
            } else {
                System.out.println(hostname + " is not reachable.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}