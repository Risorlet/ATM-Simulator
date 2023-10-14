package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniAccountStatement extends JFrame{
    
    //Image icon for the frame
    String frameIconPath = System.getProperty("user.dir") + "\\src\\main\\resources\\images\\bank.png";
    ImageIcon frameIcon = new ImageIcon(frameIconPath);

    MiniAccountStatement(String from_number){

        // Setting up the frame title and icon
        setTitle("Fill Up Account Details");
        setLocation(400, 80);
        setIconImage(frameIcon.getImage());
        setLayout(null);



        // Setting up the size of the frame and making it visible
        setSize(600, 600);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
