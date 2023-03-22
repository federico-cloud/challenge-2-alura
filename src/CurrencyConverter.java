import java.text.DecimalFormat;

public class CurrencyConverter extends Converter{

    String[] arsUsd = {"ars", "usd"};
    String[] arsEur = {"ars", "eur"};
    String[] arsGbp = {"ars", "gbp"};
    String[] arsJpy = {"ars", "jpy"};
    String[] arsKpm = {"ars", "kpm"};
    String[] usdArs = {"usd", "ars"};
    String[] usdEur = {"usd", "eur"};
    String[] gbpEur = {"gbp", "eur"};


    String[][][] symbols = {
            {arsUsd},
            {arsEur},
            {arsGbp},
            {arsJpy},
            {arsKpm},
            {usdArs},
            {usdEur},
            {gbpEur},
    };

    //CONSTRUCTOR
    public CurrencyConverter() {}

    //METHODS
    //We obtain the result of the query according to the selected currency option.
    @Override
    public String getResult(int opt, Double cantidad) throws NegativeException {

        //We set the output format
        DecimalFormat df = new DecimalFormat("#.##");

        //We perform the GET query
        CurrencyRequest response = new CurrencyRequest(getOrigin(opt), getDestiny(opt), cantidad);

        //We obtain the result of the conversion
        double result = response.get();

        //We show the result of the conversion
        return "El resultado del cambio de moneda es: " + df.format(result) + " " + response.getDestiny();
    }

    //With this function we obtain the ORIGIN value for the instance of the converter.
    public String getOrigin(int opt){
        return symbols[opt][0][0];
    }

    //With this function we get the DESTINATION value for the instance of the converter.
    public String getDestiny(int opt){
        return symbols[opt][0][1];
    }

}
