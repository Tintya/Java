package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HW3 {
    public static double getAverage(List<Integer> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        result = result / list.size();
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 50, 107, 98, 2, 4, 85, 96));

        for(int i = 0; i <= list.size(); i++) {
            if(list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }

        double avg = getAverage(list);

        System.out.println("Изначальный список: " + list);
        System.out.println("Удалены все четные числа: " + list);
        System.out.println("Максимальное число в массиве: " + Collections.max(list));
        System.out.println("Минимальное число в массиве: " + Collections.min(list));
        System.out.println("Среднее число в массиве: " + avg);

    }
}
