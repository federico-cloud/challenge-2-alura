import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyRequest extends Request {

    String origin;
    String destiny;
    double amount;
    String url;

    //GETTERS
    public String getDestiny() {
        return destiny;
    }

    //CONSTRUCTOR
    public CurrencyRequest(String origin, String destiny, Double amount) throws NegativeException, NumberFormatException {

        if (amount <= 0) {
            throw new NegativeException("El monto a convertir no puede ser menor o igual a cero.");
        } else {
            try {
                Double.parseDouble(amount.toString());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("El monto ingresado no es un número válido.");
            } finally {
                System.out.println("El bloque finally se está ejecutando.");
            }
        }

        this.amount = amount;
        this.origin = origin;
        this.destiny = destiny;

        url = "https://api.apilayer.com/exchangerates_data/convert?to="+ destiny +"&from="+ origin +"&amount="+amount;

    }




    //METHODS
    @Override
    public double get() {

        try {
            //We proceed to the consultation get
            URL obj = new URL(url);

            //We make the connection
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //We set query parameters
            con.setRequestMethod("GET");
            con.setRequestProperty("apikey", apiKey);

            //We open the reader for response
            BufferedReader in = new BufferedReader (new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            //We close the reader
            in.close();

            //We convert the response to json
            Gson gson = new Gson();
            CurrencyResponse currencyResponse = gson.fromJson(content.toString(), CurrencyResponse.class);

            return currencyResponse.get();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Double.parseDouble(null);

    }
}
