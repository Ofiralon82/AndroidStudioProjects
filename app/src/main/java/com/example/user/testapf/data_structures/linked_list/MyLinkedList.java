package com.example.user.testapf.data_structures.linked_list;

public class MyLinkedList<T>
{
    public MyLinkedList(T value)
    {
        first = new Node(value, null);
        last = first;
    }

    public Node first;
    private Node last;

    public void add(T value)
    {
        Node node = new Node(value, null);
        last.next = node;
        last = node;
    }

    public String print()
    {
        Node temp = first;
        String y = "";
        while(temp != null)
        {
            y += "   " + temp.value;
            temp = temp.next;
        }

        return y;
    }

//    MyLinkedList list = new MyLinkedList(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);


}
