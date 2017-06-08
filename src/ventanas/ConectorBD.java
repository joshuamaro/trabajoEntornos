/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


/**
 *
 * @author joseluisgs
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author joseluisgs
 */
// Patron Singleton y Fachada
public class ConectorBD {
    private java.sql.Connection conexion; 
    private java.sql.Statement consulta; //ExecuteQuery --> Solo para selects (El resultado se guarda en Conj_Registros) ; ExecuteUpdate --> para todo lo demas
    private java.sql.ResultSet resultado; // --> Esta variable se usa solo para los resultados de las selects
    
    private String ruta;
    private String bbdd;
    private String usuario;
    private String clave;
    
    private static ConectorBD bd;
    
    // Constructor BD privado --> Singleton
    private ConectorBD() {
        this.bbdd = "clase.db"; // Nombre de la base de datos
        this.usuario = ""; // No tenemos en SQLite
        this.clave = ""; // No tenemos en SQLite
        this.ruta = getPathBaseDatos();
        
        //System.out.println("Mi nombre es: " + this.nombre);
    }
    
    // Creador de instancias --> Singleton
    public static ConectorBD nuevaConexionBD() {
        if (bd == null){
            bd = new ConectorBD();
        }
        else{
            //System.out.println("No se puede crear el objeto "+ nombre + " porque ya existe un objeto de la clase SoyUnico");
        }       
        return bd;
    }
    
    // Metodo para abrir la Conexion la Base de Datos
    public void abrirBD() {
        String conector ="org.sqlite.JDBC"; // MySQL: "com.mysql.jdbc.Driver"
        try {
            Class.forName(conector);
	}
	catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error de conexion",JOptionPane.ERROR_MESSAGE);
            //System.err.println(e.getMessage());
	}	 
        try {
            String url = "jdbc:sqlite:"+this.ruta+this.bbdd; //MySQL jdbc:mysql://localhost/prueba", "root", "1daw"
            //System.out.println(this.ruta);
            conexion = DriverManager.getConnection(url);
            consulta = conexion.createStatement();// Para que aenviar consultas a la BD, objeto Statement
            System.out.println("Conectado de la Base de Datos");
	} catch (SQLException e) {
             //System.err.println(e.getMessage());
             JOptionPane.showMessageDialog(null, e.getMessage(),"Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cerrarBD(){
        try {
           // resultado.close();
            conexion.close();
            System.out.println("Desconectado de la Base de Datos");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Error de Desconexion",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet consultarBD(String sql){
        
        resultado = null; // Limpiamos lo que hay
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
                //System.err.println("Mensaje:"+e.getMessage());
                //System.err.println("Estado:"+e.getSQLState());
                //System.err.println("Codigo del error:"+e.getErrorCode());
                //System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Mensaje:"+e.getMessage()+"\nEstado: "+e.getSQLState()+"\nCodigo de error:"+e.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
        
    }
    
    public int actualizarBD(String sql){
        int valor = 0;
        try {
            valor=consulta.executeUpdate(sql);
        }catch (SQLException e) {
            valor = 0;
            //System.err.println("Mensaje:"+e.getMessage());
            //System.err.println("Estado:"+e.getSQLState());
            //System.err.println("Codigo del error:"+e.getErrorCode());
            //System.err.println(e.getMessage());
             JOptionPane.showMessageDialog(null, "Mensaje:"+e.getMessage()+"\nEstado: "+e.getSQLState()+"\nCodigo de error:"+e.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }      
        return valor;
    }
    
    private String getPathBaseDatos() {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        String pathBD = path+"\\BD\\";
        return pathBD;   
    }

}

