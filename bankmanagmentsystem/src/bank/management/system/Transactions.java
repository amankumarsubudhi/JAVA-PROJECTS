package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;

    String pinnumber;

    Transactions(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBounds(148,225,700,35);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setBounds(120,317,120,20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setFont(new Font("Raleway",Font.BOLD,10));
        withdrawl.setBounds(268,317,120,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setFont(new Font("Raleway",Font.BOLD,10));
        fastcash.setBounds(120,342,120,20);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setFont(new Font("Raleway",Font.BOLD,10));
        ministatement.setBounds(268,342,120,20);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setFont(new Font("Raleway",Font.BOLD,10));
        pinchange.setBounds(120,367,120,20);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setFont(new Font("Raleway",Font.BOLD,10));
        balanceenquiry.setBounds(268,367,120,20);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD,10));
        exit.setBounds(268,392,120,20);
        exit.addActionListener(this);
        image.add(exit);

        setSize(680,680);
        setLocation(300,8);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else  if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else  if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            setVisible(true);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args){
        new Transactions("");

    }
}
