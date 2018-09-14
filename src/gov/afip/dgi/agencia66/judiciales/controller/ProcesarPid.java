package gov.afip.dgi.agencia66.judiciales.controller;

import com.itextpdf.text.BaseColor;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesarPid {

    private static String src = null;

    private static boolean cambioBoleta(String boleta, String boletaAnt) {
        String _boletaNueva = boleta.substring(4,9);
        String _boletaAnt = boletaAnt;

        if(boletaAnt != null) { _boletaAnt = boletaAnt.substring(4,9); }
        
        if(_boletaNueva.equalsIgnoreCase(_boletaAnt)) {
            return false;
        } else {
            return true;
        }
        
    }
    
    private String pathFile = null;
    
    private File estadisticas;

    static private File iturralde;
    static  private File endelli;
    static private File valverde;
    
    static private  Document docEst = new Document();
    static private  Document docVal = new Document();
    static private  Document docEnd = new Document();
    static private  Document docItu = new Document();
    
    static private  FileOutputStream fosEst = null;
    static private  FileOutputStream fosVal = null;
    static private  FileOutputStream fosEnd = null;
    static private  FileOutputStream fosItu = null;

    static private  PdfCopy copiaValverde = null;
    static private  PdfCopy copiaEndelli = null;
    static private  PdfCopy copiaIturralde = null;
    
    private PdfReader pdr;
    
    private static int boletasVal = 0;
    private static int boletasEnd = 0;
    private static int boletasItu = 0;
    
    private  static String boletaNumero = null;
    private  static String boletaAntVal = null;
    private  static String boletaAntEnd = null;
    private  static String boletaAntItu = null;
    
    private String _pid = null;
    
    
    public ProcesarPid(String pid, String archivo) throws FileNotFoundException, DocumentException, IOException {
        System.out.println("En procesar");
        abrirArchivoEntrada(archivo);
        _pid = pid;
        crearArchivosSalida(_pid);
        
    }
    
    public int procesar() throws IOException, Exception {
        
        int page;
        String pagina = null;
        
        Pattern nroBoleta = Pattern.compile("\\b" + Pattern.quote("BOLETA DE DEUDA NRO. 066") + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher match;
        
        escribirEstadistica(true, "Resultado del proceso de separacion de BD de pid: " +_pid +"\n\n");
                
        
        for(page=1; page <= pdr.getNumberOfPages(); page++) {
            pagina = PdfTextExtractor.getTextFromPage(pdr, page);
            match = nroBoleta.matcher(pagina);    
            
            if(match.find()) { boletaNumero = pagina.substring(match.start()+21,39 ); }
                    
                switch(obtieneAbogado(pagina)) {
                    case "Valverde":
                        procesaValverde(pdr, page, boletaNumero);
                        break;
                    case "Iturralde":
                        procesaIturralde(pdr, page, boletaNumero);
                        break;
                    case "Endelli":
                        procesaEndelli(pdr, page, boletaNumero);
                        break;
                }
        }
        resumenEstadistica();
        return 1;
    }

    private void abrirArchivoEntrada(String archivo) throws FileNotFoundException, IOException {
        System.out.println("En abrir"); 
        src = archivo;
        
        /* Uso esto para poder separar cada carpeta del Path y luego
           formar el path para los archivo de salida y que esten en 
           la misma carpeta que el de entrada
        */
        String[] path = archivo.split("\\\\");
        
        
        /* Le resto 1 al largo del arreglo porque el ultimo miembro
           ese el nombre del archivo que estoy leyendo y solo quiero
           el path
        */
        for(int j=0; path.length-1 > j; j++) {
            if(j==0) {
                pathFile = path[j];
            } else {
                pathFile = pathFile+"\\"+path[j];
            }
        }
        System.out.println("El path quedo: " +pathFile);
        
        pdr = new PdfReader(src);
        
    }

    private void crearArchivosSalida(String pid) throws FileNotFoundException, DocumentException {
        estadisticas = new File(pathFile+"\\Estadisticas_PID_"+pid+".pdf");
        iturralde = new File(pathFile+"\\Iturralde_PID_"+pid+".pdf");
        endelli = new File(pathFile+"\\Endelli_Pid_"+pid+".pdf");
        valverde = new File(pathFile+"\\Valverde_Pid_"+pid+".pdf");
        
        fosEst =  new FileOutputStream(estadisticas);
        
        fosVal = new FileOutputStream(valverde);
        fosEnd = new FileOutputStream(endelli);
        fosItu = new FileOutputStream(iturralde);
        
        PdfWriter.getInstance(docEst, fosEst).setInitialLeading(20);
        docEst.open();
        
        copiaEndelli = new PdfCopy(docEnd, fosEnd);
        docEnd.open();
        
        copiaIturralde = new PdfCopy(docItu, fosItu);
        docItu.open();
        
        copiaValverde = new PdfCopy(docVal, fosVal);
        docVal.open();
    }
    
    private static String obtieneAbogado(String pagina) throws Exception {
        /** El codigo mas feo del mundo */
        
        Pattern iturralde = Pattern.compile("\\b" + Pattern.quote("ITURRALDE JUAN JOSE") + "\\b", Pattern.CASE_INSENSITIVE);
        Pattern endelli = Pattern.compile("\\b" + Pattern.quote("ENDELLI LILIANA BEATRIZ") + "\\b", Pattern.CASE_INSENSITIVE);
        Pattern valverde = Pattern.compile("\\b" + Pattern.quote("VALVERDE SANDRA INES") + "\\b", Pattern.CASE_INSENSITIVE);
        
        Matcher match;
        String boga = null;
        boolean encontro = false;
        
        match = iturralde.matcher(pagina);
        if(match.find()) {
            boga = "Iturralde";
            encontro = true;
        } 
        
        if(!encontro) {
            match = endelli.matcher(pagina);
            if(match.find()) {
                boga = "Endelli";
                encontro = true;
            }
        }
        
        if(!encontro) {
            match = valverde.matcher(pagina);
            if(match.find()) {
                boga = "Valverde";
                encontro = true;
            }
        }
        
        if(!encontro) {
            throw new Exception("No se encontraron abogados en una boleta");
        }
        
        return boga;
    }
    
     private static void procesaEndelli(PdfReader pagina, int page, String boleta) throws DocumentException, IOException {
        //System.out.println("Procesando Endelli");
        if(cambioBoleta(boleta, boletaAntEnd)) {
            boletasEnd++;
            boletaAntEnd = boleta;
        }
        copiaEndelli.addPage(copiaEndelli.getImportedPage(pagina, page));
    }
     
    private static void procesaValverde(PdfReader pagina, int page, String boleta) throws DocumentException, IOException {
        //System.out.println("Procesando Valverde");
       if(cambioBoleta(boleta, boletaAntVal)) {
           boletasVal++;
           boletaAntVal = boleta;
       }
       copiaValverde.addPage(copiaValverde.getImportedPage(pagina, page));
    }
     
    private static void procesaIturralde(PdfReader pagina, int page, String boleta) throws DocumentException, IOException {
        //System.out.println("Procesando Iturralde");
       if(cambioBoleta(boleta, boletaAntItu)) {
           boletasItu++;
           boletaAntItu = boleta;
       }
       copiaIturralde.addPage(copiaIturralde.getImportedPage(pagina, page));
    }
    
    private static void escribirEstadistica(boolean inicia, String texto) throws FileNotFoundException, DocumentException {
        
        if(inicia) {
            docEst.add(new Paragraph("\n"+texto, FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLACK)));
        } else {
            docEst.add(new Paragraph("\n"+texto, FontFactory.getFont("courier",14,Font.PLAIN,BaseColor.BLACK)));
        }
    
    }
    
    private static void resumenEstadistica() throws FileNotFoundException, DocumentException, IOException {
        
        int total = boletasEnd+boletasItu+boletasVal;
        escribirEstadistica(false, "\n Se totalizaron la cantidad de " +total +" boletas \n\n");
        escribirEstadistica(false, "Desagregado de las hojas según abogados \n\n");

        if(boletasEnd > 0) {
            escribirEstadistica(false, "Se generaron " +boletasEnd +" boletas para Liliana Endelli en archivo: " +endelli);
            copiaEndelli.flush(); copiaEndelli.close();
            fosEnd.flush(); fosEnd.close();
            docEnd.close();
        }
        
        if(boletasItu >0 ) {
            escribirEstadistica(false, "Se generaron " +boletasItu +" boletas para Juan José Iturralde en archivo: " +iturralde);
            copiaIturralde.flush(); copiaIturralde.close();
            fosItu.flush(); fosItu.close();
            docItu.close();
        }
        
        if(boletasVal > 0) {
            escribirEstadistica(false, "Se generaron " +boletasVal +" boletas para Sandra Valverde en archivo:" +valverde);
            copiaValverde.flush(); copiaValverde.close();
            fosVal.flush(); fosVal.close();
            docVal.close();
        }
        docEst.close();
    }
}
