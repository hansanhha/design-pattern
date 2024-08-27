#include <stdio.h>
#include <stdlib.h>

typedef struct DNode {
    int data;
    struct DNode* prev;
    struct DNode* next;
} DNode;

DNode* create(int data) {
    DNode* newNode = (DNode*) malloc(sizeof (DNode));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }

    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

void insertAtHead(DNode** head, int data) {
    DNode* newNode = create(data);
    (*head)->prev = newNode;
    newNode->next = *head;
    *head = newNode;
}

void insertAtTail(DNode** tail, int data) {
    DNode* newNode = create(data);
    (*tail)->next = newNode;
    newNode->prev = *tail;
    *tail = newNode;
}

void printList(DNode* head, DNode* tail) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    DNode* current = head;

    do {
        printf("%d -> ", current->data);
        current = current->next;
    } while (current != NULL);

    printf("NULL\n");

    current = tail;

    do {
        printf("%d -> ", current->data);
        current = current->prev;
    } while (current != NULL);

    printf("NULL\n");
}

int main() {
    DNode* head = create(5);
    DNode* tail = create(6);
    head->next = tail;
    tail->prev = head;

    insertAtHead(&head, 4);
    insertAtHead(&head, 3);
    insertAtHead(&head, 2);
    insertAtHead(&head, 1);
    insertAtTail(&tail, 7);
    insertAtTail(&tail, 8);
    insertAtTail(&tail, 9);
    insertAtTail(&tail, 10);

    printList(head, tail);

    return 0;
}

