/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import conexionBD.ConexionMySQL;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author LabTW21
 */
public class Reporte {

    public String SolicitarRuta() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fc.showSaveDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            try {
                String cadena = "" + fc.getSelectedFile();
                return cadena;
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        return "";
    }

    public void GenerarPDFListaExpedientesClinicos() throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        String reportSrcFile = "src\\Reportes\\ExpedienteClinico.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ReporteExpedienteClínico.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFListaIdiomasPaciente() throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        String reportSrcFile = "src\\Reportes\\IdiomasPaciente.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ReporteIdiomas.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }
    public void GenerarPDFListaEnfermedadesPaciente() throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        String reportSrcFile = "src\\Reportes\\EnfermedadesPaciente.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ReporteEnfermedades.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }
    //Falta La condición del Usuario
    public void GenerarPDFHistorialExperimentos(int IdUsuario, String menor, String mayor) throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion1", new Integer(menor));
        parameters.put("Condicion2", new Integer(mayor));
        parameters.put("Condicion3", new Integer(1));
        String reportSrcFile = "src\\Reportes\\ReporteHERango.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        //<parameter name="Condicion" class="java.lang.String"/>
        /////////////////////////////////////////////////////
        /*
        ////////////////////////////////////////////////////
        
        
        WHERE
            expedienteusuario.`idExpedienteUsuario`=$P{Condicion}
        //////////////////////////////////////////////////////
         */
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/HistorialExperimentosRango.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFHistorialExperimentos(int IdUsuario, String igual) throws JRException {
        String cade = SolicitarRuta();
        System.out.println(""+cade);
        if(!cade.equals("")){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion", new Integer(igual));
        parameters.put("Condicion3", new Integer(1));
        String reportSrcFile = "src\\Reportes\\ReporteHEUno.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        //<parameter name="Condicion" class="java.lang.String"/>
        /////////////////////////////////////////////////////
        /*
        ////////////////////////////////////////////////////
        
        
        WHERE
            expedienteusuario.`idExpedienteUsuario`=$P{Condicion}
        //////////////////////////////////////////////////////
         */
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/HistorialExperimentos.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFHistorialExperimentos(int IdUsuario) throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion3", new Integer(1));
        String reportSrcFile = "src\\Reportes\\ReporteHE.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();

        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/HistorialExperimentos.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFHistorialExperimentosTemporales(int IdUsuario) throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion3", new Integer(0));
        String reportSrcFile = "src\\Reportes\\ReporteHETemp.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        //<parameter name="Condicion" class="java.lang.String"/>
        /////////////////////////////////////////////////////
        /*
        ////////////////////////////////////////////////////
        
        
        WHERE
            expedienteusuario.`idExpedienteUsuario`=$P{Condicion}
        //////////////////////////////////////////////////////
         */
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ExperimentosTemporales.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFHistorialExperimentosTemporales(int IdUsuario, String igual) throws JRException {
        String cade = SolicitarRuta();
        if(!cade.equals("")){

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion", new Integer(igual));
        parameters.put("Condicion3", new Integer(0));
        String reportSrcFile = "src\\Reportes\\ReporteHEUnoTemp.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        //<parameter name="Condicion" class="java.lang.String"/>
        /////////////////////////////////////////////////////
        /*
        ////////////////////////////////////////////////////
        
        
        WHERE
            expedienteusuario.`idExpedienteUsuario`=$P{Condicion}
        //////////////////////////////////////////////////////
         */
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ExperimentosTemporales.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

    public void GenerarPDFHistorialExperimentosTemporales(int IdUsuario, String menor, String mayor) throws JRException {
String cade = SolicitarRuta();
        if(!cade.equals("")){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("IdUsuario", new Integer(IdUsuario));
        parameters.put("Condicion1", new Integer(menor));
        parameters.put("Condicion2", new Integer(mayor));
        parameters.put("Condicion3", new Integer(0));

        String reportSrcFile = "src\\Reportes\\ReporteHERangoTemp.jrxml";
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        ConexionMySQL SQL = new ConexionMySQL();
        Connection conn = SQL.conectarMySQL();
        // Parameters for report

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        //<parameter name="Condicion" class="java.lang.String"/>
        /////////////////////////////////////////////////////
        /*
        ////////////////////////////////////////////////////
        
        
        WHERE
            expedienteusuario.`idExpedienteUsuario`=$P{Condicion}
        //////////////////////////////////////////////////////
         */
        JasperPrint print = JasperFillManager.fillReport(jasperReport,
                parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Experimentos");
        outDir.mkdirs();

        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(cade + "/ExperimentosTemporalesRango.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        //JOptionPane.showMessageDialog(null, "Exportación exitosa!");
        }
    }

}
