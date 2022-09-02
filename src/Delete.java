import java.util.ArrayList;
import java.util.List;

public class Delete {
    public static List<String> DeleteGroup(String group, List<String> StInGr){
        List<String> local = new ArrayList<String>();

        int i = 0;
        for(String str:StInGr){
            if(!str.trim().contains(group))
                local.add(StInGr.get(i));
            i++;
        }
        return local;
    }

    public static List<String> DeleteSub(String group, List<String> GrInSub){
        List<String> local = new ArrayList<String>();

        int i = 0;
        for(String str:GrInSub){
            if(!str.trim().contains(group))
                local.add(GrInSub.get(i));
            i++;
        }
        return local;
    }
}
