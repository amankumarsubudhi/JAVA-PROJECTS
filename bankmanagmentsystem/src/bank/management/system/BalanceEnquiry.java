package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        back = new JButton("Back");
        back.setBounds(288,368,100,22);
        back.addActionListener(this);
        image.add(back);


        Connect c = new Connect();
        int balance = 0;
        try {
            ResultSet rs = c.statement.executeQuery("select * from bank where pin_number = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance Is Rs " +balance );
        text.setForeground(Color.WHITE);
        text.setBounds(140,230,400,25);
        image.add(text);

        setSize(680,680);
        setLocation(300,8);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }


public static void main(String args[]){
    new BalanceEnquiry("");
}
}
