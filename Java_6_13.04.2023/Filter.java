import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Filter {

	public int ram; // переменные класса
	public int size_hhd;
	public String os;
	public String color;

	public Filter(int ram, int size_hhd, String os, String color) { // конструктор для создания ноутбуков
		super();
		this.ram = ram;
		this.size_hhd = size_hhd;
		this.os = os;
		this.color = color;
	}

	public static void main(String[] args) throws IOException {
		Filter notebook1 = new Filter(16, 1024, "Windows", "grey");
		Filter notebook2 = new Filter(16, 1024, "Linux", "grey");
		Filter notebook3 = new Filter(4, 526, "Windows", "white");
		Filter notebook4 = new Filter(16, 526, "Windows", "white");

		ArrayList<Filter> notebooks = new ArrayList<>();
		notebooks.add(notebook1);
		notebooks.add(notebook2);
		notebooks.add(notebook3);
		notebooks.add(notebook4);
		ArrayList<Filter> otv = my_filter(notebooks);
		System.out.println("У нас имеются ноутбуки со следующими характеристиками:");
		for (int i = 0; i < otv.size(); i++) {
			System.out.println(String.valueOf(i + 1) + ") ОЗУ: " + otv.get(i).ram + ", Жесткий диск: "
					+ otv.get(i).size_hhd + ", Операционная система: " + otv.get(i).os + ", Цвет: " + otv.get(i).color);

		}
	}

	public static ArrayList<Filter> my_filter(ArrayList<Filter> nootebooks) throws IOException {
		System.out.println("Доступные критерии сортировки (введите 1 или несколько чисел черз пробел):"
				+ "\n 1. ОЗУ"
				+ "\n 2. Объем жесткого диска"
				+ "\n 3. Операционная система"
				+ "\n 4. Цвет");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String value = reader.readLine();

		ArrayList<Filter> filter_notebooks = new ArrayList<>();
		ArrayList<Filter> my_array = nootebooks;
		for (int i = 0; i < value.length(); i++) {
			boolean flag = true;
			if (value.charAt(i) != ' ') {
				switch (value.charAt(i)) {
					case '1':
						System.out.println("Введите количество ОЗУ ниже");
						flag = true;
						break;
					case '2':
						System.out.println("Введите количество объема жесткого диска ниже");
						flag = true;
						break;
					case '3':
						System.out.println("Введите наименование операционной системы ниже");
						flag = true;
						break;
					case '4':
						System.out.println("Введите желаемый цвет на англиском языке ниже");
						flag = true;
						break;
					default:
						System.out.println("Критерий не был найден!");
						flag = false;
						break;
				}
				if (flag) {
					String value_in_noteebok = reader.readLine(); // Считывание значения для критерия сортировки
					filter_notebooks = new ArrayList<>(); // пустой массив для записи ввыводимых значений фильтра
					for (int d = 0; d < my_array.size(); d++) {
						switch (value.charAt(i)) {
							case '1':
								if (Integer.parseInt(value_in_noteebok) == my_array.get(d).ram) { // получает значение и
																									// сравнивает с
																									// парамкетром
																									// ноутбука
									filter_notebooks.add(my_array.get(d));
									break;
								}
							case '2':
								if (Integer.parseInt(value_in_noteebok) == my_array.get(d).size_hhd) {
									filter_notebooks.add(my_array.get(d));
									break;
								}
							case '3':
								if (value_in_noteebok.equals(my_array.get(d).os)) {
									filter_notebooks.add(my_array.get(d));
									break;
								}
							case '4':
								if (value_in_noteebok.equals(my_array.get(d).color)) {
									filter_notebooks.add(my_array.get(d));
									break;
								}
						}
					}
				}
				my_array = filter_notebooks; // Записывает в my_array ноуты подходящие критериям фильтра для вывода в
												// консоль
			}
		}
		return my_array;
	};

}