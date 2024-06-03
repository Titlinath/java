import java.util.HashMap;
import java.util.Map;

public class StaticRouter {
    private final Map<String, String> routingTable = new HashMap<>();

    // Add a route to the routing table
    public void addRoute(String destination, String nextHop) {
        routingTable.put(destination, nextHop);
    }

    // Get the next hop for a given destination
    public String getRoute(String destination) {
        return routingTable.get(destination);
    }

    public static void main(String[] args) {
        StaticRouter router = new StaticRouter();
        router.addRoute("192.168.1.0/24", "192.168.1.1");
        router.addRoute("192.168.2.0/24", "192.168.2.1");
        router.addRoute("10.0.0.0/8", "10.0.0.1");

        String destination = "192.168.1.10";
        String nextHop = router.getRoute("192.168.1.0/24");

        if (nextHop != null) {
            System.out.println("Next hop for destination " + destination + " is " + nextHop);
        } else {
            System.out.println("No route found for destination " + destination);
        }
    }
}