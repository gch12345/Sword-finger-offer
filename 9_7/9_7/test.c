#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
struct ListNode {
	int val;
    struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head){
	assert(head != NULL);
	head = head->next;
	struct ListNode* new_head = head;
	struct ListNode* p = head->next;
	struct ListNode* q = p->next;
	while (p != NULL){
		new_head->next = q->next;
		p->next = new_head;
		new_head = q;
		p = new_head->next;
		if (p == NULL){
			q = NULL;
		}
		else{
			q = p->next;
		}
	}
	return head;
}