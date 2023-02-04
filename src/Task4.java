import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
Задание 4
Пользователь с клавиатуры вводит путь к файлу и слово для поиска.
После чего запускается поток. Он ищет это слово в файле. Результат
поиска возвращается в main.
Файл текстом: text.txt
Текст: Happy birthday to you!
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с текстом :");
        String path = scanner.nextLine();
        System.out.println("Введите слово для поиска :");
        String word = scanner.nextLine();

        new FindWord(path,word).start();

    }

    static class FindWord extends Thread{
        String text, path, word;

        public FindWord( String path,String word) {
            this.path = path;
            this.word = word;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(path)))
            {
                text=br.readLine();
                if (text.contains(word))
                    System.out.println("Слово "+ word+" есть в тексте");
                else
                    System.out.println("Нет такого слова в тексте");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
