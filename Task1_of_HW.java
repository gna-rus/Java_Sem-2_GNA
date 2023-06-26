// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Task1_of_HW
{
    public static void Sort1(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int elem = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = elem;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        Sort1(sortArr);
        Logger logger1 = Logger.getAnonymousLogger();
        FileWriter filewriter1 = new FileWriter("log.txt");
        String messeg = "Test1";
        logger1.info(messeg);
        filewriter1.write(String.valueOf(logger1.toString()) + " ");
        filewriter1.write(messeg);
        filewriter1.close();
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }
}
