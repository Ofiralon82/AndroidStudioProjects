package com.example.user.testapf.questions.linked_list;

import com.example.user.testapf.data_structures.linked_list.Node;

public class ReverseList
{
    public Node reverseList(Node A)
    {
        Node node = A;
        Node prev = null;

        while(true)
        {
            Node nextNode = node.next;
            node.next = prev;
            prev = node;

            if (nextNode == null)
            {
                break;
            }

            node = nextNode;
        }

        return node;
    }
}
