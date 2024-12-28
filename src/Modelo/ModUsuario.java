/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Fercho
 */
public class ModUsuario {
    //Consulta idUsuario
    private int idUsuario=0;
    private String usuario_nombre="", usuario_pass="", usuario_fullname="", usuario_email="", usuario_tipo="";
    //Este constructor se usa en el momento de leer un ModUsuario de la BD y almacenar sus datos aqui
    public ModUsuario(int idUsuario, String Nombre, String Pass, String NombreCompleto, String Email, String Tipo) {
        this.idUsuario = idUsuario;
        this.usuario_nombre = Nombre;
        this.usuario_pass = Pass;
        this.usuario_fullname = NombreCompleto;
        this.usuario_email = Email;
        this.usuario_tipo = Tipo;
    }
    //Este constructor se usa antes de almacenar los datos en la BD y guarda los datos del usuario aqui
    public ModUsuario(String Nombre, String Pass, String NombreCompleto, String Email, String Tipo) {
        this.usuario_nombre = Nombre;
        this.usuario_pass = Pass;
        this.usuario_fullname = NombreCompleto;
        this.usuario_email = Email;
        this.usuario_tipo = Tipo;
    }

    public ModUsuario(String Nombre, String Pass){
        this.usuario_nombre = Nombre;
        this.usuario_pass = Pass;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_pass() {
        return usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }

    public String getUsuario_fullname() {
        return usuario_fullname;
    }

    public void setUsuario_fullname(String usuario_fullname) {
        this.usuario_fullname = usuario_fullname;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_tipo() {
        return usuario_tipo;
    }

    public void setUsuario_tipo(String usuario_tipo) {
        this.usuario_tipo = usuario_tipo;
    }
    
    
    
}
