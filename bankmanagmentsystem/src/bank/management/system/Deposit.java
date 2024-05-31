package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit,back;
    String pinnumber;

    Deposit(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To You Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,11));
        text.setBounds(136,225,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(210,280,90,30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setBounds(268,342,120,20);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,10));
        back.setBounds(268,392,120,20);
        back.addActionListener(this);
        image.add(back);


        setSize(680,680);
        setLocation(300,8);
        setUndecorated(true);
        setVisible(true);
    }




    public static void main(String[] args){
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter The Amount You Want To Deposit");
            }else {
                try {
                    Connect conn = new Connect();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }


            }

        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }
}
