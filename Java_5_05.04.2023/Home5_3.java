// 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;




public class Home5_3 {
    public void sort(int arr[]) {
        int n = arr.length;

        // Построение пирамиды (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из пирамиды
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной пирамиде
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную пирамиду поддерева с корневым узлом i, что является индексом в arr[]. n - размер пирамиды
    void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную пирамиду затронутое поддерево
            heapify(arr, n, largest);
        }
    }

        static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введите размер массива: ");
        String n = reader.readLine();
        int q = Integer.parseInt(n);
        Random rd = new Random();
        int[] Arr = new int[q];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = rd.nextInt(1, 100);
        }
        System.out.println("Первоначальный массив: ");
        printArray(Arr);
        Home5_3 ob = new Home5_3();
        ob.sort(Arr);

        System.out.println("Отсортированный массив: ");
        printArray(Arr);
    }
}
