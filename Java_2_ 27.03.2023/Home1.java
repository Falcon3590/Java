// 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.

// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Home1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведите параметры для фильтрации: ");
        String title = reader.readLine();
        title = title.replace("\"", "").replace("{", "").replace("}", "");
        String[] words = title.split(", ");

        Map<String /* тип данных ключей */, String/* тип данных значений */> params1 = new HashMap /*
                                                                                                    * конструктор класса
                                                                                                    */<String, String>();
        for (String word : words) {
            String[] word2 = word.split(":");
            int index = word2[1].lastIndexOf("null");
            if (index != -1) {
                params1.put(word2[0], null);
            } else {
                params1.put(word2[0], word2[1]);
            }
        }

        System.out.println(getQuery(params1));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) // Беру ключ и значение из словоря и сохраняю в
                                                                 // перемнную
        {
            if (pair.getValue() != null) // Проверяем на пустоту
            {
                s.append(pair.getKey() + " = '" + pair.getValue() + "' and "); // Добавляем значение в строку
            }
        }
        s.delete(s.toString().length() - 5, s.toString().length()); // Удаляю пробел and пробел
        return s.toString();
    }
}