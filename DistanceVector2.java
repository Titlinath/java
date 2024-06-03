import java.util.HashMap;
import java.util.Map;

public class SimpleDVRouter {
    private final Map<String, RouteInfo> routeTable = new HashMap<>();

    // Route information structure
    private static class RouteInfo {
        String nextHop;
        int cost;

        RouteInfo(String nextHop, int cost) {
            this.nextHop = nextHop;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "NextHop: " + nextHop + ", Cost: " + cost;
        }
    }

    // Add or update a route in the route table
    public void addOrUpdateRoute(String dest, String nextHop, int cost) {
        routeTable.put(dest, new RouteInfo(nextHop, cost));
    }

    // Simulate receiving a route update from a neighbor
    public void receiveUpdate(String neighbor, Map<String, Integer> neighborRoutes) {
        for (Map.Entry<String, Integer> entry : neighborRoutes.entrySet()) {
            String destination = entry.getKey();
            int neighborCost = entry.getValue() + 1;

            if (!routeTable.containsKey(destination) || neighborCost < routeTable.get(destination).cost) {
                addOrUpdateRoute(destination, neighbor, neighborCost);
            }
        }
    }

    // Get the next hop for a given destination
    public String getNextHop(String destination) {
        RouteInfo route = routeTable.get(destination);
        return route != null ? route.nextHop : null;
    }

    // Print the route table
    public void printRoutes() {
        routeTable.forEach((dest, route) -> 
            System.out.println("Destination: " + dest + ", " + route)
        );
    }

    public static void main(String[] args) {
        SimpleDVRouter router = new SimpleDVRouter();
        
        // Neighbor route tables
        Map<String, Integer> neighbor1 = new HashMap<>();
        neighbor1.put("192.168.1.0/24", 1);
        neighbor1.put("192.168.2.0/24", 2);

        Map<String, Integer> neighbor2 = new HashMap<>();
        neighbor2.put("192.168.3.0/24", 1);

        // Simulate receiving updates
        router.receiveUpdate("192.168.0.1", neighbor1);
        router.receiveUpdate("192.168.0.2", neighbor2);

        // Print route table
        System.out.println("Route Table:");
        router.printRoutes();

        // Query for a destination
        String target = "192.168.1.10";
        String nextHop = router.getNextHop("192.168.1.0/24");

        if (nextHop != null) {
            System.out.println("Next hop for destination " + target + " is " + nextHop);
        } else {
            System.out.println("No route found for destination " + target);
        }
    }
}


DistanceVector2.java