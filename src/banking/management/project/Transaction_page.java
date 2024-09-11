package banking.management.project;

import javax.swing.*;
import java.awt.*; // contains Image class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction_page extends JFrame implements ActionListener {
    JLabel image ,note;
    JButton deposit , withdraw , cash , ministatement , pinchange ,Balance,Exit ;
    String T_pinumber;
    Transaction_page(String t_pin){
        this.T_pinumber =t_pin;
        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        note = new JLabel("Please Select your transactions");
        note.setBounds(170,270,600,35);
        note.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(note);

        deposit = new JButton("Deposit");;
        deposit.setBounds(140,400,140 ,25);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);

        cash = new JButton("Cash");;
        cash.setBounds(310,400,140 ,25);
        cash.setFont(new Font("Raleway",Font.BOLD,15));
        cash.addActionListener(this);
        image.add(cash);

        withdraw = new JButton("Withdraw");;
        withdraw.setBounds(140,430,140 ,25);
        withdraw.setFont(new Font("Raleway",Font.BOLD,15));
        withdraw.addActionListener(this);
        image.add(withdraw);

        ministatement = new JButton("Mini-Statement");;
        ministatement.setBounds(310,430,140 ,25);
        ministatement.setFont(new Font("Raleway",Font.BOLD,13));
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");;
        pinchange.setBounds(140,460,140 ,25);
        pinchange.setFont(new Font("Raleway",Font.BOLD,15));
        pinchange.addActionListener(this);
        image.add(pinchange);

        Balance = new JButton("Balance enquiry");;
        Balance.setBounds(310,460,140 ,25);
        Balance.setFont(new Font("Raleway",Font.BOLD,13));
        Balance.addActionListener(this);
        image.add(Balance);

        Exit = new JButton("Exit");;
        Exit.setBounds(350,490,100 ,25);
        Exit.setFont(new Font("Raleway",Font.BOLD,13));
        Exit.addActionListener(this);
        image.add(Exit);





        setSize(800,800);
        setLocation(360,0);
        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Exit){
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new deposit(T_pinumber).setVisible(true);
        } else if (e.getSource()==withdraw) {
            setVisible(false);
            new withdraw(T_pinumber).setVisible(true);
        } else if (e.getSource()==cash) {
            setVisible(false);
            new fast_cash(T_pinumber).setVisible(true);
        } else if (e.getSource()==pinchange) {
            setVisible(false);
            new PIN_CHANGE(T_pinumber).setVisible(true);
        } else if (e.getSource()==Balance){
            setVisible(false);
            new Balance_enquiry(T_pinumber).setVisible(true);

        }else if(e.getSource()==ministatement){
            new MiniStatement(T_pinumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Transaction_page("");
    }


}
