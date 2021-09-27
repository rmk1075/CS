package Algorithm.Graph.Prim;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import Algorithm.Graph.Graph;

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}

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

    private int[][] primList() {
        List<Node>[] graphLists = new LinkedList[N];
        for(int i = 0; i < N; i++) {
            graphLists[i] = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                if(this.graph[i][j] == Integer.MAX_VALUE) continue;
                graphLists[i].add(new Node(j, this.graph[i][j]));
            }
        }

        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                result[i][j] = result[j][i] = -1;
            }
        }

        Node[] v = new Node[N];
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) {
            v[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        v[0].weight = 0;
        parent[0] = 0;
        visited[0] = true;

        TreeSet<Node> queue = new TreeSet<Node>(new NodeComparator());
        for(int i = 0; i < N; i++) queue.add(v[i]);

        while(!queue.isEmpty()) {
            Node node = queue.pollFirst();
            visited[node.vertex] = true;
            result[parent[node.vertex]][node.vertex] = result[node.vertex][parent[node.vertex]] = v[node.vertex].weight;
            this.weight += v[node.vertex].weight;

            for(Node next : graphLists[node.vertex]) {
                if(visited[next.vertex] || v[next.vertex].weight <= next.weight) continue;
                queue.remove(v[next.vertex]);
                v[next.vertex].weight = next.weight;
                queue.add(v[next.vertex]);
                parent[next.vertex] = node.vertex;
            }
        }

        return result;
    }

    @Override
    public void search() {
        // graph = prim();
        graph = primList();

        System.out.println("[Prim]");
        System.out.println("weight of MST: " + weight);
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
