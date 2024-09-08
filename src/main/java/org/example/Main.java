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

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 2, 9, 10, 4, 7, 6, 8, 1, 5));
        insertionSort(A);
    }
}