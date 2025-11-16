package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* Задание 2. Вариант 5*/

public class InsertionSortExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество элементов списка: ");
        int n = scanner.nextInt();

        ArrayList<Double> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(random.nextDouble() * 100);
        }

        System.out.println("Исходный список: " + list);

        for (int i = 1; i < list.size(); i++) {
            double key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        System.out.println("Отсортированный список: " + list);
    }
}
