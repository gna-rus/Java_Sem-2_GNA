// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task1_of_HW {
    // функция для сортировки
    public static void Sort1(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int elem = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = elem;
                }
            }
        }
    }

    // функция заполнения массива случайными числами
    public static int[] rand_of_arr(int num) {
        int[] sortArr = new int[num];
        Random random = new Random();
        for (int i = 0; i < sortArr.length; i++) {
            sortArr[i] = 1 + random.nextInt(100);
        }
        return sortArr;
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] sortArr = new int[num];
        sortArr = rand_of_arr(num);
        Sort1(sortArr); // образаюсь к функции сортировки

        Logger logger1 = Logger.getAnonymousLogger();
        FileWriter filewriter1 = new FileWriter("log.txt");
        String messeg = " ";

        // логирование и вывод на экран результата сортировки
        for (int i = 0; i < sortArr.length; i++) {
            messeg = String.valueOf(sortArr[i]);
            logger1.info(messeg);
            filewriter1.write("i: " + i + " |sorting result " + messeg + " ");
            filewriter1.write(String.valueOf(logger1.toString()) + " \n");
            System.out.print(sortArr[i] + "\n");
        }
        filewriter1.close();
    }
}
