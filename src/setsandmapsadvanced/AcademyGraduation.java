package setsandmapsadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).addAll(grades);
        }
        System.out.println(printStudents(students));
    }

    private static String printStudents(Map<String, List<Double>> students) {
        StringBuilder builder = new StringBuilder();

        for (String student : students.keySet()) {
            builder.append(student)
                    .append(" is graduated with ")
                    .append(getAverageGrade(students.get(student)))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static Double getAverageGrade(List<Double> grades) {
        double total = 0;
        for (Double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }
}
