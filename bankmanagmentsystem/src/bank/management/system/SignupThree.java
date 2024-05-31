package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6;

    JRadioButton agree;

    JButton submit,cancel;

    String formno;

    SignupThree(String formno){

        this.formno = formno;

        setLayout(null);

        JLabel l1=new JLabel("Page : 3 Account Details");
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        l1.setBounds(250,30,600,40);
        add(l1);

        JLabel accounttype=new JLabel("Account Type : ");
        accounttype.setBackground(Color.WHITE);
        accounttype.setFont(new Font("Raleway",Font.BOLD,20));
        accounttype.setBounds(100,100,200,30);
        add(accounttype);

        r1=new JRadioButton("Saving Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBounds(100,130,300,30);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBounds(420,130,300,30);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBounds(100,180,300,30);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBounds(420,180,300,30);
        add(r4);

        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card=new JLabel("Card Number : ");
        card.setBackground(Color.WHITE);
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,230,200,30);
        add(card);

        JLabel cardNumber=new JLabel("XXXX-XXXX-XXXX-4862");
        cardNumber.setBackground(Color.WHITE);
        cardNumber.setFont(new Font("Raleway",Font.BOLD,20));
        cardNumber.setBounds(320,230,350,30);
        add(cardNumber);

        JLabel cardinfo=new JLabel("Your 16 Digit Card Number");
        cardinfo.setBackground(Color.WHITE);
        cardinfo.setFont(new Font("Raleway",Font.BOLD,12));
        cardinfo.setBounds(100,260,180,18);
        add(cardinfo);

        JLabel pin=new JLabel("PIN : ");
        pin.setBackground(Color.WHITE);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,290,200,30);
        add(pin);

        JLabel pinNumber=new JLabel("XXXX");
        pinNumber.setBackground(Color.WHITE);
        pinNumber.setFont(new Font("Raleway",Font.BOLD,20));
        pinNumber.setBounds(320,290,250,30);
        add(pinNumber);

        JLabel pininfo=new JLabel("Your 4 Digit Password");
        pininfo.setBackground(Color.WHITE);
        pininfo.setFont(new Font("Raleway",Font.BOLD,12));
        pininfo.setBounds(100,320,180,18);
        add(pininfo);

        JLabel service=new JLabel("Service Required : ");
        service.setBackground(Color.WHITE);
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100,350,200,30);
        add(service);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);

        c2=new JCheckBox("Mobile Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(100,450,200,30);
        add(c2);

        c3=new JCheckBox("Cheque Book");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,500,200,30);
        add(c3);

        c4=new JCheckBox("Internet Banking");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(450,400,200,30);
        add(c4);

        c5=new JCheckBox("EMAIL & SMS Alerts");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(450,450,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(450,500,200,30);
        add(c6);

        agree=new JRadioButton("I hereby declares that the above entered details are correct to the best of my knowledge");
        agree.setBackground(Color.WHITE);
        agree.setFont(new Font("Raleway",Font.BOLD,12));
        agree.setBounds(100,550,600,30);
        add(agree);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(200,620,120,40);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(440,620,120,40);
        cancel.addActionListener(this);
        add(cancel);




        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String accounttype = null;
            if (r1.isSelected()) {
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accounttype = "Current Account";
            } else if (r4.isSelected()) {
                accounttype = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs(random.nextLong() % 90000000L + 801856772000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card,";
            } else {
            }

            if (c2.isSelected()) {
                facility = facility + " Mobile Banking,";
            } else {
            }

            if (c3.isSelected()) {
                facility = facility + "Cheque Book,";
            } else {
            }
            if (c4.isSelected()) {
                facility = facility + "Internet Banking,";
            } else {
            }
            if (c5.isSelected()) {
                facility = facility + "EMAIL & SMS Alerts,";
            } else {
            }
            if (c6.isSelected()) {
                facility = facility + "E-Statement";
            } else {
            }


            try{
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Is Required !");
                }else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null,"Serviced Required Is Required !");
                }else {
                    Connect connection3 = new Connect();
                    String q3="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String q4="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    connection3.statement.executeUpdate(q3);
                    connection3.statement.executeUpdate(q4);

                    JOptionPane.showMessageDialog(null,"Card Number - " + cardnumber + "\n Pin Number - " + pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            }catch (Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == cancel){

            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String[] args){
        new SignupThree("");
    }
}
