import java.util.Arrays;

public class equalsoperators {
    public static void main(String[] args) {
        String str = "Hello Sujan";
        String charstr[]= str.split(" ");
        String reversed="";
        StringBuilder sb= new StringBuilder(Arrays.toString(charstr));
        System.out.println(sb.reverse());
    }
}
