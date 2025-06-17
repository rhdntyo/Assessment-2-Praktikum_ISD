import java.util.*;

public class BurgerGraph {
    private final Map<String, List<String>> adjList;

    public BurgerGraph() {
        adjList = new HashMap<>();
    }

    public void addStep(String step) {
    adjList.putIfAbsent(step, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adjList.putIfAbsent(to, new ArrayList<>()); 
    }

    public List<String> getNeighbors(String node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    public void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            for (String neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(String current, Set<String> visited) {
        visited.add(current);
        System.out.println(current);

        for (String neighbor : getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
