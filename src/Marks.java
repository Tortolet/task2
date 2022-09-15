import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marks {
    private String nameSt;
    private String groupSt;
    private String subjectSt;
    private int markSt;


    public String getNameSt() {
        return nameSt;
    }

    public void setName(String name) {
        this.nameSt = name;
    }

    public String getGroupSt() {
        return groupSt;
    }

    public void setGroupSt(String groupSt) {
        this.groupSt = groupSt;
    }

    public String getSubjectSt() {
        return subjectSt;
    }

    public void setSubjectSt(String subjectSt) {
        this.subjectSt = subjectSt;
    }

    public int getMarkSt() {
        return markSt;
    }

    public void setMarkSt(int markSt) {
        this.markSt = markSt;
    }

    public Marks(String nameSt, String groupSt, String subjectSt, int markSt) {
        this.nameSt = nameSt;
        this.groupSt = groupSt;
        this.subjectSt = subjectSt;
        this.markSt = markSt;
    }

    public static void save(List<String> students, List<String> groups, List<String> subjects, List<Marks> marks, List<String> StInGr) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО");
        String fio = scanner.nextLine();
        System.out.println("Введите группу");
        String gr = scanner.nextLine();
        System.out.println("Введите предмет");
        String sj = scanner.nextLine();
        System.out.println("Введите оценку");
        int mk = scanner.nextInt();

        String localFio = Search.SearchFio(fio,StInGr);
        String localGr = Search.SearchGroup(gr,StInGr);


        if(!localFio.equals(fio) || !localGr.equals(gr) && subjects.contains(sj)) // Исправить (см. выше) или исправить StInGr удалив первый и последний символ.
            System.out.println("Ошибочка");
        else {
            marks.add(new Marks(fio, gr, sj, mk));
            System.out.println("Вы успешно добавили новую оценку");
        }
    }

    public static void show(List<Marks> marks){
        System.out.println("\n");
        for (Marks mark : marks) {
            System.out.println("ФИО: " + mark.getNameSt());
            System.out.println("Группа: " + mark.getGroupSt());
            System.out.println("Предмет: " + mark.getSubjectSt());
            System.out.println("Оценка: " + mark.getMarkSt());
        }
    }

}
