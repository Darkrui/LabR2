public class Hill implements Fieldable{
    @Override
    public String getSymbol() {
        return " @ ";
    }
    @Override
    public boolean equalSymbol(String sym) {
        return sym.equals(" @ ");
    }
}
