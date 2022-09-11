import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void SearchSubjects(String fio, List<String> StInGr, List<String> GrInSub){
        String find = null;
        String local;

        int i = 0;
        for(String str:StInGr){
            if(str.trim().contains(fio))
                find = StInGr.get(i);
            i++;
        }

        local = find; // Запись нужной фамилии с группой

        String separator =" ";
        int sepPos = find.indexOf(separator);
        if (sepPos == -1) {
            System.out.println("");
        }

        List<String> loc = new ArrayList<String>();

        i=0;
        String local1 = local.substring(1,local.indexOf(" "));
        for(String str:GrInSub){
            if(str.trim().contains(local1)) {
                str = GrInSub.get(i);
                loc.add(str);
            }
            i++;
        }


        String test = local.substring(sepPos + separator.length());

        StringBuffer stringBuffer = new StringBuffer(test);

        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println("\nСтудент:\n" + stringBuffer);
        System.out.println("\nПредметы:");
        for (String test1 : loc) {
            test1 = test1.substring(sepPos + separator.length());
            StringBuffer stringBuffer1 = new StringBuffer(test1);
            stringBuffer1.deleteCharAt(stringBuffer1.length() - 1);
            System.out.println(stringBuffer1);
        }
    }

    public static void SearchGroups(String fio, List<String> StInGr) throws Exception {
        String find = null;
        String local;

        int i = 0;
        for(String str:StInGr){
            if(str.trim().contains(fio))
                find = StInGr.get(i);
            i++;
        }

        local = find; // Запись нужной фамилии с группой

        String separator =" ";
        int sepPos = find.indexOf(separator);
        if (sepPos == -1) {
            System.out.println("");
        }

        String res = null;
        if(local!=null)
            res = local.substring(1,local.indexOf(" "));
        if(res==null)
            throw new Exception();
        String test = local.substring(sepPos + separator.length());
        StringBuffer stringBuffer = new StringBuffer(test);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println("\nСтудент:\n" + stringBuffer + "\n\nГруппа:");
        System.out.println(res);

    }
}
