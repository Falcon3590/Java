import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// Реализуйте очередь с помощью LinkedList со следующими методами:
// • enqueue() — помещает элемент в конец очереди,
// • dequeue() — возвращает первый элемент из очереди и удаляет его,
// • first() — возвращает первый элемент из очереди, не удаляя.

public class Home4_2 {

    public static void main(String[] args) throws IOException {
        // Объявление linkedlist
        LinkedList<String> linklist = new LinkedList<String>();
        // Добавление элементов в конец списка
        linklist.add("Element1");
        linklist.add("Element2");
        linklist.add("Element3");
        linklist.add("Element4");
        linklist.add("Element5");
        System.out.println("Начальный списоок: " + linklist);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введите элемент который нужно добавить: ");
        String n = reader.readLine();

        enqueue(linklist, n);
        System.out.println("Новый элемент добавлен в конец очереди: " + linklist);

        String str = dequeue(linklist);
        System.out.println("Первый элемент из очереди (Удален из списка): " + str);
        
        String str2 = first(linklist);
        System.out.println("Первый элемент из очереди (Без удаления): " + str2);
        
    }

    public static void enqueue(LinkedList<String> linklist, String num) {
        linklist.addLast(num);
    }


    public static String dequeue(LinkedList<String> list) {
        String str = "";
        str = list.get(0);
        list.remove(0);
        return str;
    }

    public static String first(LinkedList<String> list) {
        String str = "";
        str = list.get(0);
        return str;
    }
    

}