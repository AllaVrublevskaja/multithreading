import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Задание 3
Пользователь с клавиатуры вводит путь к файлу, содержащему набор чисел.
После чего запускаются две потока. Первый поток создает новый файл, в который
запишет только четные элементы массива. Второй поток создает новый файл в который
запишет только нечетные элементы массива.
Количество четных и нечетных эле-ментов возвращается в метод main.
 */
public class Task3 {
    public static void main(String[] args) {
//        int [] arr = {1,200,300,5,7,0,123};
        String path = "arr.txt";
        List<Integer> arr = new ArrayList<>();
        new FileTread(path).start();
        try (BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            String str = br.readLine();
            String[] word = str.split(",");
            int num;
            for (int i = 0; i < word.length; i++) {
                num = Integer.parseInt(word[i]);
                if (num % 2 == 0) arr.add(num);
            }
        } catch (IOException ex) {
            arr = new ArrayList<>();
        }

        try (FileOutputStream outputStream = new FileOutputStream("honest.txt");
             PrintWriter writer = new PrintWriter(outputStream)
        ) {

            for (int i = 0; i < arr.size(); i++)
                writer.print(arr.get(i) + ",");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Четных элементов :"+ arr.size());
    }


    static class  FileTread extends Thread{
        private final String path;

        public FileTread(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            List<Integer> arr = new ArrayList<>();
            try(BufferedReader br = new BufferedReader(new FileReader(path))
            )
            {
                String str = br.readLine();
                String[] word =str.split(",");
                int num;
                for(int i =0; i<word.length; i++) {
                    num = Integer.parseInt(word[i]);
                    if (num%2!=0) arr.add(num);
                }
            }
            catch(IOException ex) {
                arr = new ArrayList<>();
            }

            try (FileOutputStream outputStream = new FileOutputStream("odd.txt");
                 PrintWriter writer = new PrintWriter(outputStream)
            ) {
                for (int i = 0; i < arr.size(); i++)
                    writer.print(arr.get(i) + ",");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Нечетных элементов :"+ arr.size());
        }
    }
}
