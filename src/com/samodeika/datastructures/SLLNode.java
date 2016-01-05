package com.samodeika.datastructures;

public class SLLNode<E> {

    SLLNode<E> next;
    E data;

    public SLLNode() {
        this.next = null;
        this.data = null;
    }

    public SLLNode(E data) {
        this.data = data;
    }

    public SLLNode(E data, SLLNode<E> prevNode) {
        this(data);
        this.next = prevNode.next;
        prevNode.next = this;
    }

}
