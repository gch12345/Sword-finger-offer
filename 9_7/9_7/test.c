#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
struct ListNode {
	int val;
    struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head){
	if (head == NULL || head->next == NULL)
		return head;
	struct ListNode* new_head = head;
	struct ListNode* p = head->next;
	struct ListNode* q = p->next;
	head = head->next;
	while (q != NULL){
		if (q->next == NULL){
			new_head->next = q;
		}
		else{
			new_head->next = q->next;
		}
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
	if (new_head->next != NULL){
		p->next = new_head;
		new_head->next = NULL;
	}
	return head;
}