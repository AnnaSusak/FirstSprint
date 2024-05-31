import java.util.Random;
import java.util.Scanner;

public class LittleMonster {
    public static boolean provide_task() {
        Random r = new Random();
        int x = r.nextInt(300);
        int y = r.nextInt(300);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            return true;
        }
        return false;
    }
}
