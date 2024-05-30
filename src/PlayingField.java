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
    public static void setHeroPos(){
        Random random = new Random();
        Hero.xPos = random.nextInt(sz);
        pos[Hero.yPos][Hero.xPos] = 4;
    }
    public static void setMonstersPos(){
        int curMonserNum = 0;
        Random random = new Random();
        while (curMonserNum < 12) {
            int x = random.nextInt(sz);
            int y = random.nextInt(sz);
            if (pos[x][y] == 0) {
                curMonserNum++;
                if (curMonserNum > 6) {
                    pos[x][y] = 2;
                } else {
                    pos[x][y] = 1;
                }
            }
        }
    }
    public static void display(int lives){
        for (int i = 0; i < sz; i++) {
            System.out.println(border);
            for (int j = 0; j < sz; j++) {
                System.out.print("|");
                switch (pos[i][j]){
                    case 1:
                        System.out.print(littleMonster);
                        break;
                    case 2:
                        System.out.print(bigMonster);
                        break;
                    case 3:
                        System.out.print(castle);
                        break;
                    case 4:
                        System.out.print(hero);
                        break;
                    default:
                        System.out.print("  ");
                        break;
                }
            }
            System.out.println("|");
        }
        System.out.println(border);
        System.out.println("Количество жизней: " + lives);
    }
}
