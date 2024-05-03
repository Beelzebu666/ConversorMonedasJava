package conversorMonedas;

import java.util.Map;

public class DatosMoneda {
    private String result;
    private Map<String, Double> conversion_rates;

    public Double getDolar() {
        return conversion_rates.get("USD");
    }

    public Double getPesoArgentino() {
        return conversion_rates.get("ARS");
    }

    public Double getPesoColombiano() {
        return conversion_rates.get("COP");
    }

    public Double getRealBrasilero() {
        return conversion_rates.get("BRL");
    }

    @Override
    public String toString() {
        return "DatosMoneda{" +
                "result='" + result + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
