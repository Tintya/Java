package homework;


public class HW2 {
    public static void main (String[] args) {
        String str1 = "select * from students where";
        String str2 = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String str3 = str2.replace(":", "=")
                .replaceAll("\\p{P}", "")
                .replaceAll(" ", ", ");
        StringBuilder builder = new StringBuilder();
        builder.append(str1).append(str3);
        System.out.println(builder+"\n");

        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String str4 = jsonString.replace("}", "\n")
                .replace(":", " ")
                .replace(",", " ")
                .replaceAll("\\p{P}", "")
                .replaceAll("фамилия", "Студент")
                .replaceAll("оценка", "получил")
                .replaceAll("предмет", "по предмету");
        System.out.println(str4);
    }
}
