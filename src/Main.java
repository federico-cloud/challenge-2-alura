import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        boolean continueProcess = true;

        while (continueProcess) {

            String[] opciones = {"Divisa", "Temperatura"};
            String convOpt = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona un conversor:",
                    "Elija su conversor", JOptionPane.PLAIN_MESSAGE,
                    null, opciones, opciones[0]
            );

            int menuResponse = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro de que quieres continuar?"
            );

            //Obtain the exchange list
            OptionsList list = new OptionsList();

            if (menuResponse == JOptionPane.NO_OPTION) {
                // If the user selects "No", ask again to select a converter.
                continueProcess = false;
            } else if (menuResponse == JOptionPane.YES_OPTION) {

                if (convOpt.equals("Divisa")){
                    //We set up the currency converter
                    CurrencyConverter CurrConv  = new CurrencyConverter();
                    //Obtain the selected currency option
                    String exchange = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion:", "Tipo de cambio", JOptionPane.PLAIN_MESSAGE, null, list.getCurrencyOptions(), list.getCurrencyOptions()[0]);
                    //Obtain the amount to be exchanged
                    Double amountToExchange = Double.valueOf(JOptionPane.showInputDialog("Ingrese el monto"));

                    //We are trying to perform the operation
                    try {
                        JOptionPane.showMessageDialog(
                                null,
                                CurrConv.getResult(Arrays.asList(list.getCurrencyOptions()).indexOf(exchange), amountToExchange)
                        );
                    //We handle errors
                    //If the number entered is negative we return a NegativeException
                    } catch (NegativeException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    //If the number entered is NaN we return a NumberFormatException with custom message.
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "El valor ingresado no es un valor numerico",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                } else if (convOpt.contains("Temperatura")) {

                    //We set up the temperature converter
                    TemperatureConverter tempConv  = new TemperatureConverter();

                    String temperature = (String) JOptionPane.showInputDialog(
                            null,
                            "Selecciona una opcion:",
                            "Tipo de cambio", JOptionPane.PLAIN_MESSAGE,
                            null, list.getTemperatureOptions(), list.getCurrencyOptions()[0]
                    );
                    //Obtain the amount to be exchanged
                    Double tempToExchange = Double.valueOf(JOptionPane.showInputDialog("Ingrese el monto"));

                    try {
                        JOptionPane.showMessageDialog(
                                null,
                                tempConv.getResult(Arrays.asList(list.getTemperatureOptions()).indexOf(temperature), tempToExchange)
                        );
                    //We handle errors
                    //If the number entered is negative we return a NegativeException
                    } catch (NegativeException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    //If the number entered is NaN we return a NumberFormatException with custom message.
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "El valor ingresado no es un valor numerico",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                }
                continueProcess = false; // If the user selects "Yes", exit the while cycle.
            } else {
                System.exit(0);
                continueProcess = false; // If the user closes the dialogue box, exit the while loop.
            }
        }
    }

}