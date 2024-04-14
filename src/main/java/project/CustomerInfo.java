package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    CustomerInfo(){
        setTitle("Customer Information");
        setLayout(null);

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(20, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number ");
        l2.setBounds(160, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(280, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender ");
        l4.setBounds(400, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country ");
        l5.setBounds(520, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Room No ");
        l6.setBounds(640, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Checking Time ");
        l7.setBounds(760, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit ");
        l8.setBounds(880, 10, 100, 20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try{
            Conn conn = new Conn();
            String query = "Select * from customer";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){

            }
        }catch(Exception e){
            System.out.println(e);
        }

        back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {

        new CustomerInfo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception().setVisible(true);
    }
}