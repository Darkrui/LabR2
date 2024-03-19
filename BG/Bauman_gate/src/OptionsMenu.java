import java.util.Scanner;

public class OptionsMenu {
    static Scanner scanner = new Scanner(System.in);
    static int command;
    public static void showOptionsMenu(){
        do{
            System.out.println("Сделайте выбор и нажпите Enter:\n"+
                    "1: Выбор размера поля\n"+
                    "2: Обратно в меню ");
            command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.println("\n Текущие настройки:\n"+
                            "Строки: "  + "10" + "\n Столбцы: " + "10\n");
                    Main.StartMenu();
                    break;
                case 2:
                    Main.StartMenu();
                    break;
                default:
                    System.out.println("Команда не распознана. Попробуйте снова.");
            }
        }
        while (command != 3);
    }
}
