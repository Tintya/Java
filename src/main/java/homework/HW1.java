package homework;

import java.util.*;

public class HW1 {
    // 1. Генерация случайного от нуля до n;
    public static int GetRandomInt(int n) {
        return new Random().nextInt(n);
    }

    // 2. Возвращает позицию старшего бита в int;
    public static int GetMaxBitNum(int i) {
        return Integer.toBinaryString(i).length();
    }

    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в
    // массив m1
    public static int[] GetArrayDivisible(int i, int n) {
        int minDivider = i / n + 1 * ((i % n == 0) ? 0 : 1);
        int firstElement = minDivider * n;
        int maxDivider = Short.MAX_VALUE / n;
        int count = maxDivider - minDivider + 1;

        int[] result = new int[count];
        int k = firstElement;
        for (int j = 0; j < result.length; j++) {
            result[j] = k;
            k += n;
        }
        return result;
    }

    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и
    // сохранить в массив m2
    public static int[] GetArrayNotDivisible(int i, int n) {
        int minDivider = -Short.MIN_VALUE / n;
        int maxDivider = i / n;
        int count = i - Short.MIN_VALUE - minDivider - maxDivider;
        int[] result = new int[count];
        int k = 0;
        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j % n != 0) {
                result[k] = j;
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = GetRandomInt(2000); // 1 Пункт задания
        System.out.println("i = "+i);

        int n = GetMaxBitNum(i); // 2 Пункт задания
        System.out.println("n = "+n);

        int[] m1 = GetArrayDivisible(i, n); // 3 Пункт задания
        System.out.println(Arrays.toString(m1));

        int[] m2 = GetArrayNotDivisible(i, n); // 4 Пункт задания
        System.out.println(Arrays.toString(m2));

    }
}
