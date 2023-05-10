package java_week2_classwork;

public class StringDemo {
    public static void main(String[] args) {
        String name="sujan";
        char ch[]=name.toCharArray();
        for(int i=0;i< ch.length;i++){
            System.out.println(ch[i]);
        }
        System.out.println(ch);
    }
}
