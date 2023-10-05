package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        table = new JTable();
        table.setBounds(0,185,900,250);
        add(table);
        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(350,30,200,30);
        add(text);

        JLabel lbbed = new JLabel("Bed Type");
        lbbed.setBounds(50,80,100,20);
        add(lbbed);
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,80,150,25);
        bedType.setBackground(Color.white);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650,80,350,25);
        available.setBackground(Color.white);
        add(available);

        l1 = new JLabel("Room Number");
        l1.setBounds(30,155,100,20);
        add(l1);
        l2 = new JLabel("Availability");
        l2.setBounds(240,155,100,20);
        add(l2);
        l3 = new JLabel("Status");
        l3.setBounds(420,155,100,20);
        add(l3);
        l4 = new JLabel("Price");
        l4.setBounds(620,155,100,20);
        add(l4);
        l5 = new JLabel("Bed Type");
        l5.setBounds(760,155,100,20);
        add(l5);
        try{
            Conn c= new Conn();
            ResultSet q1 = c.s.executeQuery("Select * from room");
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
                String q1 = "Select * from room where bedType = '"+bedType.getSelectedItem()+"'";
                String q2 = "Select * from room where availability = 'Available'";
                Conn c = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = c.s.executeQuery(q2);
                }else{
                    rs = c.s.executeQuery(q1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
