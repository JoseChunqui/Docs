package pe.uni.mision2;

import java.util.Scanner;

public class Vendedor {
    private Double[][] ventas;
    private Integer total_ventas_diadias;
    private Double bonos_productividad_1;
    private Double bonos_productividad_2;

    public Double[][] getVentas() {
        return ventas;
    }

    public Vendedor(Double tasa) {

        Scanner in = new Scanner ( System.in );
        Double[][] ventas = new Double[100][3];
        String cadena;
        Boolean llave=true;
        Double bonos_totales=0.0;
        int i=0;
        while (llave) {
            if (i == 0) {
                System.out.println("Ingrese monto de Venta");
                ventas[i][0] = in.nextDouble();
                ventas[i][1] = ventas[i][0] /(1+tasa);
                if (ventas[i][1] < 500) {
                    ventas[i][2] = 0.03 * ventas[i][1];
                    bonos_totales += ventas[i][2];
                } else {
                    if (ventas[i][1] >= 1000 && ventas[i][1] <= 1500) {
                        ventas[i][2] = 0.05 * ventas[i][2];
                        bonos_totales += ventas[i][2];
                    } else {
                        if (ventas[i][1] > 1500) {
                            ventas[i][2] = 0.07 * ventas[i][1];
                            bonos_totales += ventas[i][2];
                        }
                    }
                }
                i++;
            } else {
                System.out.println("Ingresar nueva venta (inc. IGV)? S/N");
                cadena = in.next();
                if (cadena.equals("S")) {
                    System.out.println("Ingrese nuevo monto de Venta");
                    ventas[i][1] = in.nextDouble();
                    ventas[i][2] = ventas[i][1] /(1+tasa);
                    if (ventas[i][1] < 500) {
                        ventas[i][2] = 0.03 * ventas[i][1];
                        bonos_totales += ventas[i][2];
                    } else {
                        if (ventas[i][1] >= 1000 && ventas[i][1] <= 1500) {
                            ventas[i][2] = 0.05 * ventas[i][2];
                            bonos_totales += ventas[i][2];
                        } else {
                            if (ventas[i][1] > 1500) {
                                ventas[i][2] = 0.07 * ventas[i][1];
                                bonos_totales += ventas[i][2];
                            }
                        }
                    }
                    i++;
                } else {
                    llave = false;
                }
            }
        }
        this.ventas = ventas;
        this.total_ventas_diadias = i;
        this.bonos_productividad_1=bonos_totales;
        if(i<30){
            this.bonos_productividad_2=20.0;
        }else{
            if(i>40 && i<=100){
                this.bonos_productividad_2=50.0;
            }else{
                this.bonos_productividad_2=100.0;
            }
        }
    }

    public Integer getTotal_ventas_diadias() {
        return total_ventas_diadias;
    }

    public Double getBonos_productividad_1() {
        return bonos_productividad_1;
    }

    public Double getBonos_productividad_2() {
        return bonos_productividad_2;
    }
}
