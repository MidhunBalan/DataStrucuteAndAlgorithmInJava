package com.dsandalgorithm.list;

public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data; // it can be any generic type
        private ListNode next;

        public ListNode(int data){
            this.data= data;
            this.next= null;
        }
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next= head;
        head= newNode;
    }

    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if(position ==1 ){
            node.next= head;
            head = node;
        }else {
            ListNode previous =head;
            int count = 1;
            while(count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current= previous.next;
            previous.next = node;
            node.next= current;
        }
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null !=current.next){
            current = current.next;
        }
        current.next = newNode;
    }

    public void display(ListNode headValue){
        ListNode current = headValue ==null? head: headValue;
        while(current !=null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }



    public int findLength(){
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current !=null){
            count++;
            current = current.next;
        }
        return count;
    }
    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next= null;
        return temp;
    }

    public ListNode deleteLast(){
        if(head ==null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous =null;

        while(current.next !=null){
            previous=current;
            current = current.next;
        }
        previous.next=null;
        return current;
    }

    public void delete(int position){
        if(position == 1){
            head= head.next;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position-1){
                previous= previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }
    public boolean find(ListNode head, int serchKey){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while(current !=null){
            if(current.data == serchKey){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current !=null){
            next= current.next;
            current.next= previous;
            previous= current;
            current= next;
        }
        return previous;
    }

    public ListNode getMiddleNode(){
        if(head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr !=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
    public ListNode getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n <= 0){
            throw new IllegalArgumentException("Invalid value : n = "+n);
        }
        ListNode mainPtr= head;
        ListNode refPtr = head;

        int count = 0;
        while(count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n +"is greater than the number of nodesin list");
            }
            refPtr= refPtr.next;
            count++;
        }
        while(refPtr !=null){
            refPtr = refPtr.next;
            mainPtr= mainPtr.next;
        }
        return mainPtr;
    }
    public void removeDuplicates(){
        if(head == null){
            return;
        }
        ListNode current= head;
        while(current !=null && current.next !=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

//    public static void main(String[] args) {
//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.head= new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);

    // We will connect the nodes together to form a chain
//        sll.head.next = second;
//        second.next = third;
//        third.next= fourth;
//
//        sll.insertLast(11);
//        sll.insertLast(8);
//        sll.insertLast(1);
//        sll.display();
//        System.out.println("Length is"+sll.findLength());
//    }
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(1, 3);
        sll.insert(2, 5);
        sll.insert(3, 3);
        sll.insert(1, 2);

        sll.insert(2, 4);
        sll.insert(2, 10);
        sll.insert(1, 2);
        sll.display(null);
//        sll.delete(2);
//        System.out.println(sll.deleteLast().data);
//        sll.display();
        if(sll.find(sll.head, 2)){
            System.out.println("Present");
        }else{
            System.out.println("Not present");
        }

//        ListNode reverseListHead = sll.reverse(sll.head);
//        sll.display(reverseListHead);
        ListNode middleNode= sll.getMiddleNode();
        System.out.println("MiddleNode is "+ middleNode.data);

        ListNode nthNode = sll.getNthNodeFromEnd(2);
        System.out.println("nth node from end is "+ nthNode.data);

        sll.removeDuplicates();
        sll.display(null);
    }
}
