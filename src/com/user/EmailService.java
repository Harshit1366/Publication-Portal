/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    public static void mailNewLogin(String to, String text, String id, String pass) {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "***************"); // User name
        properties.put("mail.smtp.password", "**************"); // password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("**************", "****************"); // Email, password
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("***************"));// Email
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to) ); 
            message.setSubject("NCU: Internship Facility");
            message.setText(text+id+" "+pass);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sendMessage(String to, String text, String tfrom, String subject) {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "**************"); // User name
        properties.put("mail.smtp.password", "***************"); // password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("*************", "***********"); // Email, password
            }
        });
        try {
            System.out.println(text);
            System.out.println(subject);
            System.out.println(tfrom);
            System.out.println(to);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("******************")); // Email from
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to) ); 
            message.setSubject("NCU : PUBLICATION FACILITY "+subject);
            message.setText("Mail Sent By : "+tfrom+".\n"+text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
}
