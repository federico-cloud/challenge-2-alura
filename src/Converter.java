public abstract class Converter {

    //ATTRIBUTES
    protected int option;

    //METHODS
    public abstract String getResult(int opt, Double amount) throws NegativeException;
}
