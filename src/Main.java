import java.util.Arrays;
import java.util.OptionalInt;
/*
Задание 1
Пользователь с клавиатуры вводит значения в массив. После чего
запускаются две потока. Первый поток находит максимум в массиве.
Второй поток находит минимум в массиве.
Результаты вычислений возвращаются в метод main.
 */
public class Main {
    public static void main(String[] args) {
        int [] arr = {1,200,300,5,7,0};
        new MinTread(arr).start();
        OptionalInt max = Arrays.stream(arr).max();
//        if (max.isPresent())
            System.out.println("Максимальный элемент массива :" +" "
                    +max.getAsInt());
    }
    static class  MinTread extends Thread{
        private final int [] arr;

        public MinTread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            OptionalInt min = Arrays.stream(arr).min();
            if (min.isPresent())
                System.out.println("Минимальный элемент массива :" +" "
                        +min.getAsInt());
        }
    }
}