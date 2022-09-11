import java.util.ArrayList;
import java.util.List;

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

    public void save(){

    }

    public static void show(List<Marks> marks){
        for (Marks mark : marks) {
            System.out.println("ФИО: " + mark.getNameSt());
            System.out.println("Группа: " + mark.getGroupSt());
            System.out.println("Предмет: " + mark.getSubjectSt());
            System.out.println("Оценка: " + mark.getMarkSt());
        }
    }

}
