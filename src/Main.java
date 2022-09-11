import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> groups = new ArrayList<String>();
        List<String> students = new ArrayList<String>();
        List<String> subjects = new ArrayList<String>();

        List<String> local;
        List<String> StInGr = new ArrayList<String>();
        List<String> GrInSub = new ArrayList<String>();
        List<Marks> marks = new ArrayList<>();
        /*                   Test
        marks.add(new Marks("Петя", "П-184", "Алгебра", 5));
        marks.add(new Marks("Саша", "П-185", "Алгебра", 4));
         */
        int number = 100;

        try {
            while(number!=0) {
                System.out.println("\nВыберете действие, которое хотите совершить:\n");
                System.out.println("----------------------------Добавление----------------------------");
                System.out.println("1. Добавить новый предмет");
                System.out.println("2. Добавить новую группу");
                System.out.println("3. Добавить нового студента");
                System.out.println("4. Добавить студента в группу");
                System.out.println("5. Добавить группу к предмету");
                System.out.println("----------------------------Просмотр------------------------------");
                System.out.println("6. Посмотреть все предметы");
                System.out.println("7. Посмотреть все группы");
                System.out.println("8. Посмотреть всех студентов");
                System.out.println("9. Посмотреть всех студентов по группам");
                System.out.println("10. Посмотреть все предметы по группам");
                System.out.println("----------------------------Поиск---------------------------------");
                System.out.println("11. Поиск предметов по ФИО");
                System.out.println("12. Поиск группы по ФИО");
                System.out.println("----------------------------Прочее--------------------------------");
                System.out.println("13. Удаление группу и всех студентов в ней");
                System.out.println("14. Добавить оценку");
                System.out.println("15. Посмотреть все оценки");
                System.out.println("0. Выход");
                number = sc.nextInt();

                switch (number) {
                    case 1 -> subjects.add(Subject.addSubject());
                    case 2 -> groups.add(Group.addGroup());
                    case 3 -> students.add(Student.addStudent());
                    case 4 -> {
                        local = addStudentInGr(groups, students);
                        if (local!=null)
                            StInGr.add(local.toString()); // Исправить, при необходимости (см. ниже)
                    }
                    case 5 -> {
                        local = addGroupInSub(groups, subjects);
                        if (local!=null)
                            GrInSub.add(local.toString()); // Исправить, при необходимости (см. ниже)
                    }
                    case 6 -> {
                        System.out.println("\nПредметы:");
                        for (String subject : subjects)
                            System.out.println(subject);
                    }
                    case 7 -> {
                        System.out.println("\nГруппы:");
                        for (String group : groups)
                            System.out.println(group);
                    }
                    case 8 -> {
                        System.out.println("\nСтуденты:");
                        for (String student : students)
                            System.out.println(student);
                    }
                    case 9 -> {
                        System.out.println("\nСтуденты по группам:");
                        for (String studentGroup : StInGr)
                            System.out.println(studentGroup);
                    }
                    case 10 -> {
                        System.out.println("\nПредметы по группам:");
                        for (String SubGroup : GrInSub)
                            System.out.println(SubGroup);
                    }
                    case 11 -> {
                        System.out.println("\nПоиск предметов по ФИО:\n");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Введите ФИО:");
                        String fio = scanner.nextLine();
                        Search.SearchSubjects(fio, StInGr, GrInSub);
                    }
                    case 12 -> {
                        System.out.println("\nПоиск группы по ФИО:\n");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Введите ФИО:");
                        String fio = scanner.nextLine();
                        Search.SearchGroups(fio, StInGr);
                    }
                    case 13 -> {
                        System.out.println("\nУдаление группы:\n");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Введите группу:");
                        String group = scanner.nextLine();


                        System.out.println("Результат:\n");
                        StInGr = Delete.DeleteGroup(group, StInGr);
                        for (String ost : StInGr)
                            System.out.println(ost);
                        GrInSub = Delete.DeleteSub(group, GrInSub);
                        for (String ost : GrInSub)
                            System.out.println(ost);
                    }
                    case 14 -> {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Введите ФИО");
                        String fio = scanner.nextLine();
                        System.out.println("Введите группу");
                        String gr = scanner.nextLine();
                        System.out.println("Введите предмет");
                        String sj = scanner.nextLine();
                        System.out.println("Введите оценку");
                        int mk = scanner.nextInt();

//                        String localFio = Search.SearchFio(fio,StInGr);
//                        String localGr = Search.SearchGroup(gr,StInGr);


                        if(!students.contains(fio) || !groups.contains(gr) && subjects.contains(sj)) // Исправить (см. выше) или исправить StInGr удалив первый и последний символ.
                            System.out.println("Ошибочка");
                        else {
                            marks.add(new Marks(fio, gr, sj, mk));
                            System.out.println("Вы успешно добавили новую оценку");
                        }
                    }
                    case 15 -> Marks.show(marks);

                }
            }
            System.exit(0);
        }
        catch (Exception exception){
            System.out.println("Ошибка, неверно введенный выбор.");
        }
    }

    public static List<String> addStudentInGr(List<String> groups, List<String> students){
        List<String> local = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите группу:");
            String gr = scanner.nextLine();
            System.out.println("Введите ФИО студента:");
            String fio = scanner.nextLine();

            if (!groups.contains(gr) || !students.contains(fio)) {
                System.out.println("Такой группы или студента не существует");
                return null;
            }

            Group groupSt = new Group(gr, fio);
            local.add(gr + " " + fio);
            groupSt.displayGS();
        }
        catch (Exception exception){
            System.out.println("Ошибка!");
        }
        return local;
    }

    public static List<String> addGroupInSub(List<String> groups, List<String> subjects){
        List<String> local = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите группу:");
            String gr = scanner.nextLine();
            System.out.println("Введите предмет:");
            String sub = scanner.nextLine();

            if (!groups.contains(gr) || !subjects.contains(sub)) {
                System.out.println("Такой группы или предмета не существует");
                return null;
            }

            Subject subject = new Subject(gr, sub);
            local.add(gr + " " + sub);
            subject.displayGrSub();
        }
        catch (Exception exception){
            System.out.println("Ошибка!");
        }
        return local;
    }

}
