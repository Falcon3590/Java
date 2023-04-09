// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Home5_1{

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Соловьев", 12345, bookPhone);
        addNumber("Воробьев", 43435, bookPhone);
        addNumber("Журавлев", 34534256, bookPhone);
        addNumber("Воронов", 23456246, bookPhone);
        addNumber("Сорокин", 23464235, bookPhone);
        addNumber("Соловьев", 2345345, bookPhone);
        addNumber("Воронов", 2562345, bookPhone);
        addNumber("Сорокин", 23465434, bookPhone);
        addNumber("Соловьев", 5, bookPhone);
        printBook(bookPhone);
       }
    
       // Добавляю номера в книгу
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }
    // Печать списка контактов
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) { // поочередно достаю ключи
            String phones = "";
            for(int el: item.getValue()){ // поочередно достаю значения по ключу
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    
}