/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author joshua
 */
public class Nodo {

       private Alumno conteneder;//contiene alumno
       private Nodo sig;   //marca el siguente nodo
    /**
     * @return the conteneder
     */
    public Alumno getConteneder() {
        return conteneder;
    }

    /**
     * @param conteneder the conteneder to set
     */
    public void setConteneder(Alumno conteneder) {
        this.conteneder = conteneder;
    }

    /**
     * @return the sig
     */
    public Nodo getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    /**
     * @param sig the sig to nul
     */
    public void setSigN() {
        this.sig = null;
    }
    /**
     * Cotructor basico
     */
    
    Nodo(){
         conteneder = null;
         sig = null;
    }
    /**
     * Contructor con itroducion de alumno
     * @param dato 
     */
    Nodo(Alumno dato){
        conteneder = dato;
    }
    /**
     * Contructor avanzado
     * @param dato dato a introducir
     * @param sig nodo siguente
     */
    Nodo(Alumno dato,Nodo sig){
        conteneder = dato;
        this.sig = sig;
    }
   
   /**
    * Apilamos los nodos corresponidentes segun datos.
    * @param entrada 
    */
   public void apil(Alumno entrada){
       Nodo n=new Nodo(entrada);//Nuevo nodo
        if(cima==null){//si es primero
            cima=n;//La cima es el nuevo rey
        }else{//resto
            n.setSig(cima);//siguente nodo
            cima=n;//nuevo rey de la pista
        }
   }
   /**
     * Elimina si hay
     * @return Alumno 
     */
    public Alumno desapilar(){
        Alumno aux=null; //Crea object
        if(cima!=null){//mira si hay un rey
            aux=cima.getConteneder();//El objeto auxiliar se iguala al objeto alumno que hay en cumbre
            cima=cima.getSig();//El siguiente nodo pasa a la cumbre
        }
        return aux;//Regresa el objecto
    }
    /**
     * Método para mirar si hay rey
     * @return true si esta vacia, false si no lo está
     */
    public boolean vacio(){
       if(cima==null){
           return true;
       }else{
           return false;
       }
    }
}
