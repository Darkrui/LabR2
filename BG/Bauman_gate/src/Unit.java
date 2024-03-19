public class Unit implements Fieldable{
    String name;
    String symbol;
    int health;
    int maximumHealth;
    int damage;
    int attackRange;
    int defence;
    int moveDistance;
    int price;
    float treeMove;
    float hillMove;
    float swampMove;
    int x;
    int y;
    int Price;
    public Unit() {}
    public Unit (String Name) {
        name = Name;
        symbol = "U";
        health = 100;
        maximumHealth = 100;
        damage = 100;
        attackRange = 2;
        defence = 100;
        moveDistance = 5;
        price = 100;
        treeMove = 2;
        hillMove = 2;
        swampMove = 2;
        x = 0;
        y = 0;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }
    public int getDamage() {
        return damage;
    }
    public int getPrice() {
        return price;
    }
    public int getHealth() {
        return health;
    }
    public int getMoveDistance() {
        return moveDistance;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean move(Field field, int newX, int newY) {
        if (newX < 0)
            return false;
        if (newY < 0)
            return false;
        if (newX >= field.getSizeX())
            return false;
        if (newY >= field.getSizeX())
            return false;
        if (!field.getField(newX, newY).equalSymbol(" * "))
            return false;
        if (newX == x && newY == y)
            return false;
        if (newX != x && newY != y)
            return false;
        if (newX == x) {
            int minIndex = Math.min(y, newY);
            int maxIndex = Math.max(y, newY);
            float distance = 0;
            for (int i = minIndex; i < maxIndex + 1; i++) {
                String cell = field.getField(x, i).getSymbol().strip();
                switch (cell) {
                    case "*":
                        distance++;
                        break;
                    case "#":
                        distance += swampMove;
                        break;
                    case "@":
                        distance += hillMove;
                        break;
                    case "!":
                        distance += treeMove;
                        break;
                }
            }
            if ((int)Math.floor(distance) > moveDistance)
                return false;
        }
        else {
            int minIndex = Math.min(x, newX);
            int maxIndex = Math.max(x, newX);
            float distance = 0;
            for (int i = minIndex; i < maxIndex + 1; i++) {
                String cell = field.getField(i, y).getSymbol().strip();
                switch (cell) {
                    case "*":
                        distance++;
                        break;
                    case "#":
                        distance += swampMove;
                        break;
                    case "@":
                        distance += hillMove;
                        break;
                    case "!":
                        distance += treeMove;
                        break;
                }
            }
            if ((int)Math.ceil(distance) > moveDistance)
                return false;
        }
        Fieldable emptyCell = field.getField(newX, newY);
        field.setFieldable(x, y, emptyCell);
        field.setFieldable(newX, newY, this);
        x = newX;
        y = newY;
        return true;
    }
    public void changeHealth(int amount) {
        if(amount <= defence) {
            defence -= amount;
        }
        else {
            int pureAmount = amount - defence;
            defence = 0;
            if (pureAmount >= health) {
                health = 0;
            }
            else {
                health -= pureAmount;
            }
        }
        if (health == 0)
            symbol = "*";
    }
    public boolean attack(Unit enemy) {
        if (enemy.getHealth() == 0)
            return false;
        if (this.getHealth() == 0)
            return false;
        int distanceBetween = (int)Math.ceil(Math.sqrt(Math.pow(this.x - enemy.getX(), 2) + Math.pow(this.y - enemy.getY(), 2)));
        if (distanceBetween > attackRange)
            return false;
        enemy.changeHealth(this.damage);
        return true;
    }
    @Override
    public String getSymbol() {
        return " " + symbol + " ";
    }
    @Override
    public boolean equalSymbol(String sym) {
        return sym.equals(" " + symbol + " ");
    }
}
