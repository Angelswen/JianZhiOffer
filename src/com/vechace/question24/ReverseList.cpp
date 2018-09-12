#include <iostream>

using namespace std;

struct ListNode
{
    int val;
    ListNode* next;
};

ListNode* ReverseList(ListNode* pHead)
{
    ListNode* pReversedHead = nullptr;
    ListNode* pNode = pHead;
    ListNode* pPrev = nullptr;

    while(pNode!=nullptr)
    {
        ListNode* pNext = pNode->next;

        if(pNext == nullptr)
        {
            pReversedHead = pNode;
        }

        pNode->next = pPrev;
        pPrev = pNode;
        pNode = pNext;
    }
    return pReversedHead;
}

int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
