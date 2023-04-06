// Урок 3. Коллекции JAVA: Введение
// 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Random;

public class Home3_3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int val = rnd.nextInt(1, 100);
            list.add(val);
        }
        System.out.printf("Первоначальный список %s\n", list);
        int maxItem = list.get(0);
        int minItem = list.get(0);
        int sumItems = 0;
        for (int item : list) {
            if (item > maxItem) {
                maxItem = item;
            }
            if (item < minItem) {
                minItem = item;
            }
            sumItems += item;
        }
        float average = (float) sumItems / list.size();

        System.out.printf("Максимальный элемент %s\n", maxItem);
        System.out.printf("Минимальный элемент %s\n", minItem);
        System.out.printf("Среднее арифметическое %s\n", average);
    }

}