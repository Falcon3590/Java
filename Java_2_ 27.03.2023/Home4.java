// // 4. * К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Home4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SecurityException, IOException {
        Logger log = Logger.getLogger(Home4.class.getName());
        FileHandler fh = new FileHandler("logger2.log");
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
        int N1 = Number();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Первое число: " + N1));
        int N2 = Number();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Второе число: " + N2));
        char operation = Operation();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Операция: " + operation));
        int result = calc(N1, N2, operation);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Произвел расчет"));
        System.out.println("Результат = " + result);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Вывел результат: " + result));
    }

    public static int Number() {
        System.out.println("Введите число:");
        int N;
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
        } else {
            System.out.println("Введены не верные данные, введите только цифры.");
            scanner.next();
            N = Number();
        }
        return N;
    }

    public static char Operation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Введены не верные данные, введите только цифры.");
            scanner.next();
            operation = Operation();
        }
        return operation;
    }

    public static int calc(int N1, int N2, char operation) throws SecurityException, IOException {
        Logger log = Logger.getLogger(Home4.class.getName());

        int result;
        switch (operation) {
            case '+':
                result = N1 + N2;
                log.setLevel(Level.INFO);
                log.log(Level.INFO, String.format("Произвел сложение"));
                break;
            case '-':
                result = N1 - N2;
                log.setLevel(Level.INFO);
                log.log(Level.INFO, String.format("Произвел вычетание"));
                break;
            case '*':
                result = N1 * N2;
                log.setLevel(Level.INFO);
                log.log(Level.INFO, String.format("Произвел умножение"));
                break;
            case '/':
                result = N1 / N2;
                log.setLevel(Level.INFO);
                log.log(Level.INFO, String.format("Произвел деление"));
                break;
            default:
                System.out.println("Введены не верные данные, введите один из символов: + - */ ");
                log.setLevel(Level.INFO);
                log.log(Level.INFO, String.format("Введены не верные данные"));
                result = calc(N1, N2, Operation());
        }
        return result;
    }
}
