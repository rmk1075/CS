package Algorithm.Graph.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Algorithm.Graph.Graph;

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFord implements Graph {

    private int N;
    private int E;

    private int[][] graph;
    private List<Edge> edges;

    public BellmanFord(int[][] graph) {
        N = graph.length;
        this.graph = new int[N][N];
        this.edges = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
                if(graph[i][j] != Integer.MAX_VALUE) {
                    this.E++;
                    this.edges.add(new Edge(i, j, graph[i][j]));
                }
            }
         }
    }

    private int[] bellmanFord(int src) {
        // 최단 거리 초기화
        int[] shortest = new int[N];
        for(int i = 0; i < N; i++) shortest[i] = Integer.MAX_VALUE;
        shortest[src] = 0;

        // 모든 간선에 대해서 N-1번 만큼 edge relaxation 한다.
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < E; j++) {
                Edge edge = this.edges.get(j); // 간선 하나를 가져와서 edge relaxation을 수행한다.
                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;
                if(shortest[u] != Integer.MAX_VALUE && shortest[u] + w < shortest[v])
                    shortest[v] = shortest[u] + w;
            }
        }

        // negative-wegith cycle의 존재 유무를 확인한다.
        for(int i = 0; i < E; i++) {
            Edge edge = edges.get(i);
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;
            // V-1 만큼 반복하여 모든 정점을 고려한 최단 거리를 찾았음에도 더 짧은 경로가 있다는 것은 음수의 사이클이 존재한다는 의미이다.
            if(shortest[u] != Integer.MAX_VALUE && shortest[u] + w < shortest[v]) {
                System.out.println("Graph contains negative weight cycle.");
                return new int[N];
            }
        }

        return shortest;
    }

    @Override
    public void search() {
        System.out.println("[BellmanFord]");
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(bellmanFord(i)));
        }
    }
}