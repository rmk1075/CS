package Algorithm.Test;

import java.util.Arrays;
import java.util.Random;

import Algorithm.Graph.Graph;
import Algorithm.Graph.BFS.BFS;
import Algorithm.Graph.DFS.DFS;
import Algorithm.Graph.Dijkstra.Dijkstra;
import Algorithm.Graph.FloydWarshall.FloydWarshall;

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

        System.out.println("non weighted graph");
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
        
        Graph graph;
        
        graph = new DFS(map);
        graph.search();

        graph = new BFS(map);
        graph.search();

        int[][] weightedMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                weightedMap[i][j] = weightedMap[j][i] = rand.nextInt(100);
            }
        }

        System.out.println("-----------------------------------");
        System.out.println("weighted graph");
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(weightedMap[i]));
        }
        System.out.println();

        graph = new Dijkstra(weightedMap);
        graph.search();

        graph = new FloydWarshall(weightedMap);
        graph.search();
    }
}
