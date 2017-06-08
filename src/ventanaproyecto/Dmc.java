package ventanaproyecto;

import java.util.List;
import javax.swing.DefaultComboBoxModel;



public class Dmc extends DefaultComboBoxModel{
    List<Habitacion> lista;
    public Dmc (List<Habitacion> lista){
        this.lista=lista;
        for (int i=0; i<lista.size(); i++){
            this.addElement(lista.get(i));
        }
    }
    
}
