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

    String[] possibleReligions = {"Hindu", "Muslim", "Sikh", "Christian", "Buddhist", "Other"};
    String[] possibeCasts = {"General", "OBC", "SC/ST", "Other"};
    String[] possibleIncomes = {"null", "Below 50,000", "50,000 - 1,00,000", "1,00,000 - 5,00,000", "Above 5,00,000"};
    String[] possibleQualifications = {"null", "High School", "Bachelors", "Masters", "Other"};
    String[] possibleOccupations = {"Unemployed", "Business", "Salaried", "Self-Employed", "Other"};

    SignUp (){
        //setting up the frame title and icon
        setTitle("New Account Application Form");
        setLocation(350, 150);
        setIconImage(frameIcon.getImage());
        setLayout(null);

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
        JLabel personalDetailsLabel = new JLabel("Section 1: Personal Details");
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

        // Additional details heading
        JLabel additionalDetailsLabel = new JLabel("Section 2: Additional Details");
        additionalDetailsLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

        JPanel heading3Panel = new JPanel(new FlowLayout());
        heading3Panel.setBounds(100, 650, 500, 50);
        heading3Panel.setBackground(Color.WHITE);
        heading3Panel.add(additionalDetailsLabel);

        // Religion
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JComboBox<String> religionDropdown = new JComboBox<>(possibleReligions);
        religionDropdown.setFont(new Font("Helvetica", Font.BOLD, 13));
        religionDropdown.setPreferredSize(new Dimension(250, 20));
        religionDropdown.setBackground(Color.WHITE);
        religionDropdown.setSelectedItem(null);
        religionDropdown.setFocusable(false);

        JPanel religionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        religionPanel.setBounds(100, 700, 500, 50);
        religionPanel.setBackground(Color.WHITE);
        religionPanel.add(religionLabel);
        religionPanel.add(religionDropdown);
        
        // Category
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JComboBox<String> categoryDropdown = new JComboBox<>(possibeCasts);
        categoryDropdown.setFont(new Font("Helvetica", Font.BOLD, 13));
        categoryDropdown.setPreferredSize(new Dimension(250, 20));
        categoryDropdown.setBackground(Color.WHITE);
        categoryDropdown.setSelectedItem(null);
        categoryDropdown.setFocusable(false);

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        categoryPanel.setBounds(100, 750, 500, 50);
        categoryPanel.setBackground(Color.WHITE);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryDropdown);

        //Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JComboBox<String> incomeDropdown = new JComboBox<>(possibleIncomes);
        incomeDropdown.setFont(new Font("Helvetica", Font.BOLD, 13));
        incomeDropdown.setPreferredSize(new Dimension(250, 20));
        incomeDropdown.setBackground(Color.WHITE);
        incomeDropdown.setSelectedItem(null);
        incomeDropdown.setFocusable(false);

        JPanel incomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        incomePanel.setBounds(100, 800, 500, 50);
        incomePanel.setBackground(Color.WHITE);
        incomePanel.add(incomeLabel);
        incomePanel.add(incomeDropdown);

        //Education
        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JComboBox<String> educationDropdown = new JComboBox<>(possibleQualifications);
        educationDropdown.setFont(new Font("Helvetica", Font.BOLD, 13));
        educationDropdown.setPreferredSize(new Dimension(250, 20));
        educationDropdown.setBackground(Color.WHITE);
        educationDropdown.setSelectedItem(null);
        educationDropdown.setFocusable(false);

        JPanel educationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        educationPanel.setBounds(100, 850, 500, 50);
        educationPanel.setBackground(Color.WHITE);
        educationPanel.add(educationLabel);
        educationPanel.add(educationDropdown);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JComboBox<String> occupationDropdown = new JComboBox<>(possibleOccupations);
        occupationDropdown.setFont(new Font("Helvetica", Font.BOLD, 13));
        occupationDropdown.setPreferredSize(new Dimension(250, 20));
        occupationDropdown.setBackground(Color.WHITE);
        occupationDropdown.setSelectedItem(null);
        occupationDropdown.setFocusable(false);

        JPanel occupationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        occupationPanel.setBounds(100, 900, 500, 50);
        occupationPanel.setBackground(Color.WHITE);
        occupationPanel.add(occupationLabel);
        occupationPanel.add(occupationDropdown);

        // PAN Number
        JLabel PANLabel = new JLabel("PAN Number:");
        PANLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField PANField = new JTextField(20);
        PANField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel PANPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        PANPanel.setBounds(100, 950, 500, 50);
        PANPanel.setBackground(Color.WHITE);
        PANPanel.add(PANLabel);
        PANPanel.add(PANField);

        // Aadhar Number
        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JTextField aadharField = new JTextField(20);
        aadharField.setFont(new Font("Helvetica", Font.BOLD, 13));

        JPanel aadharPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        aadharPanel.setBounds(100, 1000, 500, 50);
        aadharPanel.setBackground(Color.WHITE);
        aadharPanel.add(aadharLabel);
        aadharPanel.add(aadharField);

        // Senior Citizenship
        JLabel seniorCitizenshipLabel = new JLabel("Senior Citizen:");
        seniorCitizenshipLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JRadioButton SC_YesButton = new JRadioButton("Yes");
        SC_YesButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        SC_YesButton.setBackground(Color.WHITE);

        JRadioButton SC_NoButton = new JRadioButton("No");
        SC_NoButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        SC_NoButton.setBackground(Color.WHITE);

        ButtonGroup SC_Buttons = new ButtonGroup();
        SC_Buttons.add(SC_YesButton);
        SC_Buttons.add(SC_NoButton);

        JPanel seniorCitizenshipPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        seniorCitizenshipPanel.setBounds(100, 1050, 500, 50);
        seniorCitizenshipPanel.setBackground(Color.WHITE);
        seniorCitizenshipPanel.add(seniorCitizenshipLabel);
        seniorCitizenshipPanel.add(SC_YesButton);
        seniorCitizenshipPanel.add(SC_NoButton);

        // Existing Account Holder
        JLabel accountLabel = new JLabel("Existing Account:");
        accountLabel.setFont(new Font("Helvetica", Font.BOLD, 13));

        JRadioButton account_YesButton = new JRadioButton("Yes");
        account_YesButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        account_YesButton.setBackground(Color.WHITE);

        JRadioButton account_NoButton = new JRadioButton("No");
        account_NoButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        account_NoButton.setBackground(Color.WHITE);

        ButtonGroup accountButtons = new ButtonGroup();
        accountButtons.add(account_YesButton);
        accountButtons.add(account_NoButton);

        JPanel  accountPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        accountPanel.setBounds(100, 1100, 500, 50);
        accountPanel.setBackground(Color.WHITE);
        accountPanel.add(accountLabel);
        accountPanel.add(account_YesButton);
        accountPanel.add(account_NoButton);

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
            religionDropdown.setSelectedItem(null);
            categoryDropdown.setSelectedItem(null);
            incomeDropdown.setSelectedItem(null);
            educationDropdown.setSelectedItem(null);
            occupationDropdown.setSelectedItem(null);
            PANField.setText("");
            aadharField.setText("");
            SC_Buttons.clearSelection();
            accountButtons.clearSelection();
        });

        JButton nextButton = new JButton("NEXT");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.BLACK);
        nextButton.setFont(new Font("Helvetica", Font.BOLD, 13));
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.setPreferredSize(new Dimension(120, 40));
        nextButton.setFocusable(false);
        nextButton.addActionListener(ae -> {

            //storing the values entered in the form in variables to push into database
            //data from personal details
            String formNo = Integer.toString(formNumber);
            String fName = firstNameField.getText();
            String lName = lastNameField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            
            String gender = "null";
            if(maleButton.isSelected()){
                gender = "Male";
            }else if(femaleButton.isSelected()){
                gender = "Female";
            }else if(otherButton.isSelected()){
                gender = "Other";
            }

            String email = emailField.getText();
            
            String maritalStatus = "null";
            if(marriedButton.isSelected()){
                maritalStatus = "Married";
            }else if(singleButton.isSelected()){
                maritalStatus = "Single";
            }

            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String pinCode = pinCodeField.getText();

            //data from additional details

            String religion = (String) religionDropdown.getSelectedItem();
            String cast = (String) categoryDropdown.getSelectedItem();
            String income = (String) incomeDropdown.getSelectedItem();
            String education = (String) educationDropdown.getSelectedItem();
            String occupation = (String) occupationDropdown.getSelectedItem();
            String PAN = PANField.getText();
            String aadhar = aadharField.getText();

            String senior = "null";
            if(SC_YesButton.isSelected()){
                senior = "Yes";
            }else if(SC_NoButton.isSelected()){
                senior = "No";
            }

            String account = "null";
            if(account_YesButton.isSelected()){
                account = "Yes";
            }else if(account_NoButton.isSelected()){
                account = "No";
            }

            //databse connection and query processing            
            try {
                DatabaseConnection dbConnection = new DatabaseConnection();
                String query = "insert into users values('" + formNo + "','" + fName + "','" + lName + "','" + dob + "','" + gender + "','" + email + "','" + maritalStatus + "','" + address + "','" + city + "','" + state + "','" + pinCode + "','" + religion + "','" + cast + "','" + income + "','" + education + "','" + occupation + "','" + PAN + "','" + aadhar + "','" + senior + "','" + account + "')";

                dbConnection.st.executeUpdate(query);

                dbConnection.st.close();
                dbConnection.conn.close();
                
            } catch (Exception e) {
                System.out.println(e);
            }

            //closing this frame and opening the next frame

        });

        JPanel controlButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        controlButtonsPanel.setBounds(100, 1150, 500, 50);
        controlButtonsPanel.setBackground(Color.WHITE);
        controlButtonsPanel.add(clearButton);
        controlButtonsPanel.add(nextButton);

        //the form component which holds all the elements
        JPanel signUpForm = new JPanel(null);
        signUpForm.setPreferredSize(new Dimension(700,1250));
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

        signUpForm.add(heading3Panel);

        signUpForm.add(religionPanel);
        signUpForm.add(categoryPanel);
        signUpForm.add(incomePanel);
        signUpForm.add(educationPanel);
        signUpForm.add(occupationPanel);
        signUpForm.add(PANPanel);
        signUpForm.add(aadharPanel);
        signUpForm.add(seniorCitizenshipPanel);
        signUpForm.add(accountPanel);

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
    }

}
