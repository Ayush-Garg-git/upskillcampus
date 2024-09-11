package banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class Balance_enquiry extends JFrame implements ActionListener {
    JButton back;
    JLabel image;
    int balance = 0;
    String pin;
    Balance_enquiry(String pin){
        this.pin = pin;

        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);


        connection c = new connection();

        try{

            ResultSet rs = c.s.executeQuery("select * from data where pin = '"+pin+"'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception ae){
            System.out.println(ae);
        }

        JLabel text = new JLabel("Your Current Account Balance is : "+ balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBounds(150,300,600,30);
        image.add(text);



        back = new JButton("BACK");;
        back.setBounds(330,490,120 ,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        setSize(800,800);
        setLocation(360,0);
        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==back){
            setVisible(false);
            new Transaction_page(pin).setVisible(true);
        }

    }
    public static void main(String[] args) {
            new Balance_enquiry("");
    }


}
