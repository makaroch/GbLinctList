package org.example;

import org.example.linckList.LinckList;
import org.example.tree.RedBlackTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int x = scanner.nextInt();
            redBlackTree.add(x);
            redBlackTree.print();
        }

    }
}