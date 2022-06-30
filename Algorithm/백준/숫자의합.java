import java.util.Arrays;
import java.util.Scanner;

public class 숫자의합 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        String numSet = sc.next();

        String[] nums = numSet.split("");
        int answer = Arrays.stream(nums).mapToInt(i -> Integer.parseInt(i)).sum();

        System.out.println(answer);
    }
}
