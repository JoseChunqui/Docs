package pe.uni.fiis.misiones;

public class Main {
    public static void main(String[] args) {
        Vehiculo miMoto=new Moto(150,2,20,false);
        System.out.println("La Velocidad de la moto es de: "+miMoto.getVelocidad());
        Vehiculo miCarro=new Carro(200,4,30,4);
        System.out.println("La Velocidad del carro es de: "+miCarro.getVelocidad());
        miCarro.frenar();
        miMoto.acelera();
        System.out.println("La Velocidad de la moto es de: " + miMoto.getVelocidad());
        System.out.println("La Velocidad del carro es de: "+miCarro.getVelocidad());
    }
}
