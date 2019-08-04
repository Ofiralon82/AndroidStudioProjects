package com.example.user.testapf.data_structures.linked_list.udemy_linked_list_task;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

//    public void IntegerLinkedList()
//    {
//        Integer one = 1;
//        Integer two = 2;
//        Integer three = 3;
//        Integer four = 4;
//
////        IntegerLinkedList list = new IntegerLinkedList();
//        list.insertSorted(three);
//        list.printList();
//        list.insertSorted(two);
//        list.printList();
//        list.insertSorted(one);
//        list.printList();
//        list.insertSorted(four);
//        list.printList();
//    }

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
	    size++;
	    IntegerNode newNode = new IntegerNode(value);
	    if (head == null)
        {
            head = newNode;
            return;
        }

//	    if (size - 1 == 1)
//        {
//            if (head.getValue() > value)
//            {
//                IntegerNode ttemp = head;
//                head = newNode;
//                head.setNext(ttemp);
//            }
//            else
//            {
//                head.setNext(newNode);
//            }
//            return;
//        }

	    IntegerNode temp = head;
	    IntegerNode prevNode = null;

	    while (temp != null) {
		    if (value < temp.getValue()) {
			    if (prevNode == null) {
				    head = newNode;
				    head.setNext(temp);
			    } else {
				    prevNode.setNext(newNode);
				    newNode.setNext(temp);
			    }
			
			    return;
		    }

		    prevNode = temp;
		    temp = temp.getNext();
	    }

	    prevNode.setNext(newNode);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
