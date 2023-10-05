package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back;
    Rooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        l1 = new JLabel("Room Number");
        l1.setBounds(5,10,100,20);
        add(l1);
        l2 = new JLabel("Availability");
        l2.setBounds(110,10,100,20);
        add(l2);
        l3 = new JLabel("Status");
        l3.setBounds(220,10,100,20);
        add(l3);
        l4 = new JLabel("Price");
        l4.setBounds(320,10,100,20);
        add(l4);
        l5 = new JLabel("Bed Type");
        l5.setBounds(420,10,100,20);
        add(l5);
        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from room");
            table.setModel(DbUtils.resultSetToTableModel(q1));
        }catch (Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(300,500,120,30);
        add(back);

        setBounds(100,80,1050,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
    public static void main(String[] args){
        new Rooms();
    }
}
