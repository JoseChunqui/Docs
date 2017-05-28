package pe.uni.fiis.mision3;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        //Obtener Hora del Sistema
        Calendar calendario = new GregorianCalendar();
        Integer hora, minutos, segundos;
        String hora_sistema;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        hora_sistema=hora + ":" + minutos;
        System.out.println(hora_sistema);

        //Creacion del objeto Cronograma de vuelos
        ConogramaVuelos cronograma= new ConogramaVuelos(hora_sistema);
        //Ingreso de los datos de los vuelos
        cronograma.agregarVuelo();

        //Escribir en una hoja de excel
        try{
            //Archivo que contendrá el excel
            String rutaArchivo = System.getProperty("user.home")+"/Vuelos2.xls";
            File archivoXLS = new File(rutaArchivo);
            if(archivoXLS.exists()) archivoXLS.delete();
            archivoXLS.createNewFile();

            //Creacion del libro
            Workbook libro = new HSSFWorkbook();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);

            //Creacion de una hoja dentro del libro
            Sheet hoja = libro.createSheet("Vuelos");

            //Creacion de filas y celdas en dichas filas
            for(int num_fila=0; num_fila<=cronograma.getNum_vuelos(); num_fila++){
                Row fila = hoja.createRow(num_fila);
                for(int num_celda=0; num_celda<6; num_celda++){
                    Cell celda = fila.createCell(num_celda);
                    if(num_fila==0){
                        //Encabezados
                        switch (num_celda){
                            case 0:
                                celda.setCellValue("Cod Vuelo");
                                break;
                            case 1:
                                celda.setCellValue("Destino");
                                break;
                            case 2:
                                celda.setCellValue("Origen");
                                break;
                            case 3:
                                celda.setCellValue("Salida");
                                break;
                            case 4:
                                celda.setCellValue("Llegada");
                                break;
                            case 5:
                                celda.setCellValue("Situacion");
                        }
                    }else{
                        switch(num_celda){
                            case 0:
                                celda.setCellValue(cronograma.getVuelo(num_fila-1).getCodVuelo());
                                break;
                            case 1:
                                celda.setCellValue(cronograma.getVuelo(num_fila-1).getEntrada());
                                break;
                            case 2:
                                celda.setCellValue(cronograma.getVuelo(num_fila-1).getSalida());
                                break;
                            case 3:
                                celda.setCellValue(cronograma.getVuelo(num_fila-1).getHora());
                                break;
                            case 4:
                                celda.setCellValue(cronograma.getVuelo(num_fila-1).getHoraLlegada());
                                break;
                            case 5:
                                if(cronograma.getVuelo(num_fila-1).getHora().compareTo(hora_sistema)>0){
                                    celda.setCellValue("PROGRAMADO");
                                }else{
                                    celda.setCellValue("SALIDO");
                                }
                        }

                    }
                }
            }
            //Fin de creacion de filas

            //Escribir el excel en el archivo
            libro.write(archivo);
            archivo.close();

            //Abrir el excel
            Desktop.getDesktop().open(archivoXLS);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
