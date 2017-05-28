package pe.uni.fiis.mision3;


import java.util.ArrayList;
import java.util.Scanner;

public class ConogramaVuelos {
    private String fechaCronograma;
    private ArrayList<Vuelo> vuelosProgramados;
    private Integer num_vuelos;

    //Constructor
    public ConogramaVuelos(String fechaCronograma) {
        /*Scanner in = new Scanner ( System.in );
        Integer num_vuelos;
        System.out.println("Ingrese el numero de vuelos");
        num_vuelos=in.nextInt();
        */
        this.fechaCronograma = fechaCronograma;
        this.num_vuelos = 5;
        this.vuelosProgramados = new ArrayList<Vuelo>();
    }

    public String getFechaCronograma() {
        return fechaCronograma;
    }

    public Integer getNum_vuelos() {
        return num_vuelos;
    }

    public Vuelo getVuelo(Integer posicion){
        if (posicion >= 0 && posicion < vuelosProgramados.size() ) {
            return vuelosProgramados.get(posicion); }
        else { return null;}
    }

    public void agregarVuelo(){
        Scanner in = new Scanner ( System.in );
            Vuelo nuevoVuelo1=new Vuelo("AR245","Lima","Tokio","12:34","22:15");
            vuelosProgramados.add(nuevoVuelo1);
            Vuelo nuevoVuelo2=new Vuelo("MR565","Santiago","Lima","15:34","18:15");
            vuelosProgramados.add(nuevoVuelo2);
            Vuelo nuevoVuelo3=new Vuelo("AR245","Salingrado","Brasilia","08:35","17:12");
            vuelosProgramados.add(nuevoVuelo3);
            Vuelo nuevoVuelo4=new Vuelo("AR245","Miami","Tokio","20:34","22:20");
            vuelosProgramados.add(nuevoVuelo4);
            Vuelo nuevoVuelo5=new Vuelo("AR245","Miami","Pekin","19:34","23:15");
            vuelosProgramados.add(nuevoVuelo5);


            /* for (int i=0; i<this.num_vuelos; i++){
                Vuelo nuevoVuelo=new Vuelo();
                System.out.println("Ingresar Codigo de vuelo");
                nuevoVuelo.setCodVuelo(in.next());
                System.out.println("Ingresar Destino de vuelo");
                nuevoVuelo.setEntrada(in.next());
                System.out.println("Ingresar Origen de vuelo");
                nuevoVuelo.setSalida(in.next());
                System.out.println("Ingresar Hora de vuelo");
                nuevoVuelo.setHora(in.next());
                System.out.println("Ingresar Hora de llegada a destino");
                nuevoVuelo.setHoraLlegada(in.next());
                vuelosProgramados.add(nuevoVuelo);
              }*/

    }
}
