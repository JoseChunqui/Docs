package pe.uni.mision1;
import java.util.Scanner;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Cliente{
    public static void main(String [] agr) throws Exception {
        Double cuota;
        Integer numero_cuotas;
        AnalistaCreditos consultor=new AnalistaCreditos(0.36,12000);
        Scanner in = new Scanner ( System.in );
        System.out.println("Ingrese en numero de meses");
        numero_cuotas =in.nextInt();
        cuota=consultor.simulacion_pagos(numero_cuotas);

        String rutaArchivo = System.getProperty("user.home")+"/SimulacionPrestamos.xls";
        File archivoXLS = new File(rutaArchivo);
        /*Si el archivo existe se elimina*/
        if(archivoXLS.exists()) archivoXLS.delete();
        /*Se crea el archivo*/
        archivoXLS.createNewFile();

        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
        Workbook libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
        FileOutputStream archivo = new FileOutputStream(archivoXLS);

        /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
        Sheet hoja = libro.createSheet("cuotas");

        /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
        for(int f=0;f<=numero_cuotas;f++){
            /*La clase Row nos permitirá crear las filas*/
            Row fila = hoja.createRow(f);

            /*Cada fila tendrá 4 celdas de datos*/
            Cell celda = fila.createCell(0);
            if(f==0){
                celda.setCellValue("#");
            }else{
                celda.setCellValue(f);
            }
            /* */
            celda = fila.createCell(1);
            if(f==0){
                celda.setCellValue("Cuotas");
            }else{
                celda.setCellValue(cuota);
            }
            /**/

            /*intereses*/
            celda = fila.createCell(2);
            if(f==0){
                celda.setCellValue("Intereses");
            }else{
                celda.setCellValue(consultor.intereses(f,numero_cuotas));
            }
            /*fin_intereses*/

            /*Amortización*/
            celda = fila.createCell(3);

            if(f==0){
                celda.setCellValue("Amortizacion");
            }else{
                celda.setCellValue(cuota-consultor.intereses(f,numero_cuotas));
            }
            /*fin_amortización*/

            /*Capital vivo*/
            celda = fila.createCell(4);

            if(f==0){
                celda.setCellValue("CapitalVivo");
            }else{
                if(consultor.capital_actual(f,numero_cuotas)>0){
                    celda.setCellValue(consultor.capital_actual(f,numero_cuotas));
                }else {
                    celda.setCellValue(0);
                }
            }
            /*fin_capital_vivo*/
        }

        /*Escribimos en el libro*/
        libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        /*Y abrimos el archivo con la clase Desktop*/
        Desktop.getDesktop().open(archivoXLS);
    }

}

