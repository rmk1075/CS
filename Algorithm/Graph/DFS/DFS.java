package Algorithm.Graph.DFS;

import Algorithm.Graph.Graph;

public class DFS implements Graph {

    private int N;

    private boolean[] visited;

    private boolean[][] graph;

    public DFS(boolean[][] graph) {
        N = graph.length;
        this.visited = new boolean[N];
        this.graph = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
    }

    private int dfs(int[] result, int index, int R) {
        for(int i = R; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!graph[i][j] || visited[j])
                    continue;
                visited[j] = true;
                result[index++] = j;
                index = dfs(result, index, j);
            }
        }
        return index;
    }

    @Override
    public int[] search() {
        int[] result = new int[N];
        result[0] = 0;
        visited[0] = true;
        dfs(result, 1, 0);
        return result;
    }
    
}
