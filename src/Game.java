import java.util.Scanner;

public class Game {
    public static int difficultGame;
    public static void play(){
        PlayingField.setCastlePos();
        PlayingField.setMonstersPos();
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
            // логика хода
        }
        if (PlayingField.castleX == Hero.xPos && PlayingField.castleY == Hero.xPos) {
            System.out.println("Поздравляем! Вы выиграли!");
        } else {
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
