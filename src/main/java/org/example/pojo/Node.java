package org.example.pojo;

/* Node 節點*/
public class Node<T> {

    /* 本體資料 */
    T data ;

    /*上節點*/
    Node<T> prev;

    /**下節點*/
    Node<T> next;

}
