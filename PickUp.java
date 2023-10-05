package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton back,submit;
    Choice Carbrand;
    JCheckBox available;
    PickUp(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        table = new JTable();
        table.setBounds(0,185,900,250);
        add(table);
        JLabel text = new JLabel("PickUp Services");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(350,30,200,30);
        add(text);

        JLabel lbbed = new JLabel("Type Of Car");
        lbbed.setBounds(50,80,100,20);
        add(lbbed);
        Carbrand = new Choice();
        Carbrand.setBounds(150,80,200,25);
        add(Carbrand);
        Carbrand.add("Select");
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from driver");
            while(rs.next()){
                Carbrand.add(rs.getString("Model"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l1 = new JLabel("Name");
        l1.setBounds(30,155,100,20);
        add(l1);
        l2 = new JLabel("Age");
        l2.setBounds(170,155,100,20);
        add(l2);
        l3 = new JLabel("Gender");
        l3.setBounds(290,155,100,20);
        add(l3);
        l4 = new JLabel("Company");
        l4.setBounds(415,155,100,20);
        add(l4);
        l5 = new JLabel("Brand");
        l5.setBounds(560,155,100,20);
        add(l5);
        l6 = new JLabel("Availability");
        l6.setBounds(680,155,100,20);
        add(l6);
        l7 = new JLabel("Location");
        l7.setBounds(785,155,100,20);
        add(l7);
        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from Driver");
            table.setModel(DbUtils.resultSetToTableModel(q1));
        }catch (Exception e){
            e.printStackTrace();
        }
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(250,520,120,30);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);

        setBounds(200,80,900,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
        }else if(ae.getSource() == submit){
            try {
                String q1 = "Select * from Driver where Model = '"+Carbrand.getSelectedItem()+"'";
                Conn c = new Conn();
                ResultSet rs;
                rs = c.s.executeQuery(q1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new PickUp();
    }
}
