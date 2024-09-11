package banking.management.project;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class withdraw extends JFrame implements ActionListener {
    JLabel image, message;
    JButton withdraw_btn, back;
    JTextField amount;
    String w_pinumber;

    withdraw(String w_pin) {
        this.w_pinumber = w_pin;
        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);

        message = new JLabel("Enter the amount you want to Withdraw");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Raleway", Font.BOLD, 13));
        message.setBounds(130, 250, 400, 30);
        image.add(message);

        amount = new JTextField();
        amount.setForeground(Color.black);
        amount.setFont(new Font("Raleway", Font.BOLD, 13));
        amount.setBounds(110, 290, 280, 30);
        image.add(amount);

        withdraw_btn = new JButton();
        withdraw_btn = new JButton("Withdraw");
        ;
        withdraw_btn.setBounds(280, 420, 130, 25);
        withdraw_btn.setFont(new Font("Raleway", Font.BOLD, 15));
        withdraw_btn.addActionListener(this);
        image.add(withdraw_btn);

        back = new JButton();
        back = new JButton("Go Back");
        ;
        back.setBounds(280, 452, 130, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);

        setSize(700, 700);
        setLocation(400, 50);
        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String s_Amount_text = amount.getText();
            Date s_date = new Date();
            if (e.getSource() == withdraw_btn) {
                if (s_Amount_text.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a amount to Withdraw");
                } else {

                    connection conn = new connection();
                    ResultSet rs = conn.s.executeQuery("select * from data where pin = '" + this.w_pinumber + "'");
                    int balance = 0;

                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(s_Amount_text)) {
                        JOptionPane.showMessageDialog((Component) null, "Insuffient Balance");
                        return;
                    }
                    conn.s.executeUpdate("insert into data values('" + this.w_pinumber + "', '" + s_date + "', 'Withdrawl', '" + s_Amount_text + "')");
                    JOptionPane.showMessageDialog((Component) null, "Rs. " + s_Amount_text + " Debited Successfully");
                    this.setVisible(false);
                    (new Transaction_page(this.w_pinumber)).setVisible(true);
                }
            } else if (e.getSource() == this.back) {
                this.setVisible(false);
                (new Transaction_page(this.w_pinumber)).setVisible(true);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            System.out.println("error: " + var7);
        }

    }


    public static void main(String[] args) {
        new withdraw("");
    }
}



