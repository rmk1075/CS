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
        // 모든 정점이 한번씩 중간 경로가 되게 한다.
        for(int k = 0; k < N; k++) {
            // 그래프 내에서 될 수 있는 모든 정점 쌍 (i, j)를 구한다.
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 현재 (i, j)의 최단 거리와 k를 중간경로로 한 거리를 비교한다.
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
