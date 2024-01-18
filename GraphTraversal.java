import java.util.*; 
 
class GraphTraversal { 
    static class Graph { 
        private Map<Integer, List<Integer>> graph; 
 
        public Graph() { 
            this.graph = new HashMap<>(); 
        } 
 
        public void addEdge(int node, List<Integer> neighbors) { 
            graph.put(node, neighbors); 
        } 
 
        public List<Integer> dfs(int start) { 
            Set<Integer> visited = new HashSet<>(); 
            List<Integer> result = new ArrayList<>(); 
 
            dfsUtil(start, visited, result); 
 
            return result; 
        } 
 
        private void dfsUtil(int node, Set<Integer> visited, List<Integer> result) { 
            visited.add(node); 
            result.add(node); 
 
            for (int neighbor : graph.get(node)) { 
                if (!visited.contains(neighbor)) { 
                    dfsUtil(neighbor, visited, result); 
                } 
            } 
        } 
 
        public List<Integer> bfs(int start) { 
            Set<Integer> visited = new HashSet<>(); 
            List<Integer> result = new ArrayList<>(); 
            Queue<Integer> queue = new LinkedList<>(); 
 
            visited.add(start); 
            queue.add(start); 
 
            while (!queue.isEmpty()) { 
                int currentNode = queue.poll(); 
                result.add(currentNode); 
 
                for (int neighbor : graph.get(currentNode)) { 
                    if (!visited.contains(neighbor)) { 
                        visited.add(neighbor); 
                        queue.add(neighbor); 
                    } 
                } 
            } 
 
            return result; 
        } 
    } 
 
    public static void main(String[] args) { 
        Graph graph = new Graph(); 
 
        
        graph.addEdge(1, Arrays.asList(2, 3)); 
        graph.addEdge(2, Arrays.asList(1, 4, 5)); 
        graph.addEdge(3, Arrays.asList(1, 6)); 
        graph.addEdge(4, Arrays.asList(2)); 
        graph.addEdge(5, Arrays.asList(2, 7)); 
        graph.addEdge(6, Arrays.asList(3)); 
        graph.addEdge(7, Arrays.asList(5)); 
 
        
        System.out.println("DFS Traversal:"); 
        List<Integer> dfsResult = graph.dfs(1); 
        for (int node : dfsResult) { 
            System.out.print(node + " -> "); 
        } 
        System.out.println(); 
 
        
        System.out.println("BFS Traversal:"); 
        List<Integer> bfsResult = graph.bfs(1); 
        for (int node : bfsResult) { 
            System.out.print(node + " -> "); 
        } 
    } 
}