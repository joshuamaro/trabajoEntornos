package ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// System.out.print(this.comboAlumnos.getSelectedItem());
/**
 *
 * @author joshua
 */
public class ClassUtil {
    /*************************************************************************************************
     * Metodo con try catch para comprobar si realmente se inserta un int y no fallse el programa*****
     * @return regresara el numero int correspondiente************************************************
     * ***********************************************************************************************
     */
    public  int comprobarInt(String pregunta){
        BufferedReader en = new BufferedReader(new InputStreamReader(System.in));
        boolean  correcto;
        int respuesta=0;
        do{
                correcto=true;
                System.out.println(pregunta);
                try {
                respuesta = Integer.parseInt(en.readLine());
                }
                catch(Exception ex){
                    correcto = false;
                    System.out.println("Pon un numero");
                    // opcion de entrada erronea
                }

                if(respuesta<1 || respuesta >7){
                    correcto = false;
                    System.out.println("Dime un numero del menu");
                }
            }while(!correcto);
        return respuesta;
    }
    /*************************************************************************************************
     * Metodo con try catch para comprobar si realmente se inserta un float y no fallse el programa***
     * @return regresara el numero float correspondiente**********************************************
     * ***********************************************************************************************
     */
    public  float comprobarFloat(String pregunta){
        BufferedReader en = new BufferedReader(new InputStreamReader(System.in));
        boolean  correcto;
        float respuesta=0;
        do{
                correcto=true;
                System.out.println(pregunta);
                try {
                respuesta = Float.valueOf(en.readLine());
                }
                catch(Exception ex){
                    correcto = false;
                    System.out.println("Pon un numero");
                    // opcion de entrada erronea
                }
            }while(!correcto);
        return respuesta;
    }
    /*************************************************************************************************
     * Metodo con try catch para comprobar la cantidad de decimales deseados en la ejecucion**********
     * @param ten la cantidad de decimales permitidos*************************************************
     * @param entrante numero a comprobar*************************************************************
     * @return regresara el numero float correspondiente**********************************************
     * ***********************************************************************************************
     */
    public  float comprobarDecimales(int ten, float entrante){
        float respuesta;
        entrante = entrante*(int) Math.pow(10,ten);
        entrante = (int)entrante;
        respuesta = entrante/(int) Math.pow(10,ten);
        return respuesta;
    }
    /**
     * Metodo que regresa un numero random entre unos valores predifinidos entre:*********************
     * @param maximo numero maximo que puede llegar a sacar el random*********************************
     * @param minimo numero minimo que puede sacar.***************************************************
     * @return regresa un numero random entre (maximo-minimo)+maximo**********************************
     */
    public int randoms(int maximo,int minimo){
        return ((int)(Math.random()*(maximo-minimo)+minimo));
    }
    /**************************************************************************************************
     * Metodo que regresa un boolean segun la probabilidad de acierto que tengamos*****************************
     * @param limitador variable tipo int que entra para poder saber cuando gana, si limitador es mas pequeño *
     * que el random sale true*********************************************************************************
     * @return  regresa true cuando es mas pequeño false cuando es gmas grande ********************************
     * ************************************************************************************************
     */
    public boolean probabilidad(int limitador){
        boolean correcto = false;
        if(limitador <((int)(Math.random()*100))){
            correcto = true;
        }
        return correcto;
    }
    /**Este metodo lo eliminare esta por si veo que me puede ser util, pero antes del examen lo elimino
     * ************************************************************************************************
     * Metodo de la burbuja basico, sirve para ordenar hay que modificar mucho*************************
     * @param A valor a ordenar************************************************************************
     * ************************************************************************************************
     */
    public void ordenadcioninvalido(int [] A){
         int i, j, aux;
         for(i=0;i<A.length-1;i++){
              for(j=0;j<A.length-i-1;j++){
                   if(A[j+1]<A[j]){
                      aux=A[j+1];
                      A[j+1]=A[j];
                      A[j]=aux;
                               }
                    /*
                  ArrayList<Alumnos> aula  = new ArrayList<Alumnos>();
                  Alumnos pa = new Alumnos();
                   pa = aula.get(i+1);
                   aula.set(i+1,aula.get(i));
                   aula.set(i,pa);
                   }*/
                }
         }
        }
    /**
     * Metodo para esperar.
     * @param segundos
     * @throws InterruptedException 
     */
    private void esperarXsegundos(int segundos) throws InterruptedException {
		Thread.sleep(segundos * 1000);
	}
    /**
     * Leer fichero.
     * @param arg objeto a leer 
     * @param a donde esta
     * @return 
     */
    private static Object leer(ArrayList<Object> arg,String a) {
        // File f = new File( "D:\\ejerciciosConFicheros/pj.txt");
        File f = new File(a);
        BufferedReader entrada;
        int i=0;
        try {
        entrada = new BufferedReader( new FileReader( f ) );
        String linea;
        while(entrada.ready()){
            linea = entrada.readLine();
            System.out.println(linea);
            //pj.add(new pj(linea.split(",")));
        }
        }catch (IOException e) {
            System.out.println("Error:" + e);
        }
        return arg;
    }
    /**
     * Guardar usando el treemap
     * @param tmap
     * @throws IOException 
     */
    private static void escribir(TreeMap<Integer, Object> tmap) throws IOException {
            /*BufferedReader en = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fichero = null;
            Calendar cal = Calendar.getInstance(Locale.ITALY);
            PrintWriter pw = null;
            System.out.println("Dime el nombre del fichero");  
            String respuesta = en.readLine();
            // ponemos la direcion nombre intruducido por el usuario y fecha
            respuesta = "D:\\"+respuesta+"Dia"+cal.get(Calendar.DAY_OF_MONTH)+"."+cal.get(Calendar.MONTH)+ "."+(cal.get(Calendar.YEAR))+"hora."+cal.get(Calendar.HOUR_OF_DAY)+"."+cal.get(Calendar.MINUTE)+".txt";
            try{
                fichero = new FileWriter(respuesta);
                pw = new PrintWriter(fichero);
               for(int i = 0;i<tmap.size();i++){
                    pw.println(tmap.get(i+1) + ";");// vamos guardando linia a linia
                }
            } catch (Exception e) {
            e.printStackTrace();
            } finally {
            try {
                if (null != fichero)
                fichero.close();//cerramos el fichero
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            } */   
    }
}




