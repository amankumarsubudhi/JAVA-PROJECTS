package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,
            cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway",Font.BOLD,35));
        formno.setBounds(100,20,600,30);
        add(formno);

        JLabel personalDetails=new JLabel("Page 1 : Pesonal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        personalDetails.setBounds(200,70,400,30);
        add(personalDetails);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,120,350,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,180,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,170,350,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,180,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,220,220,30);
        add(dateChooser);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,120,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,270,150,30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(500,270,150,30);
        female.setBackground(Color.WHITE);
        add(female);



        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,250,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,320,350,30);
        add(emailTextField);

        JLabel marital=new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,370,250,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300,370,90,30);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(420,370,90,30);
        add(unmarried);

        other=new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(550,370,90,30);
        add(other);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,250,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,420,350,30);
        add(addressTextField);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,250,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,470,350,30);
        add(cityTextField);

        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,250,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,520,350,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,570,250,30);
        add(pincode);

        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,570,350,30);
        add(pincodeTextField);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550,615,150,40);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(700,680);
        setVisible(true);
        setLocation(380,80);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if (female.isSelected()){
            gender="Female";
        }


    String email=emailTextField.getText();

    String marital=null;
        if(married.isSelected()){
        marital="Married";
    }else if (unmarried.isSelected()){
        marital="Unmarried";
    }else if(other.isSelected()){
            marital="Other";
    }

        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name Is Required !");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name Is Required !");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date Of Birth Is Required !");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender Is Required !");
            }else if(email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Email Address Is Required !");
            }else if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status Is Required !");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address Is Required !");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City Required !");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State Is Required !");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code Is Required !");
            }else {
                Connect connection = new Connect();
                String q="insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                connection.statement.executeUpdate(q);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
}
    public static void main(String[] args){
        new SignupOne();
    }
}