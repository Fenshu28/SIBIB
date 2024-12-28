/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import Modelo.ModExpedienteSujetoPruebas;
import Vistas.JComboCheckBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Fercho
 */
public class CRUD_ExpedienteSujetoPruebas {

    public int tipo_de_usuario = 0;
    // Instancias la clase que hemos creado anteriormente
    private ConexionMySQL SQL = new ConexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();

    //Creación de un nuevo usuario de prueba para expediente clinico
    public void InsertarExpedienteUsuario(ModExpedienteSujetoPruebas expedienteUsuario) throws SQLException {
        //Obtener el id ultimo expediente clínico y generar las lreaciones de la linea 1533 del archivo v4 programa principal
        String sql = " insert into expedienteSujetoPruebas "
                + "(sujetoNombre, sujetoApPat, sujetoApMat, sujetoFechaNac, sujetoCurp"
                + ",EstadoCivil_idEstadoCivil ,Sexo_idSexo ,Religion_idReligion)  values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, expedienteUsuario.getExpedienteUsuario_nombre());
        statement.setString(2, expedienteUsuario.getExpedienteUsuario_ap_pat());
        statement.setString(3, expedienteUsuario.getExpedienteUsuario_ap_mat());
        statement.setString(4, expedienteUsuario.getExpedienteUsuario_fecha_nac());
        statement.setString(5, expedienteUsuario.getExpedienteUsuario_curp());
        statement.setInt(6, ObtenerEstadoCivil(expedienteUsuario.getExpedienteUsuario_ec()));
        statement.setInt(7, ObtenerSexo(expedienteUsuario.getExpedienteUsuario_s()));
        statement.setInt(8, ObtenerReligion(expedienteUsuario.getExpedienteUsuario_religion()));

        System.out.println(statement);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en ExpedienteUsuario");
        }
    }

    public void InsertarRelacionCarrera(String val1, String val2) throws SQLException {
        String sql = " insert into expedienteSujetoPruebas_has_gradoEstudio "
                + "(expedienteSujetoPruebas_idSujetoPruebas,gradoEstudio_idGradoEstudio)  values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, RetornaIdExpedienteUsuario(val1));
        statement.setInt(2, ObtenerCarrera(val2));

        System.out.println(statement);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en ExpedienteUsuario");
        }
    }

    public void InsertarRelacionEnfermedades(String val1, String val2) throws SQLException {
        String sql = " insert into expedienteSujetoPruebas_has_enfermedades "
                + "(expedienteSujetoPruebas_idSujetoPruebas,enfermedades_idEnfermedades)  values (?, ?)";
        try{
        PreparedStatement statement = conn.prepareStatement(sql);
        System.out.println(""+val1+" "+val2);
        statement.setInt(1, RetornaIdExpedienteUsuario(val1));
        statement.setInt(2, ObtenerEnfermermedad(val2));

        System.out.println(statement);

        int rowsInserted = statement.executeUpdate();
        
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en InsertarRelacionEnfermedades");
        }
        }catch(Exception w){
            System.out.println(""+w.toString());
        }
    }
    
    public void DeleteRelacionEnfermedades(String idUsuario) throws SQLException {
        String sql = "DELETE FROM expedienteSujetoPruebas_has_enfermedades WHERE expedienteSujetoPruebas_idSujetoPruebas=? ";
        System.out.println("" + sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, Integer.parseInt(idUsuario));
        System.out.println("SQL - " + statement);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("ExpedienteUsuario eliminado exitosamente");
        }
    }

    public int ObtenerCarrera(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdCarrera(ec);
    }

    public int ObtenerEnfermermedad(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdEnfermedad(ec);
    }

    public int RetornaIdExpedienteUsuario(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdExpedienteUsuario(ec);
    }

    public int ObtenerEstadoCivil(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdEstadoCivil(ec);
    }

    public int ObtenerSexo(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdSexo(ec);
    }

    public int ObtenerReligion(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdReligion(ec);
    }

    public int ObtenerIdioma(String ec) throws SQLException {
        CRUD_TablasGenerales ct = new CRUD_TablasGenerales();
        return ct.RetornaIdIdioma(ec);
    }

    public boolean ExisteExpedienteUsuario(ModExpedienteSujetoPruebas expedienteUsuario) throws SQLException {
        int ban = 0;
        try {

            String sql = "SELECT * FROM expedienteSujetoPruebas where "
                    + "sujetoNombre = '" + expedienteUsuario.getExpedienteUsuario_nombre() + "' and "
                    + "sujetoApPat ='" + expedienteUsuario.getExpedienteUsuario_ap_pat() + "' and "
                    + "sujetoApMat ='" + expedienteUsuario.getExpedienteUsuario_ap_mat() + "' and "
                    + "sujetoFechaNac ='" + expedienteUsuario.getExpedienteUsuario_fecha_nac() + "'";
            //  System.out.println("sql = "+sql);

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                System.out.println("Existe un ExpedienteUsuario");
                ban = 1;
                System.out.println("yy -> " + result.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("ErrorA " + e.toString());
        }
        return ban == 1;

    }

//    public ModExpedienteSujetoPruebas RetornaExpedienteUsuariosiExiste(ModExpedienteSujetoPruebas expedienteUsuario) throws SQLException {
//        ModExpedienteSujetoPruebas datos;
//
//        //System.out.println("Método ExisteExpedienteUsuario");
//        String sql = "SELECT * FROM expedienteSujetoPruebas where "
//                + "sujetoNombre = '" + expedienteUsuario.getExpedienteUsuario_nombre() + "' and "
//                + "sujetoApPat ='" + expedienteUsuario.getExpedienteUsuario_ap_pat() + "' and "
//                + "sujetoApMat ='" + expedienteUsuario.getExpedienteUsuario_ap_mat() + "' and "
//                + "sujetoFechaNac ='" + expedienteUsuario.getExpedienteUsuario_fecha_nac() + "'";
//        System.out.println("sql = " + sql);
//        Statement statement = conn.createStatement();
//        ResultSet result = statement.executeQuery(sql);
//        while (result.next()) {
//            try {
//                datos = new ModExpedienteSujetoPruebas(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getString(11), result.getString(12), result.getBoolean(13), result.getBoolean(14), result.getBoolean(15), result.getBoolean(16), result.getBoolean(17));
//                return datos;
//            } catch (Exception e) {
//                System.out.println("ErrorB " + e.toString());
//            }
//        }
//        return null;
//    }

//    public ModExpedienteSujetoPruebas RetornaExpedienteUsuariosiExiste(String nombre) throws SQLException {
//        ModExpedienteSujetoPruebas datos;
//        System.out.println("Método ExisteExpedienteUsuario");
//        String sql = "SELECT * FROM expedienteSujetoPruebas where "
//                + "sujetoNombre = '" + nombre + "'";
//        System.out.println("sql = " + sql);
//        Statement statement = conn.createStatement();
//        ResultSet result = statement.executeQuery(sql);
//        while (result.next()) {
//            try {
//                datos = new ModExpedienteSujetoPruebas(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5) + "", result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getString(11), result.getString(12), result.getBoolean(13), result.getBoolean(14), result.getBoolean(15), result.getBoolean(16), result.getBoolean(17));
//                return datos;
//            } catch (Exception e) {
//                System.out.println("ErrorC " + e.toString());
//            }
//        }
//        return null;
//    }

    public ModExpedienteSujetoPruebas RetornaExpedienteUsuariosiExisteId(String id) throws SQLException {
        ModExpedienteSujetoPruebas datos = null;
        String sql = "SELECT * FROM expedienteSujetoPruebas where idSujetoPruebas = " + id + "";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            try {
                System.out.println(""+result.getInt(1)+".."+ result.getString(2)+".."+ result.getString(3)+ ".."+result.getString(4)+".."+ result.getDate(5) + ""+ ".."+result.getString(6)+".."+ result.getString(7)+".."+ result.getString(8)+".."+ result.getString(9));
                datos = new ModExpedienteSujetoPruebas(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5) + "", result.getString(6), result.getString(7), result.getString(8), result.getString(9));
            } catch (Exception e) {
                System.out.println("ErrorC " + e.toString());
            }
        }
        sql = "SELECT gradoEstudio_idGradoEstudio FROM expedientesujetopruebas_has_gradoestudio where expedienteSujetoPruebas_idSujetoPruebas = " + id + "";
        statement = conn.createStatement();
        result = statement.executeQuery(sql);
        System.out.println("ANTES DEL MUY IMPORTANTE "+id);
        if (result.next()) {
            System.out.println("MUY MUY IMPORTANTE "+result.getInt(1) + "");
            datos.setExpedienteUsuario_carrera(result.getInt(1) + "");
        }
        sql = "SELECT idioma_idIdioma FROM expedientesujetopruebas_has_idioma where expedienteSujetoPruebas_idSujetoPruebas = " + id + "";
        statement = conn.createStatement();
        result = statement.executeQuery(sql);
        if (result.next()) {
            datos.setExpedienteUsuario_lm(result.getInt(1) + "");
        }
        if (result.next()) {
            datos.setExpedienteUsuario_oi(result.getInt(1) + "");
        }
        sql = "SELECT enfermedades_idEnfermedades FROM expedienteSujetoPruebas_has_enfermedades where expedienteSujetoPruebas_idSujetoPruebas = " + id + "";
        statement = conn.createStatement();
        result = statement.executeQuery(sql);
        for (int i = 0; i < 10; i++) {
            if (result.next()) {
                if (result.getInt(1) == 1) {
                    datos.setEnf1(result.getInt(1) + "");
                }
                if (result.getInt(1) == 2) {
                    datos.setEnf2(result.getInt(1) + "");
                }
                if (result.getInt(1) == 3) {
                    datos.setEnf3(result.getInt(1) + "");
                }
                if (result.getInt(1) == 4) {
                    datos.setEnf4(result.getInt(1) + "");
                }
                if (result.getInt(1) == 5) {
                    datos.setEnf5(result.getInt(1) + "");
                }
                if (result.getInt(1) == 6) {
                    datos.setEnf6(result.getInt(1) + "");
                }
                if (result.getInt(1) == 7) {
                    datos.setEnf7(result.getInt(1) + "");
                }
                if (result.getInt(1) == 8) {
                    datos.setEnf8(result.getInt(1) + "");
                }
                if (result.getInt(1) == 9) {
                    datos.setEnf9(result.getInt(1) + "");
                }
                if (result.getInt(1) == 10) {
                    datos.setEnf10(result.getInt(1) + "");
                }
            }
        }

        return datos;
    }

    public List<String> RetornaListaExpedientes() throws SQLException {
        List<String> dato = new ArrayList<String>();
        System.out.println("Método ExisteExpedienteUsuario");
        String sql = "SELECT idSujetoPruebas,sujetoNombre,sujetoApPat,sujetoApMat FROM expedienteSujetoPruebas";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            dato.add(result.getInt(1) + ") " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4));
        }
        return dato;
    }

    public void UpdateExpedienteUsuario(int id_para_actualizar, ModExpedienteSujetoPruebas datos_nuevos) throws SQLException {
        try {
            String sql = "UPDATE expedienteSujetoPruebas SET sujetoNombre=?,sujetoApPat=?,sujetoApMat=?,sujetoFechaNac=? ,sujetoCurp = ?,EstadoCivil_idEstadoCivil=?,Sexo_idSexo=?,Religion_idReligion=? "
                    + "WHERE idSujetoPruebas=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, datos_nuevos.getExpedienteUsuario_nombre());
            statement.setString(2, datos_nuevos.getExpedienteUsuario_ap_pat());
            statement.setString(3, datos_nuevos.getExpedienteUsuario_ap_mat());
            statement.setString(4, datos_nuevos.getExpedienteUsuario_fecha_nac());
            statement.setString(5, datos_nuevos.getExpedienteUsuario_curp());
            statement.setInt(6, ObtenerEstadoCivil(datos_nuevos.getExpedienteUsuario_ec()));//id
            statement.setInt(7, ObtenerSexo(datos_nuevos.getExpedienteUsuario_s()));//id
            statement.setInt(8, ObtenerReligion(datos_nuevos.getExpedienteUsuario_religion()));//id
            statement.setInt(9, id_para_actualizar);
            System.out.println("SQL - " + statement);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente");
            }
        } catch (Exception e) {
            e.toString();
        }
        System.out.println("ACTUALIZANDO LENGUA MATERNA");
        //Actualización de Lengua materna y otro idioma
        try{
        DeleteLenguas(id_para_actualizar);
        CRUD_ExpedienteSujetoPruebas cew = new CRUD_ExpedienteSujetoPruebas();
        cew.InsertarRelacionIdioma(datos_nuevos.getExpedienteUsuario_nombre(), datos_nuevos.getExpedienteUsuario_lm());
        cew.InsertarRelacionIdioma(datos_nuevos.getExpedienteUsuario_nombre(), datos_nuevos.getExpedienteUsuario_oi());
        }catch(Exception c){
            System.out.println("SQL Error "+c);
        }
        //Actualización de Carrera
        System.out.println("ACTUALIZANDO CARRERA");
        CRUD_TablasGenerales tt = new CRUD_TablasGenerales();
        try {
            DeleteCarrera(id_para_actualizar);
            String sql = "UPDATE expedienteSujetoPruebas_has_gradoEstudio SET gradoEstudio_idGradoEstudio=? WHERE expedienteSujetoPruebas_idSujetoPruebas=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, tt.RetornaIdCarrera(datos_nuevos.getExpedienteUsuario_carrera()));
            statement.setInt(2, id_para_actualizar);
            System.out.println("SQL - " + statement);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("grado de estudio actualizado exitosamente");
            }
        } catch (Exception e) {
            e.toString();
        }
    }

    public void DeleteLenguas(int id) throws SQLException {
        String sql = "DELETE FROM expedientesujetopruebas_has_idioma WHERE expedienteSujetoPruebas_idSujetoPruebas=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("DeleteLenguas eliminado exitosamente");
        }
    }
    public void DeleteCarrera(int id) throws SQLException {
        String sql = "DELETE FROM expedienteSujetoPruebas_has_gradoEstudio WHERE expedienteSujetoPruebas_idSujetoPruebas=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("DeleteLenguas eliminado exitosamente");
        }
    }
    
    public void DeleteExpedienteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM expedienteSujetoPruebas WHERE idSujetoPruebas=?";
        System.out.println("" + sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println("SQL 199 - " + statement);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("ExpedienteUsuario eliminado exitosamente");
        }
    }

    public void InsertarRelacionIdioma(String val1, String val2) throws SQLException {
        String sql = " insert into expedienteSujetoPruebas_has_idioma "
                + "(expedienteSujetoPruebas_idSujetoPruebas, Idioma_idIdioma)  values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, RetornaIdExpedienteUsuario(val1));
        statement.setInt(2, ObtenerIdioma(val2));

        System.out.println(statement);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Insert Exitoso en ExpedienteUsuario");
        }
    }

    public void UpdateExpedienteUsuario(ModExpedienteSujetoPruebas eu, JPanel jPanel11) throws SQLException {
        JComboCheckBox nue = (JComboCheckBox) jPanel11.getComponent(0);
        CRUD_ExpedienteSujetoPruebas cew2 = new CRUD_ExpedienteSujetoPruebas();
        cew2.DeleteRelacionEnfermedades(eu.getIdExpedienteUsuario()+"");
        Vector v = new Vector();
        for (int i = 0; i < nue.getItemCount(); i++) {
            v.add(nue.getItemAt(i));
        }
        for (int i = 1; i < v.size(); i++) {
            JCheckBox val = (JCheckBox) v.get(i);
            System.out.println("<<<Accediendo al Vector " + i + " " + val.getText() + " " + val.isSelected());
            if (val.isSelected()) {
                cew2.InsertarRelacionEnfermedades(eu.getExpedienteUsuario_nombre(), val.getText());
            }
        }
    }
    /*
        
        
        
        
        
    */
}
