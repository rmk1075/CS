package Algorithm.Graph.Kruskal;

import java.util.Arrays;
import java.util.PriorityQueue;

import Algorithm.Graph.Graph;

public class Kruskal implements Graph {
    
    private int N;

    private int weight;

    private int[] visited;

    private int[][] graph;

    public Kruskal(int[][] graph) {
        N = graph.length;
        weight = 0;
        visited = new int[N];
        for(int i = 1; i < N; i++) {
            visited[i] = i;
        }

        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
    }

    public int find(int v) {
        if(visited[v] == v) return v;
        return find(visited[v]);
    }

    private void kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                graph[i][j] = -1;
            }
            for(int j = i + 1; j < N; j++) {
                pq.add(new Edge(i, j, graph[i][j]));
                graph[i][j] = -1;
            }
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v1 = edge.v1, v2 = edge.v2;
            int p1 = find(v1), p2 = find(v2);
            if(p1 == p2)
                continue;
            visited[p1] = p2;
            graph[v1][v2] = graph[v2][v1] = edge.weight;
            weight += edge.weight;
        }
    }

    @Override
    public void search() {
        kruskal();

        System.out.println("[Kruskal]");
        System.out.println("weight of MST: " + weight);
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    private class Edge implements Comparable<Edge> {
        int v1, v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
