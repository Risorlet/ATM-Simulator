package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TransactionInterface extends JFrame{
    
    //Image icon for the frame
    String frameIconPath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\bank.png";
    ImageIcon frameIcon = new ImageIcon(frameIconPath);

    // Setting up the background Image
    String bgImagePath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\atm.jpg";
    ImageIcon ATM_Lagrge = new ImageIcon(bgImagePath);
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

        // Home screen Buttons Panel
        JPanel buttonsPanel = new JPanel(null);
        buttonsPanel.setBounds(115,348,272,118);
        buttonsPanel.setOpaque(false);

        // Deposit panel
        JLabel depositLabel = new JLabel("Enter the Amount you wish to Deposit:");
        depositLabel.setForeground(Color.BLACK);
        depositLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField depositAmountField = new JTextField();
        depositAmountField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel depositPanel = new JPanel();
        depositPanel.setBackground(Color.WHITE);
        depositPanel.setBounds(115,240,272,220);
        depositPanel.setVisible(false);

        depositPanel.add(depositLabel);

        background.add(depositPanel);

        // Withdrawal Panel

        // Fast-Cash Panel

        // PIN change Panel
            // Main Heading
        JLabel enterYourPINLabel = new JLabel("Enter your new PIN:");
        enterYourPINLabel.setForeground(Color.WHITE);
        enterYourPINLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

        JPanel enterNewPINPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        enterNewPINPanel.add(enterYourPINLabel);
        enterNewPINPanel.setBounds(0,35,272,80);
        enterNewPINPanel.setOpaque(false);

            // TextField to type your new PIN
        JTextField PIN_Field = new JTextField(15);
        PIN_Field.setFont(new Font("Helvetica", Font.BOLD, 15));
        PIN_Field.setHorizontalAlignment(JTextField.CENTER);
        PIN_Field.setDocument(new LengthRestrictedDocument(4)); //limits the input to 4 charecters

        enterNewPINPanel.add(PIN_Field);
        
            // Main panel to hold everything
        JPanel changePINPanel = new JPanel(null);
        changePINPanel.setOpaque(false);
        changePINPanel.setBounds(115,240,272,220);
        changePINPanel.setVisible(false);

            // Setting up the button to go back from this frame
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        cancelButton.setBounds(2,168,120,25);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.setFocusable(false);

            // Settting up the button to update the PIN of the user
        JButton changePINButton = new JButton("CHANGE PIN");
        changePINButton.setForeground(Color.BLACK);
        changePINButton.setBackground(Color.WHITE);
        changePINButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        changePINButton.setBounds(150,168,120,25);
        changePINButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePINButton.setFocusable(false);

            // Adding components to the main panel
        changePINPanel.add(enterNewPINPanel);
        changePINPanel.add(cancelButton);
        changePINPanel.add(changePINButton);

            // Adding button functionality
        cancelButton.addActionListener(ae -> {
            changePINPanel.setVisible(false);
            heading.setVisible(true);
            buttonsPanel.setVisible(true);

        });

        changePINButton.addActionListener(ae -> {

            String newPIN = PIN_Field.getText();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String updatePINQuery = "update login set PIN = '" + newPIN + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updatePINQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Your PIN has been changed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                changePINPanel.setVisible(false);
                heading.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        });

            // Adding the main panel to the background (Main Frame)
        background.add(changePINPanel);

        // Balance Enquiry Panel
            // Main Heading
        JLabel balanceLabel = new JLabel("Your Account Balance:");
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

        JPanel balanceLabelPanel = new JPanel();
        balanceLabelPanel.add(balanceLabel);
        balanceLabelPanel.setBounds(0,35,272,25);
        balanceLabelPanel.setOpaque(false);
        
            // Main panel to hold everything
        JPanel balanceEnquiryPanel = new JPanel(null);
        balanceEnquiryPanel.setOpaque(false);
        balanceEnquiryPanel.setBounds(115,240,272,220);
        balanceEnquiryPanel.setVisible(false);

            // Setting up the button to go back from this frame
        JButton backButton = new JButton("BACK");
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.WHITE);
        backButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        backButton.setBounds(0,168,120,25);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusable(false);

            // Adding components to the main panel
        balanceEnquiryPanel.add(balanceLabelPanel);
        balanceEnquiryPanel.add(backButton);

            // Adding button functionality
        backButton.addActionListener(ae -> {
            balanceEnquiryPanel.setVisible(false);
            heading.setVisible(true);
            buttonsPanel.setVisible(true);

        });

            // Adding the main panel to the background (Main Frame)
        background.add(balanceEnquiryPanel);

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


            heading.setVisible(false);
            buttonsPanel.setVisible(false);
            changePINPanel.setVisible(true);
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
            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select balance from account_balance where form_number = '" + formNumber + "'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String balance = result.getString("balance");
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JLabel currentBalanceLabel = new JLabel(balance);
                currentBalanceLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
                currentBalanceLabel.setForeground(Color.WHITE);

                JPanel balancePanel = new JPanel();
                balancePanel.setBounds(0,75,272,25);
                balancePanel.add(currentBalanceLabel);
                balancePanel.setOpaque(false);

                balanceEnquiryPanel.add(balancePanel);

                heading.setVisible(false);
                buttonsPanel.setVisible(false);
                balanceEnquiryPanel.setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
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
