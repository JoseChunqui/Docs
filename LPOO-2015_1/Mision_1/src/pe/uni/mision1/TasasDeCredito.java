package pe.uni.mision1;

public class TasasDeCredito {
    private Double tasa_anual;

    public TasasDeCredito(Double tasa_anual) {
        this.tasa_anual = tasa_anual;
    }

    public Double getTasa_anual() {
        return tasa_anual;
    }

    public Double tasa_mensual(){
        Double tasa_mensual;
        tasa_mensual=Math.pow((1+this.tasa_anual),(1/12.0)) - 1;
        return tasa_mensual;
    }
}
