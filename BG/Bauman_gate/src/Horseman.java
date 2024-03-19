public class Horseman extends Unit{
    public Horseman(int type, String symbol, int x, int y) {
        switch(type) {
            case 1:
                name = "Рыцарь";
                this.symbol = symbol;
                health = 30;
                maximumHealth = 30;
                damage = 5;
                attackRange = 1;
                defence = 3;
                moveDistance = 6;
                price = 20;
                treeMove = (float)1.5;
                hillMove = (float)1.2;
                swampMove = (float)2.2;
                this.x = x;
                this.y = y;
                break;
            case 2:
                name = "Кирасир";
                this.symbol = symbol;
                health = 50;
                maximumHealth = 50;
                damage = 1000;
                attackRange = 1000;
                defence = 7;
                moveDistance = 5;
                price = 23;
                treeMove = (float)1.5;
                hillMove = (float)1.2;
                swampMove = (float)2.2;
                this.x = x;
                this.y = y;
                break;
            case 3:
                name = "Конный лучник";
                this.symbol = symbol;
                health = 25;
                maximumHealth = 25;
                damage = 3;
                attackRange = 3;
                defence = 2;
                moveDistance = 5;
                price = 25;
                treeMove = (float)1.5;
                hillMove = (float)1.2;
                swampMove = (float)2.2;
                this.x = x;
                this.y = y;
                break;
        }
    }
}
