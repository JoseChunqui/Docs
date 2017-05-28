package pe.uni.fiis.misiones;

public class Carro extends Vehiculo {
    private Integer puertas;

    public Carro(Integer caballosFuerza, Integer ruedas, Integer velocidad, Integer puertas) {
        super(caballosFuerza, ruedas, velocidad);
        this.puertas = puertas;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    public void acelera(){
        setVelocidad(getVelocidad()+20);
    }
    public void frenar(){
        if(getVelocidad()>=2){
            setVelocidad(getVelocidad()-2);
        }else{
            setVelocidad(0);
        }
    }
}
