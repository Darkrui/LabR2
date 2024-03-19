public class Tree implements Fieldable{
    @Override
    public String getSymbol() {
        return " ! ";
    }
    @Override
    public boolean equalSymbol(String sym) {
        return sym.equals(" ! ");
    }
}
