package Algorithm.Graph.FloydWarshall;

import java.util.Arrays;

import Algorithm.Graph.Graph;

public class FloydWarshall implements Graph {
    
    private int N;

    private int[][] graph;

    public FloydWarshall(int[][] graph) {
        N = graph.length;
        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
    }

    private void floydWarshall() {
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(graph[i][j] < graph[i][k] + graph[k][j]) continue;
                    graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }

    @Override
    public void search() {
        floydWarshall();

        System.out.println("Floyd-Warshall");
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
