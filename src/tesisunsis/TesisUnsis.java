package tesisunsis;

import Vistas.Interfaz;
import java.io.IOException;

/**
 * @author Luis Fernando Santiago Martínez
 * Verificar que la computadora donde se instale tenga:
 * jmf
 */
public class TesisUnsis {
    public static void main(String[] args) throws IOException {
        
        Interfaz miInterfaz = new Interfaz();
            miInterfaz.setSize(1900,1000);
            miInterfaz.setDefaultCloseOperation(Interfaz.EXIT_ON_CLOSE);
            miInterfaz.setLocationRelativeTo(null);
            miInterfaz.setVisible(true);
            miInterfaz.show();
    }
}