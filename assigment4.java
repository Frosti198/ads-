
TASK 1

Source node: A
Adjacency lists order used:
A: C, B, D
B: A, C, E, G
C: A, B, D
D: C, A
E: G, F, B
F: G, E
G: F, B

Detailed Trace:
1. Visit A. Neighbors: C, B, D. Go to C.
2. Visit C. Neighbors: A(visited), B, D. Go to B.
3. Visit B. Neighbors: A(visited), C(visited), E, G. Go to E.
4. Visit E. Neighbors: G, F, B(visited). Go to G.
5. Visit G. Neighbors: F, B(visited). Go to F.
6. Visit F. Neighbors: G(visited), E(visited). Backtrack to G.
7. Backtrack to E. Next neighbor is F(visited), B(visited). Backtrack to B.
8. At B, next neighbor is G(visited). Backtrack to C.
9. At C, next neighbor is D. Go to D.
10. Visit D. Neighbors: C(visited), A(visited). Backtrack to C.
11. Backtrack to A. Next neighbors B(visited), D(visited). Done.

DFS Visit Order: A -> C -> B -> E -> G -> F -> D

TASK 2

Source node: A

Detailed Trace:
1. Initialize Queue = [A], Visited = {A}
2. Dequeue A. Visit A. Add unvisited neighbors (C, B, D) to Queue.
   Queue = [C, B, D], Visited = {A, C, B, D}
3. Dequeue C. Visit C. Neighbors (A, B, D) are already visited.
   Queue = [B, D]
4. Dequeue B. Visit B. Add unvisited neighbors (E, G) to Queue.
   Queue = [D, E, G], Visited = {A, C, B, D, E, G}
5. Dequeue D. Visit D. Neighbors (C, A) are already visited.
   Queue = [E, G]
6. Dequeue E. Visit E. Add unvisited neighbor (F) to Queue.
   Queue = [G, F], Visited = {A, C, B, D, E, G, F}
7. Dequeue G. Visit G. Neighbors (F, B) are already visited.
   Queue = [F]
8. Dequeue F. Visit F. Neighbors (G, E) are already visited.
   Queue = [] (Empty)

BFS Visit Order: A -> C -> B -> D -> E -> G -> F


TASK 4: Dijkstra's Algorithm Trace

Source: Edinburgh, Destination: Dundee

Initial state:
Edinburgh(0), Glasgow(∞), Stirling(∞), Perth(∞), Dundee(∞)

Detailed Trace:
1. Process Edinburgh (0). Update neighbors:
   - Stirling: 0 + 50 = 50. Dist[Stirling] = 50.
   - Glasgow: 0 + 70 = 70. Dist[Glasgow] = 70.
   - Perth: 0 + 100 = 100. Dist[Perth] = 100.
   Unvisited: {Stirling(50), Glasgow(70), Perth(100), Dundee(∞)}

2. Process Stirling (50). Update neighbors:
   - Glasgow: 50 + 50 = 100 (100 > 70, no update).
   - Perth: 50 + 40 = 90. (90 < 100). Dist[Perth] = 90.
   Unvisited: {Glasgow(70), Perth(90), Dundee(∞)}

3. Process Glasgow (70). Update neighbors:
   - No shorter paths found.
   Unvisited: {Perth(90), Dundee(∞)}

4. Process Perth (90). Update neighbors:
   - Dundee: 90 + 60 = 150. (150 < ∞). Dist[Dundee] = 150.
   Unvisited: {Dundee(150)}

5. Process Dundee (150). Destination reached.

Shortest Path: Edinburgh -> Stirling -> Perth -> Dundee
Total Distance: 150




import java.util.*;

public class GraphTraversal {
    private Map<String, List<String>> adjList = new LinkedHashMap<>();

    public void addEdge(String src, String... dests) {
        adjList.put(src, Arrays.asList(dests));
    }

    public void dfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        System.out.print("DFS Output: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (String neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        
        System.out.print("BFS Output: ");

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            for (String neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        graph.addEdge("A", "C", "B", "D");
        graph.addEdge("B", "A", "C", "E", "G");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "C", "A");
        graph.addEdge("E", "G", "F", "B");
        graph.addEdge("F", "G", "E");
        graph.addEdge("G", "F", "B");

        graph.dfs("A"); 
        graph.bfs("A"); 
    }
}




import java.util.*;

public class GraphTraversal {
    private Map<String, List<String>> adjList = new LinkedHashMap<>();

    public void addEdge(String src, String... dests) {
        adjList.put(src, Arrays.asList(dests));
    }

    public void dfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        System.out.print("DFS Output: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (String neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        
        System.out.print("BFS Output: ");

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            for (String neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        graph.addEdge("A", "C", "B", "D");
        graph.addEdge("B", "A", "C", "E", "G");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "C", "A");
        graph.addEdge("E", "G", "F", "B");
        graph.addEdge("F", "G", "E");
        graph.addEdge("G", "F", "B");

        graph.dfs("A"); 
        graph.bfs("A"); 
    }
}
