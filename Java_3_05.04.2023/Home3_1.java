// / Урок 3. Коллекции JAVA: Введение
// // 1. Реализовать алгоритм сортировки слиянием

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;


public class Home3_1 {
    public static void main(String[] argv) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введите размер массива: ");
        String n = reader.readLine();
        int q = Integer.parseInt(n);
        Random rd = new Random(); // создание случайного объекта
        int[] Arr = new int[q];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = rd.nextInt(1,100);
        } // хранение случайных целых чисел в массиве
        System.out.println("Исходный массив: " + Arrays.toString(Arr));

        mergeSort(Arr, Arr.length);

        System.out.println("Отсортированный массив: " + Arrays.toString(Arr));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) { // проверяет, равна ли длина массива 1, если да, то возвращает значение
            return;
        }
        int mid = n / 2; // Для рекурсивного случая получаем средний индекс и создаем два временных
                         // массива, затем мы вызываем функцию mergeSort рекурсивно для обоих подмассивов
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
        // вызываем функцию merge, которая принимает входные данные и оба подмассива, а
        // также начальный и конечный индексы обоих подмассивов.
        // Функция merge сравнивает элементы обоих подмассивов один за другим и помещает
        // меньший элемент во входной массив.
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
