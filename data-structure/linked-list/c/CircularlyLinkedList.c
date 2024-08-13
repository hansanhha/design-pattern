#include <stdio.h>
#include <stdlib.h>

typedef struct CNode {
    int data;
    struct CNode* next;
} CNode;

CNode* create(int data) {
    CNode* newNode = (CNode*) malloc(sizeof(CNode));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }

    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertAtHead(CNode** head, CNode** tail, int data) {
    CNode* newNode = create(data);
    newNode->next = *head;
    *head = newNode;
    (*tail)->next = newNode;
}

void insertAtTail(CNode** tail, int data) {
    CNode* newNode = create(data);

    if (*tail == NULL) {
        *tail = newNode;
        (*tail)->next = newNode;
    } else {
        newNode->next = (*tail)->next;
        (*tail)->next = newNode;
        *tail = newNode;
    }
}

void printList(CNode* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    CNode* current = head;

    do {
        printf("%d -> ", current->data);
        current = current->next;
    } while (current!= head);

    printf("NULL\n");
}

int main() {
    CNode* head = create(5);
    CNode* tail = create(6);
    head->next = tail;
    tail->next = head;

    insertAtHead(&head, &tail, 4);
    insertAtHead(&head, &tail, 3);
    insertAtHead(&head, &tail, 2);
    insertAtHead(&head, &tail, 1);
    insertAtTail(&tail, 7);
    insertAtTail(&tail, 8);
    insertAtTail(&tail, 9);
    insertAtTail(&tail, 10);

    printList(head);


    printList(head);

    return 0;
}