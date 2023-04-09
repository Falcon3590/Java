// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// 1.Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.1/

import java.util.LinkedList;

public class Home4_1 {
    public static void main(String[] args) {
        // Объявление linkedlist
        LinkedList<String> linklist = new LinkedList<String>();
        // Добавление элементов в конец списка
        linklist.add("Элемент1");
        linklist.add("Элемент2");
        linklist.add("Элемент3");
        linklist.add("Элемент4");
        linklist.add("Элемент5");
        System.out.print("Список перед переворотом: " + linklist);
        linklist = reverseLinkedList(linklist);
        System.out.print("\nСписок после переворота: " + linklist);
    }

    // Принимает linkedlist в качестве параметра и возвращает обратный linkedlist
    public static LinkedList<String> reverseLinkedList(LinkedList<String> llist) {
        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            // Добавление элементов в обратном порядке
            revLinkedList.add(llist.get(i));
        }
        // Возвращает перевернутый arraylist
        return revLinkedList;
    }
}