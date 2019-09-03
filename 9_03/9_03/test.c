#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
	assert(head != NULL);
	struct ListNode*p1 = head;
	struct ListNode*p2 = head;
	struct ListNode*p = head;
	for (int i = 0; i < n; i++)
	{
		p2 = p2->next;
		if (p2 == NULL)
		{
			head = head->next;
			return head;
		}
	}
	while (p2 != NULL)
	{
		p = p1;
		p1 = p1->next;
		p2 = p2->next;
	}
	p->next = p1->next;
	return head;
}
