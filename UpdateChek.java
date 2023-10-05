package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateChek extends JFrame implements ActionListener {
    Choice Ccustomer;
    JLabel lbId,lbroom,lbname,lbcheckin,lbpaid,lbpending;
    JTextField tfname,tfroom,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    UpdateChek(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update status");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        lbroom.setBounds(30,120,100,20);
        add(lbroom);
        tfroom = new JTextField();
        tfroom.setBounds(150,120,170,20);
        add(tfroom);

        lbname = new JLabel("Name");
        lbname.setBounds(30,160,100,20);
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(150,160,170,20);
        add(tfname);

        lbcheckin = new JLabel("CheckIn Time");
        lbcheckin.setBounds(30,200,100,20);
        add(lbcheckin);
        tfcheckin = new JTextField();
        tfcheckin.setBounds(150,200,170,20);
        add(tfcheckin);

        lbpaid = new JLabel("Amount Paid");
        lbpaid.setBounds(30,240,100,20);
        add(lbpaid);
        tfpaid = new JTextField();
        tfpaid.setBounds(150,240,170,20);
        add(tfpaid);

        lbpending = new JLabel("Pending Amount");
        lbpending.setBounds(30,280,100,20);
        add(lbpending);
        tfpending = new JTextField();
        tfpending.setBounds(150,280,170,20);
        add(tfpending);

        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        check.setBounds(25,340,90,30);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBounds(135,340,90,30);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(245,340,90,30);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(370,50,500,350);
        add(image);

        setBounds(245,100,930,470);
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
                    tfname.setText(rs.getString("CustomerName"));
                    tfcheckin.setText(rs.getString("Time"));
                    tfpaid.setText(rs.getString("Deposite"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from Room where RoomNumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("Price");
                    String paid = tfpaid.getText();
                    int paidAmount = Integer.parseInt(price) - Integer.parseInt(paid);
                    tfpending.setText(""+paidAmount);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            String number = Ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkIn = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try{

                Conn c = new Conn();
                c.s.executeUpdate("Update customer set Room = '"+room+"',CustomerName = '"+name+"',Time = '"+checkIn+"', Deposite = '"+deposit+"' where DocNumber = '"+number+"'");
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
        new UpdateChek();
    }
}
