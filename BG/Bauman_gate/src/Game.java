import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Flow;

public class Game {
    private int rows;
    private int columns;
    private Field field;
    private ArrayList<Unit> playerUnits = new ArrayList<>();
    private ArrayList<Unit> enemyUnits = new ArrayList<>();
    private  boolean IsGameFinished = false;
    public Game(){
        rows = 10;
        columns = 10;
        field = new Field(10, 10);
        for(int i = 0; i < rows; i++ ){
            for (int j = 0; j < columns; j++ ){
                field.setFieldable(i, j, new Empty());
            }
        }
        field.setFieldable(1, 0, new Tree());
        field.setFieldable(1, 1, new Hill());
        field.setFieldable(1, 2, new Swamp());
        field.setFieldable(8, 0, new Tree());
        field.setFieldable(8, 1, new Tree());

        /*playerUnits.add(new Soldier(1, "1", 0, 0));
        playerUnits.add(new Soldier(1, "2", 0, 1));
        playerUnits.add(new Horseman(2, "3", 0, 2));*/

        enemyUnits.add(new Archer(3, "A", 9, 0));
        enemyUnits.add(new Soldier(2, "B", 9, 1));
    }
    int AmountOfMoney = 100;
    public void Shop(){
        System.out.println("Добро пожаловать в лучшие из худших казарм Тылета!\n"+
                "Скольких старых вояк вы хотите позвать с собой? (меньше 10)");
        Scanner comanda = new Scanner(System.in);
        int AmountOfUnits;
        while(true){
            AmountOfUnits = comanda.nextInt();
            if (AmountOfUnits >= 10){
                System.out.println("Э не, брат, так не пойдет, так много с тобой не пойдет!\n");
            }
            else {
                break;
            }
        }
        if (AmountOfMoney < AmountOfUnits*10) {
            System.out.println("Денег нет, командир! Вы пойдете в бой с командой 'Альфа'! ");
            playerUnits.add(new Soldier(1, "1", 0, 0));
            playerUnits.add(new Soldier(1, "2", 0, 1));
            playerUnits.add(new Horseman(2, "3", 0, 2));
        }
        else{
            System.out.println("1. Мечник: здоровье 50, атака 1000, дистанция атаки 1, цена 10\n"
                    + "2. Копейщик: здоровье 35, атака 3, дистанция атаки 1, цена  15\n" +
                    "3. Топорщик: здоровье 45, атака 9, дистанция атаки 1, цена  20\n"
                    + "4. Рыцарь: здоровье 30 , атака 5, дистанция атаки 1, цена 23\n"
                    + "5. Керасир: здоровье 50, атака 1000, дистанция атаки 1000, цена 23\n"
                    + "6. Конный лучник: урон 25, атака 3, дистанция атаки 3, цена 25\n" +
                    "7. Лучник с длинным луком: здоровье 30, атака 6, дистанция атаки 5, цена 15\n"
                    + "8. Лучник с коротким луком: здоровье 25, атака 3, дистанция атаки 3, цена 23\n" +
                    "9. Арбалетчик: здоровье 40, атака 7, дистанция атаки 6, цена 23\n");
            Scanner ShopChoiceTwo = new Scanner(System.in);
            int ChoiceOfUnitTwo;
            for (int i = 0; i < AmountOfUnits; i++){
                if (AmountOfMoney < 10){
                    System.out.println("\nДеньги кончились, командир! Пора бы и в бой!\n");
                    break;}
                System.out.println("Кого желаете позвать в свою команду?\n"
                        + "Текущие средства: " + AmountOfMoney);
                boolean choiceFlag = false;
                while(!choiceFlag) {
                    ChoiceOfUnitTwo = ShopChoiceTwo.nextInt();
                    switch (ChoiceOfUnitTwo) {
                        case 1:
                            if (AmountOfMoney < 10) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Soldier(1, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 10;
                            break;
                        case 2:
                            if (AmountOfMoney < 15) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Soldier(2, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 15;
                            break;
                        case 3:
                            if (AmountOfMoney < 20) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Soldier(3, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 20;
                            break;
                        case 4:
                            if (AmountOfMoney < 23) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Horseman(1, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 23;
                            break;
                        case 5:
                            if (AmountOfMoney < 23) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Horseman(2, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 23;
                            break;
                        case 6:
                            if (AmountOfMoney < 25) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Horseman(3, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 25;
                            break;
                        case 7:
                            if (AmountOfMoney < 15) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Archer(1, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 15;
                            break;
                        case 8:
                            if (AmountOfMoney < 23) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Archer(2, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 23;
                            break;
                        case 9:
                            if (AmountOfMoney < 23) {
                                System.out.println("Денег нет, командир! Выберете другого бойца!");
                                break;
                            }
                            choiceFlag = true;
                            playerUnits.add(new Archer(3, Integer.toString(i+1), 0, i));
                            AmountOfMoney = AmountOfMoney - 23;
                            break;
                        default:
                            System.out.println("Выберите правильный номер бойца!!");
                    }
                }
            }
        }
    }

    public void InformationOfPlayer(){
        System.out.println("Ваши юниты: \n");
        for (int i = 0; i < playerUnits.size(); i++){
            System.out.println( playerUnits.get(i).getName() + "(Символ на поле: " + playerUnits.get(i).getSymbol().strip() + ")");
            System.out.println("Здоровье: " + playerUnits.get(i).getHealth()+"/" + playerUnits.get(i).getMaximumHealth());
            System.out.println("Защита: " + playerUnits.get(i).getDefence());
            System.out.println("Дистанция передвижения: " + playerUnits.get(i).getMoveDistance());
            System.out.println("Урон: " + playerUnits.get(i).getDamage() + "\n");
        }
    }
    public void InformationOfEnemy(){
        System.out.println("Ваши враги: \n");
        for (int i = 0; i < enemyUnits.size(); i++){
            System.out.println( enemyUnits.get(i).getName() + "(Символ на поле: " + enemyUnits.get(i).getSymbol().strip() + ")");
            System.out.println("Здоровье: " + enemyUnits.get(i).getHealth()+"/" + enemyUnits.get(i).getMaximumHealth());
        }
    }
    public void InformationOfPlayerInGame(){
        for (int i = 0; i < playerUnits.size(); i++){
            if(playerUnits.get(i).health != 0 ) {
                System.out.println(playerUnits.get(i).getName() + "(Символ на поле: " + playerUnits.get(i).getSymbol().strip() + ")");
                System.out.println("Здоровье: " + playerUnits.get(i).getHealth() + "/" + playerUnits.get(i).getMaximumHealth());
            }
        }
    }
    public void StartGame(){
        PlaceEnemies();
        PlacePlayer();
        InformationOfPlayer();
        while (!IsGameFinished){
            ShowField();
            InformationOfPlayerInGame();
            InformationOfEnemy();
            PlayerTurn();
            ComputerTurn();
            CheckIfGameNotFinished();
        }
    }
    private void ShowField(){
        field.showField();
    }
    private void PlayerTurn(){
        String unit;
        Unit chosed = new Unit();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Выберите Юнит (символ): ");
            unit = scanner.next().strip();
            for (int i = 0; i < playerUnits.size(); i++) {
                if (playerUnits.get(i).getHealth() == 0)
                    continue;
                if (playerUnits.get(i).getSymbol().strip().equals(unit)) {
                    chosed = playerUnits.get(i);
                    flag = false;
                }
            }
        }
        int command;
        boolean flagCommand = true;
        while(flagCommand){
            System.out.println("Выберите действие:\n" +
                    "1. Атака\n" +
                    "2. Движение\n" +
                    "3. Ничего (пропуск)");
            command = scanner.nextInt();
            switch (command){
                case 1:
                    flag = true;
                    Unit enemy = new Unit();
                    while(flag) {
                        System.out.println("Выберите врага (символ): ");
                        unit = scanner.next().strip();
                        for (int i = 0; i < enemyUnits.size(); i++) {
                            if (enemyUnits.get(i).getHealth() == 0)
                                continue;
                            if (enemyUnits.get(i).getSymbol().strip().equals(unit)) {
                                enemy = enemyUnits.get(i);
                                flag = false;
                            }
                        }
                    }
                    chosed.attack(enemy);
                    flagCommand = false;
                    break;
                case 2:
                    int direction;
                    int cells;
                    flag = true;
                    System.out.println("Выберите направление:\n" +
                            "1. Вверх\n" +
                            "2. Вниз\n" +
                            "3. Влево\n" +
                            "4. Вправо ");
                    direction = scanner.nextInt();
                    System.out.println("Выберите количество клеток для передвижения:");
                    cells = scanner.nextInt();
                    switch(direction) {
                        case 1:
                            chosed.move(field, chosed.getX() - cells, chosed.getY());
                            break;
                        case 2:
                            chosed.move(field, chosed.getX() + cells, chosed.getY());
                            break;
                        case 3:
                            chosed.move(field, chosed.getX(), chosed.getY() - cells);
                            break;
                        case 4:
                            chosed.move(field, chosed.getX(), chosed.getY() + cells);
                            break;
                    }
                    flagCommand = false;
                    break;
                case 3:
                    flagCommand = false;
                    break;
                default:
                    System.out.println("Команда не распознана. Пожалуйста, попробуйте снова.");
            }
        }
    }
    private void ComputerTurn(){
        int healthSumEnemy = 0;
        for(int i = 0; i < enemyUnits.size(); i++)
            healthSumEnemy += enemyUnits.get(i).getHealth();
        if (healthSumEnemy == 0)
            return;
        Random ran = new Random();
        boolean liveFlag = false;
        Unit chosed = new Unit();
        while(!liveFlag) {
            int index = ran.nextInt(0, enemyUnits.size());
            if (enemyUnits.get(index).getHealth() == 0)
                continue;
            chosed = enemyUnits.get(index);
            liveFlag = true;
        }
        Unit victim = new Unit();
        for (int i = 0; i < playerUnits.size(); i++) {
            victim = playerUnits.get(i);
            boolean attacked = chosed.attack(victim);
            if (attacked)
                return;
        }
        for (int i = chosed.getMoveDistance(); i > 0; i--)
            if (chosed.move(field,chosed.getX() - i, chosed.getY()))
                break;
    }
    private void CheckIfGameNotFinished(){
        int healthSumPlayer = 0;
        int healthSumEnemy = 0;
        for(int i = 0; i < playerUnits.size(); i++)
            healthSumPlayer += playerUnits.get(i).getHealth();
        for(int i = 0; i < enemyUnits.size(); i++)
            healthSumEnemy += enemyUnits.get(i).getHealth();
        if (healthSumPlayer == 0)
            IsGameFinished = true;
        if (healthSumEnemy == 0)
            IsGameFinished = true;
        if (IsGameFinished = true && healthSumEnemy == 0) {
            AmountOfMoney = AmountOfMoney + 25;
            System.out.println("\nПоздравляем! Вы смогли победить Черных рыцарей и защитили город!!!");
            System.out.println("\nНачать новую игру?\n" + "1. Да\n" + "2. Нет");
            Scanner choiseOne = new Scanner(System.in);
            int ChoiseOne;
            ChoiseOne = choiseOne.nextInt();
            switch (ChoiseOne) {
                case 1:
                    Game game = new Game();
                    game.InformationOfPlayer();
                    game.StartGame();
                    break;
                case 2:
                    Main.StartMenu();
                    break;
                default:
                    System.out.println("Команда не распознана. Выход в меню....");
                    Main.StartMenu();
            }
        }
        if (IsGameFinished = true && healthSumPlayer == 0){
            AmountOfMoney = AmountOfMoney - 25;
            System.out.println("\nВы погибли, защищая город.... Тылета будет вспоминать Вас, как героя!");
            System.out.println("\nНачать новую игру?\n" + "1. Да\n" + "2. Нет");
            Scanner choiseTwo = new Scanner(System.in);
            int ChoiseTwo;
            ChoiseTwo = choiseTwo.nextInt();
            switch (ChoiseTwo) {
            case 1:
                Game game = new Game();
                game.InformationOfPlayer();
                game.StartGame();
                break;
            case 2:
                Main.StartMenu();
                break;
            default:
                System.out.println("Команда не распознана. Выход в меню....");
                Main.StartMenu();
        }
        }
    }
    private void PlaceEnemies(){
        for(int i = 0; i < enemyUnits.size(); i++) {
            Unit U = enemyUnits.get(i);
            field.setFieldable(U.getX(), U.getY(), U);
        }
    }
    private void PlacePlayer(){
        for(int i = 0; i < playerUnits.size(); i++) {
            Unit U = playerUnits.get(i);
            field.setFieldable(U.getX(), U.getY(), U);
        }
    }

}