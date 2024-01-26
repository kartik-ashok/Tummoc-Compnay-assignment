package assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteGrouping {

    public static void main(String[] args) {
        String[] routes = {
            "13", "13-C", "342-R", "146-Q", "27", "29-A", "215-U", "27-E1", "13J", "SBS-D34G"
        };

        int[] fares = {10, 15, 10, 10, 15, 12, 12, 15, 12, 10};

        Map<Integer, List<String>> fareRouteMap = groupRoutesByFare(routes, fares);

        System.out.println("Fare    \t\tRoute");
        for (Map.Entry<Integer, List<String>> entry : fareRouteMap.entrySet()) {
            System.out.printf("%-8d\t\t%s%n", entry.getKey(), entry.getValue());
        }
    }

    private static Map<Integer, List<String>> groupRoutesByFare(String[] routes, int[] fares) {
        Map<Integer, List<String>> fareRouteMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            int fare = fares[i];
            String route = routes[i];

            // If the fare is not in the map, create a new list for that fare
            fareRouteMap.putIfAbsent(fare, new ArrayList<>());

            // Add the route to the corresponding fare in the map
            fareRouteMap.get(fare).add(route);
        }

        return fareRouteMap;
    }
}

