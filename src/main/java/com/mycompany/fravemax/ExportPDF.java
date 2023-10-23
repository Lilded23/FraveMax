package com.mycompany.fravemax;

import Entidades.Venta;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class ExportPDF {

    public static void exportToPDF(JTable tabla, String nombreArchivo, Venta venta, String total) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Agregar los datos del cliente al PDF
            document.add(new Paragraph("                                                Fravemax Empresa lider en Electrodomesticos"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("                 Ticket de compra "));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("                 Numero de venta: " + venta.getIdVenta()));
            document.add(new Paragraph("                 Fecha de venta: " + venta.getFechaVenta()));
            document.add(new Paragraph("                 - - - - - - - - - - - - - - - - - - - - - - - Datos del Cliente - - - - - - - - - - - - - - - - - - - - - - - "));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("                 Nombre: " + venta.getCliente().getNombre()));
            document.add(new Paragraph("                 Apellido: " + venta.getCliente().getApellido()));
            document.add(new Paragraph("                 DNI: " + venta.getCliente().getDni()));
            document.add(new Paragraph("                 Teléfono: " + venta.getCliente().getTelefono()));
            document.add(new Paragraph("                 Domicilio: " + venta.getCliente().getDomiciio()));
            document.add(new Paragraph("\n"));

            // Agregar los datos de la tabla al PDF
            document.add(new Paragraph("                - - - - - - - - - - - - - - - - - - - - - - - Datos Productos - - - - - - - - - - - - - - - - - - - - - - - "));
            document.add(new Paragraph("\n"));
            PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Paragraph(tabla.getColumnName(i))));
            }
            for (int row = 0; row < tabla.getRowCount(); row++) {
                for (int column = 0; column < tabla.getColumnCount(); column++) {
                    pdfTable.addCell(new PdfPCell(new Paragraph(tabla.getValueAt(row, column).toString())));
                }
            }
            document.add(pdfTable);
            document.add(new Paragraph("                                                                                                            TOTAL : $" + total));         
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void abrirPDF(String nombreArchivo) {
        File archivoPDF = new File(nombreArchivo);
        if (archivoPDF.exists()) {
            SwingUtilities.invokeLater(() -> {
                try {
                    Desktop.getDesktop().open(archivoPDF);
                } catch (IOException ex) {
                    Logger.getLogger(ExportPDF.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } else {
            System.out.println("El archivo PDF no existe.");
        }
    }
}
