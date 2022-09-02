import java.util.Scanner;

public class Group extends Student{


    private String groupName;


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Group(){
    }

    public Group(String groupName, String studentName){
        this.groupName = groupName;
        super.setStudentName(studentName);
    }

    public void displayGS(){
        System.out.println(getGroupName());
        System.out.println(getStudentName());
    }

    public static String addGroup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название группы:");
        return sc.nextLine();
    }


}
