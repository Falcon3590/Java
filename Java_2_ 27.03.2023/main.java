// 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.

// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// import java.util.HashMap;
// import java.util.Map;

// public class main {
//     public static void main(String[] args) {
//         Map<String /*тип данных ключей*/, String/*тип данных значений*/> params1 = new HashMap /*конструктор класса */<String,String>();
//         params1.put("name","Ivanov");
//         params1.put("country","Russia");
//         params1.put("city","Moscow");
//         params1.put("age",null);
//         System.out.println(getQuery(params1));
//     }
//     public static String getQuery(Map<String, String> params)
//     {
//         StringBuilder s = new StringBuilder();
//         for (Map.Entry<String,String> pair : params.entrySet()) // Беру ключ и значение из словоря и сохраняю в перемнную
//         {
//             if (pair.getValue() != null) // Проверяем на пустоту
//             {
//                 s.append(pair.getKey() +" = '" + pair.getValue()+"' and "); // Добавляем значение в строку
//             }
//         }
//         s.delete(s.toString().length()-5,s.toString().length()); //Удаляю  пробел and пробел  
//         return s.toString(); 
//     }
// }

// 2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// import java.util.Random;
// import java.util.Arrays;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import java.util.logging.SimpleFormatter;
// import java.io.IOException;

// public class main {
// public static void main(String[] args) throws IOException {

// int[] arr = new int[10];
// Random rand = new Random();
// int tmp = 0;
// Logger log = Logger.getLogger(main.class.getName());
// FileHandler fh = new FileHandler("logger.log");
// log.addHandler(fh);
// fh.setFormatter(new SimpleFormatter());

// for (int i = 0; i < arr.length; i++) {
// arr[i] = rand.nextInt(11);
// }

// for (int j = 0; j < arr.length - 1; j++) {
// for (int k = j + 1; k < arr.length; k++) {
// if (arr[k] < arr[j]) {
// tmp = arr[j];
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Присвоил tmp для сортировки"));
// arr[j] = arr[k];
// arr[k] = tmp;
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Значения меньшее убираю влево"));
// }
// String str = Arrays.toString(arr);
// System.out.println(str);
// log.log(Level.INFO, String.format(str));
// }
// }
// System.out.println(Arrays.toString(arr));
// String str = Arrays.toString(arr);
// log.log(Level.INFO, String.format("Сортировка выполнина"));
// log.log(Level.INFO, String.format(str));
// }
// }


// 3. ** Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// import java.io.BufferedReader;
// import java.io.FileReader;

// public class main {

//     public static void main(String[] args) throws Exception {
//         String[] arrayData = ReadLineFromFile(
//                 "C:/Users/vi/Desktop/Учеба в GB/Java/Java_2_ 27.03.2023/dataStudents.txt");
//         for (int i = 0; i < arrayData.length; i++) {
//             System.out.println(PrintLine(arrayData[i]));
//         }

//     }

//     public static StringBuilder PrintLine(String line) {
//         String line1 = line.replace("{", "");
//         String line2 = line1.replace("}", "");
//         String line3 = line2.replaceAll("\"", "");
//         String line4 = line3.replace("[", "");
//         String line5 = line4.replace("]", "");
//         StringBuilder result = new StringBuilder("");
//         String[] arrayData = line5.split(",");
//         String[] listName = { "Студент ", " получил ", " по предмету " };
//         for (int i = 0; i < arrayData.length; i++) {
//             String[] arrData = arrayData[i].split(":");
//             result.append(listName[i]);
//             result.append(arrData[1]);
//         }
//         return result;
//     }

//     // Считывю строки из файла
//     public static String[] ReadLineFromFile(String pathway) throws Exception {
//         BufferedReader br = new BufferedReader(new FileReader(pathway));
//         String str;
//         int size = 0;
//         while ((str = br.readLine()) != null) {
//             size += 1;
//         }
//         br.close();
//         String[] listData = new String[size];

//         int i = 0;
//         BufferedReader br1 = new BufferedReader(new FileReader(pathway));
//         while ((str = br1.readLine()) != null) {
//             listData[i] = str;
//             i += 1;
//         }
//         br1.close();
//         return listData;

//     }

// }



// // 4. * К калькулятору из предыдущего дз добавить логирование.

// import java.io.IOException;
// import java.util.Scanner;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import java.util.logging.SimpleFormatter;

// public class main {
// static Scanner scanner = new Scanner(System.in);

// public static void main(String[] args) throws SecurityException, IOException
// {
// Logger log = Logger.getLogger(main.class.getName());
// FileHandler fh = new FileHandler("logger2.log");
// log.addHandler(fh);
// fh.setFormatter(new SimpleFormatter());
// int N1 = Number();
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Первое число: " + N1));
// int N2 = Number();
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Второе число: " + N2));
// char operation = Operation();
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Операция: " + operation));
// int result = calc(N1, N2, operation);
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Произвел расчет"));
// System.out.println("Результат = " + result);
// log.setLevel(Level.INFO);
// log.log(Level.INFO, String.format("Вывел результат: " + result));
// }

// public static int Number() {
// System.out.println("Введите число:");
// int N;
// if (scanner.hasNextInt()) {
// N = scanner.nextInt();
// } else {
// System.out.println("Введены не верные данные, введите только цифры.");
// scanner.next();
// N = Number();
// }
// return N;
// }

// public static char Operation() {
// System.out.println("Введите операцию:");
// char operation;
// if (scanner.hasNext()) {
// operation = scanner.next().charAt(0);
// } else {
// System.out.println("Введены не верные данные, введите только цифры.");
// scanner.next();
// operation = Operation();
// }
// return operation;
// }

// public static int calc(int N1, int N2, char operation) {
// int result;
// switch (operation) {
// case '+':
// result = N1 + N2;
// break;
// case '-':
// result = N1 - N2;
// break;
// case '*':
// result = N1 * N2;
// break;
// case '/':
// result = N1 / N2;
// break;
// default:
// System.out.println("Введены не верные данные, введите один из символов: + - *
// / ");
// result = calc(N1, N2, Operation());
// }
// return result;
// }
// }
