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
public class ModExpedienteSujetoPruebas {

    //ExpedienteUsuario
    private int idExpedienteUsuario;
    private String ExpedienteUsuario_nombre, ExpedienteUsuario_ap_pat, ExpedienteUsuario_ap_mat;
    private String ExpedienteUsuario_fecha_nac;
    private String ExpedienteUsuario_carrera="", ExpedienteUsuario_religion="", ExpedienteUsuario_ec="", ExpedienteUsuario_curp="", ExpedienteUsuario_s="", ExpedienteUsuario_lm="", ExpedienteUsuario_oi="";
    private String Enf1 = "", Enf2 = "", Enf3 = "", Enf4 = "", Enf5 = "", Enf6 = "", Enf7 = "", Enf8 = "", Enf9 = "", Enf10 = "";

    public String getEnf1() {
        return Enf1;
    }

    public void setEnf1(String Enf1) {
        this.Enf1 = Enf1;
    }

    public String getEnf2() {
        return Enf2;
    }

    public void setEnf2(String Enf2) {
        this.Enf2 = Enf2;
    }

    public String getEnf3() {
        return Enf3;
    }

    public void setEnf3(String Enf3) {
        this.Enf3 = Enf3;
    }

    public String getEnf4() {
        return Enf4;
    }

    public void setEnf4(String Enf4) {
        this.Enf4 = Enf4;
    }

    public String getEnf5() {
        return Enf5;
    }

    public void setEnf5(String Enf5) {
        this.Enf5 = Enf5;
    }

    public String getEnf6() {
        return Enf6;
    }

    public void setEnf6(String Enf6) {
        this.Enf6 = Enf6;
    }

    public String getEnf7() {
        return Enf7;
    }

    public void setEnf7(String Enf7) {
        this.Enf7 = Enf7;
    }

    public String getEnf8() {
        return Enf8;
    }

    public void setEnf8(String Enf8) {
        this.Enf8 = Enf8;
    }

    public String getEnf9() {
        return Enf9;
    }

    public void setEnf9(String Enf9) {
        this.Enf9 = Enf9;
    }

    public String getEnf10() {
        return Enf10;
    }

    public void setEnf10(String Enf10) {
        this.Enf10 = Enf10;
    }

    public ModExpedienteSujetoPruebas(String Nombre, String ApPat, String ApMat, String Fecha, String Curp, String Ec, String S, String Religion) {
        this.ExpedienteUsuario_nombre = Nombre;
        this.ExpedienteUsuario_ap_pat = ApPat;
        this.ExpedienteUsuario_ap_mat = ApMat;
        this.ExpedienteUsuario_fecha_nac = Fecha;
        this.ExpedienteUsuario_curp = Curp;
        this.ExpedienteUsuario_ec = Ec;
        this.ExpedienteUsuario_s = S;
        this.ExpedienteUsuario_religion = Religion;
    }

    public ModExpedienteSujetoPruebas(String Nombre, String ApPat, String ApMat, String Fecha, String Carrera, String Religion, String Ec, String Curp, String S, String Lm, String Oi) {
        this.ExpedienteUsuario_nombre = Nombre;
        this.ExpedienteUsuario_ap_pat = ApPat;
        this.ExpedienteUsuario_ap_mat = ApMat;
        this.ExpedienteUsuario_fecha_nac = Fecha;
        this.ExpedienteUsuario_carrera = Carrera;
        this.ExpedienteUsuario_curp = Curp;
        this.ExpedienteUsuario_ec = Ec;
        this.ExpedienteUsuario_s = S;
        this.ExpedienteUsuario_religion = Religion;
        this.ExpedienteUsuario_lm = Lm;
        this.ExpedienteUsuario_oi = Oi;
    }

    public ModExpedienteSujetoPruebas(int id, String Nombre, String ApPat, String ApMat, String Fecha, String Curp, String S, String Religion, String Ec) {
        this.idExpedienteUsuario = id;
        this.ExpedienteUsuario_nombre = Nombre;
        this.ExpedienteUsuario_ap_pat = ApPat;
        this.ExpedienteUsuario_ap_mat = ApMat;
        this.ExpedienteUsuario_fecha_nac = Fecha;
        this.ExpedienteUsuario_curp = Curp;
        this.ExpedienteUsuario_s = S;
        this.ExpedienteUsuario_religion = Religion;
        this.ExpedienteUsuario_ec = Ec;
    }

    public ModExpedienteSujetoPruebas() {

    }

    public int getIdExpedienteUsuario() {
        return idExpedienteUsuario;
    }

    public void setIdExpedienteUsuario(int idExpedienteUsuario) {
        this.idExpedienteUsuario = idExpedienteUsuario;
    }

    public String getExpedienteUsuario_nombre() {
        return ExpedienteUsuario_nombre;
    }

    public void setExpedienteUsuario_nombre(String ExpedienteUsuario_nombre) {
        this.ExpedienteUsuario_nombre = ExpedienteUsuario_nombre;
    }

    public String getExpedienteUsuario_ap_pat() {
        return ExpedienteUsuario_ap_pat;
    }

    public void setExpedienteUsuario_ap_pat(String ExpedienteUsuario_ap_pat) {
        this.ExpedienteUsuario_ap_pat = ExpedienteUsuario_ap_pat;
    }

    public String getExpedienteUsuario_ap_mat() {
        return ExpedienteUsuario_ap_mat;
    }

    public void setExpedienteUsuario_ap_mat(String ExpedienteUsuario_ap_mat) {
        this.ExpedienteUsuario_ap_mat = ExpedienteUsuario_ap_mat;
    }

    public String getExpedienteUsuario_fecha_nac() {
        return ExpedienteUsuario_fecha_nac;
    }

    public void setExpedienteUsuario_fecha_nac(String ExpedienteUsuario_fechaa_nac) {
        this.ExpedienteUsuario_fecha_nac = ExpedienteUsuario_fechaa_nac;
    }

    public String getExpedienteUsuario_carrera() {
        System.out.println("get "+ExpedienteUsuario_carrera);
        return ExpedienteUsuario_carrera;
    }

    public void setExpedienteUsuario_carrera(String ExpedienteUsuario_carrera) {
        this.ExpedienteUsuario_carrera = ExpedienteUsuario_carrera;
    }

    public String getExpedienteUsuario_religion() {
        return ExpedienteUsuario_religion;
    }

    public void setExpedienteUsuario_religion(String ExpedienteUsuario_religion) {
        this.ExpedienteUsuario_religion = ExpedienteUsuario_religion;
    }

    public String getExpedienteUsuario_ec() {
        return ExpedienteUsuario_ec;
    }

    public void setExpedienteUsuario_ec(String ExpedienteUsuario_ec) {
        this.ExpedienteUsuario_ec = ExpedienteUsuario_ec;
    }

    public String getExpedienteUsuario_curp() {
        return ExpedienteUsuario_curp;
    }

    public void setExpedienteUsuario_curp(String ExpedienteUsuario_curp) {
        this.ExpedienteUsuario_curp = ExpedienteUsuario_curp;
    }

    public String getExpedienteUsuario_s() {
        return ExpedienteUsuario_s;
    }

    public void setExpedienteUsuario_s(String ExpedienteUsuario_s) {
        this.ExpedienteUsuario_s = ExpedienteUsuario_s;
    }

    public String getExpedienteUsuario_lm() {
        return ExpedienteUsuario_lm;
    }

    public void setExpedienteUsuario_lm(String ExpedienteUsuario_lm) {
        this.ExpedienteUsuario_lm = ExpedienteUsuario_lm;
    }

    public String getExpedienteUsuario_oi() {
        return ExpedienteUsuario_oi;
    }

    public void setExpedienteUsuario_oi(String ExpedienteUsuario_oi) {
        this.ExpedienteUsuario_oi = ExpedienteUsuario_oi;
    }

}
