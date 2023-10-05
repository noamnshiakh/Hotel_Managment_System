package Hotel.Managment.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back;
    Department(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Department");
        l1.setBounds(150,10,100,20);
        add(l1);
        l2 = new JLabel("Budget");
        l2.setBounds(400,10,100,20);
        add(l2);
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from Department");
            table.setModel(DbUtils.resultSetToTableModel(q1));
        }catch (Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        setBounds(285,120,700,490);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Department();
    }
}
