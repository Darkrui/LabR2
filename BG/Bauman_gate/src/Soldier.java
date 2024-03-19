public class Soldier extends Unit{
    public Soldier(int type, String symbol, int x, int y) {
        switch (type) {
            case 1:
                name = "Мечник";
                this.symbol = symbol;
                health = 50;
                maximumHealth = 50;
                damage = 1000;
                attackRange = 1;
                defence = 8;
                moveDistance = 3;
                price = 10;
                treeMove = (float)1.2;
                hillMove = 2;
                swampMove = (float) 1.5;
                this.x = x;
                this.y = y;
                break;
            case 2:
                name = "Копьеносец";
                this.symbol = symbol;
                health = 35;
                maximumHealth = 35;
                damage = 3;
                attackRange = 1;
                defence = 4;
                moveDistance = 6;
                price = 15;
                treeMove = (float)1.2;
                hillMove = 2;
                swampMove = (float) 1.5;
                this.x = x;
                this.y = y;
                break;
            case 3:
                name = "Топорщик";
                this.symbol = symbol;
                health = 45;
                maximumHealth = 45;
                damage = 9;
                attackRange = 1;
                defence = 3;
                moveDistance = 4;
                price = 20;
                treeMove = (float)1.2;
                hillMove = 2;
                swampMove = (float) 1.5;
                this.x = x;
                this.y = y;
                break;
        }
    }
}
