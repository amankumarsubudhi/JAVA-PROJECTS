package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;

    JLabel pintext,repintext;
    JPasswordField pin,repin;
    JButton change,cancel;



    PinChange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_machine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(680,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,680,680);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBounds(182,225,700,35);
        image.add(text);

        pintext = new JLabel("ENTER NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,11));
        pintext.setBounds(120,275,300,20);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setBackground(Color.WHITE);
        pin.setFont(new Font("Raleway",Font.BOLD,11));
        pin.setBounds(245,275,120,20);
        image.add(pin);

        repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,11));
        repintext.setBounds(120,325,300,20);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setBackground(Color.WHITE);
        repin.setFont(new Font("Raleway",Font.BOLD,11));
        repin.setBounds(245,325,120,20);
        image.add(repin);

        change = new JButton("Proceed");
        change.setBounds(120,368,100,22);
        change.addActionListener(this);
        image.add(change);

        cancel = new JButton("Cancel");
        cancel.setBounds(288,368,100,22);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(680,680);
        setLocation(300,8);
        setUndecorated(true);
        setVisible(true);


    }

    public  void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN Does Not Match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                    return;
                }

                Connect c = new Connect();
                String q1 = "update bank set pin_number = '"+rpin+"' where pin_number = '"+pinnumber+"'";
                String q2 = "update login set pin_number = '"+rpin+"' where pin_number = '"+pinnumber+"'";
                String q3 = "update signupthree set pin_number = '"+rpin+"' where pin_number = '"+pinnumber+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);


            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }





    public static void main(String args[]){
        new PinChange("");
    }
}
