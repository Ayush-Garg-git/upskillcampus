package banking.management.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class Login extends JFrame implements ActionListener {
    JButton login ,clear, signup;
    JTextField cardtext;
    JPasswordField pintext;
    Login() {


        // it adds atm logo in our PANel
        setTitle("ATM MACHINE");
        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//        Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel label = new JLabel(i3);
//        label.setBounds(70,10,100,100);
//        add(label);

        // for WElcome to atm  text

        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(200,40,400,40);
        add(text);

//        card number

        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,36));
        cardno.setBounds(100,150,200,30);
        add(cardno);
        cardtext = new JTextField();
        cardtext.setBounds(300,150,260,30);
        cardtext.setFont(new Font("arial",Font.BOLD,16));
        add(cardtext);

        // for pin number
        JLabel pin= new JLabel("Pin :");
        pin.setFont(new Font("Osward",Font.BOLD,35));
        pin.setBounds(100,240,200,30);
        add(pin);
        pintext = new JPasswordField();
        pintext.setBounds(300,240,260,30);
        pintext.setFont(new Font("arial",Font.BOLD,16));
        add(pintext);
        // for background color white of panel
        getContentPane().setBackground(Color.white);

// buttons
         login = new JButton("Sign In");
        login.setBounds(300,310,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

//        2nd button
         clear = new JButton("CLEAR");
        clear.setBounds(450,310,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
// 3rd Button
        signup = new JButton("Sign UP");
        signup.setBounds(300,360,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);



        // for panel creation
        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()== clear){
        cardtext.setText("");
        pintext.setText("");
    } else if (e.getSource()== signup) {
        setVisible(false);// it is for when user click on the signup button the current panel will close
        new SignupOne().setVisible(true); // it is for when user click signup the new panel will open
    } else if (e.getSource()== login) {
        connection conn = new connection();
        String cardnumber = cardtext.getText();
        String pinnumber = pintext.getText();
        String query = "select * from login where Cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";

        try{
         ResultSet result = conn.s.executeQuery(query);

         if (result.next()){
             setVisible(false);
             new Transaction_page(pinnumber).setVisible(true);
         }else {
             JOptionPane.showMessageDialog(null,"Incorrect Cardnumber Or PIN");
         }
        }catch(Exception ae){
            System.out.println(ae);
        }

    }
    }
}

public class ayush{

    public static void main(String args[]){
        new Login();
    }
}


