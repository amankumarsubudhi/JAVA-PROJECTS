package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber;
    JLabel mini,bank,card,balance;

    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        setLayout(null);

        mini = new JLabel();
        add(mini);

        bank = new JLabel("State Bank Of India");
        bank.setBounds(150,20,200,20);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20,400,320,20);
        add(balance);

        try{
            Connect c = new Connect();
            ResultSet rs = c.statement.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : " +rs.getString("card_number").substring(0,4) + "XXXXXXXXXXXXXX" + rs.getString("card_number").substring(10));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Connect d = new Connect();
            int bal = 0;
            ResultSet rs = d.statement.executeQuery("select * from bank where pin_number = '"+pinnumber+"' ");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")  + "<br><br><html>" );
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance Is Rs " +bal);

        }catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }



    public static void main(String args[]){

        new MiniStatement("");

    }
}
