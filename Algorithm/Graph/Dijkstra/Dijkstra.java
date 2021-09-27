package Algorithm.Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

import Algorithm.Graph.Graph;

public class Dijkstra implements Graph {

    private int N;

    private boolean[] visited;

    private int[][] graph;

    private PriorityQueue<Node> pq;

    public Dijkstra(int[][] graph) {
        N = graph.length;
        this.visited = new boolean[N];
        this.graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                this.graph[i][j] = graph[i][j];
            }
        }
        pq = new PriorityQueue<>();
    }

    // src: 출발점의 인덱스
    private int[] dijkstra(int src) {
        int[] distance = new int[N]; // src로부터 다른 정점들까지의 최단 거리를 저장하는 배열
        for(int i = 0; i < N; i++) {
            if(i == src) continue;
            distance[i] = Integer.MAX_VALUE;
            pq.add(new Node(i, distance[i]));
        }
        distance[src] = 0;
        pq.add(new Node(src, 0));   // Node(정점의 인덱스, 정점의 최단거리)

        while(!pq.isEmpty()) {
            // priority queue에서 현재 최단 거리를 가지고 있는 정점을 구한다.
            Node node = pq.poll();
            if(visited[node.index])
                continue;
            
            // 미방문 정점인 경우 방문으로 바꾼 후 해당 정점과 인접한 정점들에 대해 거리를 계산, 비교한다.
            visited[node.index] = true;
            for(int i = 0; i < N; i++) {
                if(visited[i] || distance[i] < distance[node.index] + graph[node.index][i])
                    continue;
                distance[i] = distance[node.index] + graph[node.index][i];
                pq.add(new Node(i, distance[i]));
            }
        }

        return distance;
    }

    @Override
    public void search() {
        System.out.println("[Dijkstra]");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) visited[j] = false;
            System.out.println(Arrays.toString(dijkstra(i)));
        }
    }
    
    private class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
