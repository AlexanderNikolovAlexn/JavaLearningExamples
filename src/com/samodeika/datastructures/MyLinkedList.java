package com.samodeika.datastructures;

import java.util.AbstractList;
import java.util.ListIterator;


/*
 A class that implements a doubly linked list
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /** Create a new empty LinkedList */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Appends an element to the end of the list
     * @param element The element to add
     */
    public boolean add(E element)
    {
        add(this.size, element);
        return true;
    }

    /** Get the element at position index
     * @throws IndexOutOfBoundsException if the index is out of bounds. */
    public E get(int index)
    {
        return getElement(index).data;
    }

    private LLNode<E> getElement(int index)
    {
        if(this.size == 0 || index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range!");
        }

        LLNode<E> currElement = head;
        for (int i = 0; i < index; i++) {
            currElement = currElement.next;
        }

        return currElement;
    }

    /**
     * Add an element to the list at the specified index
     * @param The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element)
    {
        LLNode<E> newElement = new LLNode<>(element);
        if(this.size == 0 && index == 0) {
            this.head = newElement;
            this.tail = newElement;
        }
        else {
            if(index == this.size) {
                newElement.prev = this.tail;
                this.tail.next = newElement;
                this.tail = newElement;
            }
            else {
                LLNode<E> currElement = getElement(index);
                newElement.prev = currElement.prev;
                newElement.next = currElement;
                currElement.prev.next = newElement;
                currElement.prev = newElement;
            }
        }
        this.size++;
    }


    /** Return the size of the list */
    public int size()
    {
        return this.size;
    }

    /** Remove a node at the specified index and return its data element.
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     *
     */
    public E remove(int index)
    {
        LLNode<E> currElement = getElement(index);
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        if(currElement.next != null) {
            currElement.next.prev = currElement.prev;
        }
        else {
            this.tail = currElement.prev;
        }
        if(currElement.prev != null) {
            currElement.prev.next = currElement.next;
        }
        else {
            this.head = currElement.next;
        }
        this.size--;

        return currElement.data;
    }

    /**
     * Set an index position in the list to a new element
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element)
    {
        if(element == null) {
            throw new NullPointerException("You are trying to set the value to null");
        }
        LLNode<E> currElement = getElement(index);
        E oldValue = currElement.data;
        currElement.data = element;
        return oldValue;
    }
}

class LLNode<E>
{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E e)
    {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

}

