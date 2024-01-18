import java.util.*; 
 
class PrimAlgorithm { 
 
    static class Edge { 
        int source, destination, weight; 
 
        public Edge(int source, int destination, int weight) { 
            this.source = source; 
            this.destination = destination; 
            this.weight = weight; 
        } 
    } 
 
    static List<Edge> prim(int[][] graph) { 
        int vertices = graph.length; 
 
        List<Edge> mst = new ArrayList<>(); 
        boolean[] visited = new boolean[vertices]; 
 
         
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight)); 
 
       
        int startNode = 0; 
        visited[startNode] = true; 
 
        for (int i = 0; i < vertices; i++) { 
            if (graph[startNode][i] != 0) { 
                priorityQueue.add(new Edge(startNode, i, graph[startNode][i])); 
            } 
        } 
 
        while (!priorityQueue.isEmpty()) { 
            Edge edge = priorityQueue.poll(); 
 
            int current = edge.destination; 
            if (!visited[current]) { 
                visited[current] = true; 
                mst.add(edge); 
 
                for (int i = 0; i < vertices; i++) { 
                    if (graph[current][i] != 0 && !visited[i]) { 
                        priorityQueue.add(new Edge(current, i, graph[current][i])); 
                    } 
                } 
            } 
        } 
 
        return mst; 
    } 
 
    public static void main(String[] args) { 
       
        int[][] graph = { 
                {0, 3, 4, 0}, 
                {3, 0, 2, 5}, 
                {4, 2, 0, 7}, 
                {0, 5, 7, 0} 
        }; 
 
    
        List<Edge> minimumSpanningTree = prim(graph); 
 
        
        System.out.println("Minimum Spanning Tree:"); 
        for (Edge edge : minimumSpanningTree) { 
            System.out.println(edge.source + " - " + edge.destination + " (Weight: " + edge.weight + ")"); 
        } 
    } 
}