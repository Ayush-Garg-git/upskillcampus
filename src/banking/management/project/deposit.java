package banking.management.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    JLabel image , message;
    JButton Deposit_btn, back;
    JTextField amount;
    String D_pinumber;
    deposit(String d_pin){
        this.D_pinumber = d_pin;
        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        message = new JLabel("Enter the amount you want to deposit");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Raleway",Font.BOLD,13));
        message.setBounds(140,240,400,30);
        image.add(message);

       amount = new JTextField();
        amount.setForeground(Color.black);
        amount.setFont(new Font("Raleway",Font.BOLD,13));
        amount.setBounds(110,290,280,30);
        image.add(amount);

        Deposit_btn = new JButton();
        Deposit_btn = new JButton("Deposit");;
        Deposit_btn.setBounds(280,420,130 ,25);
        Deposit_btn.setFont(new Font("Raleway",Font.BOLD,15));
        Deposit_btn.addActionListener(this);
        image.add(Deposit_btn);

        back = new JButton();
        back = new JButton("Go Back");;
        back.setBounds(280,452,130 ,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);

        setSize(700,700);
        setLocation(400,50);
        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== Deposit_btn){
            String s_Amount_text = amount.getText();
            Date s_date = new Date();
            if (s_Amount_text.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter a amount to Deposit");
            }else {
                try {
                    connection conn = new connection();
                    String query = "insert into data values('"+D_pinumber+"','"+s_date+"','Deposit','"+s_Amount_text+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Congrats! Rupees "+s_Amount_text+" Deposited successfully ");
                    setVisible(false);
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }

        } else if (e.getSource()==back) {
                setVisible(false);
                new Transaction_page(D_pinumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new deposit("");
    }

}
