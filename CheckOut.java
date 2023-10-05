package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice Ccustomer;
    JLabel lbId,lbRoom,lbChekInTime,lbroom,lbCheckIn,lbCheckOut,lbChekOutTime;
    JButton checkOut,Back;
    CheckOut(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("CheckOut");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("tahoma",Font.BOLD,20));
        add(text);

        lbId = new JLabel("Customer Id");
        lbId.setBounds(30,80,100,30);
        add(lbId);

        Ccustomer = new Choice();
        Ccustomer.setBounds(150,80,150,25);
        add(Ccustomer);
        Ccustomer.add("Select");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);

        lbroom = new JLabel("Room Number");
        lbroom.setBounds(30,130,100,30);
        add(lbroom);
        lbRoom = new JLabel();
        lbRoom.setBounds(150,130,100,30);
        add(lbRoom);

        lbCheckIn = new JLabel("Checkin Time");
        lbCheckIn.setBounds(30,180,100,30);
        add(lbCheckIn);
        lbChekInTime = new JLabel();
        lbChekInTime.setBounds(150,180,200,30);
        add(lbChekInTime);

        lbCheckOut = new JLabel("Checkout Time");
        lbCheckOut.setBounds(30,230,100,30);
        add(lbCheckOut);
        Date date = new Date();
        lbChekOutTime = new JLabel(""+date);
        lbChekOutTime.setBounds(150,230,200,25);
        add(lbChekOutTime);

        checkOut = new JButton("Check Out");
        checkOut.setBackground(Color.black);
        checkOut.setForeground(Color.white);
        checkOut.setBounds(30,280,120,30);
        checkOut.addActionListener(this);
        add(checkOut);

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setBounds(170,280,120,30);
        Back.addActionListener(this);
        add(Back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer");
            while(rs.next()){
                Ccustomer.add(rs.getString("DocNumber"));
                lbRoom.setText(rs.getString("room"));
                lbChekInTime.setText(rs.getString("Time"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel imag = new JLabel(i6);
        imag.setBounds(350,50,400,250);
        add(imag);

        setBounds(185,150,800,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkOut) {
            String q1 = "delete from customer where DocNumber = '"+Ccustomer.getSelectedItem()+"'";
            String q2 = "update room set availability = 'Available' where RoomNumber ='"+ lbRoom.getText()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"CheckOut Done");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new CheckOut();
    }
}
