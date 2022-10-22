package AddTwoNumRepresentedLinkedlist.LinkedListsUsingStack;

// Java program to add two numbers represented by Linked
// Lists using Stack

import java.util.Stack;

public class Linkedlist {
    static Node headOne, headTwo;

    static class Node {
        int data;
        Node next;

        public Node(int k) {
            data = k;
            next = null;
        }
    }

    // function that calculates and prints the sum of two numbers represented by
    // linked lists
    static void addTwoLists(Node listOne, Node listTwo) {
        Node prev = null;

        // Create 3 stacks
        Stack<Node> stackOne = new Stack<>();
        Stack<Node> stackTwo = new Stack<>();
        Stack<Node> stackThree = new Stack<>();

        // Fill first stack with first list Elements
        while (listOne != null) {
            stackOne.add(listOne);
            listOne = listOne.next;
        }

        // Fill second stack with second list Elements
        while (listTwo != null) {
            stackTwo.add(listTwo);
            listTwo = listTwo.next;
        }
        int carry = 0;

        // Fill the third stack with the sum of first and second stack
        while (!stackOne.isEmpty() && !stackTwo.isEmpty()) {
            int sum = stackOne.peek().data + stackTwo.peek().data + carry;
            Node temp = new Node(sum % 10);
            stackThree.add(temp);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            stackOne.pop();
            stackTwo.pop();
        }
        while (!stackOne.isEmpty()) {
            int sum = carry + stackOne.peek().data;
            Node temp = new Node(sum % 10);
            stackThree.add(temp);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            stackOne.pop();
        }
        while (!stackTwo.isEmpty()) {
            int sum = carry + stackTwo.peek().data;
            Node temp = new Node(sum % 10);
            stackThree.add(temp);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            stackTwo.pop();
        }

        // If carry is still present create a new node with value 1 and push it to the
        // third stack.
        if (carry == 1) {
            Node temp = new Node(1);
            stackThree.add(temp);
        }

        // Link all the elements inside third stack with each other.
        if (!stackThree.isEmpty()) {
            prev = stackThree.peek();
        }
        while (!stackThree.isEmpty()) {
            Node temp = stackThree.peek();
            stackThree.pop();
            if (stackThree.size() == 0) {
                temp.next = null;
            } else {
                temp.next = stackThree.peek();
            }
        }
        printlist(prev);
    }

    // Utility function to print a linked list.
    static void printlist(Node head) {
        while (head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    // Driver Code.
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        // creating the first list.
        list.headOne = new Node(7);
        list.headOne.next = new Node(5);
        list.headOne.next.next = new Node(9);
        list.headOne.next.next.next = new Node(4);
        list.headOne.next.next.next.next = new Node(6);
        System.out.println("First List : ");
        list.printlist(headOne);

        // creating second list.
        list.headTwo = new Node(8);
        list.headTwo = new Node(4);
        System.out.println("Second List :");
        list.printlist(headTwo);
        System.out.println("Sum list :");

        // adding the two linked lists and see the result
        list.addTwoLists(headTwo, headOne);
    }
}
