package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField,aadhaarTextField;
    JComboBox religionbox,categorybox,incomebox,educationbox,occupationbox;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;

    SignupTwo(String formno){

        this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails=new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,30));
        additionaldetails.setBounds(150,40,400,40);
        add(additionaldetails);

        JLabel religion=new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,120,150,30);
        add(religion);

        String valReligion[]={"Select","Hindu","Muslim","Sikh","Other"};
        religionbox=new JComboBox(valReligion);
        religionbox.setBackground(Color.WHITE);
        religionbox.setForeground(Color.BLACK);
        religionbox.setBounds(280,120,280,30);
        add(religionbox);

        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,170,150,30);
        add(category);

        String valCategory[]={"Select","GENERAL","OBC","SC","ST"};
        categorybox=new JComboBox(valCategory);
        categorybox.setBackground(Color.WHITE);
        categorybox.setForeground(Color.BLACK);
        categorybox.setBounds(280,170,280,30);
        add(categorybox);

        JLabel income=new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,220,150,30);
        add(income);

        String valincome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomebox=new JComboBox(valincome);
        incomebox.setBackground(Color.WHITE);
        incomebox.setForeground(Color.BLACK);
        incomebox.setBounds(280,220,280,30);
        add(incomebox);

        JLabel qualification=new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,270,150,30);
        add(qualification);

        String valeducation[]={"Select","Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        educationbox=new JComboBox(valeducation);
        educationbox.setBackground(Color.WHITE);
        educationbox.setForeground(Color.BLACK);
        educationbox.setBounds(280,270,280,30);
        add(educationbox);

        JLabel occupation=new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,320,150,30);
        add(occupation);

        String valoccupation[]={"Select","Salaried","Self-Employed","Bussiness","Student","Retired"};
        occupationbox=new JComboBox(valoccupation);
        occupationbox.setBackground(Color.WHITE);
        occupationbox.setForeground(Color.BLACK);
        occupationbox.setBounds(280,320,280,30);
        add(occupationbox);

        JLabel panno=new JLabel("PAN Number : ");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,370,150,30);
        add(panno);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(280,370,280,30);
        add(panTextField);

        JLabel aadhaarno=new JLabel("Aadhaar Number : ");
        aadhaarno.setFont(new Font("Raleway",Font.BOLD,20));
        aadhaarno.setBounds(100,420,180,30);
        add(aadhaarno);

        aadhaarTextField=new JTextField();
        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadhaarTextField.setBounds(280,420,280,30);
        add(aadhaarTextField);

        JLabel seniorcitizen=new JLabel("Senior Citizen : ");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,470,150,30);
        add(seniorcitizen);

        syes=new JRadioButton("Yes");
        syes.setBounds(320,470,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(420,470,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup scgroup=new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);

        JLabel exisiting=new JLabel("Exisiting Account : ");
        exisiting.setFont(new Font("Raleway",Font.BOLD,20));
        exisiting.setBounds(100,520,200,30);
        add(exisiting);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(320,520,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(420,520,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egroup=new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);

        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(480,570,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(700,680);
        setVisible(true);
        setLocation(380,80);

    }
    public void actionPerformed(ActionEvent ae){
        String religion=(String) religionbox.getSelectedItem();
        String category=(String) categorybox.getSelectedItem();
        String income=(String) incomebox.getSelectedItem();
        String educational_qualification=(String) educationbox.getSelectedItem();
        String occupation=(String) occupationbox.getSelectedItem();
        String pan_number=panTextField.getText();
        String aadhaar_number=aadhaarTextField.getText();

        String senior_citizen=null;
        if (syes.isSelected()){
            senior_citizen="Yes";
        }else if(sno.isSelected()){
            senior_citizen="No";
        }

        String existing_account=null;
        if (eyes.isSelected()){
            existing_account="Yes";
        }else if (eno.isSelected()){
            existing_account="No";
        }

        try{
            if(religion.equals("Select")){
                JOptionPane.showMessageDialog(null,"Religion Is Required !");
            }else if (category.equals("Select")){
                JOptionPane.showMessageDialog(null,"Category Is Required !");
            }else if(income.equals("Null")){
                JOptionPane.showMessageDialog(null,"Income Is Required !");
            }else if (educational_qualification.equals("Select")){
                JOptionPane.showMessageDialog(null,"Educational Qulification Is Required !");
            }else if (occupation.equals("Select")){
                JOptionPane.showMessageDialog(null,"Occupation Is Required !");
            }else if (pan_number.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Number Is Required !");
            }else if(aadhaar_number.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhaar Number Is Required !");
            }else if (senior_citizen.equals("")){
                JOptionPane.showMessageDialog(null,"Senior Citizen Is Not Selected !");
            }else if (existing_account.equals("")){
                JOptionPane.showMessageDialog(null,"Existing Account Is Not Selected !");
            }else {
                Connect connection2=new Connect();
                String q2="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+educational_qualification+"','"+occupation+"','"+pan_number+"','"+aadhaar_number+"','"+senior_citizen+"','"+existing_account+"')";
                connection2.statement.executeUpdate(q2);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
