/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joseluisgs
 */
public class Path {
    private static Path clase = null;
    
    public static Path nuevaInstancia() {
        if(clase ==null){
            clase = new Path();
        }
        return clase;
    }
    
    private Path() {
        
    }
    
    
    public String getPathBaseImagenes() {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        String pathBD = path+"\\IMG\\";
        return pathBD;   
    }
    
      public String getPathBaseFotos() {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        String pathBD = path+"\\IMG\\";
        return pathBD;   
    }
    
    public String getPathBaseBaseDatos() {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        String pathBD = path+"\\BD\\";
        return pathBD;   
    }
    
    public void copiarFotoAlumno(File fotoAlumno) {
        try {
            String fichero = fotoAlumno.getName();
            fichero=getPathBaseFotos()+fichero;
            File destino = new File(fichero);
            Files.copy(fotoAlumno.toPath(), destino.toPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se puede copiar el fichero de imagen seleccionado","error al copiar imagen",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
