import java.util.Scanner;

/**
 * Created by Eason Tse on 1/3/2017.
 */
public class StudentTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入學生名稱: ");
        String StudentName = input.next();

        System.out.print("請輸入學號: ");
        String StudentId = input.next();

        System.out.print("請輸入班級: ");
        String StudentClass = input.next();

        Student Student1 = new Student(args[0], args[1], args[2]);
        Student Student2 = new Student(StudentName, StudentId, StudentClass);

        System.out.println();

        System.out.println("---------- Student 1 ----------");
        System.out.printf("Name: %s%n", Student1.getStudentName());
        System.out.printf("ID: %s%n", Student1.getStudentId());
        System.out.printf("Class: %s%n", Student1.getStudentClass());

        System.out.println("---------- Student 2 ----------");
        System.out.printf("Name: %s%n", Student2.getStudentName());
        System.out.printf("ID: %s%n", Student2.getStudentId());
        System.out.printf("Class: %s%n", Student2.getStudentClass());
    }
}
