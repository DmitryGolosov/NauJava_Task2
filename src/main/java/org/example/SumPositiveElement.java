package org.example;

import java.util.Random;
import java.util.Scanner;

/* Задание 1. Вариант 5 */

public class SumPositiveElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Заполнение массива случайными числами в диапазоне [-100, 100]
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        // Вывод массива
        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Нахождение суммы положительных элементов
        int sumPositive = 0;
        for (int num : array) {
            if (num > 0) {
                sumPositive += num;
            }
        }

        // Вывод результата
        System.out.println("Сумма положительных элементов: " + sumPositive);
    }
}