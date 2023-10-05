package com.company;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.activation.*;
import java.util.Scanner;

public class Email implements Serializable {
    private Recipient toWhome;
    private String Content;
    private String Subject;
    private LocalDate Date;

    public String getReceiversName() {
        return toWhome.getName();
    }

    public String getTheReceiversEmailAddress(){
        return toWhome.getName();
    }

    public String getContent() {
        return Content;
    }

    public String getSubject() {
        return Subject;
    }
    public LocalDate getDate(){
        return Date;
    }
    public Recipient getToWhome(){
        return toWhome;
    }


    public Email(Recipient toWhome, String content, String subject) {
        this.toWhome = toWhome;
        this.Content = content;
        this.Subject = subject;
        LocalDate thisdate = LocalDate.now();
        this.Date = thisdate;

        //setting the addressing of the email for different recipient types
        if (toWhome instanceof Personal) {
            //if sending emails to a personal
            String NickName = ((Personal) toWhome).getNickName();
            LocalDate Birthday = ((Personal) toWhome).getBirthday();
            // modifying the content of the email
            if (this.Subject.equals( "Birthday Wish")){
                this.Content =   " Happy Birthday for turning " + String.valueOf(LocalDate.now().getYear()-Birthday.getYear()) +" years, "+ this.Content;
            }
            this.Content =  NickName + ",\n" + this.Content;
        }
        else if (toWhome instanceof Official_Friend) {
            LocalDate Birthday = ((Official_Friend) toWhome).getBirthday();
            String Designation = ((Official_Friend) toWhome).getDesignation();
            //modifying the content
            if (this.Subject.equals( "Birthday Wish")){
                this.Content =   " Happy Birthday for turning " + String.valueOf(LocalDate.now().getYear()-Birthday.getYear()) +" years and "+ this.Content;
            }
            this.Content = "Mr/Mrs/Miss " + toWhome.getName() + ",\n" + Designation + ".\n" + this.Content;

        }
        else if (toWhome instanceof Official) {
            String Designation = ((Official) toWhome).getDesignation();
            // modifying the content
            this.Content = "Mr/Mrs/Miss " + toWhome.getName() + ",\n" + Designation + ".\n" + this.Content;

        }

    }


    public void send() {
        // senders details

        String username = "kkajskumarasinghe@gmail.com";
        String password = "ohrisgkqwlshpwpf";
        //getting receivers details
        String receiverName = toWhome.getName();
        String receiverEmail = toWhome.getEmail();

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail)
            );
            message.setSubject(Subject);
            message.setText(Content);

            Transport.send(message);

            //System.out.println("Massage sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
