import java.util.Scanner;

public class Student {

    private String studentName;


    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public Student() {
    }


    public static String addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя студента:");
        return sc.nextLine();
    }
}
