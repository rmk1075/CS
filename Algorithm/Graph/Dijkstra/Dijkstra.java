package Algorithm.Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

import Algorithm.Graph.Graph;

public class Dijkstra implements Graph {

    private int N;

    private boolean[] visited;

    private int[][] graph;

    private PriorityQueue<Node> pq;

    public Dijkstra(int[][] graph) {
        N = graph.length;
        this.visited = new boolean[N];
        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
        pq = new PriorityQueue<>();
    }

    private int[] dijkstra(int src) {
        int[] distance = new int[N];
        for(int i = 0; i < N; i++) {
            if(i == src) continue;
            distance[i] = Integer.MAX_VALUE;
            pq.add(new Node(i, distance[i]));
        }
        distance[src] = 0;
        pq.add(new Node(src, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.index])
                continue;
            
            visited[node.index] = true;
            for(int i = 0; i < N; i++) {
                if(visited[i] || distance[i] < distance[node.index] + graph[node.index][i])
                    continue;
                distance[i] = distance[node.index] + graph[node.index][i];
                pq.add(new Node(i, distance[i]));
            }
        }

        return distance;
    }

    @Override
    public void search() {
        System.out.println("[Dijkstra]");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) visited[j] = false;
            System.out.println(Arrays.toString(dijkstra(i)));
        }
    }
    
    class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
