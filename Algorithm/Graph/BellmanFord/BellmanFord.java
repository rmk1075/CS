package Algorithm.Graph.BellmanFord;

import java.util.Arrays;

import Algorithm.Graph.Graph;

public class BellmanFord implements Graph {

    private int N;

    private int[][] graph;

    public BellmanFord(int[][] graph) {
        N = graph.length;
        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
         }
    }

    private int[] bellmanFord(int src) {
        int[] shortest = new int[N];
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) shortest[i] = Integer.MAX_VALUE;
        shortest[src] = 0;

        boolean isChanged = true;
        while(isChanged) {
            isChanged = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int x = src + i < N ? src + i : src + i - N;
                    int y = src + j < N ? src + j : src + j - N;
                    if(shortest[x] + graph[x][y] < shortest[y]) {
                        shortest[y] = shortest[x] + graph[x][y];
                        parent[y] = x;
                        isChanged = true;
                    }
                }
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