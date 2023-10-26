package com.mycompany.fravemax;

import Entidades.Venta;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Angel
 */
public class EnviarTicket {

    private static String emailFrom = "fravemax@gmail.com";
    private static String passwordFrom = "axyz moso voau imrx";

    private static Session mSession;
    private static MimeMessage mCorreo;

 /**
 * Crea un correo electrónico con un ticket adjunto y lo configura con los datos proporcionados.
 *
 * @param correoCliente    Correo del cliente al que se enviará el correo.
 * @param ticket           Archivo que se adjuntará al correo.
 * @param nombreArchivo    Nombre del archivo adjunto.
 * @param venta            Detalles de la venta asociada al ticket.
 */
    public static void crearEmail(String correoCliente, File ticket, String nombreArchivo, Venta venta) {
        String asunto = "Ticket de compra FraveMax";
        String contenido = "Estimado/a  " + venta.getCliente().getNombre() + " " + venta.getCliente().getApellido()
                + ". Le enviamos por este medio el ticket de su compra. Esperamos que vuelva pronto. Atte FraveMax";

        Properties mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            MimeMultipart mElementosCorreo = new MimeMultipart();

            // Contenido del correo
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(contenido, "text/html; charset=utf-8");
            mElementosCorreo.addBodyPart(mContenido);

            // Agregar archivos adjuntos.
            MimeBodyPart mAdjuntos = new MimeBodyPart();
            mAdjuntos.setDataHandler(new DataHandler(new FileDataSource(ticket)));
            mAdjuntos.setFileName(ticket.getName());
            mElementosCorreo.addBodyPart(mAdjuntos);

            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correoCliente));
            mCorreo.setSubject(asunto);
            mCorreo.setContent(mElementosCorreo);

        } catch (MessagingException ex) {
            System.out.println("Error en la creacion del email");
        }
    }

/**
 * Envía el correo electrónico previamente configurado.
 *
 * @return `true` si el correo se envía correctamente, `false` en caso de error.
 */
    public static boolean sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
            return true;
        } catch (NoSuchProviderException ex) {
            System.out.println("3" + ex);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Error! correo incorrecto \n" + ex);
            return false;
        }
        return false;

    }
}
