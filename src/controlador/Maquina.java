
package controlador;

public class Maquina {
        //Capacidades máximas de máquina
    public static final int maxCafe = 1000;        // Gramos
    public static final double maxLecheEnte = 10;  // Litros
    public static final double maxLecheDesc = 10;  // Litros
    public static final double maxLecheSoya = 5;  // Litros
    public static final double maxChoc = 1;        // Litros
    public static final int maxAzucar = 1000;      // Gramos
    
    //Cantidades mínimas de máquina para gatillar alertas
    private static final int minCafe = 200;         // Gramos --> 20 gramos por shot
    private static final double minLecheEnte = 2;   // Litros --> 200ml pot café
    private static final double minLecheDesc = 2;   // Litros --> 200ml pot café
    private static final double minLecheSoya = 2;   // Litros --> 200ml pot café
    private static final double minChoc = 0.2;      // Litros --> 20ml por preparación
    private static final int minAzucar = 200;       // Gramos --> 10 gramos por porción
    
    //Cantidades actuales de máquina. Inicializa la máquina a full capacidad
    private static int stCafe = maxCafe;                // Gramos
    private static double stLecheEnte = maxLecheEnte;   // Litros
    private static double stLecheDesc = maxLecheDesc;   // Litros
    private static double stLecheSoya = maxLecheSoya;   // Litros
    private static double stChoc = maxChoc;             // Litros
    private static int stAzucar = maxAzucar;            // Gramos
        
    //Método encargado de agregar shot y descontar desde stock
    public static boolean addShot(int nShot){
        if(stCafe>=20*nShot){
            stCafe = stCafe -20*nShot;
            return true;
        }else{
            return false;
        }        
    }
    //Método encargado de agregar leche y descontar desde stock
    public static boolean addMilk(int tipo, int medida){
        switch (tipo){
            case 1: // Leche entera
                if(stLecheEnte>=0.1*medida){
                    stLecheEnte = stLecheEnte -0.1*medida;
                return true;
                }else{
                    return false;
                }   
            case 2: // Leche descremada
                if(stLecheDesc>=0.1*medida){
                    stLecheDesc = stLecheDesc -0.1*medida;
                return true;
                }else{
                    return false;
                }   
            case 3: // Leche de soya
                if(stLecheSoya>=0.1*medida){
                    stLecheSoya = stLecheSoya -0.1*medida;
                return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }
    //Método encargado de agregar chocolate y descontar desde stock
    public static boolean addChoc(int medida){
        if(stChoc>=0.02*medida){
            stChoc = stChoc -0.02*medida;
            return true;
        }else{
            return false;
        }        
    }
    //Método encargado de agregar azucar y descontar desde stock
    public static boolean addAzucar(int nUnidad, int factor){
        if(stAzucar>=10*nUnidad*factor){
            stAzucar = stAzucar -10*nUnidad*factor;
            return true;
        }else{
            return false;
        }        
    }
    
    //Método encargado de desplegar alertas cuando stock es bajo
    public static boolean[] alertaStock(){
        boolean [] lowStock = new boolean[6];
        if(stCafe<minCafe){
            lowStock[0] = true;
        }
        if(stLecheEnte<minLecheEnte){
            lowStock[1] = true;
        }
        if(stLecheDesc<minLecheDesc){
            lowStock[2] = true;
        }
        if(stLecheSoya<minLecheSoya){
            lowStock[3] = true;
        }
        if(stChoc<minChoc){
            lowStock[4] = true;
        }
        if(stAzucar<minAzucar){
            lowStock[5] = true;
        }
        return lowStock;
    }
    
    //Método encargado de desplegar stock disponible para cada ingrediente
    public static int[] stockDisponible(){
        int[] stockIng = new int[6];
        stockIng[0] = (int)((float)(stCafe)/(float)(maxCafe)*100);
        stockIng[1] = (int)(stLecheEnte/maxLecheEnte*100);
        stockIng[2] = (int)(stLecheDesc/maxLecheDesc*100);
        stockIng[3] = (int)(stLecheSoya/maxLecheSoya*100);
        stockIng[4] = (int)(stChoc/maxChoc*100);
        stockIng[5] = (int)((float)(stAzucar)/(float)(maxAzucar)*100);
        return stockIng;
    }
}
