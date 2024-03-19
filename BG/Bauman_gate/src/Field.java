public class Field {
    private int sizeX;
    private  int sizeY;
    private Fieldable[][] field;
    public Field(int sizeX, int sizeY) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        field = new Fieldable[sizeX][sizeY];
    }
    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }
    public void setFieldable(int x, int y, Fieldable object){
        field[x][y] = object;
    }
    public Fieldable getField(int x, int y) {
        return field[x][y];
    }
    public void showField(){
        for (int i = 0; i <  sizeX; i ++){
            for (int j = 0; j < sizeY; j++){
                System.out.print(field[i][j].getSymbol());
            }
            System.out.println();
        }
        System.out.println();
    }
}
