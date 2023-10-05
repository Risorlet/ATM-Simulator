package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SignUp extends JFrame{
    
    Random rand = new Random();
    int formNumber = rand.nextInt(1000, 10000);

    ImageIcon frameIcon = new ImageIcon("F:\\Argha\\Projects\\Java\\ATM Simulator\\app\\src\\main\\resources\\images\\bank.png");
    ImageIcon personIconLarge = new ImageIcon("F:\\Argha\\Projects\\Java\\ATM Simulator\\app\\src\\main\\resources\\images\\person.png");
    Image img = personIconLarge.getImage();
    ImageIcon personIcon = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_DEFAULT));

    SignUp (){
        //setting up the frame title and icon
        setTitle("New Account Application Form");
        setLocation(350, 150);
        setIconImage(frameIcon.getImage());

        //heading text and Image
        JLabel personImage = new JLabel(personIcon);

        JLabel title = new JLabel("APPLICATION FORM NUMBER: " + formNumber);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));

        JPanel headingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        headingPanel.setBounds(100, 20, 500, 50);
        headingPanel.setBackground(Color.WHITE);
        headingPanel.add(personImage);
        headingPanel.add(title);

        //personal details heading
        JLabel personalDetailsLabel = new JLabel("Enter Your Personal Details");
        personalDetailsLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

        JPanel heading2Panel = new JPanel(new FlowLayout());
        heading2Panel.setBounds(100, 80, 500, 50);
        heading2Panel.setBackground(Color.WHITE);
        heading2Panel.add(personalDetailsLabel);

        //First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField firstNameField = new JTextField(20);
        firstNameField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        firstNamePanel.setBounds(100, 150, 500, 50);
        firstNamePanel.setBackground(Color.WHITE);
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);

        //Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField lastNameField = new JTextField(20);
        lastNameField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        lastNamePanel.setBounds(100, 200, 500, 50);
        lastNamePanel.setBackground(Color.WHITE);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);

        //the form component which holds all the elements
        JPanel signUpForm = new JPanel(null);
        signUpForm.setBounds(0, 0, 700, 1000);
        signUpForm.setBackground(Color.WHITE);

        signUpForm.add(headingPanel);
        signUpForm.add(heading2Panel);
        signUpForm.add(firstNamePanel);
        signUpForm.add(lastNamePanel);

        //the scroll pane which holds the whole form and makes it scrollable
        // JScrollPane scrollableForm = new JScrollPane(signUpForm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scrollableForm.setBounds(0, 0, 700, 450);
        // add(scrollableForm);
        add(signUpForm);

        //setting up the size of the frame and making it visible
        setSize(700, 450);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
    }

}
