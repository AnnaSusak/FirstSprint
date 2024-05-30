public class PlayingField {
    static int sz = 5;
    static String border = "+ -".repeat(sz);
    static int[][] monstersPos = new int[sz][sz];
    public static void setMonstersPos(){
        monstersPos[0][1] = 2;
        monstersPos[0][2] = 2;
        monstersPos[0][3] = 1;
        monstersPos[1][4] = 1;
        monstersPos[1][1] = 2;
        monstersPos[1][0] = 2;
        monstersPos[1][3] = 1;
        monstersPos[1][4] = 2;
        monstersPos[2][1] = 2;
        monstersPos[2][2] = 1;
        monstersPos[2][3] = 1;
        monstersPos[2][4] = 1;
    }
    public static void display(){
        for (int i = 0; i < sz; i++) {
            System.out.println(border);
            for (int j = 0; j < sz; j++) {
                System.out.print("|");
                if (i == 0 && j == 0) {
                    System.out.print("З");
                }
                else if (i == 4 && j == 2) {
                    System.out.print("Гг");
                } else if (monstersPos[i][j] == 1) {
                    System.out.print("Мм");
                } else if (monstersPos[i][j] == 2) {
                    System.out.print("Мб");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println(border);
    }
}
