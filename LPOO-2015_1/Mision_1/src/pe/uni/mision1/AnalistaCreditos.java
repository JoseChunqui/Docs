package pe.uni.mision1;

public class AnalistaCreditos extends TasasDeCredito{
    private Integer prestamo;

    public AnalistaCreditos(Double tasa_anual, Integer prestamo) {
        super(tasa_anual);
        this.prestamo = prestamo;
    }

    public Integer getPrestamo() {
        return prestamo;
    }

    public Double simulacion_pagos(Integer meses){
        Double tasa, pago_mensual;
        tasa=super.tasa_mensual();
        pago_mensual=(tasa*getPrestamo())/(1-Math.pow((1 + tasa),-meses));
        return pago_mensual;
    }


    public Double capital_actual(Integer num_pago, Integer meses){
        Double capital_actual,k,pot_k;
        k=super.tasa_mensual()+1;
        pot_k=Math.pow(k, num_pago);
        capital_actual=pot_k*getPrestamo()-((pot_k-1)/(k-1))*simulacion_pagos(meses);
        return capital_actual;
    }
    public Double intereses(Integer num_pago, Integer meses){
        Double capital_actual,intereses;
        capital_actual=capital_actual(num_pago-1,meses);
        intereses=capital_actual*super.tasa_mensual();
        return intereses;
    }
}
