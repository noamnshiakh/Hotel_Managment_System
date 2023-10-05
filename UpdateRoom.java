package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice Ccustomer;
    JLabel lbId,lbroom,lbavailable,lbstatus;
    JTextField tfavailable,tfroom,tfstatus,tfpaid,tfpending;
    JButton check,update,back;
    UpdateRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Room status");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(80,20,250,30);
        add(text);

        lbId = new JLabel("Customer ID");
        lbId.setBounds(30,80,100,30);
        add(lbId);

        Ccustomer = new Choice();
        Ccustomer.setBounds(150,80,150,25);
        add(Ccustomer);
        Ccustomer.add("Select");
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer");
            while(rs.next()){
                Ccustomer.add(rs.getString("DocNumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        lbroom = new JLabel("Room Number");
        lbroom.setBounds(30,130,100,20);
        add(lbroom);
        tfroom = new JTextField();
        tfroom.setBounds(150,130,170,20);
        add(tfroom);

        lbavailable = new JLabel("Availability");
        lbavailable.setBounds(30,180,100,20);
        add(lbavailable);
        tfavailable = new JTextField();
        tfavailable.setBounds(150,180,170,20);
        add(tfavailable);

        lbstatus = new JLabel("Cleaning Status");
        lbstatus.setBounds(30,230,100,20);
        add(lbstatus);
        tfstatus = new JTextField();
        tfstatus.setBounds(150,230,170,20);
        add(tfstatus);

        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        check.setBounds(25,280,90,30);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBounds(135,280,90,30);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(245,280,90,30);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,5,500,350);
        add(image);

        setBounds(245,100,930,430);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = Ccustomer.getSelectedItem();
            String q1 = "select * from Customer where DocNumber = '"+id+"'";
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery(q1);
                while(rs.next()){
                    tfroom.setText(rs.getString("Room"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from Room where RoomNumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("status"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            String number = Ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String availabe = tfavailable.getText();
            String status = tfstatus.getText();

            try{

                Conn c = new Conn();
                c.s.executeUpdate("Update room set availability = '"+availabe+"',status = '"+status+"' where RoomNumber = '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateRoom();
    }
}
