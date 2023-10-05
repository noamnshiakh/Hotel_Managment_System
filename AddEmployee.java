package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*;

public class AddEmployee extends JFrame implements ActionListener {
    JLabel lbname,lbage,jlbgender,jljob,lbsalary,lbphone,lbemail,lbaadhar;
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit,cancel;
    JComboBox cbjob;


    AddEmployee(){
        setLayout(null);

        lbname = new JLabel("NAME");
        lbname.setBounds(60,30,120,30);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        lbage = new JLabel("AGE");
        lbage.setBounds(60,80,120,30);
        lbage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbage);
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        jlbgender = new JLabel("GENDER");
        jlbgender.setBounds(60,130,120,30);
        jlbgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jlbgender);
        rbmale= new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        getContentPane().setBackground(Color.white);
        rbfemale = new JRadioButton("female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        getContentPane().setBackground(Color.white);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        jljob = new JLabel("JOB");
        jljob.setBounds(60,180,120,30);
        jljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jljob);
        String str[] = {"Select","Front Desk Clerke","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter", "Manager","Accountant","Receptionist"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        lbsalary = new JLabel("SALARY");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        lbphone = new JLabel("PHONE");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbphone);
        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        lbemail = new JLabel("EMAIL");
        lbemail.setBounds(60,330,120,30);
        lbemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbemail);
        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        lbaadhar = new JLabel("aadhar");
        lbaadhar.setBounds(60,380,120,30);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbaadhar);
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(60,430,150,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(240,430,150,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        setBounds(300,100,850,540);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();

            String gender = null;
            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbfemale.isSelected()) {
                gender = "Female";
            }
            String job = (String) cbjob.getSelectedItem();

            if(name == null){
                JOptionPane.showMessageDialog(null, "Enter Name");
                return;
            }
            else if(name.matches(".*[0-9].*")){
                JOptionPane.showMessageDialog(null, "Enter Valid Name");
                return;
            }
            if(age == null){
                JOptionPane.showMessageDialog(null, "Enter age");
                return;
            }else if(age.length() > 3 || validNumber(age)){
                JOptionPane.showMessageDialog(null,"Enter Valid Age");
                return;
            }
            if(gender == null){
                JOptionPane.showMessageDialog(null,"Select Gender");
                return;
            }
            if(job.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select job type");
                return;
            }
            if(salary.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Salary");
                return;
            }else if(!validNumber(salary)){
                JOptionPane.showMessageDialog(null,"Enter Valid Salary");
                return;
            }
            if(phone.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Phone Number");
                return;
            }else if(phone.length() != 10 || !validNumber(phone)){
                JOptionPane.showMessageDialog(null,"Enter Valid Phone Number");
                return;
            }
            if(email == null){
                JOptionPane.showMessageDialog(null,"Enter Email Id");
                return;
            }
            else if(!emailValid(email)){
                JOptionPane.showMessageDialog(null,"Enter Valid Email Id");
                return;
            }
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Aadhar Number");
                return;
            }else if(aadhar.length() != 12 || !validNumber(aadhar)){
                JOptionPane.showMessageDialog(null,"Enter Valid Aadhar Number");
                return;
            }
            try {
                Conn c = new Conn();
                String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
//            new Dashboard();
        }
    };
    public static boolean emailValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public boolean validNumber(String num) {
        for (char i : num.toCharArray()) {
            if (!Character.isDigit(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
