package org.example;

public class Main {
    public static void main(String[] args) {
        LinckList<Integer> list = new LinckList<>();
        list.add(5);

        list.remove(5);
        list.printList();
        list.revers();
        LinckList<String> strList = new LinckList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.printList();
        strList.remove("4");
        strList.remove("8");
        strList.printList();
        strList.add("qqq", 0);
        strList.printList();

    }
}