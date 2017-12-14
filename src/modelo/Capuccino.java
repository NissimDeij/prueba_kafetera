
package modelo;

import controlador.Maquina;

public class Capuccino extends Expresso{
    
    /* Preparación Capuccino (Leche)
    *  Tamaño S: 100ml --> codificado como 1
    *  Tamaño M: 200ml --> codificado como 2
    *  Tamaño L: 300ml --> codificado como 3
    */    
    public Capuccino(int sizeCafe, int tipoLeche, int nivelAzucar){
        super(sizeCafe, nivelAzucar);
        Maquina.addMilk(tipoLeche, sizeCafe);
    }    
}
