/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LabTW21
 */
public class ModExperimento {
    private int idListaExperimentos;
    private String Fecha, nombreExperimento,nombreArchivo;
    private String experimentoTemp,  sujetoPruebas;
    int idUsuario;

    public ModExperimento(int idUsuario,String sujetoPruebas, String nombreExperimento, String nombreArchivo) {
        this.idUsuario = idUsuario;
        this.sujetoPruebas = sujetoPruebas;
        this.nombreExperimento = nombreExperimento;
        this.nombreArchivo = nombreArchivo;
    }
    public ModExperimento(int idListaExperimentos,String fecha, String sujetoPruebas, String nombreExperimento, String nombreArchivo){
        this.idListaExperimentos = idListaExperimentos;
        this.Fecha = fecha;
        this.sujetoPruebas = sujetoPruebas;
        this.nombreExperimento = nombreExperimento;
        this.nombreArchivo = nombreArchivo;
        
    }

    public int getIdListaExperimentos() {
        return idListaExperimentos;
    }

    public void setIdListaExperimentos(int idListaExperimentos) {
        this.idListaExperimentos = idListaExperimentos;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombreExperimento() {
        return nombreExperimento;
    }

    public void setNombreExperimento(String nombreExperimento) {
        this.nombreExperimento = nombreExperimento;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getExperimentoTemp() {
        return experimentoTemp;
    }

    public void setExperimentoTemp(String experimentoTemp) {
        this.experimentoTemp = experimentoTemp;
    }

    public String getSujetoPruebas() {
        return sujetoPruebas;
    }

    public void setSujetoPruebas(String sujetoPruebas) {
        this.sujetoPruebas = sujetoPruebas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
