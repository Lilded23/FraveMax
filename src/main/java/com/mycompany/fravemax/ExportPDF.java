package com.mycompany.fravemax;

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
import javax.swing.JTable;

public class ExportPDF {

    public static void exportToPDF(String nombre, String apellido, int dni, String telefono, String domicilio, String total, JTable tabla, String nombreArchivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Agregar los datos del cliente al PDF
            document.add(new Paragraph("Fravemax Empresa lider en Electrodomesticos"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Ticket de compra"));
            document.add(new Paragraph("                 - - - - - - - - - - - - - - - - - - - - - - - Datos del Cliente - - - - - - - - - - - - - - - - - - - - - - - "));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Nombre: " + nombre));
            document.add(new Paragraph("Apellido: " + apellido));
            document.add(new Paragraph("DNI: " + dni));
            document.add(new Paragraph("Teléfono: " + telefono));
            document.add(new Paragraph("Domicilio: " + domicilio));
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
            abrirPDF(nombreArchivo);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private static void abrirPDF(String nombreArchivo) {
        try {
            File archivoPDF = new File(nombreArchivo);
            if (archivoPDF.exists()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                System.out.println("El archivo PDF no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}