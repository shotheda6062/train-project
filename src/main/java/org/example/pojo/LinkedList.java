package org.example.pojo;

import java.util.Optional;

/**LinkedList*/
public class LinkedList<T> {

    private Node<T> top;
    private Node<T> bottom;
    private int count;

    public int size() {
        return this.count;
    }

    public Node<T> getFirst() {
        return this.top;
    }

    public Node<T> getLast() {
        return this.bottom;
    }

    public void addBefore(Node<T> node, T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        newNode.prev = node.prev;
        newNode.next = node;

        if (node.prev != null) {
            node.prev.next = newNode;
        } else {
            top = newNode;
        }

        node.prev = newNode;
        count++;
    }

    public void addAfter(Node<T> node, T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        newNode.prev = node;
        newNode.next = node.next;

        if (node.next != null) {
            node.next.prev = newNode;
        } else {
            bottom = newNode;
        }

        node.next = newNode;
        count++;
    }


    public void addFirst(T data) {
        Node<T> node = new Node<>();
        node.data = data;

        if(null == top) {
            this.top = node;
            this.bottom = node;
            count++;
            return;
        }

        this.top.prev = node;
        node.next = this.top;
        this.top = node;
        count++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>();
        node.data = data;

        if(null == top) {
            this.top = node;
            this.bottom = node;
            count++;
            return;
        }

        node.prev = this.bottom;
        this.bottom.next = node;
        this.bottom = node;
        count++;

    }

    public void removeFirst() {
        this.top = this.top.next;
        this.top.prev = null;
        count--;
    }

    public void removeLast() {
        this.bottom = this.bottom.prev;
        this.bottom.next = null;
        count--;
    }

    public void remove(Node<T> node) {

        Node<T> currNode = this.top;

        //從頂部開始走訪
        while (currNode != null) {

            if(!currNode.equals(node)) {
                currNode = currNode.next;
                continue;
            }

            if(null == currNode.prev) {
                this.top  = currNode.next;
                if(this.top != null) {
                    this.top.prev = null;
                }
                count--;
                return;
            }

            if(null == currNode.next) {
                this.bottom = currNode.prev;
                this.bottom.next = null;
                count--;
                return;
            }

            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            count--;
            return;
        }
    }

}
