package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room(){
        setTitle("Room");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availablity ");
        l2.setBounds(100, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(210, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price ");
        l4.setBounds(310, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed - Type");
        l5.setBounds(410, 10, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            Conn conn = new Conn();
            String query = "Select * from room";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){

            }
        }catch(Exception e){
            System.out.println(e);
        }

        back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,1050,600);
        setVisible(true);
    }

    public static void main(String[] args) {

       new Room();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception().setVisible(true);
    }
}