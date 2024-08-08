#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* create(int data) {
    Node* newNode = (Node*) malloc(sizeof(Node));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }

    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertAtHead(Node** head, int data) {
    Node* newNode = create(data);
    newNode->next = *head;
    *head = newNode;
}

void deleteHead(Node** head) {
    Node* next = (*head)->next;
    *head = next;
}

void delete(Node** head, Node** node) {

    for (Node* prev = *head; prev->next != NULL; prev = prev->next) {
        if (prev->next == *node) {
            Node* delete = prev->next;
            prev->next = delete->next;
            free(delete);
        }
    }
}

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

void printList(Node* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    Node* current = head;

    while(current != NULL) {
        if (current->next != NULL) {
            printf("%d -> ", current->data);
        } else {
            printf("%d", current->data);
        }
        current = current->next;
    }

    printf("\n");
}

int main() {
    Node* head = NULL;

    insertAtHead(&head, 5);
    insertAtHead(&head, 4);
    insertAtHead(&head, 3);
    insertAtHead(&head, 2);
    insertAtHead(&head, 1);

    printf("=====Original SinglyLinkedList======\n");
    printList(head);

    printf("=====Locating Target Value Index======\n");
    int index = find(&head, 4);
    printf("%d\n", index);

    printf("=====Third Node======\n");
    Node* thirdNode = get(&head, 2);
    printf("%d\n", thirdNode->data);
    
    printf("=====Delete Head Node======\n");
    deleteHead(&head);
    printList(head);

    printf("=====Delete Second Node======\n");
    Node* secondNode = get(&head, 1);
    delete(&head, &secondNode);
    printList(head);

    return 0;
}

