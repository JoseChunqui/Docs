package pe.uni.fiis.misiones;


public abstract class Vehiculo {

    private Integer caballosFuerza;
    private Integer ruedas;
    private Integer velocidad;

    public Vehiculo(Integer caballosFuerza, Integer ruedas, Integer velocidad) {
        this.caballosFuerza = caballosFuerza;
        this.ruedas = ruedas;
        this.velocidad = velocidad;
    }

    //Metodos Getts
    public Integer getCaballosFuerza() {return caballosFuerza;}
    public Integer getRuedas() {return ruedas;}
    public Integer getVelocidad(){return velocidad;}

    //Setters
    public void setCaballosFuerza(Integer caballosFuerza) {this.caballosFuerza = caballosFuerza;}
    public void setRuedas(Integer ruedas) {this.ruedas = ruedas;}
    public void setVelocidad(Integer velocidad) {this.velocidad = velocidad;}

    //Métodos
    public abstract void acelera();
    public void frenar(){
        velocidad=0;
    }
}

