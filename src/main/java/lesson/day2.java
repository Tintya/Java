package lesson;
//Напишите программу, чтобы найти вхождение в строке
import java.util.Scanner;
public class day2 {
    public static void main (String[] args) {
        System.out.println("Введите первую строку: ");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        if (str1.contains(str2)) {
            System.out.println("Содержит");
        } else {
            System.out.println("Не содержит");
        }

    }

}
