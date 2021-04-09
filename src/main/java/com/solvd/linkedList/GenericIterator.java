package com.solvd.linkedList;

import java.util.ListIterator;
import java.util.Objects;


public class GenericIterator<T> implements ListIterator<T> {

   private Node<T> currentStart;
   private Node<T> currentEnd;

   public GenericIterator(Node<T> head, Node<T> tail) {
       currentStart = head;
       currentEnd = tail;
   }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(currentStart);
    }

    @Override
    public T next() {
       Node<T> temp = currentStart;
       currentStart = currentStart.getNext();
       return temp.getData();
    }

    @Override
    public boolean hasPrevious() {
        return Objects.nonNull(currentEnd);
    }

    @Override
    public T previous() {
       Node<T> temp = currentEnd;
       currentEnd = currentEnd.getPrev();
       return temp.getData();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }


    public Node<T> getCurrentStart() {
        return currentStart;
    }

    public void setCurrentStart(Node<T> currentStart) {
        this.currentStart = currentStart;
    }

    public Node<T> getCurrentEnd() {
        return currentEnd;
    }

    public void setCurrentEnd(Node<T> currentEnd) {
        this.currentEnd = currentEnd;
    }

}
