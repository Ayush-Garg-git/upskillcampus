package banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {

    Long FormDigit;
    JLabel formno,text , Name , fatherName , dob ,gender , emailadd,ms,address,City,State,Pincode;
    JTextField nameText,ftext,emailText,PinText,Citytext,Statetext,AdressText;
    JDateChooser dateChooser;
    JRadioButton married,unmarried,male,female,other;
    JButton next;
    SignupOne(){
        setLayout(null);



        // random Form number generation
        Random ran = new Random();
        FormDigit = Math.abs((ran.nextLong() % 9000l ) + 1000l) ;


         formno= new JLabel("Application form No : " + FormDigit );
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(160,10,500,40);
        add(formno);

         text= new JLabel("Page 1 : Personal Details");
        text.setFont(new Font("Osward",Font.BOLD,22));
        text.setBounds(210,55 ,400 ,35);

        add(text);


        // text boxes
         Name= new JLabel("NAME :");
        Name.setFont(new Font("Osward",Font.BOLD,20));
        Name.setBounds(100,120,100,30);

        add(Name);
         nameText = new JTextField();
        nameText.setFont(new Font("Osward",Font.BOLD,20));
        nameText.setBounds(300,120,400,30);
        add(nameText);

         fatherName= new JLabel("Father's Name :");
        fatherName.setFont(new Font("Osward",Font.BOLD,20));
        fatherName.setBounds(100,170,200,30);
        add(fatherName);
         ftext = new JTextField();
        ftext.setFont(new Font("Osward",Font.BOLD,20));
        ftext.setBounds(300,170,400,30);
        add(ftext);

         dob= new JLabel("Date of birth :");
        dob.setFont(new Font("Osward",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

         gender= new JLabel("Gender :");
        gender.setFont(new Font("Osward",Font.BOLD,20));
        gender.setBounds(100,270,100,30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,270,100,20);
        male.setBackground(Color.white);
        add(male);
         female = new JRadioButton("Female");
        female.setBounds(450,270,100,20);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        emailadd= new JLabel("Email Address :");
        emailadd.setFont(new Font("Osward",Font.BOLD,20));
        emailadd.setBounds(100,320,200,30);
        add(emailadd);
         emailText = new JTextField();
        emailText.setFont(new Font("Osward",Font.BOLD,20));
        emailText.setBounds(300,320,400,30);
        add(emailText);

         ms= new JLabel("Martial Status :");
        ms.setFont(new Font("Osward",Font.BOLD,20));
        ms.setBounds(100,370,200,30);
        add(ms);
         married = new JRadioButton("Married");
        married.setBounds(300,375,100,20);
        married.setBackground(Color.white);
        add(married);
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,375,100,20);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600,375,100,20);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup martial = new ButtonGroup();
        martial.add(married);
        martial.add(unmarried);
        martial.add(other);



        address= new JLabel("Address :");
        address.setFont(new Font("Osward",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);
         AdressText = new JTextField();
        AdressText.setFont(new Font("Osward",Font.BOLD,20));
        AdressText.setBounds(300,420,400,30);
        add(AdressText);


         City= new JLabel("City :");
        City.setFont(new Font("Osward",Font.BOLD,20));
        City.setBounds(100,470,200,30);
        add(City);
         Citytext = new JTextField();
        Citytext.setFont(new Font("Osward",Font.BOLD,20));
        Citytext.setBounds(300,470,400,30);
        add(Citytext);

         State= new JLabel("State :");
        State.setFont(new Font("Osward",Font.BOLD,20));
        State.setBounds(100,520,200,30);
        add(State);
        Statetext = new JTextField();
        Statetext.setFont(new Font("Osward",Font.BOLD,20));
        Statetext.setBounds(300,520,400,30);
        add(Statetext);

         Pincode= new JLabel("Enter Pincode :");
        Pincode.setFont(new Font("Osward",Font.BOLD,20));
        Pincode.setBounds(100,570,200,30);
        add(Pincode);
         PinText = new JTextField();
        PinText.setFont(new Font("Osward",Font.BOLD,20));
        PinText.setBounds(300,570,400,30);

        add(PinText);

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

        String formnumber = " " + FormDigit;
            String name = nameText.getText();
            String Fname = ftext.getText();
            String DOB = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String GENDER = null;
            if (male.isSelected()){
                GENDER = "MAlE";
            }else if (female.isSelected()){
                GENDER = "FEMALE";
            }

            String EMAIL = emailText.getText();
            String MARTIAL = null;
            if(married.isSelected()){
                MARTIAL = "Married";
            }else if(unmarried.isSelected()){
                MARTIAL ="Unmarried";
            } else if (other.isSelected()) {
                MARTIAL = "other";
            }
        String CITY = Citytext.getText();
        String PIN = PinText.getText();
        String ADDRESS = AdressText.getText();
        String STATE = Statetext.getText();


        try{
        if (name.equals("") && PIN.equals("")){
            JOptionPane.showMessageDialog(null," NAME AND PINCODE IS REQUIRED !"); // this is for a pop up notification for a user if he/shee didn't enter name
        } else if (PIN.equals("")) {
            JOptionPane.showMessageDialog(null,"PINCODE IS REQUIRED !");
        }else if(name.equals("")){
            JOptionPane.showMessageDialog(null,"NAME IS REQUIRED !");
        }else {
            connection c = new connection();
            String query = "insert into signupone values('" + formnumber + "','" + name + "','" + Fname + "','" + MARTIAL + "','" + ADDRESS + "','" + STATE+ "','" + PIN + "','" + DOB + "','" + EMAIL + "','" + CITY + "','" + GENDER + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formnumber).setVisible(true);
        }
    }catch (Exception a)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
    new SignupOne();
    }
}
