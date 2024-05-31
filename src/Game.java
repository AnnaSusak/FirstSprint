import java.util.Scanner;

public class Game {
    public static int difficultGame;
    private static void setPos(){
        PlayingField.setCastlePos();
        PlayingField.setHeroPos();
        PlayingField.setMonstersPos();
    }
    public static void makeMove() {
        int newX = -1;
        int newY= -1;
        Scanner scanner = new Scanner(System.in);
        while (newX == -1 && newY==-1) {
            System.out.print("Введите координату x хода: ");
            newX = scanner.nextInt();
            newX -= 1;
            if (newX < 0 || newX > PlayingField.sz -1||
                    (newX != Hero.xPos + 1 && newX != Hero.xPos - 1 && newX != Hero.xPos)) {
                System.out.println("Некорректный ввод.");
                newX = -1;
            } else {
                System.out.print("Введите координату y хода: ");
                newY = scanner.nextInt();
                newY -= 1;
                if (newY < 0 || newY > PlayingField.sz -1||
                        (newY != Hero.yPos && newX != Hero.xPos) ||
                        (newY!= Hero.yPos + 1 && newY != Hero.yPos - 1 && newY != Hero.yPos)) {
                    System.out.println("Некорректный ввод.");
                    newY = -1;
                } else {
                    PlayingField.pos[(Hero.yPos) ][Hero.xPos] = 0;
                    Hero.xPos = newX;
                    Hero.yPos = newY;
                }
            }
        }
        if (PlayingField.pos[(Hero.yPos) ][Hero.xPos]==0) {
            PlayingField.pos[(Hero.yPos) ][Hero.xPos] = 4;
        } else if (PlayingField.pos[(Hero.yPos) ][Hero.xPos] == (3)) {
            System.out.println("Вы прошли игру");
        } else {
            if (PlayingField.pos[(Hero.yPos) ][Hero.xPos] == (1)) {
                if (LittleMonster.provide_task()) {
                    System.out.println("Верно! Ты победил монстра");
                    Hero.lives++;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    Hero.lives--;
                }
                PlayingField.pos[(Hero.yPos) ][Hero.xPos] = 4;
            }
        }
    }
    public static void play(){
        setPos();
        PlayingField.display(Hero.lives);
        System.out.println("Выбери сложность игры(от 1 до 5):");
        Scanner scanner = new Scanner(System.in);
        difficultGame = scanner.nextInt();
        if (difficultGame < 1 || difficultGame > 5) {
            System.out.println("некорректный ввод");
            return;
        }
        System.out.println("Выбранная сложность:\t" + difficultGame);
        while ((Hero.lives > 0) && !(PlayingField.castleX == Hero.xPos && PlayingField.castleY == Hero.xPos)) {
            PlayingField.display(Hero.lives);
            makeMove();
        }
        if (Hero.lives < 1){
            System.out.println("Вы проиграли(");
        }
    }
    public static void startGame(){
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "ДА":
                play();
                break;
            case "НЕТ":
                System.out.println("Почему ты не захотел со мной играть(");
                System.out.println("Приходи ещё!");
                break;
            default:
                System.out.println("некорректный ввод");
                break;
        }
    }
}
