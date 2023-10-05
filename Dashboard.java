package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(-5,0,1290,750);
        getContentPane().setBackground(Color.white);
    //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imag = new JLabel(i3);
        add(imag);
    //name lable
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(350,100,1000,50);
        text.setFont(new Font("serite",Font.BOLD,35));
        imag.add(text);
    // menu bar
        JMenuBar menu = new JMenuBar();
        menu.setBounds(0,0,1285,30);
        menu.setBackground(Color.black);
        imag.add(menu);
    // menu
        //hotel managment
        JMenu hotel = new JMenu("Hotel Managment");
        hotel.setForeground(Color.white);
        menu.add(hotel);
        //menue items
        JMenuItem reception = new JMenuItem("Receeption");
        reception.addActionListener(this);
        hotel.add(reception);
        //admin
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.white);
        menu.add(admin);
        // menu items
        JMenuItem addemployee = new JMenuItem("add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        JMenuItem addrooms = new JMenuItem("add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        JMenuItem adddrivers = new JMenuItem("add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("add Employee")){
            new AddEmployee() ;
//            setVisible(false);
        }else if(ae.getActionCommand().equals("add Rooms")){
            new AddRooms();
//            setVisible(false);
        }else if (ae.getActionCommand().equals("add Drivers")) {
            new AddDriver();
//            setVisible(false);
        }else if(ae.getActionCommand().equals("Receeption")){
            new Reception();
        }
    };
    public static void main(String[] args){
        new Dashboard();
    }
}
