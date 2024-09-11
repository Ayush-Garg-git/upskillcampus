package banking.management.project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PIN_CHANGE extends JFrame implements ActionListener {
    JLabel image, re_confirm;
    JButton change_btn, back_btn;

    JPasswordField Pin_text, re_text;
    String PIN;

    PIN_CHANGE(String pin) {
        this.PIN = pin;

        setLayout(null);
        setTitle("BANK Information System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);


        JLabel text = new JLabel("Change your pin");
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 270, 400, 30);
        image.add(text);


        JLabel new_pin = new JLabel("New pin :");
        new_pin.setFont(new Font("Raleway", Font.BOLD, 18));
        new_pin.setForeground(Color.WHITE);
        new_pin.setBounds(140, 330, 150, 30);
        image.add(new_pin);

        Pin_text = new JPasswordField();
        Pin_text.setBounds(315, 335, 140, 25);
        Pin_text.setFont(new Font("Raleway", Font.BOLD, 13));
        Pin_text.setForeground(Color.BLACK);
        image.add(Pin_text);


        re_confirm = new JLabel("Re-Enter your pin :");
        re_confirm.setFont(new Font("Raleway", Font.BOLD, 18));
        re_confirm.setForeground(Color.WHITE);
        re_confirm.setBounds(140, 370, 300, 30);
        image.add(re_confirm);

        re_text = new JPasswordField();
        re_text.setBounds(315, 375, 140, 25);
        re_text.setFont(new Font("Raleway", Font.BOLD, 13));
        re_text.setForeground(Color.BLACK);
        image.add(re_text);


        change_btn = new JButton("CHANGE");
        ;
        change_btn.setBounds(350, 470, 100, 25);
        change_btn.setForeground(Color.BLACK);
        change_btn.setFont(new Font("Raleway", Font.BOLD, 13));
        change_btn.addActionListener(this);
        image.add(change_btn);

        back_btn = new JButton("BACK");
        ;
        back_btn.setBounds(350, 500, 100, 25);
        back_btn.setForeground(Color.BLACK);
        back_btn.setFont(new Font("Raleway", Font.BOLD, 13));
        back_btn.addActionListener(this);
        image.add(back_btn);


        setSize(800, 800);
        setLocation(360, 0);
//        setUndecorated(true);  // remove borders of our frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String s_npin = Pin_text.getText();
            String s_rpin = re_text.getText();
            if (!s_npin.equals(s_rpin)) {
                JOptionPane.showMessageDialog(null, "Your pin does not matches with new pin or you have to re-confirm the pin");
                return;
            }


            if (e.getSource() == change_btn) {
                if (s_npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "please Enter pin to change");
                    return;
                }
                if (s_rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "RE-ENTER New Pin");
                }

                connection c = new connection();
                String query = "update data set pin = '" + s_rpin + "' where pin = '" + PIN + "' ";
                String query2 = "update login set pin = '" + s_rpin + "' where pin = '" + PIN + "' ";
                String query3 = "update signupthree set PIN_NUMBER = '" + s_rpin + "' where PIN_NUMBER = '" + PIN + "' ";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                setVisible(false);
                (new Transaction_page(s_rpin)).setVisible(true);

            } else if (e.getSource() == back_btn) {
                (new Transaction_page(s_rpin)).setVisible(true);
                setVisible(false);
            }


        }catch(Exception var8){
            var8.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PIN_CHANGE("").setVisible(true);
    }}



