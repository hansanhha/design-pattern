[연결 리스트](#연결-리스트)

[연결 리스트 종류](#연결-리스트-종류)

[연결 리스트 기본 작업](#연결-리스트-기본-작업)
- [초기화](#초기화)
- [삽입](#삽입)
- [삭제](#삭제)
- [접근](#접근)
- [인덱스 찾기](#인덱스-찾기)

[배열과 비교](#배열과-비교)

[연결 리스트 사용처](#연결-리스트-사용처)

## 연결 리스트

**연결 리스트가 필요한 이유**

메모리 공간은 컴퓨터 시스템의 전체 프로그램이 공통적으로 사용하는 자원임

배열은 인접한 메모리 공간을 연속적으로 사용하는데, 되게 큰 데이터들을 담아야 될 경우에 그만한 인접 메모리 공간을 찾기 어려움

반면 연결 리스트는 배열과 같이 선형 자료구조에 속하지만, 실제로는 메모리를 분산해서 데이터를 저장하기 때문에 이런 상황에서 배열보다 효율적으로 메모리를 사용할 수 있음

**연결 리스트 구성 요소**

연결 리스트에 속한 요소를 "노드(node)"라고 함

각 노드는 자신의 "데이터(value)"와 다음 노드의 메모리 주소를 가리키는 "참조(references, pointer)"를 가짐

노드는 다음 노드의 주소를 알고 있으므로 인접한 메모리 공간의 필요가 없게 되지만, 배열에 비해 더 많은 메모리 공간을 필요로 함

맨 처음 노드를 head node, 맨 마지막 노드를 tail node라고 함

## 연결 리스트 종류

### 단일 연결 리스트 (Singly Linked List)

<img src="../images/Singly linked list.png" alt="단일 연결 리스트">

각 노드가 다음 노드의 주소만 알고 있는 연결 리스트

tail 노드의 포인터는 null 값을 가짐

한 방향으로만 이동이 가능하고, tail 노드가 순회의 끝임

### 이중 연결 리스트 (Doubly Linked List)

<img src="../images/Doubly linked list.png" alt="이중 연결 리스트">

각 노드가 이전 노드와 다음 노드의 주소를 알고 있는 연결 리스트

head 노드의 이전 노드 포인터 값(predecessor)과 tail 노드의 다음 노드 포인터는 null 값(successor)을 가짐

각 노드 간 양방향 이동이 가능하지만, 그 대신 더 많은 메모리를 사용함 

### 원형 연결 리스트 (Circular Linked List)

<img src="../images/Circularly linked list.png" alt="원형 연결 리스트">

단일 연결 리스트이면서, tail 노드가 head 노드에 연결되어 있는 연결 리스트

tail 노드의 포인터는 head 노드를 가리킴

한 방향으로만 이동이 가능하지만, tail 노드 방문 이후 다시 head 노드부터 순회를 돌 수 있음

### 원형 이중 연결 리스트 (Circular Doubly Linked List)

이중 연결 리스트이면서, head 노드와 tail 노드가 서로 연결되어 있는 연결 리스트

head 노드에서 tail 노드로 이동할 수 있음

어느 방향으로든지 이동 가능

## 연결 리스트 기본 작업

### 초기화

초기화는 두 단계로 이뤄짐

1. 노드 생성
2. 노드 간 참조 형성

배열은 인덱스를 통해서 값 자체에 바로 접근할 수 있지만, 노드는 하나의 객체이기에 참조를 통해 다음 노드에 접근할 수 있음

```c
// 단일 연결 리스트, 원형 연결 리스트 구조체
typedef struct CNode {
    int data;
    struct CNode* next;
} CNode;
```

```c
// 이중 연결 리스트, 원형 이중 연결 리스트 구조체
typedef struct DNode {
    int data;
    struct DNode* prev;
    struct DNode* next;
} DNode;
```

### 삽입

삽입할 위치를 알고 있는 경우에 `O(1)`의 시간 복잡도를 가짐

순회가 필요한 경우 최악으로 `O(n)` 시간 복잡도를 가짐

해당 위치에 근접한 노드들의 포인터만 바꾸면 됨

```c
// 단일 연결 리스트에서 head 노드에 새 노드를 삽입하는 함수
void insertAtHead(CNode** head, int data) {
    CNode* newNode = create(data);
    newNode->next = *head;
    *head = newNode;
}
```

위의 함수는 head에 새 노드를 넣고 새 head 노드가 기존의 head를 가리키게 함

새로운 노드를 생성한 뒤, 새 노드의 next가 head를 가리키게 함

그리고 head 노드를 새 노드로 변경함


```c
// 원형 연결 리스트에서 tail 노드에 새 노드를 삽입하는 함수
void insertAtTail(CNode** tail, int data) {
    CNode* newCNode = create(data);
    
    if (*tail == NULL) {
        *tail = newCNode;
        (*tail)->next = newCNode;
    } else {
        newCNode->next = (*tail)->next;
        (*tail)->next = newCNode;
        *tail = newCNode;
    }
}
```

위의 함수는 tail 노드에 새 노드를 넣고, 새 tail 노드가 head를 가리키게 함

tail 노드가 null인 경우 새 노드를 tail 노드로 하고,

아닌 경우 tail 노드의 next 값을 새 노드의 next에 넣은 다음 tail 노드의 next 값을 새 노드로 함

그리고 tail 노드를 새 노드로 지정함

```c
// 이중 연결 리스트에서 head 노드에 새 노드를 삽입하는 함수
void insertAtHead(DNode** head, int data) {
    DNode* newNode = create(data);
    (*head)->prev = newNode;
    newNode->next = *head;
    *head = newNode;
}
```

위의 함수는 head에 새 노드를 넣고 새 head 노드가 기존의 head를 가리키게 함

단일 연결 리스트와는 다르게 이전 노드의 포인터도 있기 때문에 기존 head의 prev 포인터를 새 노드로 지정함

### 삭제

삽입과 마찬가지로 위치를 알고 있는 경우엔 `O(1)`의 시간 복잡도를 가지고, 순회가 필요한 경우 `O(n)`의 시간 복잡도를 가짐

```c
// 단일 연결 리스트에서 head 노드를 삭제하는 함수
void deleteHead(Node** head) {
    Node* next = (*head)->next;
    *head = next;
}
```

단일 연결 리스트에서 head 노드를 삭제할 경우 head 노드의 다음 노드를 head로 지정함 (`O(1)`)

```c
// 단일 연결 리스트에서 특정 노드를 삭제하는 함수
void delete(Node** head, Node** node) {

    for (Node* prev = *head; prev->next != NULL; prev = prev->next) {
        if (prev->next == *node) {
            Node* delete = prev->next;
            prev->next = delete->next;
            free(delete);
        }
    }

}
```

반면 중간의 노드를 삭제해야 되는 경우 삭제할 노드의 이전 노드를 찾아서 next 값을 바꿔줘야 되므로 순회가 필요함(`O(n)`)

### 접근

배열은 랜덤 억세스가 가능하므로 모든 요소의 접근에 대해 `O(1)`의 시간 복잡도를 가짐

- 메모리를 연속적으로 사용하기 때문에 (배열 시작 위치 + 요소의 크기 x 인덱스 번호) 계산을 통해서 쉽게 해당 요소의 메모리 주소 위치에 접근할 수 있음

반면 연결 리스트의 각 요소는 메모리에 분산되어 저장되기 때문에 배열과 달리 랜덤 억세스가 불가능함

특정 인덱스에 위치한 노드에 접근하기 하려면 head 또는 tail 노드부터 해당 인덱스 전까지 순회가 필요함 `O(n)`의 시간 복잡도를 가짐

```c
// 단일 연결 리스트에서 주어진 인덱스에 위치한 노드를 반환하는 함수
Node* get(Node** head, int index) {
    Node* current = *head;
    
    for (int i = 0; i < index; ++i) {
        if (current == NULL) {
            return NULL;
        }
        current = current->next;
    }

    return current;
}
```

### 인덱스 찾기

특정 값을 가지고 있는 노드를 찾는 작업 역시 접근과 마찬가지로 연결 리스트의 특성 상 순회가 필요함 (`O(n)`)

```c
// 단일 연결 리스트에서 인자로 주어진 값의 노드 위치를 반환하는 함수
int find(Node** head, int value) {
    Node* current = *head;
    int index = 0;

    while (current != NULL) {
        if (current->data == value) {
            return index;
        }
        current = current->next;
        index++;
    }

    return -1;
}
```

## 배열과 비교

|                              |             Array             |    Linked List    |
|:----------------------------:|:-----------------------------:|:-----------------:|
|         저장(Storage)          |          연속된 메모리 공간           |    분산된 메모리 공간     |
|  용량 확장(Capacity Expanstion)  |       고정 길이 (용량 확장 불가)        |      유연한 확장       |
|  메모리 효율(Memory Efficiency)   | 요소 당 적은 메모리 사용, 공간 낭비 가능성 있음  | 요소 당 더 많은 메모리 필요  |
|  요소 접근(Accessing Elements)   |            `O(1)`             |      `O(n)`       |
|    요소 삽입(Adding Elements)    |        `O(1)`, `O(n)`         |  `O(1)`, `O(n)`   |
|   요소 제거(Deleting Elements)   |            `O(n)`             |  `O(1)`, `O(n)`   |

## 연결 리스트 사용처

### 단일 연결 리스트

**스택, 큐**

삽입, 삭제가 특정 부분에서만 이뤄지는 자료구조이기 때문에 단일 연결 리스트로 구현하면 효율적인 작업 가능

스택 - FILO

큐 - FIFO

**해시 테이블**

해시 충돌 시 충돌 된 요소들은 단일 연결 리스트로 그룹화

**그래프**

그래프의 인접 목록을 표현하는 데 기본적으로 사용됨

각 정점(vertex)은 연결 리스트로 구성되어 연결된 다른 정점들을 가지고 있음

### 이중 연결 리스트 

**red-black tree, b-tree**

**브라우저 히스토리**

**LRU algorithm**

### 원형 연결 리스트

os의 리소스 스케줄링 같이 주기적인 작업이 필요한 곳에서 원형 연결 리스트가 적합함

**round-robin 스케줄링 알고리즘**

각 프로세스에게 시간을 분배해서 할당하고, 시간이 만료되면 CPU는 다음 프로세스를 실행시키는 주기적인 작업을 하는 알고리즘으로 

원형 연결 리스트를 통해 구현할 수 있음

**data buffers**