
package modelo;

import controlador.Maquina;


public class Moka extends Latte{
    
    /* Preparación Moka (Chocolate) // Extension del Latte
    *  Tamaño S: 20ml --> codificado como 1
    *  Tamaño M: 40ml --> codificado como 2
    *  Tamaño L: 60ml --> codificado como 3
    */    
    public Moka(int sizeCafe, int tipoLeche, int nivelAzucar){
        super(sizeCafe, tipoLeche, nivelAzucar);
        Maquina.addChoc(sizeCafe);
    }
    
}
