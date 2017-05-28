package pe.uni.mision2;

public class Administrador {
    public static void main(String[] agr){
        Double bonos_1,bonos_2,bonos_totales;
        System.out.println("PERSONAL ADMINISTRATIVO");
        Vendedor vendedor_1 = new Vendedor(0.19);
        bonos_1=vendedor_1.getBonos_productividad_1();
        bonos_2=vendedor_1.getBonos_productividad_2();
        bonos_totales=bonos_1+bonos_2;
        System.out.println("El bono por monto de venta del vendedor es:");
        System.out.println(bonos_1);
        System.out.println("El bono por cantidad de ventas del vendedor es:");
        System.out.println(bonos_2);
        System.out.println("El bono total es:");
        System.out.println(bonos_totales);

    }
}
