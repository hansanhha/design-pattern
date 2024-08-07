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

void insertAtHead(CNode** head, int data) {
    CNode* newNode = create(data);
    newNode->next = *head;
    *head = newNode;
}

void printList(CNode* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    CNode* current = head;

    while(current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }

    printf("NULL\n");
}

int main() {
    CNode* head = NULL;

    insertAtHead(&head, 1);
    insertAtHead(&head, 2);
    insertAtHead(&head, 3);
    insertAtHead(&head, 4);
    insertAtHead(&head, 5);

    printList(head);

    return 0;
}

