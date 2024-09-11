package banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import  java.util.Date;

public class fast_cash extends JFrame implements ActionListener {
    JLabel image ,note;
    JButton one , five, one_t , two_t , five_t , ten_t,back;
    String pin;
    fast_cash(String f_pinnumber) {
        this.pin =  f_pinnumber;

        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        note = new JLabel("Select Withdrawal Amount");
        note.setBounds(190,290,600,35);
        note.setForeground(Color.WHITE);
        note.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(note);


        one = new JButton("Rs 100");
        one.setBounds(140,400,130,30);
        one.setFont(new Font("Raleway",Font.BOLD,14));
        one.addActionListener(this);

        image.add(one);

        five = new JButton("Rs 500");
        five.setBounds(330,400,130,30);
        five.setFont(new Font("Raleway",Font.BOLD,14));
        five.addActionListener(this);

        image.add(five);

        two_t = new JButton("Rs 2000");
        two_t.setBounds(330,435,130,30);
        two_t.setFont(new Font("Raleway",Font.BOLD,14));
        two_t.addActionListener(this);

        image.add(two_t);

        one_t = new JButton("Rs 1000");
        one_t.setBounds(140,435,130,30);
        one_t.setFont(new Font("Raleway",Font.BOLD,14));
        one_t.addActionListener(this);

        image.add(one_t);

        five_t = new JButton("Rs 5000");
        five_t.setBounds(140,470,130,30);
        five_t.setFont(new Font("Raleway",Font.BOLD,14));
        five_t.addActionListener(this);

        image.add(five_t);

        ten_t = new JButton("Rs 10000");
        ten_t.setBounds(330,470,130,30);
        ten_t.setFont(new Font("Raleway",Font.BOLD,14));
        ten_t.addActionListener(this);

        image.add(ten_t);

        back = new JButton("Back");
        back.setBounds(330,505,130,25);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.addActionListener(this);
        back.addActionListener(this);
        image.add(back);


        setSize(800,700);
        setLocation(360,50);
        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            try{
                String amount = ((JButton)e.getSource()).getText().substring(3);
                connection c = new connection();
                ResultSet rs = c.s.executeQuery("select * from data where pin = '"+pin+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                if (e.getSource() == back) {
                    this.setVisible(false);
                    new Transaction_page(pin).setVisible(true);
                }else{
                    Date date = new Date();
                    c.s.executeUpdate("insert into data values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transaction_page(pin).setVisible(true);
                }
            }catch (Exception z ){
                System.out.println(z);
            }
        }


    public static void main(String[] args) {
        new fast_cash("").setVisible(true);
    }
    }


