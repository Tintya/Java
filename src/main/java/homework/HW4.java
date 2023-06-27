package homework;

import java.util.ArrayList;
import java.util.Scanner;
public class HW4 {
    enum SortBy {
        NONE, AGE, AGE_AND_GENDER;
    };
    public static void main(String[] args) {
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> surNames = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<String> genders = new ArrayList<>();

        String encoding = System.getProperty("console.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in, encoding);

        String[] inputFieldNames = new String[] { "ФИО или 0 для выхода или 9 для сортировки", "Пол (1. Мужской, 2. Женский)", "Возраст" };
        String[] inputFields = new String[inputFieldNames.length];

        boolean input = true;
        boolean add;

        while (input) {
            add = true;

            for (int i = 0; i < inputFields.length; i++) {
                do {
                    inputFields[i] = inputData(scanner, inputFieldNames[i]).strip();
                } while (inputFields[i].length() == 0);
                if (inputFields[i].equals("0")) {
                    input = false;
                    add = false;
                    break;
                }
                if (inputFields[i].equals("9")) {
                    add = false;
                    System.out.println("Без сортировки:");
                    showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.NONE);
                    System.out.println("-----------------");
                    System.out.println("Сортировка по возрасту:");
                    showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.AGE);
                    System.out.println("-----------------");
                    System.out.println("Сортировка по возрасту и полу:");
                    showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.AGE_AND_GENDER);
                    break;
                }
            }
            if (add) {
                String[] fullnameArr = inputFields[0].split(" ");

                lastNames.add(fullnameArr[0]);
                try {
                    firstNames.add(fullnameArr[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    firstNames.add("");
                }
                try {
                    surNames.add(fullnameArr[2]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    surNames.add("");
                }
                switch (inputFields[1]) {
                    case "1":
                        genders.add("мужской");
                        break;
                    case "2":
                        genders.add("женский");
                        break;
                    default:
                        genders.add("");
                        break;
                }
                ages.add(getDigit(inputFields[2]));
            }
        }
        scanner.close();
    }

    public static void showPersons(ArrayList<String> lastNames, ArrayList<String> firstNames,
                                   ArrayList<String> surNames,
                                   ArrayList<Integer> ages, ArrayList<String> genders, SortBy sortBy) {

        int[] indexes = getDefaultIndexes(ages.size());
        switch (sortBy) {
            case AGE:
                indexes = getSortAgesIndexes(ages);
                break;
            case AGE_AND_GENDER:
                indexes = getSortAGIndexes(ages, genders);
                break;
            case NONE:
                break;
        }
        for (int index : indexes) {
            System.out.println(lastNames.get(index)
                    + ((firstNames.get(index).length() > 0) ? (" " + firstNames.get(index).charAt(0) + ".") : "")
                    + ((surNames.get(index).length() > 0) ? (surNames.get(index).charAt(0) + ". ") : " ")
                    + ages.get(index) + " " + genders.get(index));
        }
    }

    public static String inputData(Scanner scanner, String text) {
        System.out.print(text + ": ");
        return scanner.nextLine();
    }

    private static int[] getDefaultIndexes(int count) {
        int[] indexes = new int[count];
        for (int i = 0; i < count; i++) {
            indexes[i] = i;
        }
        return indexes;
    }

    private static int[] getSortAGIndexes(ArrayList<Integer> ages, ArrayList<String> genders) {
        int[] indexes = getDefaultIndexes(ages.size());

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < indexes.length - 1; i++) {
                if ((genders.get(indexes[i]).toLowerCase().equals("женский")
                        && genders.get(indexes[i + 1]).toLowerCase().equals("мужской"))
                        || ((genders.get(indexes[i]).equals(genders.get(indexes[i + 1])))
                        && (ages.get(indexes[i]) > ages.get(indexes[i + 1])))) {
                    isSorted = false;
                    int tmp = indexes[i];
                    indexes[i] = indexes[i + 1];
                    indexes[i + 1] = tmp;
                }
            }
        }

        return indexes;
    }
    private static int[] getSortAgesIndexes(ArrayList<Integer> ages) {
        int[] indexes = getDefaultIndexes(ages.size());

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < indexes.length - 1; i++) {
                if (ages.get(indexes[i]) > ages.get(indexes[i + 1])) {
                    isSorted = false;
                    int tmp = indexes[i];
                    indexes[i] = indexes[i + 1];
                    indexes[i + 1] = tmp;
                }
            }
        }

        return indexes;
    }
    private static int getDigit(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
