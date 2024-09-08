package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void insertionSort(ArrayList<Integer> A) {
        for (int j = 2; j < A.size(); j++) {
            System.out.println(A);
            int key = A.get(j);
            int i = j - 1;

            while (i > 0 && A.get(i) > key) {
                A.set(i + 1, A.get(i));
                i--;
            }
            A.set(i + 1, key);
        }
    }

    static class Node {
        int key;
        Node next;
        Node prev;

        Node(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        Node head;

        void listInsert(Node x) {
            if (x == null) {
                return; // Если вставляемый элемент null, ничего не делаем
            }

            if (head != null) {
                // Если список не пуст
                x.next = head;
                x.prev = null;
                head.prev = x;
                head = x;
            } else {
                // Если список пуст
                head = x;
                x.prev = null;
                x.next = null;
            }
        }

        // Вспомогательный метод для вывода списка
        void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println("task 1");
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 2, 9, 10, 4, 7, 6, 8, 1, 5));
        insertionSort(A);
        System.out.println();

        System.out.println("task 2");
        DoublyLinkedList list = new DoublyLinkedList();

        // Вставка элементов
        list.listInsert(new Node(1));
        list.listInsert(new Node(2));
        list.listInsert(new Node(3));
        list.listInsert(new Node(4));
        list.listInsert(new Node(5));

        // Вывод списка
        list.printList(); // Ожидаемый вывод: 5 4 3 2 1
        System.out.println();
    }
}