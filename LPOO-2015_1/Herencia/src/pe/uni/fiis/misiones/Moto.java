package pe.uni.fiis.misiones;


public class Moto extends Vehiculo{
    private Boolean reparar_cadena;

    //Constructor
    public Moto(Integer caballosFuerza, Integer ruedas, Integer velocidad, Boolean reparar_cadena) {
        super(caballosFuerza, ruedas, velocidad);
        this.reparar_cadena = reparar_cadena;
    }

    public Boolean getReparar_cadena() {
        return reparar_cadena;
    }

    public void acelera(){
        setVelocidad(getVelocidad()+10);
    }

    public void frenar(){
        if(getVelocidad()>=5){
            setVelocidad(getVelocidad()-5);
        }else{
            setVelocidad(0);
        }
    }
}
