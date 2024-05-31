package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    Withdrawl(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To You Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,11));
        text.setBounds(136,225,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(210,280,90,30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway",Font.BOLD,10));
        withdraw.setBounds(268,342,120,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw){
            String number = amount.getText();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter The Amount You Want To Deposit");
            }else {
                try {
                    Connect conn = new Connect();
                    ResultSet rs = conn.statement.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
                    int balance = 0;
                    while (rs.next()){
                        if (rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (ae.getSource() != back && balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + number + "')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
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
