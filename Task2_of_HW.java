//2) К калькулятору из предыдущего дз добавить логирование.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2_of_HW {
    public static void main(String[] args) throws IOException {
        try {
            int num1 = num();
            int num2 = num();
            char sign = Operation();
            if ((sign == '*') || (sign == '/') || (sign == '+') || (sign == '-')) {
                int result = Rezult(num1, num2, sign);
                System.out.println("Результат операции: " + result);
                logic(num1, num2, sign, result); // вызывает функцию которая проводит логирование результата вычисления
            } else {
                // вызывает функцию в которой проводится логирование на ошибку вводи символа
                Object id = "java.util.NumberFormatException";
                logic_of_error(id);
            }

        } catch (NoSuchElementException id) {
            // вызывает функцию в которой проводится логирование на ошибку ввода числа/цифры
            logic_of_error(id);
        }
    }

    public static int num() {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }

    public static char Operation() {
        System.out.println("Введите операцию: ");
        Scanner scanner = new Scanner(System.in);
        char result = scanner.next().charAt(0);
        return result;
    }

    public static int Rezult(int num1, int num2, char sign) throws IOException {
        int result = 0;
        switch (sign) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }

    // функция логирования результата ввода
    public static void logic(int num1, int num2, char sim, int result) throws IOException {
        String messeg = " ";
        Logger logger1 = Logger.getAnonymousLogger();
        FileWriter filewriter1 = new FileWriter("log.txt");
        Formatter f = new Formatter();
        f.format("%d %c %d = %d ", num1, sim, num2, result);
        messeg = String.valueOf(f);
        logger1.info(messeg);
        filewriter1.write(messeg + " | " + String.valueOf(logger1.toString()) + " \n");
        filewriter1.close();

    }

    // функция логирования ошибки ввода
    public static void logic_of_error(Object id) throws IOException {
        String messeg = " ";
        Logger logger1 = Logger.getAnonymousLogger();
        FileWriter filewriter1 = new FileWriter("log.txt");
        Formatter f = new Formatter();
        f.format("Error!!! ");
        messeg = String.valueOf(f);
        logger1.info(messeg);
        filewriter1.write(messeg + " Name: " + id + " \n");
        filewriter1.close();
    }
}
