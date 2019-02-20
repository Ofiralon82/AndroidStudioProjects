package com.example.user.testapf.questions.linked_list;

import com.example.user.testapf.data_structures.linked_list.Node;

public class RemoveNthFromEnd
{
    public Node removeNthFromEnd(Node A, int B)
    {
        Node result1 = A;
        Node result2 = A;
        int length = 0;
        while (A != null)
        {
            length++;
            A = A.next;
        }

        if (B >= length)
        {
            result1 = result1.next;
            return result1;
        }

        int index = 1;
        while (result1 != null)
        {
            if (index + 1 == length - B + 1)
            {

                result1.next = result1.next.next;
                break;
            }

            index++;
            result1 = result1.next;
        }

        return result2;
    }
}
