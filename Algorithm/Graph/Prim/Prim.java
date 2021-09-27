package Algorithm.Graph.Prim;

import java.util.Arrays;

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

    // 아직 MST에 포함되지 않은 정점 중 최단 거리의 정점을 찾는다.
    private int find(int[] vertices) {
        int vertex = -1;
        int minWeight = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(vertices[i] < minWeight) {
                minWeight = vertices[i];
                vertex = i;
            }
        }

        return vertex;
    }

    private int[][] prim() {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                result[i][j] = result[j][i] = -1;
            }
        }

        // 각 정점의 연결 상태를 저장하는 배열
        int[] parent = new int[N];
        parent[0] = 0;

        // 각 정점들의 최소 거리
        int[] vertices = new int[N];
        // 첫번째 노드를 제외하고는 INF로 초기화
        for(int i = 1; i < N; i++) vertices[i] = Integer.MAX_VALUE;

        int count = 0;
        while(count++ < N) {
            int vertex = find(vertices);
            visited[vertex] = true;
            result[parent[vertex]][vertex] = result[vertex][parent[vertex]] = vertices[vertex];
            this.weight += vertices[vertex];

            // 새로 추가되는 정점과 인접한 정점 중 아직 포함되지 않은 정점들에 대해 weight를 업데이트 한다.
            for(int i = 0; i < N; i++) {
                if(graph[vertex][i] == Integer.MAX_VALUE || visited[i] || vertices[i] < graph[vertex][i]) continue;
                vertices[i] = graph[vertex][i];
                parent[i] = vertex;
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
}
