package org.example.tree;

public class Node {
    private int value;

    private Node left;
    private Node right;
    private Colors color;

    public Node(int value, Colors color){
        this.value = value;
        this.color = color;
    }

    public Node(int value) {
        this(value, Colors.RED);
    }


    public int getValue() {
        return value;
    }
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
