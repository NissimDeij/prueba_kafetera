
package modelo;

import controlador.Maquina;

public class Expresso {
    //private int sizeCafe;
    
    /* Preparación Expresso 
    *  ## CAFE ##
    *  Tamaño S: 1 shot --> codificado como 1
    *  Tamaño M: 2 shot --> codificado como 2
    *  Tamaño L: 3 shot --> codificado como 3
    *  
    *  ## Azucar ##
    *  Tamaño S: 1 shot --> codificado como 1
    *  Tamaño M: 2 shot --> codificado como 2
    *  Tamaño L: 3 shot --> codificado como 3
    */    

    public Expresso(int sizeCafe, int nivelAzucar) { // sizeCafe ingresa codificado como se detalla arriba, nivel azucar 0: Sin azucar, 1: Con Azucar, 2: Extra azucar
      //  this.sizeCafe = sizeCafe;
        Maquina.addShot(sizeCafe);
        Maquina.addAzucar(sizeCafe,nivelAzucar);
    }
    public boolean agregarAgua(){
        return true;
    }
}
