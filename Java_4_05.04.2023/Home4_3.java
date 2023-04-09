// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// 3. В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream.Filter;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Home4_3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SecurityException, IOException {
    	Scanner sc = new Scanner(System.in); // создание сканера
    	Stack<String> result_stack = new Stack<>();
    	
        Logger log = Logger.getLogger(Home4_3.class.getName());
        FileHandler fh = new FileHandler("logger2.log");
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
        int N1 = Number();
        result_stack.add(String.valueOf(N1)); // добавление первого числа
        
        System.out.println(result_stack);
        
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Первое число: " + N1));
        int N2 = Number();
        result_stack.add(String.valueOf(N2)); // добавление первого числа
        
        System.out.println(result_stack);
        
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Второе число: " + N2));
        
        char operation = Operation();
        
        result_stack.add(String.valueOf(operation)); // добавление первого числа
        System.out.println(result_stack);
        
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Операция: " + operation));
        
        boolean flag = true;
        while (flag){
        	int deistvie = 0;
        	System.out.println("Введите действие:\n1 - Продолжить рассчет\n2 - Удалить последний элемент\n3 - Добавить элемент");
        	if (scanner.hasNextInt()) {
                deistvie = scanner.nextInt();
            }
        	if (deistvie == 1) {
        		if (result_stack.size() == 3) {
        			flag = false;
        		}
        		else {
        			System.out.println("Не все данные заполнены! Невозможно продолжить рассчет.");
        		}
        	}
        	else if ((deistvie == 2) && (!result_stack.isEmpty())){
        		result_stack.pop();
        	}
        	else if (deistvie == 3) {
        		if ((result_stack.size() == 0) || (result_stack.size() == 1)) {
        			int N = Number();
        			result_stack.add(String.valueOf(N));
        		}
        		else if (result_stack.size() == 2) {
        			char N = Operation();
        			result_stack.add(String.valueOf(N));
        		}
        	}
    		check_stack(result_stack);
        
        };
        int result = calc(Integer.parseInt(result_stack.get(0)), Integer.parseInt(result_stack.get(1)), result_stack.get(2).charAt(0));
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Произвел расчет"));
        System.out.println("Результат = " + result);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Вывел результат: " + result));
    }
    
    public static void check_stack(Stack<String> result_stack) {
    	System.out.println(result_stack);
    	if (result_stack.size() == 3) {
			System.out.println("Данные, которые у меня есть:");
			System.out.println("Первое число:" + result_stack.get(0));
			System.out.println("Второе число:" + result_stack.get(1));
			System.out.println("Операция:" + result_stack.get(2));
		}
    	else if (result_stack.size() == 2) {
			System.out.println("Данные, которые у меня есть:");
			System.out.println("Первое число:" + result_stack.get(0));
			System.out.println("Второе число:" + result_stack.get(1));
			System.out.println("Операция: не указана");
		}
		else if (result_stack.size() == 1) {
			System.out.println("Данные, которые у меня есть:");
			System.out.println("Первое число:" + result_stack.get(0));
			System.out.println("Второе число: не указано");
			System.out.println("Операция: не указана");
		}
		else if (result_stack.size() == 0) {
			System.out.println("Данные, которые у меня есть:");
			System.out.println("Первое число: не указано");
			System.out.println("Второе число: не указано");
			System.out.println("Операция: не указана");
		}
    }
    
    
    public static int Number() throws IOException {
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
        Logger log = Logger.getLogger(Filter.class.getName());

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
