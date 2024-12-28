/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LabTW21
 */
public class CRUD_TablasGenerales {
    public int tipo_de_usuario=0;
    // Instancias la clase que hemos creado anteriormente
    private ConexionMySQL SQL = new ConexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    
    public ArrayList<String> RetornaListaEstadoCivil() throws SQLException{
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT descripcion FROM EstadoCivil";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1)+"");
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
    public int RetornaIdEstadoCivil(String ec) throws SQLException{
        String sql = "SELECT idEstadoCivil FROM EstadoCivil where Descripcion='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    public int RetornaIdEnfermedad(String ec) throws SQLException{
        String sql = "SELECT idEnfermedades FROM Enfermedades where Abreviatura='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    public int RetornaIdCarrera(String ec) throws SQLException{
        String sql = "SELECT idGradoEstudio FROM gradoEstudio where descripcion='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    public int RetornaIdExpedienteUsuario(String ec) throws SQLException{
        String sql = "SELECT idSujetoPruebas FROM expedienteSujetoPruebas where sujetoNombre='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    public ArrayList<String> RetornaListaReligiones() throws SQLException{
        System.out.println("Dentro del método");
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT descripcion FROM Religion";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1)+"");
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
    public int RetornaIdReligion(String ec) throws SQLException{
        String sql = "SELECT idReligion FROM Religion where Descripcion='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    public int RetornaIdIdioma(String ec) throws SQLException{
        String sql = "SELECT idIdioma FROM Idioma where Descripcion='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    
    
    
    public ArrayList<String> RetornaListaCarrera() throws SQLException{
        System.out.println("Dentro del método");
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT descripcion FROM gradoEstudio";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1)+"");
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
    public ArrayList<String> RetornaListaSexo() throws SQLException{
        System.out.println("Dentro del método");
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT descripcion FROM Sexo";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1)+"");
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
    public int RetornaIdSexo(String ec) throws SQLException{
        String sql = "SELECT idSexo FROM Sexo where Descripcion='"+ec+"'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
               return result.getInt(1);
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return 1;
    }
    
    public ArrayList<String> RetornaListaIdioma() throws SQLException{
        System.out.println("Dentro del método");
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT descripcion FROM Idioma";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1)+"");
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
    public ArrayList<String> RetornaListaEnfermedades() throws SQLException{
        System.out.println("Dentro del método");
        ArrayList<String> datos=new ArrayList<String>();
        String sql = "SELECT abreviatura FROM Enfermedades";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            try{
                //datos.add(result.getInt(1)+"");
                datos.add(result.getString(1));
            }catch(Exception e){
                System.out.println(""+e.toString());
            }
        }
        return datos;
    }
}
