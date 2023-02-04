import java.util.Arrays;
import java.util.OptionalDouble;

/*
Задание 2
Пользователь с клавиатуры вводит значения в массив.
После чего запускаются две потока. Первый поток находит сумму элементов
в массиве. Второй поток находит среднеарифметическое в массиве.
Результаты вычислений возвращаются в метод main.
 */
public class Task2 {
    public static void main(String[] args) {
        int [] arr = {1,200,300,5,7,0};
        new CalcTread(arr).start();
        int sum = Arrays.stream(arr).sum();
            System.out.println("Сумма элементов массива :" +" "
                    +sum);
    }
    static class  CalcTread extends Thread{
        private final int [] arr;

        public CalcTread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            OptionalDouble average = Arrays.stream(arr).average();
            if (average.isPresent())
                System.out.println("Cреднеарифметическое значение в массиве :" +" "+ average.getAsDouble() );
        }
    }
}
