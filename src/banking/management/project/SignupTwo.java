package  banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    Long FormDigit;
    JLabel AddDetails , RELEGION , CATEGORY , INCOME ,QUALIFICATIONS ,occupation,Pan,AADHAR,scitizen,E_account;
    JTextField nameText,ftext,emailText,PinText,adhar_text,Statetext,Pan_text;

    JRadioButton EYES,YES,NO,ENO;
    JButton next;
    JComboBox religion,category,income,education,Occupation;
    String FORMNUMBER;
    SignupTwo(String formno){
        this.FORMNUMBER = formno;
        setLayout(null);



        // random Form number generation



        setTitle("New Account Application Form -- page 2 ");


        AddDetails= new JLabel("Page 2 : Additional Details");
        AddDetails.setFont(new Font("Osward",Font.BOLD,22));
        AddDetails.setBounds(210,55 ,400 ,35);
        add(AddDetails);

        // text boxes

        RELEGION= new JLabel("Religion ");
        RELEGION.setFont(new Font("Osward",Font.BOLD,20));
        RELEGION.setBounds(100,120,100,30);
        add(RELEGION);
        String var_riligion[]={"Hindu","Muslim","Sikh","Christian","Valmiki","Other"};
         religion= new JComboBox(var_riligion);
        religion.setBounds(300,120,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        CATEGORY= new JLabel("Category");
        CATEGORY.setFont(new Font("Osward",Font.BOLD,20));
        CATEGORY.setBounds(100,170,200,30);
        add(CATEGORY);
        String Var_Category[] = {"General","OBC","SC","ST","Other"};
         category = new JComboBox(Var_Category);
        category.setBounds(300,170,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        INCOME= new JLabel("Income : ");
        INCOME.setFont(new Font("Osward",Font.BOLD,20));
        INCOME.setBounds(100,220,200,30);
        add(INCOME);
        String var_income[]={"Null","less than 2 lakhs","less than 5 lakh","Less than 10 lakh","More than 10 lakhs","Other"};
       income= new JComboBox(var_income);
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        QUALIFICATIONS= new JLabel("Qualifications");
        QUALIFICATIONS.setFont(new Font("Osward",Font.BOLD,20));
        QUALIFICATIONS.setBounds(100,270,180,30);
        add(QUALIFICATIONS);
        String var_qualifications[] = {"Non-Graduate","Post-Graduate","Graduate","Doctrate","Other"};
         education= new JComboBox(var_qualifications);
        education.setBounds(300,270,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        occupation= new JLabel("Occupation");
        occupation.setFont(new Font("Osward",Font.BOLD,20));
        occupation.setBounds(100,320,200,30);
        add(occupation);
        String var_occupation[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        Occupation = new JComboBox(var_occupation);
        Occupation.setBounds(300,320,400,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);


        Pan= new JLabel("Pan number :");
        Pan.setFont(new Font("Osward",Font.BOLD,20));
        Pan.setBounds(100,370,200,30);
        add(Pan);
        Pan_text = new JTextField();
        Pan_text.setFont(new Font("Osward",Font.BOLD,20));
        Pan_text.setBounds(300,370,400,30);
        add(Pan_text);


        AADHAR= new JLabel("Aaddhar number :");
        AADHAR.setFont(new Font("Osward",Font.BOLD,20));
        AADHAR.setBounds(100,420,200,30);
        add(AADHAR);
        adhar_text = new JTextField();
        adhar_text.setFont(new Font("Osward",Font.BOLD,20));
        adhar_text.setBounds(300,420,400,30);
        add(adhar_text);

        scitizen= new JLabel("Senior Citizen");
        scitizen.setFont(new Font("Osward",Font.BOLD,20));
        scitizen.setBounds(100,470,200,30);
        add(scitizen);
        YES = new JRadioButton("Yes");
        YES.setBounds(300,480,100,20);
        YES.setBackground(Color.white);
        add(YES);
        NO = new JRadioButton("NO");
        NO.setBounds(450,480,100,20);
        NO.setBackground(Color.white);
        add(NO);
        ButtonGroup SENIORGRP = new ButtonGroup();
        SENIORGRP.add(YES);
        SENIORGRP.add(NO);

        E_account= new JLabel("Existing Account ");
        E_account.setFont(new Font("Osward",Font.BOLD,20));
        E_account.setBounds(100,520,200,30);
        add(E_account);
        EYES = new JRadioButton("Yes");
        EYES.setBounds(300,530,100,20);
        EYES.setBackground(Color.white);
        add(EYES);
        ENO = new JRadioButton("NO");
        ENO.setBounds(450,530,100,20);
        ENO.setBackground(Color.white);
        add(ENO);
        ButtonGroup EX_GRP = new ButtonGroup();
        EX_GRP.add(EYES);
        EX_GRP.add(ENO);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(610,620,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);



        setSize(800, 750);
        setVisible(true);
        setLocation(350,20);
    }

    public void actionPerformed(ActionEvent e) {

//        JTextField nameText,ftext,emailText,PinText,Citytext,Statetext,AdressText;

        String s_formnumber = " " + FORMNUMBER;
        String s_religion = (String) religion.getSelectedItem();
        String s_category = (String) category.getSelectedItem();
        String s_income = (String) income.getSelectedItem();
        String s_qualifications = (String) education.getSelectedItem();
        String s_occupation = (String) Occupation.getSelectedItem();
        String s_aadhar = adhar_text.getText();
        String s_pan = Pan_text.getText();

        String s_SENIOR_CITIZEN = null;
        if (YES.isSelected()){
            s_SENIOR_CITIZEN = "Yes";
        }else if (NO.isSelected()){
            s_SENIOR_CITIZEN = "No";
        }

     String s_Existing_Account = null;
        if (YES.isSelected()){
            s_Existing_Account = "Yes";
        }else if (NO.isSelected()){
            s_Existing_Account = "No";
        }



        try{
            if (s_income.equals("") && s_aadhar.equals("")){
                JOptionPane.showMessageDialog(null," Aadhar & Income IS REQUIRED !"); // this is for a pop up notification for a user if he/shee didn't enter name
            } else if (s_income.equals("")) {
                JOptionPane.showMessageDialog(null,"Income IS REQUIRED !");
            }else if(s_aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar card number IS REQUIRED !");
            }else {
                connection c = new connection();
               String query = "insert into signuptwo values('" + s_formnumber + "','" + s_religion + "','" + s_category + "','" + s_income + "','" + s_qualifications+ "','" + s_occupation+ "','" + s_pan + "','" + s_aadhar + "','" + s_SENIOR_CITIZEN + "','" + s_Existing_Account + "')";
               c.s.executeUpdate(query);
              setVisible(false);
            new SignupThree(s_formnumber).setVisible(true);
            }


        }catch (Exception a)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}


