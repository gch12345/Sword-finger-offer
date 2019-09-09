#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
//����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
//
//k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
//
//����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��

struct ListNode {
     int val;
     struct ListNode *next;
};


struct ListNode* reverseKGroup(struct ListNode* head, int k){
	if (head == NULL || k <= 1){
		return head;
	}
	struct ListNode*new_head = head;
	struct ListNode*p1 = head->next;
	int i = 1;
	for (; i<k; i++)
	{
		head = head->next;
		if (head == NULL)
			return new_head;
	}
	struct ListNode*p2 = new_head->next->next;
	struct ListNode*q = new_head;

	while (new_head != NULL) {
		i = 0;
		while (q != NULL&&k > i) {
			q = q->next;
			i++;
		}
		if (k > i){
			return head;
		}
		struct ListNode* end = q;
		int j = 0;
		if (q != NULL){
			for (; j<k - 1; j++)
			{
				if (end->next != NULL)
					end = end->next;
				else
					break;
			}
			if (j >= k - 1)
				new_head->next = end;
			else
				new_head->next = q;
		}
		else {
			new_head->next = q;
		}
		while (i > 1){
			p1->next = new_head;
			new_head = p1;
			p1 = p2;
			if (p2 != NULL)
				p2 = p2->next;
			i--;
		}
		if (q != NULL&&q->next != NULL){
			new_head = q;
			p1 = new_head->next;
			p2 = new_head->next->next;
		}
	}
	return head;
}

