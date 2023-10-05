package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox comboId,comboGender;
    JLabel lbId,lbnumber,lbname,lbgender,lbdeposite,lbnatinality,lbAlocality,lbinTime,chekInTime;
    JTextField tfnumber,tfname,tfContry,tfdeposite;
    JButton add,back;
    Choice Croom;
    AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("New  Cusrtomer  Form");
        text.setBounds(80,20,200,30);
        text.setFont(new Font("Railway",Font.BOLD,15));
        add(text);

        lbId = new JLabel("ID Type");
        lbId.setBounds(30,80,150,20);
        lbId.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbId);
        String[] options = {"Select","Adhar Card","Passport","Voter-ID Card","Driving License"};
        comboId = new JComboBox(options);
        comboId.setBounds(150,80,150,20);
        add(comboId);

        lbnumber = new JLabel("Id Number");
        lbnumber.setBounds(30,120,150,20);
        lbnumber.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbnumber);
        tfnumber = new JTextField();
        tfnumber.setBounds(150,120,150,20);
        add(tfnumber);

        lbname = new JLabel("Name");
        lbname.setBounds(30,160,200,20);
        lbname.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(150,160,150,20);
        add(tfname);

        lbgender = new JLabel("Gender");
        lbgender.setBounds(30,200,150,20);
        lbgender.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbgender);
        String[] goptions = {"Select","male","female"};
        comboGender = new JComboBox(goptions);
        comboGender.setBounds(150,200,150,20);
        add(comboGender);

        lbnatinality = new JLabel("Country Name");
        lbnatinality.setBounds(30,240,150,20);
        lbnatinality.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbnatinality);
        tfContry = new JTextField();
        tfContry.setBounds(150,240,150,20);
        add(tfContry);

        lbAlocality = new JLabel("Room Number");
        lbAlocality.setBounds(30,280,100,20);
        lbAlocality.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbAlocality);
        Croom = new Choice();
        Croom.add("Select");
        try {
            Conn c = new Conn();
            String q = "select * from Room where availability = 'Available' " ;
            ResultSet rs = c.s.executeQuery(q);
            while(rs.next()){
                Croom.add(rs.getString("RoomNumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Croom.setBounds(150,280,150,20);
        add(Croom);

        lbinTime = new JLabel("Check In Time");
        lbinTime.setBounds(30,320,150,20);
        lbinTime.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbinTime);

        Date date = new Date();
        chekInTime = new JLabel(""+date);
        chekInTime.setBounds(150,320,200,20);
        chekInTime.setFont(new Font("Railway",Font.PLAIN,12));
        add(chekInTime);

        lbdeposite = new JLabel("Deposit");
        lbdeposite.setBounds(30,360,150,20);
        lbdeposite.setFont(new Font("Railway",Font.PLAIN,15));
        add(lbdeposite);
        tfdeposite = new JTextField();
        tfdeposite.setBounds(150,360,150,20);
        add(tfdeposite);

        add = new JButton("Add");
        add.setBounds(30,405,120,25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        back = new JButton("Back");
        back.setBounds(200,405,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(250,80,800,500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Add")){
        String Id = (String) comboId.getSelectedItem();
        String number = tfnumber.getText();
        String name = tfname.getText();
        String gender = (String) comboGender.getSelectedItem();
        String contry = tfContry.getText();
        String room = Croom.getSelectedItem();
        String time = chekInTime.getText();
        String deposite = tfdeposite.getText();

        try {
            if(Id.equals("Select")){
                JOptionPane.showMessageDialog(null, "Please Select Id Type");
                return;
            }
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter ID Number");
                return;
            }else{
                if(Id.equals("Adhar Card")){
                    if(number.length() != 12){
                        JOptionPane.showMessageDialog(null, "Enter Valid Adhar Number");
                        return;
                    }else if(number.matches(".*[a-zA-Z].*")){
                        JOptionPane.showMessageDialog(null, "Enter Valid Adhar Number");
                        return;
                    }
                }else if(Id.equals("Passport")){
                    if(number.length() < 8 && number.length() > 12 || number.matches(".*[ -/:-@^-`{-~].*")){
                        JOptionPane.showMessageDialog(null, "Enter Valid Passport Number");
                        return;
                    }
                }else if(Id.equals("Voter-ID Card")){
                    if(number.length() != 10){
                        JOptionPane.showMessageDialog(null, "Enter Valid Voter-ID Number");
                        return;
                    }else if(number.matches(".*[a-zA-Z].*")){
                        JOptionPane.showMessageDialog(null, "Enter Valid Voter-ID Number");
                        return;
                    }
                }else if(Id.equals("Driving License")){
                    if(number.length() != 15 || number.matches(".*[ -/:-@^-`{-~].*")){
                        JOptionPane.showMessageDialog(null, "Enter Valid Driving License Number");
                        return;
                    }
                }
            }
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Name");
                return;
            }else if(name.matches(".*[!-@^-`|-~].*")){
                JOptionPane.showMessageDialog(null, "Enter Valid Id name");
                return;
            }
            if(gender.equals("Select")){
                JOptionPane.showMessageDialog(null, "Please Select Gender");
                return;
            }
            if(contry.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Country Name");
                return;
            }else if(contry.matches(".*[!-@^-`|-~].*")){
                JOptionPane.showMessageDialog(null, "Enter Valid Country name");
                return;
            }
            if(room.equals("Select")){
                JOptionPane.showMessageDialog(null, "Please Select room");
                return;
            }
            if(deposite.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Deposit");
                return;
            }else if(deposite.matches(".*[a-zA-Z].*")){
                JOptionPane.showMessageDialog(null, "Enter Valid Deposit");
                return;
            }

            Conn c = new Conn();
            String query1 = "INSERT INTO Customer values('"+ Id +"','"+ number +"','"+name+"','"+gender+"','"+ contry+"','"+room+"','"+time+"','"+deposite+"')";
            String query2 = "update room set availability = 'Occupied' where RoomNumber = '" + room + "'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        else if(ae.getActionCommand().equals("Back")){
            setVisible(false);
            return;
        }
    };
    public static void main(String[] args){
        new AddCustomer();
    }
}
