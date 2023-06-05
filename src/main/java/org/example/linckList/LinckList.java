package org.example.linckList;

public class LinckList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    public void revers() {
        if (head == null || head.equals(tail)) {
            return;
        }
        tail.setNext(tail.getPrev());
        tail.setPrev(null);

        Node<T> curentNode = tail.getNext();
        head = tail;

        while (true) {
            Node<T> tempNode = curentNode.getNext();
            curentNode.setNext(curentNode.getPrev());
            curentNode.setPrev(tempNode);

            if (curentNode.getNext() == null) {
                break;
            }

            curentNode = curentNode.getNext();
        }
        curentNode.setPrev(curentNode.getNext());
        curentNode.setNext(null);
        tail = curentNode;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.getValue().equals(value)) {
            if (head.getNext() == null) {
                head = null;
                tail = null;
            } else {
                head.getNext().setPrev(null);
                head = head.getNext();
            }
            size--;
        } else {
            Node<T> curentNode = head.getNext();
            while (curentNode.getNext() != null) {
                if (curentNode.getValue().equals(value)) {

                    curentNode.getNext().setPrev(curentNode.getPrev());
                    curentNode.getPrev().setNext(curentNode.getNext());
                    size--;
                    return;
                }
                curentNode = curentNode.getNext();
            }
            if (tail.getValue().equals(value)) {
                tail.getPrev().setNext(null);
                tail = tail.getPrev();
                size--;
            }
        }
    }

    public boolean add(T value, int i) {
        if (i > size || head == null) {
            return false;
        }
        if (i == size) {
            this.add(value);
            return true;
        }
        if (i == 1 || i == 0){
            Node<T> newNode = new Node<>(value);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            size++;
            return true;
        }
        Node<T> curentNode = head;
        Node<T> newNode = new Node<>(value);
        for (int j = 1; j < i; j++) {
            curentNode = curentNode.getNext();
        }
        Node<T> prevNode = curentNode.getPrev();
        newNode.setNext(curentNode);
        curentNode.setPrev(newNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        size++;
        return true;

    }

    public void addAll(T... values) {
        for (T value : values) {
            this.add(value);
        }
    }

    public void printList() {
        Node<T> curentNode = head;
        System.out.print("[ ");
        while (curentNode != null) {
            if (curentNode.getNext() != null) {
                System.out.print(curentNode.getValue() + ", ");
            } else {
                System.out.print(curentNode.getValue());
            }
            curentNode = curentNode.getNext();
        }
        System.out.println(" ] : " + size);
    }
}
