package Homework_Lesson8;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList_2 implements Iterable {
    private int size = 0;

    private Node head;
    private Node tail;


    public void addToTail(String value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addToHead(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }
    public void add(String value) {
        if (head == null) {
            addToTail(value);

        } else if (head.previous == null) {
            addToHead(value);

        } else {
            Node newNode = new Node(value);
            newNode.previous = head.previous;
            newNode.next = head;
            head.previous.next = newNode;
            head.previous = newNode;
            size++;
        }
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        Node before = tail;
        while (current != null) {
            result.append(current.getValue()).append(", ");
            current = current.getNext();
            tail = current;
        }
        result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    public LinkedListIterator listIterator() {

        return new LinkedListIterator();
    }

    public class LinkedListIterator implements ListIterator {
        private int index;
        private Node next;
        private Node last;

        LinkedListIterator() {
            next = head;
            index = 0;
        }


        public boolean hasNext() {
            return index < size;
        }


        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            last = next;
            next = next.getNext();
            index++;
            return last.getValue();
        }


        public boolean hasPrevious() {
            return index < size;
        }


        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (next == null) {
                last = next = tail;
            } else {
                last = next = next.getPrevious();
            }
            index--;
            return last.value;
        }


        public int nextIndex() {
            return index;
        }


        public int previousIndex() {
            return index - 1;
        }


        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }



    }
    private class Node {
        private String value;
        private Node next;
        private Node previous;

        public Node(String value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}
