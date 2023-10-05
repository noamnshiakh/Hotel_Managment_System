package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmploye,customer;
    JButton manager,chekout,update,roomStatus,pickup,searchRooms,logout;
    Reception(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(15,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(15,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(15,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);

        allEmploye = new JButton("Employee Info");
        allEmploye.setBounds(15,150,200,30);
        allEmploye.setBackground(Color.black);
        allEmploye.setForeground(Color.white);
        allEmploye.addActionListener(this);
        add(allEmploye);

        customer = new JButton("Customer Info");
        customer.setBounds(15,190,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);

        manager = new JButton("Manager Info");
        manager.setBounds(15,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);

        chekout = new JButton("Checkouts");
        chekout.setBounds(15,270,200,30);
        chekout.setBackground(Color.black);
        chekout.setForeground(Color.white);
        chekout.addActionListener(this);
        add(chekout);

        update = new JButton("Update Status");
        update.setBounds(15,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(15,350,200,30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Picup Service");
        pickup.setBounds(15,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);

        searchRooms = new JButton("Search Rooms");
        searchRooms.setBounds(15,430,200,30);
        searchRooms.setBackground(Color.black);
        searchRooms.setForeground(Color.white);
        searchRooms.addActionListener(this);
        add(searchRooms);

        logout = new JButton("Logout");
        logout.setBounds(15,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(230,80,800,570);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            new AddCustomer();
        }else if(ae.getSource() == rooms){
            new Rooms();
        }else if(ae.getSource() == department){
            new Department();
        } else if (ae.getSource() == allEmploye) {
            new EmployeeInfo();
        }else if(ae.getSource() == manager){
            new ManagerInfo();
        } else if (ae.getSource() == customer) {
            new CustomerInfo();
        } else if (ae.getSource() == searchRooms) {
            new SearchRoom();
        } else if(ae.getSource() == update) {
            new UpdateChek();
        } else if(ae.getSource() == roomStatus) {
            new UpdateRoom();
        }else if(ae.getSource() == pickup){
            new PickUp();
        } else if (ae.getSource() == chekout) {
            new CheckOut();
        }else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    };
    public static void main(String[] args){
        new Reception();
    }
}
