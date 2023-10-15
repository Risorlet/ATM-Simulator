package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class TransactionInterface extends JFrame{
    
    //Image icon for the frame
    String frameIconPath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\bank.png";
    ImageIcon frameIcon = new ImageIcon(frameIconPath);

    // Setting up the background Image
    String bgImagePath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\atm.jpg";
    ImageIcon ATM_Lagrge = new ImageIcon(bgImagePath);
    Image img = ATM_Lagrge.getImage();
    ImageIcon backgroundImage = new ImageIcon(img.getScaledInstance(672, 700, Image.SCALE_DEFAULT));

    String name = "xxxx";
    String cardNumber = "xxxxxxxxxxxxxxxx";

    TransactionInterface(String formNumber){

        //setting up the frame title and icon
        setTitle("Welcome to ATM");
        setLocation(370, 12);
        setIconImage(frameIcon.getImage());
        setLayout(null);

        // Adding the background Image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0,0,672,700);
        add(background);

        // Fetching the name and card number of the user who logged in
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            String query = "select * from users where form_number = '" + formNumber + "'";
            String getCardQuery = "select * from login where form_number = '" + formNumber + "'";

            ResultSet userResult = dbConnection.st.executeQuery(query);

            userResult.next();
            String fName = userResult.getString("first_name");
            String lName = userResult.getString("last_name");
            name = fName + " " + lName;

            ResultSet loginResult = dbConnection.st.executeQuery(getCardQuery); 
            loginResult.next();
            cardNumber = loginResult.getString("card_number");
            
            dbConnection.st.close();
            dbConnection.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
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
            // The heading label for this panel
        JLabel depositLabel = new JLabel("Enter the Amount you wish to deposit:");
        depositLabel.setForeground(Color.WHITE);
        depositLabel.setFont(new Font("Helvetica", Font.BOLD, 12));

        JPanel depositHeadingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        depositHeadingPanel.setBounds(0,35,272,80);
        depositHeadingPanel.setOpaque(false);

            // The textField where the amoint will be entered
        JTextField depositAmountField = new JTextField(15);
        depositAmountField.setFont(new Font("Helvetica", Font.BOLD, 15));
        depositAmountField.setHorizontalAlignment(JTextField.CENTER);

            // Adding the heading and text field to their panel
        depositHeadingPanel.add(depositLabel);
        depositHeadingPanel.add(depositAmountField);

            // The main panel to hold everything
        JPanel depositPanel = new JPanel(null);
        depositPanel.setOpaque(false);
        depositPanel.setBounds(115,240,272,220);
        depositPanel.setVisible(false);

            // Setting up the button to go back from this frame
        JButton depositCancelButton = new JButton("CANCEL");
        depositCancelButton.setForeground(Color.BLACK);
        depositCancelButton.setBackground(Color.WHITE);
        depositCancelButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        depositCancelButton.setBounds(2,168,120,25);
        depositCancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositCancelButton.setFocusable(false);
        depositCancelButton.addActionListener(ae -> {
            depositPanel.setVisible(false);
            depositAmountField.setText("");
            headingPanel.setVisible(true);
            buttonsPanel.setVisible(true);

        });

            // Settting up the button to update the PIN of the user
        JButton depositAmountButton = new JButton("DEPOSIT");
        depositAmountButton.setForeground(Color.BLACK);
        depositAmountButton.setBackground(Color.WHITE);
        depositAmountButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        depositAmountButton.setBounds(150,168,120,25);
        depositAmountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositAmountButton.setFocusable(false);
        depositAmountButton.addActionListener(ae -> {

            String depositAmount = depositAmountField.getText();
            Date currentDate = new Date();
            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                Integer newBalanceValue = Integer.parseInt(oldBalance) + Integer.parseInt(depositAmount);

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "deposit" + "','" + depositAmount + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount "+depositAmount+" has been deposited successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                depositPanel.setVisible(false);
                depositAmountField.setText("");
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

            // Adding components to the main panel
        depositPanel.add(depositHeadingPanel);
        depositPanel.add(depositCancelButton);
        depositPanel.add(depositAmountButton);

            // Adding the main panel to the background (Main Frame)
        background.add(depositPanel);

        // Withdrawal Panel
            // The heading label for this panel
        JLabel withdrawalLabel = new JLabel("Enter the Amount you wish to withdraw:");
        withdrawalLabel.setForeground(Color.WHITE);
        withdrawalLabel.setFont(new Font("Helvetica", Font.BOLD, 12));

        JPanel withdrawalHeadingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        withdrawalHeadingPanel.setBounds(0,35,272,80);
        withdrawalHeadingPanel.setOpaque(false);

            // The textField where the amoint will be entered
        JTextField withdrawalAmountField = new JTextField(15);
        withdrawalAmountField.setFont(new Font("Helvetica", Font.BOLD, 15));
        withdrawalAmountField.setHorizontalAlignment(JTextField.CENTER);

            // Adding the heading and text field to their panel
        withdrawalHeadingPanel.add(withdrawalLabel);
        withdrawalHeadingPanel.add(withdrawalAmountField);

            // The main panel to hold everything
        JPanel withdrawalPanel = new JPanel(null);
        withdrawalPanel.setOpaque(false);
        withdrawalPanel.setBounds(115,240,272,220);
        withdrawalPanel.setVisible(false);

            // Setting up the button to go back from this frame
        JButton withdrawalCancelButton = new JButton("CANCEL");
        withdrawalCancelButton.setForeground(Color.BLACK);
        withdrawalCancelButton.setBackground(Color.WHITE);
        withdrawalCancelButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        withdrawalCancelButton.setBounds(2,168,120,25);
        withdrawalCancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawalCancelButton.setFocusable(false);
        withdrawalCancelButton.addActionListener(ae -> {
            withdrawalPanel.setVisible(false);
            withdrawalAmountField.setText("");
            headingPanel.setVisible(true);
            buttonsPanel.setVisible(true);

        });

            // Settting up the button to update the PIN of the user
        JButton withdrawalAmountButton = new JButton("WITHDRAW");
        withdrawalAmountButton.setForeground(Color.BLACK);
        withdrawalAmountButton.setBackground(Color.WHITE);
        withdrawalAmountButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        withdrawalAmountButton.setBounds(150,168,120,25);
        withdrawalAmountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawalAmountButton.setFocusable(false);
        withdrawalAmountButton.addActionListener(ae -> {

            String withdrawAmount = withdrawalAmountField.getText();
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < Integer.parseInt(withdrawAmount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    withdrawalAmountField.setText("");
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - Integer.parseInt(withdrawAmount);

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + withdrawAmount + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount "+withdrawAmount+" has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                withdrawalPanel.setVisible(false);
                withdrawalAmountField.setText("");
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

            // Adding components to the main panel
        withdrawalPanel.add(withdrawalHeadingPanel);
        withdrawalPanel.add(withdrawalCancelButton);
        withdrawalPanel.add(withdrawalAmountButton);

            // Adding the main panel to the background (Main Frame)
        background.add(withdrawalPanel);

        // Fast-Cash Panel
            // Main Heading
        JLabel fastCashHeadingLabel = new JLabel("Select the amount you wish to withdraw");
        fastCashHeadingLabel.setForeground(Color.WHITE);
        fastCashHeadingLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel fastCashHeadingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        fastCashHeadingPanel.add(fastCashHeadingLabel);
        fastCashHeadingPanel.setBounds(0,35,272,80);
        fastCashHeadingPanel.setOpaque(false);

            // Main panel to hold everything
        JPanel fastCashPanel = new JPanel(null);
        fastCashPanel.setOpaque(false);
        fastCashPanel.setBounds(115,240,272,220);
        fastCashPanel.setVisible(false);

            // Buttons
        JButton fastCash500 = new JButton("500");
        fastCash500.setForeground(Color.BLACK);
        fastCash500.setBackground(Color.WHITE);
        fastCash500.setFont(new Font("Helvetica", Font.BOLD, 12));
        fastCash500.setBounds(2,141,120,25);
        fastCash500.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCash500.setFocusable(false);
        fastCash500.addActionListener(ae -> {
            
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < 500){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - 500;

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + 500 + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount 500 has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                fastCashPanel.setVisible(false);
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        JButton fastCash1000 = new JButton("1000");
        fastCash1000.setForeground(Color.BLACK);
        fastCash1000.setBackground(Color.WHITE);
        fastCash1000.setFont(new Font("Helvetica", Font.BOLD, 12));
        fastCash1000.setBounds(2,168,120,25);
        fastCash1000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCash1000.setFocusable(false);
        fastCash1000.addActionListener(ae -> {
            
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < 1000){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - 1000;

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + 1000 + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount 1000 has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                fastCashPanel.setVisible(false);
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        JButton fastCash2000 = new JButton("2000");
        fastCash2000.setForeground(Color.BLACK);
        fastCash2000.setBackground(Color.WHITE);
        fastCash2000.setFont(new Font("Helvetica", Font.BOLD, 12));
        fastCash2000.setBounds(2,195,120,25);
        fastCash2000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCash2000.setFocusable(false);
        fastCash2000.addActionListener(ae -> {
            
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < 2000){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - 2000;

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + 2000 + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount 2000 has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                fastCashPanel.setVisible(false);
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        JButton fastCash5000 = new JButton("5000");
        fastCash5000.setForeground(Color.BLACK);
        fastCash5000.setBackground(Color.WHITE);
        fastCash5000.setFont(new Font("Helvetica", Font.BOLD, 12));
        fastCash5000.setBounds(150,141,120,25);
        fastCash5000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCash5000.setFocusable(false);
        fastCash5000.addActionListener(ae -> {
            
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < 5000){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - 5000;

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + 5000 + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount 5000 has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                fastCashPanel.setVisible(false);
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        JButton fastCash10000 = new JButton("10000");
        fastCash10000.setForeground(Color.BLACK);
        fastCash10000.setBackground(Color.WHITE);
        fastCash10000.setFont(new Font("Helvetica", Font.BOLD, 12));
        fastCash10000.setBounds(150,168,120,25);
        fastCash10000.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCash10000.setFocusable(false);
        fastCash10000.addActionListener(ae -> {
            
            Date currentDate = new Date();

            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String fetchBalance = "select * from account_balance where form_number = '" + formNumber +"'";

                ResultSet result = dbConnection.st.executeQuery(fetchBalance);
                result.next();
                String oldBalance = result.getString("balance");

                if(Integer.parseInt(oldBalance) < 10000){
                    JOptionPane.showMessageDialog(null, "Insufficient balance to process transcation!","WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Integer newBalanceValue = Integer.parseInt(oldBalance) - 10000;

                String newBalance = Integer.toString(newBalanceValue);

                String updateBalanceQuery = "update account_balance set balance = '" + newBalance + "' where form_number = '" + formNumber + "'";

                dbConnection.st.executeUpdate(updateBalanceQuery);

                String newTransactionQuery = "insert into transactions values ('" + formNumber + "','" + currentDate + "','" + "withdrawal" + "','" + 10000 + "')";
                dbConnection.st.executeUpdate(newTransactionQuery);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                JOptionPane.showMessageDialog(null, "Amount 10000 has been withdrawed successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                fastCashPanel.setVisible(false);
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        JButton fastCashCancelButton = new JButton("CANCEL");
        fastCashCancelButton.setForeground(Color.BLACK);
        fastCashCancelButton.setBackground(Color.WHITE);
        fastCashCancelButton.setFont(new Font("Helvetica", Font.BOLD, 10));
        fastCashCancelButton.setBounds(150,195,120,25);
        fastCashCancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCashCancelButton.setFocusable(false);
        fastCashCancelButton.addActionListener(ae -> {

            fastCashPanel.setVisible(false);
            headingPanel.setVisible(true);
            buttonsPanel.setVisible(true);
            
        });

            // Adding components to the main panel
        fastCashPanel.add(fastCashHeadingPanel);
        fastCashPanel.add(fastCash500);
        fastCashPanel.add(fastCash1000);
        fastCashPanel.add(fastCash2000);
        fastCashPanel.add(fastCash5000);
        fastCashPanel.add(fastCash10000);
        fastCashPanel.add(fastCashCancelButton);

            // Adding the main panel to the background (Main Frame)
        background.add(fastCashPanel);

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
        JButton PINChangecancelButton = new JButton("CANCEL");
        PINChangecancelButton.setForeground(Color.BLACK);
        PINChangecancelButton.setBackground(Color.WHITE);
        PINChangecancelButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        PINChangecancelButton.setBounds(2,168,120,25);
        PINChangecancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PINChangecancelButton.setFocusable(false);
        PINChangecancelButton.addActionListener(ae -> {
            changePINPanel.setVisible(false);
            headingPanel.setVisible(true);
            buttonsPanel.setVisible(true);

        });

            // Settting up the button to update the PIN of the user
        JButton changePINButton = new JButton("CHANGE PIN");
        changePINButton.setForeground(Color.BLACK);
        changePINButton.setBackground(Color.WHITE);
        changePINButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        changePINButton.setBounds(150,168,120,25);
        changePINButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePINButton.setFocusable(false);
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
                headingPanel.setVisible(true);
                buttonsPanel.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

            // Adding components to the main panel
        changePINPanel.add(enterNewPINPanel);
        changePINPanel.add(PINChangecancelButton);
        changePINPanel.add(changePINButton);

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

            // Label to show the actual balance
        JLabel currentBalanceLabel = new JLabel();
        currentBalanceLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        currentBalanceLabel.setForeground(Color.WHITE);

        JPanel balancePanel = new JPanel();
        balancePanel.setBounds(0,75,272,25);
        balancePanel.add(currentBalanceLabel);
        balancePanel.setOpaque(false);

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
        backButton.addActionListener(ae -> {
            balanceEnquiryPanel.setVisible(false);
            headingPanel.setVisible(true);
            buttonsPanel.setVisible(true);

        });

            // Adding components to the main panel
        balanceEnquiryPanel.add(balanceLabelPanel);
        balanceEnquiryPanel.add(balancePanel);
        balanceEnquiryPanel.add(backButton);

            // Adding the main panel to the background (Main Frame)
        background.add(balanceEnquiryPanel);

        //****************************************************************************\\

        // Setting up the transaction Buttons
        JButton depositButton = new JButton("Deposit".toUpperCase());
        depositButton.setForeground(Color.BLACK);
        depositButton.setBackground(Color.WHITE);
        depositButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        depositButton.setBounds(0,0,120,25);
        depositButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositButton.setFocusable(false);
        depositButton.addActionListener(ae -> {

            headingPanel.setVisible(false);
            buttonsPanel.setVisible(false);
            depositPanel.setVisible(true);
        });

        JButton fastCashButton = new JButton("Fast Cash".toUpperCase());
        fastCashButton.setForeground(Color.BLACK);
        fastCashButton.setBackground(Color.WHITE);
        fastCashButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        fastCashButton.setBounds(0,29,120,25);
        fastCashButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fastCashButton.setFocusable(false);
        fastCashButton.addActionListener(ae -> {

            headingPanel.setVisible(false);
            buttonsPanel.setVisible(false);
            fastCashPanel.setVisible(true);
        });

        JButton pinChangeButton = new JButton("Change PIN".toUpperCase());
        pinChangeButton.setForeground(Color.BLACK);
        pinChangeButton.setBackground(Color.WHITE);
        pinChangeButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        pinChangeButton.setBounds(0,59,120,25);
        pinChangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pinChangeButton.setFocusable(false);
        pinChangeButton.addActionListener(ae -> {
            
            headingPanel.setVisible(false);
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

            headingPanel.setVisible(false);
            buttonsPanel.setVisible(false);
            withdrawalPanel.setVisible(true);
        });

        JButton miniStatementButton = new JButton("Mini Statement".toUpperCase());
        miniStatementButton.setForeground(Color.BLACK);
        miniStatementButton.setBackground(Color.WHITE);
        miniStatementButton.setFont(new Font("Helvetica", Font.BOLD, 8));
        miniStatementButton.setBounds(152,29,120,25);
        miniStatementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miniStatementButton.setFocusable(false);
        miniStatementButton.addActionListener(ae -> {

            new MiniAccountStatement(formNumber,name,cardNumber);
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

                currentBalanceLabel.setText(balance);
                
                dbConnection.st.close();
                dbConnection.conn.close();

                headingPanel.setVisible(false);
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
