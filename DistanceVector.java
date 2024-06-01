import java.util.HashMap;
import java.util.Map;

public class DistanceVector {
    private final Map<String, RouteInfo> routingTable = new HashMap<>();

    // Route information structure
    private static class RouteInfo {
        String nextHop;
        int distance;

        RouteInfo(String nextHop, int distance) {
            this.nextHop = nextHop;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "NextHop: " + nextHop + ", Distance: " + distance;
        }
    }

    // Add or update a route in the routing table
    public void updateRoute(String destination, String nextHop, int distance) {
        routingTable.put(destination, new RouteInfo(nextHop, distance));
    }

    // Simulate receiving a route update from a neighbor
    public void receiveRouteUpdate(String neighbor, Map<String, Integer> neighborTable) {
        for (Map.Entry<String, Integer> entry : neighborTable.entrySet()) {
            String dest = entry.getKey();
            int neighborDist = entry.getValue();
            int newDist = neighborDist + 1;  // Distance vector calculation (simple hop count)

            if (!routingTable.containsKey(dest) || newDist < routingTable.get(dest).distance) {
                updateRoute(dest, neighbor, newDist);
            }
        }
    }

    // Get the next hop for a given destination
    public String getRoute(String destination) {
        RouteInfo routeInfo = routingTable.get(destination);
        return routeInfo != null ? routeInfo.nextHop : null;
    }

    // Print the routing table
    public void printRoutingTable() {
        for (Map.Entry<String, RouteInfo> entry : routingTable.entrySet()) {
            System.out.println("Destination: " + entry.getKey() + ", " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        DistanceVectorRouter router = new DistanceVectorRouter();
        
        // Initial state with direct neighbors
        Map<String, Integer> neighborTableA = new HashMap<>();
        neighborTableA.put("192.168.1.0/24", 1);
        neighborTableA.put("192.168.2.0/24", 2);

        Map<String, Integer> neighborTableB = new HashMap<>();
        neighborTableB.put("192.168.3.0/24", 1);

        // Simulate receiving route updates
        router.receiveRouteUpdate("192.168.0.1", neighborTableA);
        router.receiveRouteUpdate("192.168.0.2", neighborTableB);

        // Print routing table
        System.out.println("Routing Table:");
        router.printRoutingTable();

        // Query for a destination
        String destination = "192.168.1.10";
        String nextHop = router.getRoute("192.168.1.0/24");

        if (nextHop != null) {
            System.out.println("Next hop for destination " + destination + " is " + nextHop);
        } else {
            System.out.println("No route found for destination " + destination);
        }
    }
}

