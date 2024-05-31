package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton r100,r500,r1000,r2000,r5000,r10000,back;

    String pinnumber;

    FastCash(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBounds(148,225,700,35);
        image.add(text);

        r100 = new JButton("Rs 100");
        r100.setFont(new Font("Raleway",Font.BOLD,10));
        r100.setBounds(120,317,120,20);
        r100.addActionListener(this);
        image.add(r100);

        r500 = new JButton("Rs 500");
        r500.setFont(new Font("Raleway",Font.BOLD,10));
        r500.setBounds(268,317,120,20);
        r500.addActionListener(this);
        image.add(r500);

        r1000 = new JButton("Rs 1000");
        r1000.setFont(new Font("Raleway",Font.BOLD,10));
        r1000.setBounds(120,342,120,20);
        r1000.addActionListener(this);
        image.add(r1000);

        r2000 = new JButton("Rs 2000");
        r2000.setFont(new Font("Raleway",Font.BOLD,10));
        r2000.setBounds(268,342,120,20);
        r2000.addActionListener(this);
        image.add(r2000);

        r5000 = new JButton("Rs 5000");
        r5000.setFont(new Font("Raleway",Font.BOLD,10));
        r5000.setBounds(120,367,120,20);
        r5000.addActionListener(this);
        image.add(r5000);

        r10000 = new JButton("Rs 10000");
        r10000.setFont(new Font("Raleway",Font.BOLD,10));
        r10000.setBounds(268,367,120,20);
        r10000.addActionListener(this);
        image.add(r10000);

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

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);

            Connect c = new Connect();
            try{
                ResultSet rs = c.statement.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs '"+amount+"' Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args){
        new FastCash("");

    }
}
