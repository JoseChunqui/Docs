package pe.uni.fiis.mision3;


public class Vuelo {
    private String codVuelo;
    private String salida;
    private String entrada;
    private String hora;
    private String horaLlegada;

    public Vuelo(String codVuelo, String salida, String entrada, String horaLlegada, String hora) {
        this.codVuelo = codVuelo;
        this.salida = salida;
        this.entrada = entrada;
        this.horaLlegada = horaLlegada;
        this.hora = hora;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}

