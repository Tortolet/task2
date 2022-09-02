import java.util.Scanner;

public class Subject extends Group{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
    }

    public Subject(String groupName, String name) {
        super.setGroupName(groupName);
        this.name = name;
    }

    public static String addSubject(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название предмета:");
        return sc.nextLine();
    }

    public void displayGrSub(){
        System.out.println(getGroupName());
        System.out.println(getName());
    }


}
