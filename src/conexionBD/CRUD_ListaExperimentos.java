/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import Modelo.ModExperimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LabTW21
 */
public class CRUD_ListaExperimentos {
    public int tipo_de_usuario=0;
    // Instancias la clase que hemos creado anteriormente
    private ConexionMySQL SQL = new ConexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    
    //Módulo de creación de un usuario nuevo al sistema
    public void InsertarExperimentoNuevo(ModExperimento experimento) throws SQLException{
        Date fecha = new Date();
        String sql = "INSERT INTO ListaExperimentos (fecha,nombreExperimento,NombreArchivo,experimentoTemp,usuarios_idUsuario,expedienteSujetoPruebas_idSujetoPruebas) VALUES (?, ?, ?,0,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, fecha.toString());
        statement.setString(2, experimento.getNombreExperimento());
        statement.setString(3, experimento.getNombreArchivo());
        statement.setInt(4, experimento.getIdUsuario());
        statement.setInt(5, Integer.parseInt(EncuentraCaracter(experimento.getSujetoPruebas())));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en InsertarExperimentoNuevo");
        }
    }
    
    private String EncuentraCaracter(String igual){
       System.out.println("" + igual);
        int band = 0;
        for(int i =0;i<igual.length();i++){
            if(igual.charAt(i)==')'){
                //System.out.println("Verificar muy importante_ CRUD_LISTAEXPERIMENTOS >>"+i);
                band=i;
                return igual.substring(0, band);
            }
        } 
        return igual;
    }
    
    //Verificar Después
    public void UpdateExperimento(ModExperimento ex) throws SQLException{
        try{
        String sql = "UPDATE listaExperimentos SET Fecha=?, expedienteSujetoPruebas_idSujetoPruebas=?, nombreExperimento=? WHERE idListaExperimentos=?"; 
            System.out.println(""+sql+"--");
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, ex.getFecha());
        statement.setInt(2, Integer.parseInt(EncuentraCaracter(ex.getSujetoPruebas())));
        statement.setString(3, ex.getNombreExperimento());
        statement.setInt(4, ex.getIdListaExperimentos());
        int rowsUpdated = statement.executeUpdate();
        System.out.println("..."+statement+"--");

        if (rowsUpdated > 0) {
            System.out.println("Experimento actualizado exitosamente");
        }
        }catch(Exception e){
            e.toString();
        }
    }
    
    public void UpdateExperimentoTemp(int idListaExperimentos) throws SQLException{
        try{
        //Consulta idUsuario
        //usuario_nombre, usuario_pass, usuario_fullname, usuario_email, usuario_tipo
        String sql = "UPDATE ListaExperimentos SET experimentoTemp=1 WHERE idListaExperimentos=?"; 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idListaExperimentos);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Experimento actualizado exitosamente");
        }
        }catch(Exception e){
            e.toString();
        }
    }
    //Elimina a un Usuario del Sistema
    public void DeleteExperimento(String idListaExperimentos) throws SQLException{
        String sql = "DELETE FROM ListaExperimentos WHERE idListaExperimentos=?";
        System.out.println(""+sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        System.out.println(""+statement);
        statement.setInt(1, Integer.parseInt(idListaExperimentos));
        int rowsDeleted = statement.executeUpdate();
        System.out.println(""+statement);
        if (rowsDeleted > 0) {
            System.out.println("Experimento eliminado exitosamente");
        }
    }
    
    public List<String> RetornaListaExperimentos(int idUsuario) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE usuarios_idUsuario="+idUsuario+" and experimentoTemp=1";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getInt(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getInt(3)+"");
                dato.add(result.getString(4)+"");
        }
        return dato;
    }
    public List<String> RetornaListaExperimentos(String Condiciones,int idUsuario) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE usuarios_idUsuario="+idUsuario+" "+Condiciones+" and experimentoTemp=1";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getInt(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getString(3)+"");
                dato.add(result.getString(4)+"");
                
        }
        return dato;
    }
    
    public List<String> RetornaListaExperimentosTemporales(String Condiciones,int idUsuario) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE usuarios_idUsuario="+idUsuario+" "+Condiciones+" and experimentoTemp=0";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getInt(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getString(3)+"");
                dato.add(result.getString(4)+"");
                
        }
        return dato;
    }
    
    public List<String> RetornaListaExperimentosTemporales(int idUsuario) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE usuarios_idUsuario="+idUsuario+" and experimentoTemp=0";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getInt(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getInt(3)+"");
                dato.add(result.getString(4)+"");
                
        }
        return dato;
    }
    
//    public List<String> RetornaListaFechaExperimentos() throws SQLException{
//        List<String> dato = new ArrayList<String>();
//        String sql = "SELECT Fecha FROM ListaExperimentos";
//        System.out.println("sql = "+sql);
//        Statement statement = conn.createStatement();
//        ResultSet result = statement.executeQuery(sql);
//        while (result.next()){
//                dato.add(result.getString(1));
//        }
//        return dato;
//    }
    
    public List<String> RetornaListaFechaExperimentosTemporales() throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT Fecha FROM ListaExperimentos"+" where experimentoTemp=0";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getString(1));
        }
        return dato;
    }
    
    public List<String> RetornaListaFechaExperimentos(String id) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,NombreExperimento FROM ListaExperimentos Where usuarios_idUsuario ="+id+" and experimentoTemp=1";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getString(1)+ " | "+result.getString(2));
        }
        return dato;
    }
    
    public List<String> RetornaListaFechaExperimentosTemporales(String id) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT idListaExperimentos,NombreExperimento FROM ListaExperimentos Where usuarios_idUsuario ="+id+" and experimentoTemp=0";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getString(1)+ " | "+result.getString(2));
        }
        return dato;
    }
    
    public List<String> NombreArchivoForIdExp(String id) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT NombreArchivo,idListaExperimentos,usuarios_idUsuario,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE idListaExperimentos="+id+" and experimentoTemp=1";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getString(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getInt(3)+"");
                dato.add(result.getString(4)+"");
                dato.add(result.getInt(5)+"");
                dato.add(result.getString(6)+"");
        }
        return dato;
    }
    public List<String> NombreArchivoForIdExpTemp(String id) throws SQLException{
        List<String> dato = new ArrayList<String>();
                
        String sql = "SELECT NombreArchivo,idListaExperimentos,usuarios_idUsuario,Fecha,expedienteSujetoPruebas_idSujetoPruebas,NombreExperimento FROM ListaExperimentos WHERE idListaExperimentos="+id+" and experimentoTemp=0";
        System.out.println("sql = "+sql);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
                dato.add(result.getString(1)+"");
                dato.add(result.getString(2)+"");
                dato.add(result.getString(3)+"");
                dato.add(result.getString(4)+"");
                dato.add(result.getInt(5)+"");
                dato.add(result.getString(6)+"");
        }
        return dato;
    }
}
