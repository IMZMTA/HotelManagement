package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department(){
        setTitle("Department");
        setLayout(null);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(150, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget ");
        l2.setBounds(440, 10, 100, 20);
        add(l2);

        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try{
            Conn conn = new Conn();
            String query = "Select * from department";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){

            }
        }catch(Exception e){
            System.out.println(e);
        }

        back = new JButton("Back");
        back.setBounds(280, 420, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(400,200,700,500);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Department();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception().setVisible(true);
    }
}