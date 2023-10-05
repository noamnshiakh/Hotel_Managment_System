package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JLabel jbroom,jbavilable,jbstatus,jbprice,jbtype;
    JTextField tfroom,tfprice;
    JButton addRoom,cancel;
    JComboBox avCombo,statCombo,typeCombo;
    AddRooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heding = new JLabel("Add  Rooms");
        heding.setForeground(Color.black);
        heding.setFont(new Font("tahoma",Font.BOLD,20));
        heding.setBounds(150,20,800,30);
        add(heding);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(800,540,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(370,80,450,300);
        add(image);

        jbroom = new JLabel("Room Number");
        jbroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        jbroom.setBounds(60,80,120,20);
        add(jbroom);
        tfroom = new JTextField();
        tfroom.setBounds(200,80,120,20);
        add(tfroom);

        jbavilable = new JLabel("Availability");
        jbavilable.setFont(new Font("Tahoma",Font.PLAIN,16));
        jbavilable.setBounds(60,130,120,20);
        add(jbavilable);
        String avOption[] = {"Select","Available","Occupied"};
        avCombo = new JComboBox(avOption);
        avCombo.setBounds(200,130,120,20);
        avCombo.setBackground(Color.white);
        add(avCombo);

        jbstatus = new JLabel("Cleaning Status");
        jbstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        jbstatus.setBounds(60,180,120,20);
        add(jbstatus);
        String stat[] = {"Select","Clean","Dirty"};
        statCombo = new JComboBox(stat);
        statCombo.setBounds(200,180,120,20);
        statCombo.setBackground(Color.white);
        add(statCombo);

        jbprice = new JLabel("Price");
        jbprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        jbprice.setBounds(60,230,120,20);
        add(jbprice);
        tfprice = new JTextField();
        tfprice.setBounds(200,230,120,20);
        add(tfprice);

        jbtype = new JLabel("Bed Type");
        jbtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        jbtype.setBounds(60,280,120,20);
        add(jbtype);
        String type[] = {"Select","Single bed","Double bed"};
        typeCombo = new JComboBox(type);
        typeCombo.setBounds(200,280,120,20);
        typeCombo.setBackground(Color.white);
        add(typeCombo);

        addRoom = new JButton("Add Room");
        addRoom.setBackground(Color.black);
        addRoom.setForeground(Color.white);
        addRoom.setBounds(60,350,130,30);
        addRoom.addActionListener(this);
        add(addRoom);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(200,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(300,100,850,480);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addRoom){
            String roomNumber = tfroom.getText();
            String availability = (String) avCombo.getSelectedItem();
            String status = (String) statCombo.getSelectedItem();
            String Price = tfprice.getText();
            String type = (String) typeCombo.getSelectedItem();

            try{
                Conn conn = new Conn();

                if(roomNumber == null){
                    JOptionPane.showMessageDialog(null, "Please Enter Room Number");
                    return;
                }else if(roomNumber.matches(".*[a-zA-Z].*")){
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Room Number");
                    return;
                }
                if(availability.equals("Select")){
                    JOptionPane.showMessageDialog(null, "Please Select Availability");
                    return;
                }
                if(status.equals("Select")){
                    JOptionPane.showMessageDialog(null, "Please Select Cleaning Status");
                    return;
                }
                if(Price.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter price");
                    return;
                }else if(Price.matches(".*[a-zA-Z].*")){
                    JOptionPane.showMessageDialog(null, "Please Enter correct price");
                    return;
                }
                if(type.equals("Select")){
                    JOptionPane.showMessageDialog(null, "Please Select Bed Type");
                    return;
                }

                String str = "insert into Room values('"+roomNumber+"','"+availability+"','"+status+"','"+Price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Success fully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
//            new Dashboard();
        }
    };
    public static void main(String[] args){
        new AddRooms() ;
    }
}
