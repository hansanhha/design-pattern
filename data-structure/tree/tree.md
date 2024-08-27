[트리](#트리)
- [용어](#용어)
- [특성](#특성)

[트리 종류](#트리-종류)

## 트리

[<img src="../images/tree.png" alt="tree">](https://xlinux.nist.gov/dads/HTML/tree.html)

트리는 **계층적 구조**를 표현하는 비선형 자료구조임

맨 위의 루트 노드를 시작으로 트리에 접근할 수 있는데, 루트 노드를 제외한 0개 이상의 노드들은 리프 노드이거나 내부 노드로 나뉨

### 용어

**노드**
- 트리의 기본 구성 요소
- 노드는 데이터를 포함할 수 있으며 다른 노드와 연결될 수 있음

**루트 노드**
- 트리의 시작점

**내부 노드(부모 노드)**
- 한 개 이상의 자식을 가지는 부모 노드
- 루트 노드와 리프 노드를 제외한 나머지 노드

**자식 노드**
- 부모를 가진 노드
- 같은 노드의 자식은 모두 형제 노드임

**리프 노드**
- 해당 간선의 끝 노드

**서브 트리**
- 트리를 이루는 작은 트리
- 각 노드는 자신을 루트로 하는 서브 트리를 가질 수 있음

**레벨 (해당 노드가 위치한 층 전체)**
- 같은 깊이를 가진 노드들의 집합
- 레벨0: 루트 노드
- 레벨1: 루트 노드의 모든 자식 노드들
- 레벨2: 레벨1의 모든 자식 노드들

**높이**
- 트리의 최대 레벨
- 루트 노드에서 가장 먼 리프 노드까지의 간선 수

**깊이 (개별 노드 위치)**
- 루트 노드에서 특정 노드까지의 간선 개수
- 루트 노드의 깊이: 0
- 루트 노드의 자식 노드의 깊이: 1
- 루트 노드에서 두 번째 자식 노드까지의 깊이: 2

**차수**
- 노드의 차수: 해당 노드가 가진 자식의 수
- 트리의 차수: 가장 높은 차수를 가진 노드의 차수

**경로**
- 한 노드에서 다른 노드까지의 노드 및 간선의 집합
- 경로의 길이는 노드 간의 간선 수로 정의됨

### 특성

파일 시스템, 조직도 등 같이 계층적인 관계를 표현하기 적합함

연결 리스트같은 선형적인 자료구조와 달리, 여러 개의 경로를 따라 데이터를 검색하고 저장할 수 있는 비선형 자료구조임

여러 방식으로 순회할 수 있음
- 전위 순회(preorder)
- 중위 순회(inorder)
- 후위 순회(postorder)
- 레벨 순회(level order)

트리는 방향성과 사이클이 없는 그래프(undirected, acyclic)의 일종임

노드 간의 연결(간선)이 있음(connected)

일반적으로 루트가 있고, 정렬되어 있음

## 트리 종류

### 일반 트리 (General Tree)

노드가 가질 수 있는 자식 노드의 수에 제한이 없는 트리

트리의 구조가 일정한 규칙에 의해 제한되지 않음

조직 구도나 파일 시스템 같은 계층적 구조를 표현할 때 사용

### 이진 트리 (Binary Tree)

각 노드가 최소 0개에서 최대 2개의 자식 노드를 가질 수 있는 트리

자식 노드는 왼쪽 노드과 오른쪽 노드로 구분됨

### 포화 이진 트리 (Full/Perfect Binary Tree)

[<img src="../images/full(perfect)-binary-tree.png" alt="full(perfect) binary tree">](https://medium.com/towards-data-science/5-types-of-binary-tree-with-cool-illustrations-9b335c430254)

포화 이진 트리(왼쪽)

모든 내부 노드가 자식 노드를 가지며, 모든 리프 노드가 동일한 깊이 또는 레벨을 가지는 이진 트리

### 완전 이진 트리 (Complete Binary Tree)

[<img src="../images/complete-binary-tree.png" alt="complete binary tree">](https://medium.com/towards-data-science/5-types-of-binary-tree-with-cool-illustrations-9b335c430254)

완전 이진 트리(왼쪽)

마지막 레벨을 제외하고 모든 레벨이 완전히 채워져 있으며, 마지막 레벨의 모든 노드는 가능한 왼쪽부터 채워지는 이진 트리

마지막 레벨 h에서 1부터 2^h - 1개까지의 리프 노드를 가질 수 있음

### 힙 (Heap)

완전 이진 트리의 일종으로 최대 힙과 최소 힙으로 구분됨

최대 힙: 부모 노드의 값이 자식 노드의 값보다 크거나 같음

최소 힙: 부모 노드의 값이 자식 노드의 값보다 작거나 같음

우선순위 큐나 힙 구조를 이용한 정렬 알고리즘을 구현할 수 있음

### 균형 이진 트리 (Balanced Binary Tree)

[<img src="../images/balanced-binary-tree.png" alt="balanced binary tree">](https://medium.com/towards-data-science/5-types-of-binary-tree-with-cool-illustrations-9b335c430254)

균형 이진 트리(왼쪽)

모든 노드의 왼쪽 서브트리와 오른쪽 서브트리의 높이 차이가 최대 1 이진 트리

자주 사용되는 균형 이진 트리의 종류로 AVL 트리와 Red-Black 트리가 있음

효율적인 데이터 삽입/삭제를 할 수 있음

### 이진 탐색 트리 (Binary Search Tree, BST)

[<img src="../images/binary-search-tree.png" alt="binary search tree">](https://www.geeksforgeeks.org/properties-of-binary-tree/)

이진 트리의 한 종류로, 각 노드의 왼쪽 서브 트리는 그 노드보다 작은 값을 가지고, 오른쪽 서브트리는 그 노드보다 큰 값을 가짐

효율적인 검색과 정렬된 데이터를 유지할 수 있음

### AVL 트리 (Adelson-Velsky and Landis Tree, AVL Tree)

[<img src="../images/AVL-tree.gif" alt="avl tree gif">](https://en.wikipedia.org/wiki/AVL_tree)

자가 균형 이진 탐색 트리의 일종으로 각 노드의 서브 트리의 높이 차이가 최대 1이 되도록 유지함

삽입과 삭제 시 트리의 균형을 맞추기 위해 회전(Rotation) 연산을 수행함

자주 변경되는 데이터베이스 인덱스를 관리하거나 높은 삽입과 삭제 빈도를 가진 검색 엔진에서 검색 속도를 최적화하기 위해 사용됨

### Red-Black 트리

[<img src="../images/red-black-tree.png" alt="red black tree" style="width:50%; height:50%;">](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)

또 다른 자가 균형 이진 탐색 트리의 일종으로, 노드는 빨간색 또는 검은색으로 칠하며 트리의 균형을 유지하기 위한 일종의 규칙을 따름

맵이나 셋 자료구조를 구현하는 데 사용됨 (자바의 TreeMap, TreeSet 등)

### B-Tree, B+Tree

디스크 기반 저장 시스템에서 디스크 I/O를 최소화하기 위해 설계된 트리 자료구조

데이터베이스 인덱스와 파일 시스템의 구조에 자주 사용됨

### 세그먼트 트리 (Segment Tree)

배열과 같은 연속된 데이터의 특정 구간에 대해 빠른 검색과 업데이트를 가능하게 하는 트리

구간 합, 구간의 최솟값과 최댓값을 빠르게 구해야 되거나, 범위 검색과 업데이트를 동시에 최적화할 때 사용됨

### 팬 윅 트리 (Fenwick Tree, Binary Indexed Tree)

세그먼트 트리보다 메모리 사용량이 적고 구현이 간단한 자료구조로, 배열의 누적 합 계산 및 업데이트를 빠르게 수행하는 트리

### 트라이 (Trie)

[<img src="../images/trie.png" alt="trie" style="width:50%; height:50%">](https://en.wikipedia.org/wiki/Trie)

문자열을 저장하고 효율적으로 검색하기 위한 트리 구조

각 노드는 문자열의 한 문자를 나타내며, 루트 노드에서 리프 노드까지의 한 경로가 문자열을 나타냄

단어 검색이나 네트워크 라우터에서 IP 주소를 빠르게 검색하고 결정할 때 사용됨