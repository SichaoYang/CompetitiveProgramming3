import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        
        
        TreeSet<Integer> set = new TreeSet<>((i, j) -> j > i ? 1 : -1);
        set.add(2);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        System.out.println(set);
    }
}