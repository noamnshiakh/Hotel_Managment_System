package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back;
    ManagerInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        table = new JTable();
        table.setBounds(0,40,1000,470);
        add(table);

        l1 = new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        l2 = new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
        l3 = new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
        l4 = new JLabel("Job");
        l4.setBounds(420,10,100,20);
        add(l4);
        l5 = new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        l5 = new JLabel("Phone Number");
        l5.setBounds(640,10,100,20);
        add(l5);
        l5 = new JLabel("Email");
        l5.setBounds(790,10,100,20);
        add(l5);
        l5 = new JLabel("Aadhar");
        l5.setBounds(910,10,100,20);
        add(l5);

        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from Employee where job = 'Manager'");
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
        new ManagerInfo();
    }
}
