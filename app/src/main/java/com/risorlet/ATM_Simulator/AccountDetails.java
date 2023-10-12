package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AccountDetails extends JFrame{
    
    //Image icon for the frame
    String frameIconPath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\bank.png";
    ImageIcon frameIcon = new ImageIcon(frameIconPath);

    // Random object to create random card number and pin
    Random rand = new Random();

    // Generating the Card Number for the user
    String cardNumber = Long.toString(Math.abs(rand.nextLong() % 100000000L) + 7489556300000000L);
    String PIN = Integer.toString(Math.abs(rand.nextInt() % 9000) + 1000);

    AccountDetails(String formNumber){

        // Setting up the frame title and icon
        setTitle("Fill Up Account Details");
        setLocation(380, 80);
        setIconImage(frameIcon.getImage());
        setLayout(null);

        // Label to show the form number in the top right corner
        JLabel formNoLabel = new JLabel("Form No. " + formNumber);
        formNoLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        formNoLabel.setBounds(480, 5, 100, 30);
        add(formNoLabel);

        // Form heading
        JLabel heading = new JLabel("Section 3: Account Details");
        heading.setFont(new Font("Helvetica", Font.BOLD, 15));
        heading.setBounds(200,20,200,50);
        add(heading);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        accountTypeLabel.setBounds(50,60,200,50);
        add(accountTypeLabel);

        // Options for the type of account as radio buttons
        JRadioButton savingsAccount = new JRadioButton("Savings Account");
        savingsAccount.setBounds(70,100,200,50);
        savingsAccount.setFont(new Font("Helvetica", Font.BOLD, 15));
        savingsAccount.setBackground(Color.WHITE);
        savingsAccount.setFocusable(false);
        add(savingsAccount);

        JRadioButton FD_Account = new JRadioButton("Fixed Deposit Account");
        FD_Account.setBounds(300,100,200,50);
        FD_Account.setFont(new Font("Helvetica", Font.BOLD, 15));
        FD_Account.setBackground(Color.WHITE);
        FD_Account.setFocusable(false);
        add(FD_Account);

        JRadioButton currentAccount = new JRadioButton("Current Account");
        currentAccount.setBounds(70,140,200,50);
        currentAccount.setFont(new Font("Helvetica", Font.BOLD, 15));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setFocusable(false);
        add(currentAccount);

        JRadioButton RD_Account = new JRadioButton("Recurrung Deposit Account");
        RD_Account.setBounds(300,140,250,50);
        RD_Account.setFont(new Font("Helvetica", Font.BOLD, 15));
        RD_Account.setBackground(Color.WHITE);
        RD_Account.setFocusable(false);
        add(RD_Account);

        ButtonGroup accountChoices = new ButtonGroup();
        accountChoices.add(savingsAccount);
        accountChoices.add(FD_Account);
        accountChoices.add(currentAccount);
        accountChoices.add(RD_Account);

        // Card Details
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        cardNumberLabel.setBounds(50,200,200,40);
        add(cardNumberLabel);

        JLabel dummyCardNumber = new JLabel("XXXX-XXXX-XXXX-8749");
        dummyCardNumber.setFont(new Font("Helvetica", Font.BOLD, 20));
        dummyCardNumber.setBounds(200,200,250,40);
        add(dummyCardNumber);

        JLabel cardDetails = new JLabel("16 digit dummy card number");
        cardDetails.setFont(new Font("Helvetica", Font.BOLD, 10));
        cardDetails.setBounds(50,230,300,20);
        add(cardDetails);

        // PIN Details
        JLabel pinNumber = new JLabel("PIN:");
        pinNumber.setFont(new Font("Helvetica", Font.BOLD, 20));
        pinNumber.setBounds(50,260,200,40);
        add(pinNumber);

        JLabel dummyPinNumber = new JLabel("XXXX");
        dummyPinNumber.setFont(new Font("Helvetica", Font.BOLD, 20));
        dummyPinNumber.setBounds(200,260,250,40);
        add(dummyPinNumber);

        JLabel pinDetails = new JLabel("4 digit dummy PIN");
        pinDetails.setFont(new Font("Helvetica", Font.BOLD, 10));
        pinDetails.setBounds(50,290,300,20);
        add(pinDetails);

        // Required Services
        JLabel requiredServices = new JLabel("Required Services:");
        requiredServices.setFont(new Font("Helvetica", Font.BOLD, 20));
        requiredServices.setBounds(50,330,200,40);
        add(requiredServices);

        JCheckBox ATM_Card = new JCheckBox("ATM Card");
        ATM_Card.setBounds(70,360,200,50);
        ATM_Card.setFont(new Font("Helvetica", Font.BOLD, 15));
        ATM_Card.setBackground(Color.WHITE);
        ATM_Card.setFocusable(false);
        add(ATM_Card);

        JCheckBox internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(290,360,200,50);
        internetBanking.setFont(new Font("Helvetica", Font.BOLD, 15));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFocusable(false);
        add(internetBanking);

        JCheckBox mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(70,400,200,50);
        mobileBanking.setFont(new Font("Helvetica", Font.BOLD, 15));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFocusable(false);
        add(mobileBanking);

        JCheckBox emailAndSmsAlert = new JCheckBox("Email and SMS Alert");
        emailAndSmsAlert.setBounds(290,400,200,50);
        emailAndSmsAlert.setFont(new Font("Helvetica", Font.BOLD, 15));
        emailAndSmsAlert.setBackground(Color.WHITE);
        emailAndSmsAlert.setFocusable(false);
        add(emailAndSmsAlert);

        JCheckBox chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(70,440,200,40);
        chequeBook.setFont(new Font("Helvetica", Font.BOLD, 15));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFocusable(false);
        add(chequeBook);

        JCheckBox E_Statement = new JCheckBox("E-Statement");
        E_Statement.setBounds(290,440,200,40);
        E_Statement.setFont(new Font("Helvetica", Font.BOLD, 15));
        E_Statement.setBackground(Color.WHITE);
        E_Statement.setFocusable(false);
        add(E_Statement);

        // Declaration Checkbox
        JCheckBox declaration = new JCheckBox("I hereby declare that all the information provided above is true to the best of my knowledge.");
        declaration.setBounds(50,480,500,30);
        declaration.setFont(new Font("Helvetica", Font.BOLD, 10));
        declaration.setBackground(Color.WHITE);
        declaration.setFocusable(false);
        add(declaration);

        // Control Buttons
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        cancelButton.setBounds(150,520,100,30);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(ae -> {
            setVisible(false);
            dispose();

            new Login();
        });
        add(cancelButton);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        submitButton.setBounds(350,520,100,30);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setFocusable(false);
        submitButton.addActionListener(ae -> {

            // form validation
            if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null, "You must give consent that all the data entered is true!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }else if(!(savingsAccount.isSelected() || FD_Account.isSelected() || currentAccount.isSelected() || RD_Account.isSelected())){
                JOptionPane.showMessageDialog(null, "You must select account type!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Getting the data from the form that has been entered
            String accountType = "";
            if(savingsAccount.isSelected()){
                accountType = "Savings Account";
            }else if(FD_Account.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(currentAccount.isSelected()){
                accountType = "Current Account";
            }else if(RD_Account.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            String services = "";
            if(ATM_Card.isSelected()){
                services = services.concat("ATM-Card ");
            }
            if(internetBanking.isSelected()){
                services = services.concat("Internet-Banking ");
            }
            if(mobileBanking.isSelected()){
                services = services.concat("Mobile-Banking ");
            }
            if(emailAndSmsAlert.isSelected()){
                services = services.concat("Email-&-SMS ");
            }
            if(chequeBook.isSelected()){
                services = services.concat("Cheque-Book ");
            }
            if(E_Statement.isSelected()){
                services = services.concat("E-Statement ");
            }

            // Add the data to the database
            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String detailsQuery = "insert into account_details values ('" + formNumber + "','" + accountType + "','" + services + "')";
                String loginQuery = "insert into login values ('" + formNumber + "','" + cardNumber + "','" + PIN + "')";
                
                dbConnection.st.executeUpdate(detailsQuery);
                dbConnection.st.executeUpdate(loginQuery);

                dbConnection.st.close();
                dbConnection.conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            // Show the user their card number and PIN upon successful submission of form
            JOptionPane.showMessageDialog(null, "Please save your credentials for later\n\nCard Number: " + cardNumber + "\nPIN: " + PIN, "Your Details", JOptionPane.INFORMATION_MESSAGE);

            // After successfully submitting the form, take the user to the transactions page
            setVisible(false);
            dispose();

            new TransactionInterface(formNumber);
        });
        add(submitButton);

        // Setting up the size of the frame and making it visible
        setSize(600, 600);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
