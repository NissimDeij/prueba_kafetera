package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

public class Registro extends Conexion{
    //Constructor vacio (la clase no tiene atributos globales)
    public Registro() {
    }
    
    //Metodo para listar producto
    public DefaultTableModel ListadoProducto(){
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Identificador Producto","Codigo","Nombre","Tipo","Sabor","Descripcion","Precio de venta","Cantidad", "Marca", "Azucar"};
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM producto");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      Object[][] data = new String[registros][10];
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM producto");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "idproducto" );
                data[i][1] = res.getString( "codigo" );
                data[i][2] = res.getString( "nombre" );
                data[i][3] = res.getString( "tipo" );
                data[i][4] = res.getString( "sabor" );
                data[i][5] = res.getString( "descripcion" );
                data[i][6] = res.getString( "precio" );
                data[i][7] = res.getString( "cantidad" );
                data[i][8] = res.getString( "marca" );
                data[i][9] = res.getString( "azucar" );
            i++;
         }
         res.close();
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }

    //Agregar nuevo producto
    public boolean NuevoProducto(int codigo,String nombre,String tipo,String sabor,String descripcion,int precio,int cantidad, String marca, boolean azucar){
            //Se arma la consulta
            String q=" INSERT INTO taller2.producto(codigo,nombre,tipo, sabor, descripcion,precio,cantidad,marca,azucar) "
                    + "VALUES ( '" + codigo + "','" + nombre + "', '" + tipo + "','" + sabor + "',"
                    + " '" + descripcion +" ','" + precio +"','" + cantidad +"','" + marca +"','" + azucar +"' ) ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
                return false;
            }
    }
    
    //Modificar producto seleccionado
    public boolean modificaProducto(int codigo,String nombre,String tipo,String sabor,String descripcion,int precio,int cantidad, String marca, boolean azucar){
        String q= "UPDATE taller2.producto SET nombre='"+nombre+"', tipo='"+tipo+"' , descripcion='"+descripcion+"' , cantidad='"+cantidad+"', precio='"+precio+"', sabor='"+sabor+"', azucar='"+azucar+"' "
                + " WHERE codigo='"+codigo+"' ";
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
         }catch(SQLException e){
            
            System.err.println( e.getMessage() );
            return false;
        }
        
    }

    //Elimina producto
    public boolean eliminarProducto(int codigo){
        boolean res=false;
        if (verificarCodigo(codigo) == true){
            String q = " DELETE FROM taller2.producto WHERE codigo=" + codigo + " " ;
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null,"Se ha eliminado el codigo en forma correcta");
                res=true;
            }catch(SQLException e){

                System.err.println( e.getMessage() );
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"El codigo a eliminar no existe en BD");
        }
        return res;
    }

 
    
    public DefaultTableModel BuscaProducto(int codigo){
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Identificador Producto","Codigo","Nombre","Tipo","Sabor","Descripcion","Precio de venta","Cantidad", "Marca", "Azucar"};
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM producto");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      Object[][] data = new String[registros][10];
      try{
         if (verificarCodigo(codigo) == true){
             PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM producto where codigo ="+ codigo + ";" );
             ResultSet res = pstm.executeQuery();
             int i=0;
             while(res.next()){
                data[i][0] = res.getString( "idproducto" );
                data[i][1] = res.getString( "codigo" );
                data[i][2] = res.getString( "nombre" );
                data[i][3] = res.getString( "tipo" );
                data[i][4] = res.getString( "sabor" );
                data[i][5] = res.getString( "descripcion" );
                data[i][6] = res.getString( "precio" );
                data[i][7] = res.getString( "cantidad" );
                data[i][8] = res.getString( "marca" );
                data[i][9] = res.getString( "azucar" );
                i++;
             }
             res.close();
             tablemodel.setDataVector(data, columNames );
         }
         else{
            JOptionPane.showMessageDialog(null,"El codigo a buscar no existe en BD");
            }
      }catch(SQLException e){
            System.err.println( e.getMessage() );
      }
      return tablemodel;
    }
    
    public boolean verificarCodigo(int codigo){
        boolean res=false;
        int registros;
        String q = " Select codigo FROM taller2.producto WHERE codigo=" + codigo + " " ;
        
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            ResultSet rex = pstm.executeQuery();
            rex.next();
            registros = rex.getInt("codigo");
            rex.close();
            if (registros == 0){
                res = false;
            }
            else{
                res= true;
            }
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
                
        return res;
    }
}
