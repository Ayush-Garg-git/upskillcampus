package banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener  {
    JLabel title,Account,card_no,card_no2,number,Pin_no,p_number,pin_no2,services;
    JRadioButton saving , fixed ,current , recurring;
    JCheckBox check1,check2,check3,check4,check5,check6,check7;
    JButton submit,cancel;
    String form_number3;
    SignupThree(String form){
        this.form_number3 = form;
        setLayout(null);

          title =  new JLabel("Page 3 : Account Details");
         title.setFont(new Font("Osward",Font.BOLD,24));
         title.setBounds(210,25 ,400 ,35);
         add(title);

          Account =  new JLabel("Account Type");
         Account.setFont(new Font("Osward",Font.BOLD,21));
         Account.setBounds(70,80 ,400 ,35);
         add(Account);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBounds(100,125,180,40);
        saving.setBackground(Color.white);
        add(saving);
        fixed = new JRadioButton("Fixed Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBounds(310,125,180,40);
        fixed.setBackground(Color.white);
        add(fixed);
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBounds(100,185,180,40);
        current.setBackground(Color.white);
        add(current);
        recurring = new JRadioButton("Recurring Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBounds(310,185,180,40);
        recurring.setBackground(Color.white);
        add(recurring);
        ButtonGroup account_type = new ButtonGroup();
        account_type.add(saving);
        account_type.add(recurring);
        account_type.add(current);
        account_type.add(fixed);



         card_no =  new JLabel("Card Number :");
        card_no.setFont(new Font("Osward",Font.BOLD,22));
        card_no.setBounds(70,250 ,200 ,35);
        add(card_no);
         card_no2 =  new JLabel("Your 14 Digit card Number");
        card_no2.setFont(new Font("Osward",Font.BOLD,12));
        card_no2.setBounds(70,270 ,300 ,35);
        add(card_no2);
        number = new JLabel("XXXX-XXXX-XXXX-3456");
        number.setFont(new Font("Osward",Font.BOLD,18));
        number.setBounds(310,250 ,400 ,35);
        add(number);


        Pin_no =  new JLabel("Pin Number :");
        Pin_no.setFont(new Font("Osward",Font.BOLD,22));
        Pin_no.setBounds(70,325 ,200 ,35);
        add(Pin_no);
         pin_no2 =  new JLabel("Your 4 Digit Pin Number");
        pin_no2.setFont(new Font("Osward",Font.BOLD,12));
        pin_no2.setBounds(70,345 ,300 ,35);
        add(pin_no2);
        p_number = new JLabel("XXXX");
        p_number.setFont(new Font("Osward",Font.BOLD,18));
        p_number.setBounds(310,325 ,200 ,35);
        add(p_number);


        services = new JLabel("Services Required");
        services.setFont(new Font("Osward",Font.BOLD,20));
        services.setBounds(70,410,300,30);
        add(services);

        check1 = new JCheckBox("Atm Required");
        check1.setFont(new Font("Osward",Font.BOLD,16));
        check1.setBounds(90,460,200,25);
        check1.setBackground(Color.WHITE);
        add(check1);
        check2 = new JCheckBox("Net Banking");
        check2.setFont(new Font("Osward",Font.BOLD,16));
        check2.setBounds(350,460,200,25);
        check2.setBackground(Color.WHITE);
        add(check2);
        check3 = new JCheckBox("Mobile banking");
        check3.setFont(new Font("Osward",Font.BOLD,16));
        check3.setBounds(90,510,200,25);
        check3.setBackground(Color.WHITE);
        add(check3);
        check4 = new JCheckBox("Email & Sms Alerts");
        check4.setFont(new Font("Osward",Font.BOLD,16));
        check4.setBounds(350,510,200,25);
        check4.setBackground(Color.WHITE);
        add(check4);
        check5 = new JCheckBox("Cheque Book");
        check5.setFont(new Font("Osward",Font.BOLD,16));
        check5.setBounds(90,560,200,25);
        check5.setBackground(Color.WHITE);
        add(check5);
        check6 = new JCheckBox("E-Statement");
        check6.setFont(new Font("Osward",Font.BOLD,16));
        check6.setBounds(350,560,200,25);
        check6.setBackground(Color.WHITE);
        add(check6);
        check7 = new JCheckBox("I hereby declare that the above data entered are correct to the best of my knowledge");
        check7.setFont(new Font("Osward",Font.BOLD,12));
        check7.setBounds(70,600,600,25);
        check7.setBackground(Color.WHITE);
        add(check7);

            submit = new JButton("Submit");
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.white);
            submit.setFont(new Font("Raleway",Font.BOLD,14));
            submit.setBounds(350,650,110,25);
            submit.addActionListener(this);
            add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(510,650,110,25);
        cancel.addActionListener(this);
        add(cancel);


        setSize(680, 750);
        setVisible(true);
        setLocation(350,25);
        getContentPane().setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)){

            String s_Account = null;
            if (saving.isSelected()){
                s_Account = "Saving Account";
            } else if (fixed.isSelected()) {
                s_Account ="Fixed Account";
            } else if (recurring.isSelected()) {
                s_Account = "Reccuring Account";
            }else if(current.isSelected()) {
                s_Account = "Current Account";
            }else{
                s_Account = "Null";
            }

            String s_form_number = " " + form_number3;
            Random random = new Random();
            String s_Cardnumber = "" + Math.abs((random.nextLong() % 90000000l) + 8092546000000000l);
            String s_pin = ""+ Math.abs((random.nextLong() % 9000l) + 1000l);

            String faciltiy = " ";
            if(check1.isSelected()){
                faciltiy = faciltiy + "Atm required";
            } else if (check2.isSelected()) {
                faciltiy = faciltiy + " Net Banking";
            } else if (check3.isSelected()) {
                faciltiy = faciltiy + " Mobile banking";
            } else if (check4.isSelected()) {
                faciltiy = faciltiy + " Email & SmS alerts";
            } else if (check5.isSelected()) {
                faciltiy = faciltiy + " Cheque book";
            } else if (check6.isSelected()) {
                faciltiy = faciltiy + " E-Statement";
            }

            try{
                if (check7.isSelected()== false){
                    JOptionPane.showMessageDialog(null,"please ensure the data is correct"); // this is for a pop up notification for a user if he/shee didn't enter name

                }
            else  {
                    connection c = new connection();

                    String query = "insert into signupThree values('" + s_form_number + "','" + s_Account+ "','" + s_Cardnumber+ "','" + s_pin + "','" + faciltiy + "')";
                    String query1 = "insert into login values('" + s_form_number +"','" + s_Cardnumber + "','" + s_pin+ "')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Congrats!"+"\n"+"Your card number is :"+s_Cardnumber+"\n"+"PIN NUMBER :"+s_pin+"\n"+"**keep this  Cardnumber and pin number safe  to login your account in future**");
                    setVisible(false);
                    new deposit(s_pin).setVisible(true);
                }
            }catch (Exception ae)
            {
                System.out.println(ae);
            }



        }
        else if (e.getSource()==(cancel)){
            setVisible(false);
          new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }


}
