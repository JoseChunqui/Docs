package pe.uni.fiis.sobrecarga;

public class Numero {
    private Integer numero1=0;
    private Double numero2=0.0;

    public void set (Integer numero){
        numero1 = numero;
    }
    //Sobrecarga del metodo set, no por número de parámetros sino por el tipo de dato como argumento.
    public void set (Double numero){
        numero2 = numero;
    }

    public void set (Integer numero1, Double numero2){
        this.numero1=numero1;
        this.numero2=numero2;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public Double getNumero2() {
        return numero2;
    }
}