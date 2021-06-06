package Algorithm.Graph.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Algorithm.Graph.Graph;

public class BFS implements Graph {
    
    private int N;

    private boolean[] visited;

    private boolean[][] graph;

    public BFS(boolean[][] graph) {
        N = graph.length;
        this.visited = new boolean[N];
        this.graph = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
    }

    public void bfs(int[] result, int index, int R) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        visited[R] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i = 0; i < N; i++) {
                if(!graph[current][i] || visited[i])
                    continue;
                visited[i] = true;
                result[index++] = i;
                queue.offer(i);
            }
        }
    }

    @Override
    public void search() {
        int[] result = new int[N];
        result[0] = 0;
        visited[0] = true;
        bfs(result, 1, 0);

        System.out.println("[BFS]");
        System.out.println(Arrays.toString(result));
    }
}
