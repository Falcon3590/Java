
// 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

// import java.util.Scanner;

// public class Homework {

//     public static int TriangularNumber(int x) {
//         return (x * (x + 1)) / 2;
//     }

//     public static void main(String[] args) {
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("Введите число n: ");
//         int n = iScanner.nextInt();
//         System.out.printf("Треугольное число равно: %d\n", TriangularNumber(n));
//         iScanner.close();
//     }

// }

// 2. Вывести все простые числа от 1 до 1000

// public class Homework {
//     public static void main(String[] args) {
//         for (int i = 1; i <= 1000; i++) {
//             boolean isPrime = true;
//             for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
//                 if ((i % j) == 0) {
//                     isPrime = false;
//                     break;
//                 }
//             }
//             if (isPrime) {
//                 System.out.print(i + " "); 
//             }
//         }
//     }
// }

// 3. Реализовать простой калькулятор

// import java.util.Scanner;

// public class Homework {
//     static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         int N1 = Number();
//         int N2 = Number();
//         char operation = Operation();
//         int result = calc(N1,N2,operation);
//         System.out.println("Результат = "+result);
//     }

//     public static int Number(){
//         System.out.println("Введите число:");
//         int N;
//         if(scanner.hasNextInt()){
//             N = scanner.nextInt();
//         } else {
//             System.out.println("Введены не верные данные, введите только цифры.");
//             scanner.next();
//             N = Number();
//         }
//         return N;
//     }

//     public static char Operation(){
//         System.out.println("Введите операцию:");
//         char operation;
//         if(scanner.hasNext()){
//             operation = scanner.next().charAt(0);
//         } else {
//             System.out.println("Введены не верные данные, введите только цифры.");
//             scanner.next();
//             operation = Operation();
//         }
//         return operation;
//     }

//     public static int calc(int N1, int N2, char operation){
//         int result;
//         switch (operation){
//             case '+':
//                 result = N1+N2;
//                 break;
//             case '-':
//                 result = N1-N2;
//                 break;
//             case '*':
//                 result = N1*N2;
//                 break;
//             case '/':
//                 result = N1/N2;
//                 break;
//             default:
//                 System.out.println("Введены не верные данные, введите один из символов: + - * / ");
//                 result = calc(N1, N2, Operation());
//         }
//         return result;
//     }
// }

// * +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
// заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить
// выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
// что его нет.

// public class Homework {
//     public static void main(String[] args) {

//         int count = 0;
//         for (int i = 0; i < 10; i++) {
//             for (int j = 0; j < 10; j++) {
//                 if (20 + i + j * 10 + 5 == 69) {
//                     count += 1;
//                     System.out.println(count + ") 2" + i + " + " + j + "5" + " = 69");
//                 }
//             }
//         }
//         System.out.println("\n");
//         if (count == 0) {
//             System.out.println("Решений нет\n");
//         }
//     }
// }

