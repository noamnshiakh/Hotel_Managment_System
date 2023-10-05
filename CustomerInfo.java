package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        table = new JTable();
        table.setBounds(0,40,1000,470);
        add(table);

        l1 = new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        l2 = new JLabel("Doc Number");
        l2.setBounds(160,10,100,20);
        add(l2);
        l3 = new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
        l4 = new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);
        l5 = new JLabel("Country");
        l5.setBounds(510,10,100,20);
        add(l5);
        l5 = new JLabel("Room Number");
        l5.setBounds(640,10,100,20);
        add(l5);
        l5 = new JLabel("Check In Time");
        l5.setBounds(760,10,100,20);
        add(l5);
        l5 = new JLabel("Deposit");
        l5.setBounds(900,10,100,20);
        add(l5);

        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from Customer");
            table.setModel(DbUtils.resultSetToTableModel(q1));
        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        back.setBounds(440,510,120,30);
        add(back);

        setBounds(150,80,1000,600);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}
