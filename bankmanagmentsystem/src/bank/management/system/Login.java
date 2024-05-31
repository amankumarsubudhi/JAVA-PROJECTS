package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM");

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2=i1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 125, 125);
        add(label);


        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38) );
        text.setBounds(250, 58, 400, 58);
        add(text);

        JLabel cardno=new JLabel("Card No : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28) );
        cardno.setBounds(85, 165, 400, 40);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(248,175,400,30);
        add(cardTextField);

        JLabel pin=new JLabel("Pin No : ");
        pin.setFont(new Font("Raleway",Font.BOLD,28) );
        pin.setBounds(85, 225, 400, 40);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(248,235,400,30);
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(480,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,280,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.WHITE);


        setSize(800,480);
        setVisible(true);
        setLocation(260,130);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){
            Connect connection = new Connect();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where card_number = '"+cardnumber+"' and pin_number = '"+pinnumber+"'";
            try {
                ResultSet rs = connection.statement.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin Number");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);

        }
    }



    public static void main(String args[]){
        new Login();


    }
}