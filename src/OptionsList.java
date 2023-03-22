public class OptionsList {

    String[] CurrencyOptions = {
            "Peso argentino (ARS) a dolar estado unidense (USD)",
            "Peso argentino (ARS) a euro (EUR)",
            "Peso argentino (ARS) a libras esterlinas (GBP)",
            "Peso argentino (ARS) a yen japones (JPY)",
            "Peso argentino (ARS) a yen won sur coreano (KPM)",
            "Dolar estado unidense (USD) a peso argentino (ARS)",
            "Dolar estado unidense (USD) a euro (EUR)",
            "Libras esterlinas (GBP) a yen euro (EUR)",
    };

    String[] temperatureOpt = {
            "Grados Celsius (°C) a Fahrenheit (°F)",
            "Grados Celsius (°C) a Kelvin (°K)",
            "Grados Fahrenheit (°F) a Celcius (°C)",
            "Grados Fahrenheit (°F) a Kelvin (°K)",
            "Grados Kelvin (°K) a Celcius (°C)",
            "Grados Kelvin (°K) a Fahrenheit (°F)",
    };

    public String[] getCurrencyOptions() {
        return CurrencyOptions;
    }

    public String[] getTemperatureOptions() { return temperatureOpt; }

}
