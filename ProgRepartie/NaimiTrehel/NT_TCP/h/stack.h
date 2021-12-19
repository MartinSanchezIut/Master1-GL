#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <sys/time.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>
#include <time.h>
 
typedef struct Stack Stack;

struct Stack {
    int top;
    int capacity;
    struct sockaddr_in* array;
};
 
struct Stack* createStack(unsigned capacity){
    struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
    stack->capacity = capacity;
    stack->top = -1;
    stack->array = (struct sockaddr_in*)malloc(stack->capacity * sizeof(struct sockaddr_in));
    return stack;
}
 
// Stack is full when top is equal to the last index
int isFull(struct Stack* stack){
    return stack->top == stack->capacity - 1;
}
// Stack is empty when top is equal to -1
int isEmpty(struct Stack* stack){
    return stack->top == -1;
}
 
// Function to add an item to stack.  It increases top by 1
void push(struct Stack* stack, struct sockaddr_in item){
    if (isFull(stack))
        return;
    stack->array[++stack->top] = item;
}
 
// Function to remove an item from stack.  It decreases top by 1
struct sockaddr_in pop(struct Stack* stack){
    return stack->array[stack->top--];
}

// Function to print a stack
void print_stack(struct Stack* stack){
    if (isEmpty(stack)) {
        printf("Empty stack \n") ;
    }else {
        for(int i = stack->top; i >= 0; i--) {
            struct sockaddr_in val = stack->array[i] ;
            printf("%s : %d |", inet_ntoa(val.sin_addr), ntohs(val.sin_port) ) ;
        }
        printf("\n") ;
    }
}