// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// 
// 2. Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home5_2 {
    public static void main(String[] args) {
        new_list(personals);
    }

    public static List<String> personals = new ArrayList<>(Arrays.asList(
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"));

    public static void deleteName(Map<String, Integer> map) { // удалет имена, которые встретились всего 1 раз, повторы оставляет
        map.entrySet().removeIf(entry -> entry.getValue() == 1);
    }

    public static void new_list(List<String> personals) {
        Map<String, Integer> map = new HashMap<>(); // создаем коллекцию в переменную map {}
        for (String personal : personals) { // берем пару из переменной map и сохраняем в personal
            String personalName = personal.split(" ")[0]; // разбивает имя и фамилию в массив [имя, фамилия]
            if (map.containsKey(personalName)) { // проверка, есть ли имя в коллекции
                map.put(personalName, map.get(personalName) + 1); // если есть, то увеличиваем число повторений на 1
            } else { // если имени в коллекции нет (не нашли)
                map.put(personalName, 1); // добавляем новое в формате - {имя: 1}
            }
        }
        deleteName(map); // вызов функции для удаления
        List<Map.Entry<String, Integer>> lst = new ArrayList<>(map.entrySet()); // коллекция map становится массивом lst (чтобы была возможность сортировка)
        lst.sort(Map.Entry.<String, Integer>comparingByValue().reversed()); // сортировка по убыванию значений
        System.out.println(lst);
    }
}