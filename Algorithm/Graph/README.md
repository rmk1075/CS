# Graph Algorithms

1. BFS

2. DFS

3. Dijkstra

    - 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단거리를 각각 구하는 알고리즘

    - time complexity: O((V + E) log V)

        - 각 노드마다 미방문 노드 중 출발점으로부터 현재까지 계산된 최단 거리를 가지는 노드를 찾는데 걸리는 시간: O(V log V)

        - 각 노드마다 이웃한 노드의 최단 거리를 갱신하는 시간: O(E log V)

4. Floyd-Warshall

    - 변의 가중치가 음이거나 양인 가중 그래프에서 최단 경로들을 찾는 알고리즘

    - time complexity: O(V^3)

5. Kruskal

    - 가중치가 작은 Edge부터 선택하여 MST를 구하는 알고리즘

    - time complexity: O(E log V)
