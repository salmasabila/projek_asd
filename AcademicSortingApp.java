import java.util.Scanner;

public class AcademicSortingApp {

    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void bubbleSort(Student[] students, boolean sortByGrade, boolean ascending) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition;
                if (sortByGrade) {
                    condition = ascending ? (students[j].grade > students[j + 1].grade)
                                          : (students[j].grade < students[j + 1].grade);
                } else {
                    condition = ascending ? (students[j].name.compareTo(students[j + 1].name) > 0)
                                          : (students[j].name.compareTo(students[j + 1].name) < 0);
                }

                if (condition) {
                    // Swap students[j] and students[j+1]
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Student[] students, boolean sortByGrade, boolean ascending) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student key = students[i];
            int j = i - 1;

            while (j >= 0) {
                boolean condition;
                if (sortByGrade) {
                    condition = ascending ? (students[j].grade > key.grade)
                                          : (students[j].grade < key.grade);
                } else {
                    condition = ascending ? (students[j].name.compareTo(key.name) > 0)
                                          : (students[j].name.compareTo(key.name) < 0);
                }

                if (!condition) break;

                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
    }

    public static void printStudents(Student[] students) {
        System.out.println("\nSorted Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Grade: " + student.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students[i] = new Student(name, grade);
        }

        System.out.println("\nChoose sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.println("\nSort by:");
        System.out.println("1. Grade");
        System.out.println("2. Name");
        System.out.print("Enter your choice: ");
        int sortBy = scanner.nextInt();
        boolean sortByGrade = (sortBy == 1);

        System.out.println("\nOrder:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Enter your choice: ");
        int order = scanner.nextInt();
        boolean ascending = (order == 1);

        switch (choice) {
            case 1:
                bubbleSort(students, sortByGrade, ascending);
                System.out.println("\nData sorted using Bubble Sort.");
                break;
            case 2:
                insertionSort(students, sortByGrade, ascending);
                System.out.println("\nData sorted using Insertion Sort.");
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        printStudents(students);
        scanner.close();
    }
}
