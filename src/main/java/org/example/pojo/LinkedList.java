package org.example.pojo;

import java.util.Optional;

/**LinkedList*/
public class LinkedList<T> {

    Node<T> top;
    Node<T> bottom;

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;

        if(null == top) {
            this.top = node;
            this.bottom = node;
            return;
        }

        node.prev = this.bottom;
        this.bottom.next = node;
        this.bottom = node;

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
                return;
            }

            if(null == currNode.next) {
                this.bottom = currNode.prev;
                this.bottom.next = null;
                return;
            }

            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            return;
        }
    }

}
