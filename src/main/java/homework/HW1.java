package homework;

import java.util.Random;

public class HW1 {
    public static void main (String[] args){
        System.out.println("Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i");
        int max = 2000;
        int i = new Random().nextInt(max);
        System.out.println("i = "+i);
    }
}
