package baihoc.minimart.ui;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NGUYEN HUU
 */
public class MailSender {
    public static void sendOtpToUser(String toEmail, String otpCode) {
        final String fromEmail = "your_email@gmail.com"; // Thay bằng email của bạn
        final String password = "your_app_password";     // App password từ Gmail

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true"); 

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Minimart"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Mã xác thực OTP - Minimart");
            message.setText("Xin chào,\n\nMã OTP của bạn là: " + otpCode +
                    "\nMã có hiệu lực trong 5 phút.\n\nTrân trọng,\nMinimart");

            Transport.send(message);
            System.out.println("✅ Đã gửi OTP đến " + toEmail);

        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println("❌ Lỗi gửi email: " + e.getMessage());
        }
    }
}
