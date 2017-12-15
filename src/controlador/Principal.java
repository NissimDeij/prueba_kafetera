
package controlador;

import vista.Cafematica;
import java.awt.Color;

public class Principal {

    public static void main(String[] args) {
        
        new Maquina(new Cafematica()).iniciar();
        
    }
    
}
