/*
 * Crud de Mysql
 * Universidad de la Sierra Sur 
 * Lic. Informática
 */
package conexionBD;

import Modelo.ModUsuario;
import Vistas.Cifrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fercho
 */
public class CRUD_Usuario {
    public int tipo_de_usuario=0;
    // Instancias la clase que hemos creado anteriormente
    private ConexionMySQL SQL = new ConexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    
    //Módulo de creación de un usuario nuevo al sistema
    public void InsertarUsuarioNuevo(ModUsuario usuario) throws SQLException{
        //String sql = "INSERT INTO Usuarios (idUsuario, nombreUsuario, fullname, email) VALUES (?, ?, ?, ?)";
        String sql = "INSERT INTO Usuarios (usuarionombre, usuariopass, usuariofullname, usuarioemail,usuariotipo) VALUES (?, ?, ?, ?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, cif.TextoCifrado(usuario.getUsuario_nombre()));
        statement.setString(2, cif.TextoCifrado(usuario.getUsuario_pass()));
        statement.setString(3, usuario.getUsuario_fullname());
        statement.setString(4, usuario.getUsuario_email());
        statement.setString(5, usuario.getUsuario_tipo());

        int rowsInserted = statement.executeUpdate();
        
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en Usuarios");
        }
    }
    //Verificación de existencia del usuario en el Sistema
    public boolean ExisteUsuario(ModUsuario usuario) throws SQLException{
        int ban = 0;
        try{
        //System.out.println("Método Existe ModUsuario");
        String sql = "SELECT * FROM Usuarios where "
                + "usuarionombre = '"+cif.TextoCifrado(usuario.getUsuario_nombre())+"' and "
                + "usuariopass ='"+cif.TextoCifrado(usuario.getUsuario_pass())+"'";// and "
        //        + "usuario_tipo ='"+usuario.getUsuario_tipo()+"'";
        //System.out.println("sql = "+sql);
        
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while (result.next()){
            //System.out.println("Existe un usuario");
            ban=1;
            //System.out.println("xx -> "+result.getInt(1));
        }
        }catch(Exception e){
            //System.out.println("Error "+e.toString());
        }
        return ban == 1;
        
    }
    
    //VErificación de existencia del usuario en el Sistema
    public ModUsuario RetornaUsuariosiExiste(ModUsuario usuario) throws SQLException{
        ModUsuario datos;
        String sql = "SELECT * FROM Usuarios where "
                + "usuarionombre = '"+cif.TextoCifrado(usuario.getUsuario_nombre())+"' and "
                + "usuariopass='"+cif.TextoCifrado(usuario.getUsuario_pass())+"'";// and "
        //        + "usuario_tipo='"+usuario.getUsuario_tipo()+"'";
        //System.out.println("Retorna ModUsuario SQL "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);


        while (result.next()){
            try{
            datos = new ModUsuario(result.getInt(1), cif.TextoDescifrado(result.getString(2)), result.getString(3), result.getString(4), result.getString(5),result.getString(6));
            return datos;
            }catch(Exception e){
                //System.out.println("Error en Existe un usuario");
            }
        }
        return null;
    }
    
    public ModUsuario RetornaUsuariosiExiste(int usuario) throws SQLException{
        ModUsuario datos = null;
        String sql = "SELECT * FROM Usuarios where idUsuario="+usuario;// and "
        //        + "usuario_tipo='"+usuario.getUsuario_tipo()+"'";
        //System.out.println("Retorna ModUsuario SQL "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);


        while (result.next()){
            try{
            datos = new ModUsuario(result.getInt(1), cif.TextoDescifrado(result.getString(2)), cif.TextoDescifrado(result.getString(3)), result.getString(4), result.getString(5),result.getString(6));
            return datos;
            }catch(Exception e){
                //System.out.println("Error en Existe un usuario");
            }
        }
        return null;
    }
    
    //VErificación de existencia del usuario en el Sistema
    public int RetornaIdUsuariosiExisteContador(int idContador) throws SQLException{
        ModUsuario datos=null;
        //VErificar error
        //String sql = "SELECT * FROM users where "+"idContador="+idContador;
        String sql = "call proc_cuenta_users()";//;+idContador;
        System.out.println("Retorna Usuario por ID SQL "+sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        //statement.setBytes(1, dato);
        System.out.println(""+statement);    
        ResultSet result = statement.executeQuery(sql);
        int ss = 0;
        //System.out.println("Contador = "+idContador);
        while (result.next()){
            //System.out.println("dentro del while");
            try{
                if(idContador==ss){
                //System.out.println("Dentro del If");
                    int idCont = result.getInt("usuarios_idUsuario");
                    System.out.println("idCont = "+idCont);
                    return idCont;
                }
                ss++;
            }catch(Exception e){
                System.out.println("Error en Existe un usuario");
            }
        }
        return 0;
    }
    
    public ArrayList<String> RetornaListaUsuarios() throws SQLException{
        ArrayList<String> datos=new ArrayList<String>();
        
        String sql = "SELECT * FROM Usuarios";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);


        while (result.next()){
            try{
                datos.add(result.getInt("idUsuario")+" - "+result.getString("usuariofullname"));
            }catch(Exception e){
                //System.out.println("Error en Existe un usuario");
            }
        }
        return datos;
    }
    public String RetornaDedosUsuario(int idUsuario) throws SQLException{
        
        String dedos="";
        //suario datos=null;
        //VErificar error
        
        String sql = "SELECT descripcionDedo FROM users where "+"userID="+idUsuario;
        //System.out.println("Retorna ModUsuario por ID SQL "+sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        //statement.setBytes(1, dato);
        //System.out.println(""+statement);    
            
        ResultSet result = statement.executeQuery(sql);


        while (result.next()){
            try{
                dedos+= result.getString("descripcionDedo");
            }catch(Exception e){
                //System.out.println("Error en Existe un usuario");
            }
        }
        return dedos;
    }
    Cifrado cif =  new Cifrado();
    public void UpdateUsuario(int id_para_actualizar, ModUsuario datos_nuevos) throws SQLException{
        try{
        //Consulta idUsuario
        //usuario_nombre, usuario_pass, usuario_fullname, usuario_email, usuario_tipo
        String sql = "UPDATE Usuarios SET usuarionombre=?, usuariopass=?, usuariofullname=?, usuarioemail=?,usuariotipo=? WHERE idUsuario=?"; 
        //Cifrado de contraseña
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cif.TextoCifrado(datos_nuevos.getUsuario_nombre()));
        statement.setString(2, cif.TextoCifrado(datos_nuevos.getUsuario_pass()));
        statement.setString(3, datos_nuevos.getUsuario_fullname());
        statement.setString(4, datos_nuevos.getUsuario_email());
        statement.setString(5, datos_nuevos.getUsuario_tipo());
        statement.setInt(6, id_para_actualizar);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Usuario actualizado exitosamente");
        }
        }catch(Exception e){
            e.toString();
        }
    }
    //Elimina a un ModUsuario del Sistema
    public void DeleteUsuario(int id) throws SQLException{
        String sql = "DELETE FROM Usuarios WHERE idUsuario=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            //System.out.println("ModUsuario eliminado exitosamente");
        }
    }
    
}
