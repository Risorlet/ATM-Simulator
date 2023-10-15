package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniAccountStatement extends JFrame{
    
    //Image icon for the frame
    String frameIconPath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\bank.png";
    ImageIcon frameIcon = new ImageIcon(frameIconPath);

    Image img = frameIcon.getImage();
    ImageIcon headingIcon = new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

    String balance;

    MiniAccountStatement(String from_number, String userName, String cardNumber){

        // Setting up the frame title and icon
        setTitle("Mini Statement");
        setLocation(400, 80);
        setIconImage(frameIcon.getImage());
        setLayout(null);

        // Heading Image
        JLabel headingImage = new JLabel(headingIcon);

        // Setting up the title beside the title image
        JLabel title = new JLabel("  Mini Statement");
        title.setFont(new Font("Helvetica", Font.BOLD, 35));

        // Adding the title image and title text inside a panel to group them
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0,5,600,60);
        headerPanel.setOpaque(false);
        add(headerPanel);

        headerPanel.add(headingImage);
        headerPanel.add(title);

        // Details about the mini statement
        JLabel description = new JLabel("* Mini statement contains your last 5 transactions *");
        description.setFont(new Font("Helvetica", Font.BOLD, 13));
        description.setForeground(Color.RED);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,65,600,25);
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(description);

        add(descriptionPanel);

        // Account details panel
        JPanel accountDetailsPanel = new JPanel(null);
        accountDetailsPanel.setBounds(0,100,600,100);
        accountDetailsPanel.setOpaque(false);
        add(accountDetailsPanel);

        JLabel userNameLabel = new JLabel("Account Holders Name:");
        userNameLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        userNameLabel.setBounds(30,0,200,25);

        JLabel carNumberLabel = new JLabel("Card Number:");
        carNumberLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        carNumberLabel.setBounds(30,30,200,25);

        JLabel userNameValueLabel = new JLabel(userName.toUpperCase());
        userNameValueLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        userNameValueLabel.setBounds(240,0,200,25);

        JLabel cardNumberValueLabel = new JLabel(cardNumber.substring(0,4) + "-XXXX-XXXX-" + cardNumber.substring(12, 16));
        cardNumberValueLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        cardNumberValueLabel.setBounds(240,30,200,25);

        JLabel accountBalanceLabel = new JLabel("Account Balance:");
        accountBalanceLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        accountBalanceLabel.setBounds(210,70,200,25);

        accountDetailsPanel.add(userNameLabel);
        accountDetailsPanel.add(userNameValueLabel);
        accountDetailsPanel.add(carNumberLabel);
        accountDetailsPanel.add(cardNumberValueLabel);
        accountDetailsPanel.add(accountBalanceLabel);

        // Account balance
        // Fetching the account balance from the database
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();

            String query = "select balance from account_balance where form_number = '" + from_number + "'";

            ResultSet result = dbConnection.st.executeQuery(query);
            result.next();
            balance = result.getString("balance");

            dbConnection.st.close();
            dbConnection.conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel to show the current account balance
        JPanel accountBalancePanel = new JPanel();
        accountBalancePanel.setBounds(0,200,600,30);
        accountBalancePanel.setOpaque(false);
        add(accountBalancePanel);
        
        JLabel accountBalanceValueLabel = new JLabel(balance);
        accountBalanceValueLabel.setFont(new Font("Helvetica", Font.BOLD, 22));
        accountBalancePanel.add(accountBalanceValueLabel);
        
        // Transactions
        JPanel transactions = new JPanel(new GridLayout(0,4,5,5));
        transactions.setBounds(40,260,520,200);
        transactions.setOpaque(false);
        add(transactions);

        JLabel serialNumberLabel = new JLabel("SL. No.");
        JPanel snp = new JPanel();
        snp.setOpaque(false);
        serialNumberLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        snp.add(serialNumberLabel);
        transactions.add(snp);

        JLabel transactionDateLabel = new JLabel("Transaction Date");
        JPanel tdp = new JPanel();
        tdp.setOpaque(false);
        transactionDateLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        tdp.add(transactionDateLabel);
        transactions.add(tdp);

        JLabel transactionTypeLabel = new JLabel("Transaction Type");
        JPanel ttp = new JPanel();
        ttp.setOpaque(false);
        transactionTypeLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        ttp.add(transactionTypeLabel);
        transactions.add(ttp);

        JLabel transactionAmountLabel = new JLabel("Amount");
        JPanel tap = new JPanel();
        tap.setOpaque(false);
        transactionAmountLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        tap.add(transactionAmountLabel);
        transactions.add(tap);

        try {
            
            DatabaseConnection dbConnection = new DatabaseConnection();
            String transactionsQuery = "select * from transactions where form_number = '" + from_number + "'";
            ResultSet result = dbConnection.st.executeQuery(transactionsQuery);

            if(!result.next()) {    // If resultset is empty
                
                JLabel noDataLabel = new JLabel("You haven't made any transactions yet :(");
                JPanel noDataPanel = new JPanel();
                noDataLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
                noDataLabel.setForeground(Color.RED);
                noDataPanel.add(noDataLabel);
                noDataPanel.setBounds(0,320,600,60);
                noDataPanel.setOpaque(false);

                transactions.setVisible(false);

                add(noDataPanel);
            }

            result.afterLast();
            int transactionCount = 0;

            while(result.previous() && transactionCount<5){

                String snData = Integer.toString(transactionCount+1);
                String txnDateData = result.getString("txn_date");
                String txnTypeData = result.getString("txn_type");
                String txnAmountData = result.getString("amount");

                JLabel snDataLabel = new JLabel(snData);
                JPanel p1 = new JPanel();
                p1.setOpaque(false);
                snDataLabel.setFont(new Font("Helvetica", Font.BOLD, 11));
                p1.add(snDataLabel);
                transactions.add(p1);

                JLabel txnDateLabel = new JLabel(txnDateData.substring(4));
                JPanel p2 = new JPanel();
                p2.setOpaque(false);
                txnDateLabel.setFont(new Font("Helvetica", Font.BOLD, 10));
                p2.add(txnDateLabel);
                transactions.add(p2);

                JLabel txnTypeLabel = new JLabel(txnTypeData);
                JPanel p3 = new JPanel();
                p3.setOpaque(false);
                txnTypeLabel.setFont(new Font("Helvetica", Font.BOLD, 11));
                p3.add(txnTypeLabel);
                transactions.add(p3);

                JLabel txnAmountLabel;
                if (txnTypeData.equals("deposit")){
                    txnAmountLabel = new JLabel("+" + txnAmountData);
                    txnAmountLabel.setForeground(Color.GREEN);
                } else {
                    txnAmountLabel = new JLabel("-" + txnAmountData);
                    txnAmountLabel.setForeground(Color.RED);
                }
                JPanel p4 = new JPanel();
                p4.setOpaque(false);
                txnAmountLabel.setFont(new Font("Helvetica", Font.BOLD, 11));
                p4.add(txnAmountLabel);
                transactions.add(p4);

                transactionCount++;
            }


            dbConnection.st.close();
            dbConnection.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding the exit button
        JButton okayButton = new JButton("OKAY");
        okayButton.setForeground(Color.WHITE);
        okayButton.setBackground(Color.BLACK);
        okayButton.setBounds(420,490,120,40);
        okayButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        okayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        okayButton.setPreferredSize(new Dimension(120, 40));
        okayButton.setFocusable(false);
        okayButton.addActionListener(ae -> dispose());

        add(okayButton);

        // Setting up the size of the frame and making it visible
        setSize(600, 600);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
