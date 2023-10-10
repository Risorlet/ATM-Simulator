package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TransactionInterface extends JFrame{
    
    //Image icon for the frame
    ImageIcon frameIcon = new ImageIcon("F:\\Argha\\Projects\\Java\\ATM Simulator\\app\\src\\main\\resources\\images\\bank.png");

    // Setting up the background Image
    ImageIcon ATM_Lagrge = new ImageIcon("F:\\Argha\\Projects\\Java\\ATM Simulator\\app\\src\\main\\resources\\images\\atm.jpg");
    Image img = ATM_Lagrge.getImage();
    ImageIcon backgroundImage = new ImageIcon(img.getScaledInstance(672, 700, Image.SCALE_DEFAULT));

    String name;

    TransactionInterface(String formNumber){

        //setting up the frame title and icon
        setTitle("Welcome to ATM");
        setLocation(370, 10);
        setIconImage(frameIcon.getImage());
        setLayout(null);

        // Adding the background Image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0,0,672,700);
        add(background);

        // Fetching the name of the user who logged in
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            String query = "select * from users where form_number = '" + formNumber + "'";

            ResultSet result = dbConnection.st.executeQuery(query);
            result.next();
            String fName = result.getString("first_name");
            String lName = result.getString("last_name");

            name = fName + " " + lName;
            
            dbConnection.st.close();
            dbConnection.conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Adding the heading text
        JLabel heading = new JLabel("WELCOME, " + name.toUpperCase());
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel headingPanel = new JPanel();
        headingPanel.add(heading);
        headingPanel.setOpaque(false);
        headingPanel.setBounds(115,270,272,25);
        background.add(headingPanel);

        // Setting up the transaction Buttons
        JButton depositButton = new JButton("Deposit".toUpperCase());
        depositButton.setForeground(Color.BLACK);
        depositButton.setBackground(Color.WHITE);
        depositButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        depositButton.setBounds(0,0,120,25);
        depositButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositButton.setFocusable(false);
        depositButton.addActionListener(ae -> {

        });

        JButton fastCashButton = new JButton("Fast Cash".toUpperCase());
        fastCashButton.setForeground(Color.BLACK);
        fastCashButton.setBackground(Color.WHITE);
        fastCashButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        fastCashButton.setBounds(0,29,120,25);
        fastCashButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCashButton.setFocusable(false);
        fastCashButton.addActionListener(ae -> {

        });

        JButton pinChangeButton = new JButton("Change PIN".toUpperCase());
        pinChangeButton.setForeground(Color.BLACK);
        pinChangeButton.setBackground(Color.WHITE);
        pinChangeButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        pinChangeButton.setBounds(0,59,120,25);
        pinChangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pinChangeButton.setFocusable(false);
        pinChangeButton.addActionListener(ae -> {

        });

        JButton withdrawlButton = new JButton("withdrawal".toUpperCase());
        withdrawlButton.setForeground(Color.BLACK);
        withdrawlButton.setBackground(Color.WHITE);
        withdrawlButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        withdrawlButton.setBounds(152,0,120,25);
        withdrawlButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawlButton.setFocusable(false);
        withdrawlButton.addActionListener(ae -> {

        });

        JButton miniStatementButton = new JButton("Mini Statement".toUpperCase());
        miniStatementButton.setForeground(Color.BLACK);
        miniStatementButton.setBackground(Color.WHITE);
        miniStatementButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        miniStatementButton.setBounds(152,29,120,25);
        miniStatementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miniStatementButton.setFocusable(false);
        miniStatementButton.addActionListener(ae -> {

        });

        JButton balanceEnquiryButton = new JButton("Balance Enquiry".toUpperCase());
        balanceEnquiryButton.setForeground(Color.BLACK);
        balanceEnquiryButton.setBackground(Color.WHITE);
        balanceEnquiryButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        balanceEnquiryButton.setBounds(152,59,120,25);
        balanceEnquiryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        balanceEnquiryButton.setFocusable(false);
        balanceEnquiryButton.addActionListener(ae -> {

        });

        JButton exitButton = new JButton("Exit".toUpperCase());
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.WHITE);
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        exitButton.setBounds(152,89,120,25);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setFocusable(false);
        exitButton.addActionListener(ae -> {
            System.exit(0);
        });

        JPanel buttonsPanel = new JPanel(null);
        buttonsPanel.setBounds(115,348,272,118);
        buttonsPanel.setOpaque(false);

        buttonsPanel.add(depositButton);
        buttonsPanel.add(fastCashButton);
        buttonsPanel.add(pinChangeButton);
        buttonsPanel.add(withdrawlButton);
        buttonsPanel.add(miniStatementButton);
        buttonsPanel.add(balanceEnquiryButton);
        buttonsPanel.add(exitButton);

        background.add(buttonsPanel);


        //setting up the size of the frame and making it visible
        setSize(672, 700);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
