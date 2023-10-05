package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HotelMangmentSystem extends JFrame implements ActionListener {
    HotelMangmentSystem(){
        setSize(1100,565);
        setLocation(50,50);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1100,565);
        add(image);
        JLabel frame = new JLabel("HOTEL MANAGMENT SYSTEM");
        frame.setBounds(20,440,1000,40);
        image.add(frame);
        frame.setForeground(Color.white);
        frame.setFont(new Font("serite",Font.PLAIN,45));

        JButton next = new JButton("NEXT");
        next.setBounds(800,450,150,50);
        next.addActionListener(this);
        next.setBackground(Color.white);
        next.setForeground(Color.magenta);
        next.setFont(new Font("serite",Font.PLAIN,20));
        image.add(next);

        setVisible(true);
        while(true){
            frame.setVisible(false);
            try{
                Thread.sleep(350);
            }catch (Exception e){
                e.printStackTrace();
            }
            frame.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            frame.setVisible(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    };
    public static void main(String[] args){

        new HotelMangmentSystem();
    }
}
