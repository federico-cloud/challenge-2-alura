import java.text.DecimalFormat;

public class TemperatureConverter extends Converter{

    // CONSTRUCTOR
    public TemperatureConverter() {}


    // METHODS
    @Override
    public String getResult(int opt, Double amount) throws NegativeException{

        //we set the output format
        DecimalFormat df = new DecimalFormat("#.##");

        String msg = "";

        switch (opt) {
            case 0:
                msg = "El resultado es " + df.format(CtoF(amount)) + " Grados Fahrenheit";
                break;
            case 1:
                msg = "El resultado es " + df.format((CtoK(amount))) + " Grados Kelvin";
                break;
            case 2:
                msg = "El resultado es " + df.format(FtoC(amount)) + " Grados Celcius";
                break;
            case 3:
                msg = "El resultado es " + df.format(FtoK(amount)) + " Grados Kelvin";
                break;
            case 4:
                msg = "El resultado es " + df.format(KtoC(amount)) + " Grados Celsius";
                break;
            case 5:
                msg = "El resultado es " + df.format(KtoF(amount)) + " Grados Fahrenheit";
                break;
            default:
                msg = "Opción no válida";
                break;
        };

        System.out.println(opt);
        return msg;
    }


    public Double CtoF (Double celsius){ return (celsius * 9/5) + 32; }
    public Double CtoK (Double celsius){ return celsius + 273.15; }

    public Double KtoF (Double kelvin){ return ((kelvin - 273.15) * 1.8) + 32; }
    public Double KtoC (Double kelvin){ return kelvin - 273.15; }

    public Double FtoC (Double fahrenheit) { return (fahrenheit - 32) * 5/9; }
    public Double FtoK (Double fahrenheit) { return ((fahrenheit - 32) / 1.8) + 273.15; }


}
