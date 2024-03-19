public class Archer extends Unit{
    public Archer(int type, String symbol, int x, int y) {
        switch(type) {
            case 1:
                name = "Лучник с длинным луком";
                this.symbol = symbol;
                health = 30;
                maximumHealth = 30;
                damage = 6;
                attackRange = 5;
                defence = 8;
                moveDistance = 2;
                price = 15;
                treeMove = 1;
                hillMove = (float)2.2;
                swampMove = (float)1.8;
                this.x = x;
                this.y = y;
                break;
            case 2:
                name = "Лучник с коротким луком";
                this.symbol = symbol;
                health = 25;
                maximumHealth = 25;
                damage = 3;
                attackRange = 3;
                defence = 4;
                moveDistance = 4;
                price = 19;
                treeMove = 1;
                hillMove = (float)2.2;
                swampMove = (float)1.8;
                this.x = x;
                this.y = y;
                break;
            case 3:
                name = "Воин с арбалетом";
                this.symbol = symbol;
                health = 40;
                maximumHealth = 40;
                damage = 7;
                attackRange = 6;
                defence = 3;
                moveDistance = 2;
                price = 23;
                treeMove = 1;
                hillMove = (float)2.2;
                swampMove = (float)1.8;
                this.x = x;
                this.y = y;
                break;
        }
    }
}
