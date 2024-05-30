import java.util.Random;

public class PlayingField {
    static int sz = 5;
    static String border = "+ -".repeat(sz);
    static int[][] pos = new int[sz][sz];
    public static int castleX;
    public static int castleY = 0;
    static String castle = "\uD83C\uDFF0";
    static String hero = "\ud83d\ude0e";
    static String bigMonster = "\ud83d\ude21";
    static String littleMonster = "\ud83d\udc79";
    public static void setCastlePos(){
        Random random = new Random();
        castleX = random.nextInt(sz);
        pos[castleY][castleX] = 3;
    }
    public static void setMonstersPos(){
        pos[0][1] = 2;
        pos[0][2] = 2;
        pos[0][3] = 1;
        pos[1][4] = 1;
        pos[1][1] = 2;
        pos[1][0] = 2;
        pos[1][3] = 1;
        pos[1][4] = 2;
        pos[2][1] = 2;
        pos[2][2] = 1;
        pos[2][3] = 1;
        pos[2][4] = 1;
    }
    public static void display(int lives){
        for (int i = 0; i < sz; i++) {
            System.out.println(border);
            for (int j = 0; j < sz; j++) {
                System.out.print("|");
                if (i == 0 && j == castleX) {
                    System.out.print(castle);
                }
                else if (i == 4 && j == 2) {
                    System.out.print(hero);
                } else if (pos[i][j] == 1) {
                    System.out.print(littleMonster);
                } else if (pos[i][j] == 2) {
                    System.out.print(bigMonster);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println(border);
        System.out.println("Количество жизней: " + lives);
    }
}
