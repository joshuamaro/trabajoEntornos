package ventanaproyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Habitacion {
    private int nHab;
    private int camas;
    private String tipoHab;
    private String tipoBaño;
    private float nota;
    private String tipoCama;
    private float precio;
    private List<String> imagenes;

    public Habitacion(int nHab, int camas, String tipoHab, String tipoBaño, float nota, String tipoCama, float precio) {
        this.nHab=nHab;
        this.camas = camas;
        this.tipoHab = tipoHab;
        this.tipoBaño = tipoBaño;
        this.nota = nota;
        this.tipoCama = tipoCama;
        this.precio = precio;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public int getnHab() {
        return nHab;
    }

    @Override
    public String toString() {
        return nHab+" ";
    }

    public int getCamas() {
        return camas;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public String getTipoBaño() {
        return tipoBaño;
    }

    public float getNota() {
        return nota;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public float getPrecio() {
        return precio;
    }

    public String getImagenes(int i) {
        return imagenes.get(i);
    }
    
    public int getNImg(){
        return imagenes.size();
    }
    
    public static List<Habitacion> sentencia(int camas, boolean matrimonio, String baño, float p){
        ConectorBD bd = ConectorBD.nuevaConexionBD();
        bd.abrirBD();
        String price = p+"";
        price=price.replace(",", ".");
        String sql = String.format("select * from habitaciones where camas=%d and tipoC='%b' and tipoB='%s' and precio<=%s", camas, matrimonio, baño, price);
        System.out.println(sql);
        ResultSet rs =bd.consultarBD(sql);
        List<Habitacion> lista = new LinkedList<>();
        try {
            while(rs.next()){
                int nCama=rs.getInt("camas"); 
                int nHab=rs.getInt("numero");
                String tipoHab=rs.getString("tipoH");
                String tipoBaño=rs.getString("tipoB");
                float nota=rs.getFloat("nota");
                String tipoCama=rs.getString("tipoC");
                float precio=rs.getFloat("precio");
                lista.add(new Habitacion(nHab, nCama, tipoHab, tipoBaño, nota, tipoCama, precio));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.cerrarBD();
        return lista;
    }
    
    public static List<String> obtenerFotos(int nHab){
        ConectorBD bd = ConectorBD.nuevaConexionBD();
        bd.abrirBD();
        String sql = String.format("select * from fotos where nHab=%d", nHab);
        ResultSet rs=bd.consultarBD(sql);
        List<String> lista = new LinkedList<>();
        try {
            while (rs.next()){
                String foto = rs.getString("fotos");
                lista.add(foto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
