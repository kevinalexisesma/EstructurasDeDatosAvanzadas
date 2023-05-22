import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
    	Set<Integer> color = new HashSet<>();
        int[] numArray = new int[N];
    	for(int i = 0; i < N; i++) {
    		numArray[i] = sc.nextInt();
    		color.add(numArray[i]);
    	}
    	System.out.println(color.size());
    }
}