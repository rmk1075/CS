package Algorithm.Test;

import java.util.Arrays;
import java.util.Random;

import Algorithm.Graph.Graph;
import Algorithm.Graph.BFS.BFS;
import Algorithm.Graph.DFS.DFS;

public class GraphTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int N = rand.nextInt(8) + 2;
        boolean[][] map = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            int num = rand.nextInt(N - 1) + 1;
            int cnt = 0;
            while(cnt < num) {
                int j = rand.nextInt(N);
                if(i == j)
                    continue;

                map[i][j] = map[j][i] = true;
                cnt++;
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        
        Graph graph;
        int[] result;
        
        graph = new DFS(map);
        result = graph.search();
        System.out.println(Arrays.toString(result));

        graph = new BFS(map);
        result = graph.search();
        System.out.println(Arrays.toString(result));
    }
}
