자료구조는 크게 데이터(요소) 간의 논리적 관계에 따라 유형을 나눔

### 선형(Linear) 자료구조

요소가 순차적으로 정렬되어 있는 자료구조

- [Array](./array,%20list/array.md)
- [LinkedList (Singly, Doubly, Circular)](./array,%20list/linkedlist.md)
- Stack
- Queue
- [HashTable](./hash%20table(hash%20map)/hash%20table.md)

### 비선형(Non-Linear) 자료구조

순차적으로 요소를 저장하지 않고, 고유의 방식으로 요소 간의 관계를 정의한 자료구조

트리는 조상, 자손 간의 관계를 위에서 아래로 계층적으로 관리하고

그래프는 네트워크 관계를 반영한 노드와 엣지로 구성된 자료구조임

- [Tree (Directed, Undirected, Weighted, Unweighted)](./tree/tree.md)
- Heep (Min Heap, Max Heap)
- Priority Queue
- Trie
- Graph

### 메모리 사용

자료구조의 유형이 선형/비선형으로 나뉘듯

물리적인 메모리에 데이터를 저장 유형을 인접형/분산형으로 나눔

<img src="./images/contigous-dispersed physical memory structure.png" alt="인접형, 분산형 물리적 메모리 구조" />>

**인접형(배열)**

인접한 메모리에 데이터를 순차적으로 나열

알고리즘의 최대 메모리 사용량이 시스템의 여유 메모리를 초과하면 안됨

연속된 메모리 블록이 부족한 경우 분산형으로 데이터를 저장할 필요가 있음

**분산형(연결 리스트)**

메모리에 데이터를 분산해서 저장

데이터가 저장된 메모리 주소를 가리키는 별도의 포인터가 있음

모든 자료구조(스택, 큐, 해시 테이블, 트리, 힙, 그래프)의 구현은 배열과 연결 리스트를 기반으로 함

[참고](https://medium.com/@nirajranasinghe/from-bits-to-brilliance-essential-algorithms-and-data-structures-for-computer-science-enthusiasts-960a87aa001)

[참고](https://www.hello-algo.com/en/chapter_data_structure/classification_of_data_structure/#312-physical-structure-contiguous-and-dispersed)