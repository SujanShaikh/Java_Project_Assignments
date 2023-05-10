package Collections;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadFileExample {
    public static void main(String[] args) {
        HashMap<String,Integer> studentdata=new HashMap<>();
        studentdata.put("Sujan",88);
        studentdata.put("Tanmay",77);
        studentdata.put("Aryaman",98);

       Iterator<Map.Entry<String,Integer>> iterator = studentdata.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            if (entry.getValue() == 98) {
                iterator.remove();
            }
           // System.out.println(entry);

        }
        Iterator<Map.Entry<String,Integer>> iterator1 = studentdata.entrySet().iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}



