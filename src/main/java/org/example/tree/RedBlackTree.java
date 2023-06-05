package org.example.tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value, Colors.BLACK);
            return true;
        }
        boolean res = addNode(root, value);
        root = rebalance(root);
        root.setColor(Colors.BLACK);
        return res;
    }

    private boolean addNode(Node node, int value) {
        if (node.getValue() == value) {
            return false;
        }

        if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
                return true;
            }
            boolean result = addNode(node.getLeft(), value);
            node.setLeft(rebalance(node.getLeft()));
            return result;
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
                return true;
            }
            boolean result = addNode(node.getRight(), value);
            node.setRight(rebalance(node.getRight()));
            return result;
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean neadBalance;
        do {
            neadBalance = false;
            if (result.getRight() != null && result.getRight().getColor() == Colors.RED &&
                    (result.getLeft() == null || result.getLeft().getColor() == Colors.BLACK)) {
                neadBalance = true;
                result = rightSwap(result);
            }
            if (result.getLeft() != null && result.getLeft().getColor() == Colors.RED &&
                    result.getLeft().getLeft() != null && result.getLeft().getLeft().getColor() == Colors.RED) {
                neadBalance = true;
                result = leftSap(result);
            }
            if (result.getLeft() != null && result.getRight() != null &&
                    result.getRight().getColor() == Colors.RED && result.getRight().getColor() == Colors.RED) {
                neadBalance = true;
                swapColor(result);
            }
        } while (neadBalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightCgild = node.getRight();
        Node curentNode = rightCgild.getLeft();
        rightCgild.setLeft(node);
        node.setRight(curentNode);
        rightCgild.setColor(node.getColor());
        node.setColor(Colors.RED);
        return rightCgild;
    }

    private Node leftSap(Node node) {
        Node leftChild = node.getLeft();
        Node curentNode = leftChild.getRight();
        leftChild.setRight(node);
        node.setLeft(curentNode);
        leftChild.setColor(node.getColor());
        node.setColor(Colors.RED);
        return leftChild;
    }

    private void swapColor(Node node) {
        node.getRight().setColor(Colors.BLACK);
        node.getLeft().setColor(Colors.BLACK);
        node.setColor(Colors.RED);
    }

    public void print() {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nexLine = new ArrayList<>();
            for (Node node : line) {
                System.out.print(node.getValue() + " ");
                if (node.getLeft() != null){
                    nexLine.add(node.getLeft());
                }
                if (node.getRight() != null){
                    nexLine.add(node.getRight());
                }

            }
            System.out.println("");
            line = nexLine;
        }
    }
}
