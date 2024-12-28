/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPFingerIndex;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.DPFPCapturePriority;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPDataListener;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.readers.DPFPReaderDescription;
import com.digitalpersona.onetouch.readers.DPFPReadersCollection;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author LabTW21
 */
public class CRUD_HuellaDigital {

    private String userID = "";

    static EnumMap<DPFPFingerIndex, DPFPTemplate> templates = new EnumMap<DPFPFingerIndex, DPFPTemplate>(DPFPFingerIndex.class);

    public String getUserID() {
        return userID;
    }

    public Connection cn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tesis2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            //System.out.println(e);
        }
        return conn;
    }

    public void insert(String idUsuario, byte[] digital, String DescripDedo) {
        PreparedStatement st;
        try {
            st = cn().prepareStatement("INSERT INTO huella(usuarios_idUsuario, print1,descripcionDedo) VALUES(?,?,?)");
            st.setInt(1, Integer.parseInt(idUsuario));
            st.setBytes(2, digital);
            st.setString(3, DescripDedo);
            //System.out.println("id: " + idUsuario + " digital: " + digital);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    ArrayList<String> pos=null;
    public ArrayList<byte[]> get() {
        ArrayList<String> pos = new ArrayList<String>();
        ArrayList<byte[]> vamos = new ArrayList<byte[]>();
        ResultSet rs;
        PreparedStatement st;
        byte[] digital = null;
        try {
            st = cn().prepareStatement("SELECT * FROM huella");
            //System.out.println("" + st);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                //System.out.println(""+rs.getString(1));
                //System.out.println("");
                digital = rs.getBytes("print1");
                vamos.add(digital);
                pos.add(""+i);i++;
                //System.out.println("- "+digital);
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
        return vamos;
    }
    
    public ArrayList<String> getList(String  id) {
        ArrayList<String> pos = new ArrayList<String>();
        ResultSet rs;
        PreparedStatement st;
        byte[] digital = null;
        try {
            st = cn().prepareStatement("SELECT * FROM huella where usuarios_idUsuario="+id+"");
            //System.out.println("" + st);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                pos.add(rs.getString("idHuella")+" "+rs.getString("descripcionDedo"));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
        return pos;
    }
    
    public static void listReaders() {
        DPFPReadersCollection readers = DPFPGlobal.getReadersFactory().getReaders();
        if (readers == null || readers.size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay Lector de huellas disponible");
            return;
        }
        //System.out.printf("Lectores disponibles:\n");
        for (DPFPReaderDescription readerDescription : readers) {
            System.out.println(readerDescription.getSerialNumber());
        }
    }

    public static final EnumMap<DPFPFingerIndex, String> fingerNames;

    static {
        fingerNames = new EnumMap<DPFPFingerIndex, String>(DPFPFingerIndex.class);
        fingerNames.put(DPFPFingerIndex.LEFT_PINKY, "Meñique izquierdo");
        fingerNames.put(DPFPFingerIndex.LEFT_RING, "Anillo izquierdo");
        fingerNames.put(DPFPFingerIndex.LEFT_MIDDLE, "Medio izquierdo");
        fingerNames.put(DPFPFingerIndex.LEFT_INDEX, "Índice izquierdo");
        fingerNames.put(DPFPFingerIndex.LEFT_THUMB, "Pulgar izquierdo");
        fingerNames.put(DPFPFingerIndex.RIGHT_PINKY, "Meñique derecho");
        fingerNames.put(DPFPFingerIndex.RIGHT_RING, "Anillo derecho");
        fingerNames.put(DPFPFingerIndex.RIGHT_MIDDLE, "Medio derecho");
        fingerNames.put(DPFPFingerIndex.RIGHT_INDEX, "Índice derecho");
        fingerNames.put(DPFPFingerIndex.RIGHT_THUMB, "Pulgar derecho");
    }

    public DPFPTemplate getTemplate(String activeReader, int nFinger) {

        System.out.printf("Realizar inscripción de huellas digitales...\n");
        JOptionPane.showMessageDialog(null, "Iniciando registro de Nueva Huella");
        DPFPTemplate template = null;

        try {
            DPFPFingerIndex finger = DPFPFingerIndex.values()[nFinger];
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPEnrollment enrollment = DPFPGlobal.getEnrollmentFactory().createEnrollment();

            while (enrollment.getFeaturesNeeded() > 0) {
                //System.out.println("184 Línea");
                DPFPSample sample = getSample(activeReader,
                        String.format("Escanee su dedo %s (%d restante)\n", fingerName(finger), enrollment.getFeaturesNeeded()));
                JOptionPane.showMessageDialog(null, "Coloque su dedo " + fingerName(finger) + "(" + enrollment.getFeaturesNeeded() + " restante)");
                if (sample == null) {
                    continue;
                }

                DPFPFeatureSet featureSet;
                try {
                    featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
                } catch (DPFPImageQualityException e) {
                    //System.out.printf("Mala calidad de imagen: \"%s\".Inténtalo de nuevo. \n", e.getCaptureFeedback().toString());
                    JOptionPane.showMessageDialog(null, "Mala Calidad de la Imagen, Intente de Nuevo");
                    continue;
                }

                enrollment.addFeatures(featureSet);
            }
            template = enrollment.getTemplate();
            //System.out.printf("La huella %s fue registrada.\n", fingerprintName(finger));
            JOptionPane.showMessageDialog(null, "Huella Registrada, pulsa Aceptar y después Actualizar");
        } catch (DPFPImageQualityException e) {
            //System.out.printf("Error al registrar el dedo.\n");
            JOptionPane.showMessageDialog(null, "Error al registrar el dedo");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return template;
    }
    public DPFPTemplate getTemplate2(String activeReader, int nFinger) {

        //System.out.printf("Realizar inscripción de huellas digitales...\n");
        DPFPTemplate template = null;

        try {
            DPFPFingerIndex finger = DPFPFingerIndex.values()[nFinger];
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPEnrollment enrollment = DPFPGlobal.getEnrollmentFactory().createEnrollment();

            while (enrollment.getFeaturesNeeded() > 0) {
                DPFPSample sample = getSample(activeReader,
                        String.format("Escanee su dedo %s (%d restante)\n", fingerName(finger), enrollment.getFeaturesNeeded()));
                if (sample == null) {
                    continue;
                }

                DPFPFeatureSet featureSet;
                try {
                    featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
                } catch (DPFPImageQualityException e) {
                    //System.out.printf("Mala calidad de imagen: \"%s\".Inténtalo de nuevo. \n", e.getCaptureFeedback().toString());
                    continue;
                }
                enrollment.addFeatures(featureSet);
            }
            template = enrollment.getTemplate();
            //System.out.printf("La huella %s fue registrada.\n", fingerprintName(finger));
        } catch (DPFPImageQualityException e) {
            //System.out.printf("Error al registrar el dedo.\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return template;
    }

    public DPFPTemplate getTemplate3(String activeReader, int nFinger) {

        DPFPTemplate template = null;

        try {
            DPFPFingerIndex finger = DPFPFingerIndex.values()[nFinger];
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPEnrollment enrollment = DPFPGlobal.getEnrollmentFactory().createEnrollment();

            DPFPSample sample = getSample(activeReader, String.format("Escanee su dedo %s (%d restante)\n", fingerName(finger), enrollment.getFeaturesNeeded()));
            if (sample == null) {
               // System.out.println("Ver 1");
            }

            DPFPFeatureSet featureSet = null;
            try {
                featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
            } catch (DPFPImageQualityException e) {
                //System.out.printf("Mala calidad de imagen: \"%s\".Inténtalo de nuevo. \n", e.getCaptureFeedback().toString());
                //continue;
            }

            enrollment.addFeatures(featureSet);
            enrollment.addFeatures(featureSet);
            enrollment.addFeatures(featureSet);
            enrollment.addFeatures(featureSet);

            template = enrollment.getTemplate();
            //System.out.printf("La huella %s fue registrada.\n", fingerprintName(finger));
        } catch (DPFPImageQualityException e) {
            //System.out.printf("Error al registrar el dedo.\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return template;
    }

    public boolean verify(String activeReader, DPFPTemplate template) {

        try {
            DPFPSample sample = getSample(activeReader, "Escanea tu dedo\n");
            if (sample == null) {
                throw new Exception();
            }

            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

            DPFPVerification matcher = DPFPGlobal.getVerificationFactory().createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);

            for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {
                if (template != null) {
                    DPFPVerificationResult result = matcher.verify(featureSet, template);
                    if (result.isVerified()) {
                        //System.out.printf("Dedo a juego: %s, FAR achieved: %g.\n",
                        //        fingerName(finger), (double) result.getFalseAcceptRate() / DPFPVerification.PROBABILITY_ONE);
                        return result.isVerified();
                    }
                }
            }
        } catch (Exception e) {
            //System.out.printf("Error al realizar la verificación.");
        }

        return false;
    }
    public void prueba(String activeReader, DPFPTemplate template) throws InterruptedException, Exception{
       DPFPSample sample = getSample(activeReader, "Escanea tu dedo\n");
            if (sample == null) {
                throw new Exception();
            } 
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

            DPFPVerification matcher = DPFPGlobal.getVerificationFactory().createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);
    }
    public boolean verify2(String activeReader, DPFPTemplate template,DPFPSample sample2) {

        try {
            DPFPSample sample = sample2;
            if (sample == null) {
                throw new Exception();
            }

            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
            DPFPVerification matcher = DPFPGlobal.getVerificationFactory().createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);

            for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {
                if (template != null) {
                    DPFPVerificationResult result = matcher.verify(featureSet, template);
                    if (result.isVerified()) {
                        //System.out.printf("Dedo a juego: %s, FAR achieved: %g.\n",
                        //        fingerName(finger), (double) result.getFalseAcceptRate() / DPFPVerification.PROBABILITY_ONE);
                        return result.isVerified();
                    }
                }
            }
        } catch (Exception e) {
            //System.out.printf("Error al realizar la verificación.");
        }

        return false;
    }
    public DPFPCapture capture;
    public String stateSensor="";
    public DPFPSample getSample(String activeReader, String prompt)
            throws InterruptedException {
        
        final LinkedBlockingQueue<DPFPSample> samples = new LinkedBlockingQueue<DPFPSample>();
        capture = DPFPGlobal.getCaptureFactory().createCapture();
        capture.setReaderSerialNumber(activeReader);
        capture.setPriority(DPFPCapturePriority.CAPTURE_PRIORITY_LOW);
        capture.addDataListener(new DPFPDataListener() {
            public void dataAcquired(DPFPDataEvent e) {
                if (e != null && e.getSample() != null) {
                    try {
                        samples.put(e.getSample());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            int lastStatus = DPFPReaderStatusEvent.READER_CONNECTED;

            public void readerConnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    //System.out.println("El lector está conectado");
                    stateSensor="El lector está conectado";
                }
                lastStatus = e.getReaderStatus();
            }

            public void readerDisconnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    //System.out.println("El lector está desconectado.");
                    stateSensor="El lector está desconectado";
                    
                }
                lastStatus = e.getReaderStatus();
            }

        });
        try {
            try{
            capture.startCapture();
            //System.out.print(prompt);
            return samples.take();
            }catch(Exception x){
                //System.out.println("Me vale");
            }
        } catch (RuntimeException e) {
            //System.out.printf("No se pudo iniciar la captura. Verifique que el lector no sea utilizado por otra aplicación.\n");
            stateSensor="No se pudo iniciar la captura. Verifique que el lector no sea utilizado por otra aplicación.";
            throw e;
        } finally {
            capture.stopCapture();
        }
        return null;
    }

    public String fingerName(DPFPFingerIndex finger) {
        return fingerNames.get(finger);
    }

    public String fingerprintName(DPFPFingerIndex finger) {
        return fingerNames.get(finger) + " fingerprint";
    }

    public String get(int idHuella) {
        String referenceTemplate = null;
        ResultSet rs;
        PreparedStatement st;
        try {
            st = cn().prepareStatement("SELECT * FROM huella where idHuella="+idHuella);
            rs = st.executeQuery();
            int i = 0;
            if (rs.next()) {
                referenceTemplate = rs.getString("descripcionDedo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return referenceTemplate;
    }
    

    public DPFPSample getSample(String activeReader, String prompt, JLabel lbl_stateSensor) {
        final LinkedBlockingQueue<DPFPSample> samples = new LinkedBlockingQueue<DPFPSample>();
        capture = DPFPGlobal.getCaptureFactory().createCapture();
        capture.setReaderSerialNumber(activeReader);
        capture.setPriority(DPFPCapturePriority.CAPTURE_PRIORITY_LOW);
        capture.addDataListener(new DPFPDataListener() {
            public void dataAcquired(DPFPDataEvent e) {
                if (e != null && e.getSample() != null) {
                    try {
                        samples.put(e.getSample());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            int lastStatus = DPFPReaderStatusEvent.READER_CONNECTED;

            public void readerConnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    //System.out.println("El lector está conectado");
                    stateSensor="El lector está conectado";
                    lbl_stateSensor.setText(stateSensor);
                    lbl_stateSensor.setIcon(new ImageIcon("src/img/check/exito.png"));
                }
                lastStatus = e.getReaderStatus();
            }

            public void readerDisconnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    //System.out.println("El lector está desconectado.");
                    stateSensor="El lector está desconectado";
                    lbl_stateSensor.setText(stateSensor);
                    lbl_stateSensor.setIcon(new ImageIcon("src/img/x/error (2).png"));
                }
                lastStatus = e.getReaderStatus();
            }

        });
        try {
            try{
            capture.startCapture();
            System.out.print(prompt);
            return samples.take();
            }catch(Exception x){
                System.out.println("Me vale");
            }
        } catch (RuntimeException e) {
            //System.out.printf("No se pudo iniciar la captura. Verifique que el lector no sea utilizado por otra aplicación.\n");
            stateSensor="No se pudo iniciar la captura. Verifique que el lector no sea utilizado por otra aplicación";
            lbl_stateSensor.setText(stateSensor);
            lbl_stateSensor.setIcon(new ImageIcon("src/img/x/error (2).png"));
            throw e;
        } finally {
            capture.stopCapture();
        }
        return null;
    }

    public void Delete(int val) {
        PreparedStatement st;
        String sql = "DELETE FROM huella WHERE idHuella ="+val;
        try {
            st = cn().prepareStatement(sql);
            st.executeUpdate();
            //System.out.println("Eliminación exitosa");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }
    /*
    public void DeleteExperimento(String idListaExperimentos) throws SQLException{
        String sql = "DELETE FROM ListaExperimentosTemporal WHERE idListaExperimentosTemporal=?";
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
    */

    public void Update(String cad, int id) {
        PreparedStatement st;
        String sql = "UPDATE huella SET descripcionDedo='"+cad+"' WHERE idHuella ="+id;
        try {
            st = cn().prepareStatement(sql);
            st.executeUpdate();
            //System.out.println("Actualización exitosa");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    
}
