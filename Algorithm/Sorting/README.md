# Sorting Algorithms

1. Bubble Sort

    - 인접한 두 개의 데이터를 서로 비교해가면서 정렬을 진행하는 방법

    - space complexity: O(1)

    - time complexity: O(N^2)

2. Counting Sort

    - 원소들 중 가장 큰 값을 기준으로 배열을 만들고 각 값에 해당하는 원소의 개수를 세어서 정렬하는 방법

    - space complexity: O(N)

    - time complexity: O(N)

3. Heap Sort

    - binary heap 구조를 사용하여 정렬하는 방법. heap 구조를 만들고 root 값을 추출해서 위치시킨 후 heapify 를 진행해서 다시 heap 구조를 유지한다.

    - space complexity: O(1)

    - time complexity: O(N log N)

        - insert / delete: O(log N)

        - N개의 데이터에 대해서 O(N log N)

4. Insertion Sort

    - 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여 자신의 위치를 찾아 삽입하여 정렬한다.

    - space complexity: O(1)

    - time complexity: O(N^2)

5. Merge Sort

    - 배열을 더이상 나누어지지 않을 때까지 분할한 후 각 조각들을 비교하여 결합하면서 정렬하는 방법.

    - space complexity: O(N)

    - time complexity: O(N log N)

6. Quick Sort

    - divide and conquer 기반의 정렬 방법으로 divide 시에 기준 값이 되는 pivot 을 두어서 pivot 보다 작은 값은 왼쪽에, pivot 보다 큰 값은 오른쪽에 위치하도록 정렬한 후 pivot 을 기준으로 좌측과 우측의 배열들을 각각 quick sort를 반복해서 정렬한다.

    - space complexity: O(log N)

    - time complexity: O(N log N)

        - worst case: O(N^2) - 역으로 정렬되어 있는 경우

7. Selection Sort

    - 정렬시에 값이 아닌 배열에서의 인덱스를 저장해서 값을 비교하고 비교가 끝나면 저장된 인덱스를 통해서 값을 변경하여 정렬한다.

    - space complexity: O(1)

    - time complexity: O(N^2)
