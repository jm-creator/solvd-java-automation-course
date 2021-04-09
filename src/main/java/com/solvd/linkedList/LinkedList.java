package com.solvd.linkedList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.log4j.Logger;


public class LinkedList<T> implements Iterable<T>{
    private static final Logger LOGGER = Logger.getLogger(LinkedList.class);
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(Node<T> node) {
        this.head = node;
        this.tail = node;
    }

    public LinkedList() {
        head = new Node<>();
        tail = head;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (Objects.isNull(head.getData())) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }


    public void add(int index, T data) {
        Node<T> temp = head;
        int count = 0;
        while (Objects.nonNull(temp)) {
            if (count == index) {
                Node<T> newNode = new Node<>(data);
                temp.getPrev().setNext(newNode);
                temp.setPrev(newNode);
                newNode.setPrev(temp.getPrev());
                newNode.setNext(temp);
                break;
            }
            temp = temp.getNext();
            count ++;
        }
    }


    public T get(int index) {
        int count = 0;
        for (T t : this) {
            if (count == index) return t;
            count++;
        }
        return null;
    }


    private Node<T> deleteNode(Node<T> del) {
        if (head == null || del == null)
            return null;
        if (head == del)
            head = del.getNext();
        if (del.getNext() != null)
            del.getNext().setPrev(del.getPrev());
        if(del.getPrev() != null)
            del.getPrev().setNext(del.getNext());
        return head;
    }

    public void deleteNodeAtGivenPos(int n) {
        if (head == null || n <= 0)
            return;
        Node current = head;
        for(int i = 1; current != null && i < n; i++) {
            current = current.getNext();
        }
        deleteNode(current);
    }

    public int size() {
        int count = 1;
        Node<T> temp;
        if (head.equals(tail)) {
            return 1;
        } else {
            temp = head;
            while (temp.getNext() != null) {
                count++;
                temp = temp.getNext();
            }
        }
        return count;
    }

    public LinkedList<T> reverse() {
        LinkedList<T> reverse = new LinkedList<>();
        ListIterator<T> itr = iterator();
        while (itr.hasPrevious()) {
            reverse.add(itr.previous());
        }
        return reverse;
    }

    @Override
    public ListIterator<T> iterator() {
        return new GenericIterator<>(head, tail);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> itr = iterator();
        while (itr.hasNext()) {
            result.append(itr.next().toString());
            if (itr.hasNext()) result.append(",");
        }
        return result.append("]").toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(25);
        list.add(22);
        list.add(12);
        list.add(88);
        LOGGER.info("list size: "+list.size());
        LOGGER.info(list.toString());
        LOGGER.info(list.reverse().toString());
        list.deleteNodeAtGivenPos(5);
        LOGGER.info(list.toString());
    }
}
