package Hotel.Managment.System;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JLabel lbname,lbage,lbgender,lbcompany,lbmodel,lbavailable,lblocation;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JButton addDriver,cancel;
    JComboBox avCombo,genderCombo;
    AddDriver(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heding = new JLabel("Add Drivers");
        heding.setForeground(Color.black);
        heding.setFont(new Font("tahoma",Font.BOLD,20));
        heding.setBounds(150,20,900,30);
        add(heding);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,540,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,70,500,300);
        add(image);

        lbname = new JLabel(" Full name");
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbname.setBounds(60,80,120,20);
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(200,80,120,20);
        add(tfname);

        lbage = new JLabel("Age");
        lbage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbage.setBounds(60,120,120,20);
        add(lbage);
        tfage = new JTextField();
        tfage.setBounds(200,120,120,20);
        add(tfage);

        lbgender = new JLabel("Gender");
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbgender.setBounds(60,160,120,20);
        add(lbgender);
        String gender[] = {"Select","Male","Female"};
        genderCombo = new JComboBox(gender);
        genderCombo.setBackground(Color.white);
        genderCombo.setBounds(200,160,120,20);
        add(genderCombo);

        lbcompany = new JLabel("Car Company");
        lbcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbcompany.setBounds(60,200,120,20);
        add(lbcompany);
        tfcompany = new JTextField();
        tfcompany.setBounds(200,200,120,20);
        add(tfcompany);

        lbmodel = new JLabel("Car model");
        lbmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbmodel.setBounds(60,240,120,20);
        add(lbmodel);
        tfmodel = new JTextField();
        tfmodel.setBounds(200,240,120,20);
        add(tfmodel);

        lbavailable = new JLabel("Available");
        lbavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbavailable.setBounds(60,280,120,20);
        add(lbavailable);
        String avCom[] = {"Select","Available","Busy"};
        avCombo = new JComboBox(avCom);
        avCombo.setBounds(200,280,120,20);
        avCombo.setBackground(Color.white);
        add(avCombo);

        lblocation = new JLabel("Location");
        lblocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblocation.setBounds(60,320,120,30);
        add(lblocation);
        tflocation = new JTextField();
        tflocation.setBounds(200,320,120,20);
        add(tflocation);

        addDriver = new JButton("Add Driver");
        addDriver.setBackground(Color.black);
        addDriver.setForeground(Color.white);
        addDriver.setBounds(60,380,130,30);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(200,380,130,30);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(250,100,900,480);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addDriver){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String) avCombo.getSelectedItem();
            String location =   tflocation.getText();
            try {
                Conn c = new Conn();
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Name");
                    return;
                }else if(name.matches(".*[0-9].*")){
                    JOptionPane.showMessageDialog(null, "Enter Valid Name");
                    return;
                }
                if(age.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Age");
                    return;
                }else if(age.matches(".*[a-zA-Z].*")){
                    JOptionPane.showMessageDialog(null, "Enter Valid Age");
                    return;
                }
                if(gender.equals("Select")){
                    JOptionPane.showMessageDialog(null, "Select gender");
                    return;
                }
                if(company.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter company");
                    return;
                }
                if(model.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter model");
                    return;
                }
                if(available.equals("Select")){
                    JOptionPane.showMessageDialog(null, "Select Availability");
                    return;
                }
                if(location.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Location");
                    return;
                }
                String query = "INSERT INTO Driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Driver successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    };
    public static void main(String[] args){
        new AddDriver() ;
    }
}
