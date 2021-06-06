package Algorithm.Graph.Prim;

import java.util.Arrays;
import java.util.PriorityQueue;

import Algorithm.Graph.Graph;

public class Prim implements Graph {

    private int N;

    private int weight;

    private boolean[] visited;

    private int[][] graph;

    public Prim(int[][] graph) {
        N = graph.length;
        weight = 0;
        visited = new boolean[N];
        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) this.graph[i][j] = graph[i][j];
        }
    }

    private int[][] prim() {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                result[i][j] = result[j][i] = -1;
            }
        }

        int count = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));
        while(!pq.isEmpty() && count < N - 1) {
            Edge edge = pq.poll();
            int i = edge.v2;
            if(visited[i]) continue;
            visited[i] = true;
            weight += edge.weight;
            result[edge.v1][i] = result[i][edge.v1] = edge.weight;
            for(int j = 0; j < N; j++) {
                if(i == j || visited[j]) continue;
                pq.add(new Edge(i, j, graph[i][j]));
            }
        }

        return result;
    }

    @Override
    public void search() {
        graph = prim();

        System.out.println("[Prim]");
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
