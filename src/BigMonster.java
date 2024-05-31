import java.util.Random;
import java.util.Scanner;

public class BigMonster {
    public static boolean provide_task(int difficulty) {
        Random r = new Random();
        int trueAnswer = 0, x, y;
        switch (difficulty) {
            case 1:
                x = r.nextInt(500);
                y = r.nextInt(500);
                trueAnswer = y * x;
                System.out.println("Реши пример: " + x + " * " + y + " = ?");
                break;
            case 2:
                x = r.nextInt(5);
                y = r.nextInt(10);
                trueAnswer = (int) Math.pow(y, x);
                System.out.println("Реши пример: " + y + " ^ " + x + " = ?");
                break;
            case 3:
                x = r.nextInt(500);
                y = r.nextInt(1000);
                int n = r.nextInt(2000);
                trueAnswer = (y - n) / x;
                System.out.println("Найди x " + x  + "x" + n + " = y");
                break;
            case 4:
                trueAnswer = r.nextInt(10);
                System.out.println("Реши пример: " + "log " + trueAnswer * trueAnswer + " = ?");
                break;
            case 5:
                trueAnswer = r.nextInt(3);
                System.out.println("угадай число от 0 до 3");
                break;
            default:
                break;
        }
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            return true;
        }
        return false;
    }
}
