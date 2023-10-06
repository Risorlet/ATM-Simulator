package com.risorlet.ATM_Simulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

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
        heading2Panel.setBounds(100, 100, 500, 50);
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

        //Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(250, 20));
        dateChooser.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        dobPanel.setBounds(100, 250, 500, 50);
        dobPanel.setBackground(Color.WHITE);
        dobPanel.add(dobLabel);
        dobPanel.add(dateChooser);

        //Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        maleButton.setBackground(Color.WHITE);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        femaleButton.setBackground(Color.WHITE);

        JRadioButton otherButton = new JRadioButton("Other");
        otherButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        otherButton.setBackground(Color.WHITE);

        ButtonGroup genderButtons = new ButtonGroup();
        genderButtons.add(maleButton);
        genderButtons.add(femaleButton);
        genderButtons.add(otherButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        genderPanel.setBounds(100, 300, 500, 50);
        genderPanel.setBackground(Color.WHITE);
        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        //Email Address
        JLabel emaiLabel = new JLabel("Email:");
        emaiLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel emaiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        emaiPanel.setBounds(100, 350, 500, 50);
        emaiPanel.setBackground(Color.WHITE);
        emaiPanel.add(emaiLabel);
        emaiPanel.add(emailField);

        //Marital Status
        JLabel maritalLabel = new JLabel("Marital Status:");
        maritalLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JRadioButton singleButton = new JRadioButton("Single");
        singleButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        singleButton.setBackground(Color.WHITE);

        JRadioButton marriedButton = new JRadioButton("Married");
        marriedButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        marriedButton.setBackground(Color.WHITE);

        ButtonGroup maritalButtons = new ButtonGroup();
        maritalButtons.add(singleButton);
        maritalButtons.add(marriedButton);

        JPanel  maritalPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        maritalPanel.setBounds(100, 400, 500, 50);
        maritalPanel.setBackground(Color.WHITE);
        maritalPanel.add(maritalLabel);
        maritalPanel.add(singleButton);
        maritalPanel.add(marriedButton);

        //Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField addressField = new JTextField(20);
        addressField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        addressPanel.setBounds(100, 450, 500, 50);
        addressPanel.setBackground(Color.WHITE);
        addressPanel.add(addressLabel);
        addressPanel.add(addressField);

        //City
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField cityField = new JTextField(20);
        cityField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        cityPanel.setBounds(100, 500, 500, 50);
        cityPanel.setBackground(Color.WHITE);
        cityPanel.add(cityLabel);
        cityPanel.add(cityField);

        //State
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField stateField = new JTextField(20);
        stateField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        statePanel.setBounds(100, 550, 500, 50);
        statePanel.setBackground(Color.WHITE);
        statePanel.add(stateLabel);
        statePanel.add(stateField);

        //Pin Code
        JLabel pinCodeLabel = new JLabel("Pin Code:");
        pinCodeLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField pinCodeField = new JTextField(20);
        pinCodeField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel pinCodePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        pinCodePanel.setBounds(100, 600, 500, 50);
        pinCodePanel.setBackground(Color.WHITE);
        pinCodePanel.add(pinCodeLabel);
        pinCodePanel.add(pinCodeField);

        //form control buttons
        JButton clearButton = new JButton("CLEAR");
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.setPreferredSize(new Dimension(120, 40));
        clearButton.setFocusable(false);
        clearButton.addActionListener(e -> {
            
            firstNameField.setText("");
            lastNameField.setText("");
            dateChooser.setCalendar(null);
            genderButtons.clearSelection();
            emailField.setText("");
            maritalButtons.clearSelection();
            addressField.setText("");
            cityField.setText("");
            stateField.setText("");
            pinCodeField.setText("");
        });

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setPreferredSize(new Dimension(120, 40));
        submitButton.setFocusable(false);
        submitButton.addActionListener(e -> {
            
            System.out.println("Form submitted");
        });

        JPanel controlButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        controlButtonsPanel.setBounds(100, 650, 500, 50);
        controlButtonsPanel.setBackground(Color.WHITE);
        controlButtonsPanel.add(clearButton);
        controlButtonsPanel.add(submitButton);

        //the form component which holds all the elements
        JPanel signUpForm = new JPanel(null);
        signUpForm.setPreferredSize(new Dimension(700,750));
        signUpForm.setBackground(Color.WHITE);

        signUpForm.add(headingPanel);
        signUpForm.add(heading2Panel);
        signUpForm.add(firstNamePanel);
        signUpForm.add(lastNamePanel);
        signUpForm.add(dobPanel);
        signUpForm.add(genderPanel);
        signUpForm.add(emaiPanel);
        signUpForm.add(maritalPanel);
        signUpForm.add(addressPanel);
        signUpForm.add(cityPanel);
        signUpForm.add(statePanel);
        signUpForm.add(pinCodePanel);
        signUpForm.add(controlButtonsPanel);

        //the scroll pane which holds the whole form and makes it scrollable
        JScrollPane scrollableForm = new JScrollPane(signUpForm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollableForm.setBounds(0, 0, 700, 450);
        add(scrollableForm);

        //setting up the size of the frame and making it visible
        setSize(700, 450);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
    }

}
