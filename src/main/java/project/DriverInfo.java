package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class DriverInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    Choice carType;
    JCheckBox available;

    DriverInfo(){
        setTitle("PickUp");
        setLayout(null);

        JLabel text = new JLabel("PickUp Services ");
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblcar = new JLabel("Type of Car :");
        lblcar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblcar.setBounds(50, 100, 100, 20);
        add(lblcar);

        carType = new Choice();
        carType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        carType.setBounds(150, 100, 200, 25);
        add(carType);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from driver");
            while (rs.next()){
                carType.add(rs.getString("model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        available = new JCheckBox("Only display Available Rooms.");
        available.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        available.setBackground(Color.lightGray);
        available.setBounds(650, 100, 250, 20);
        add(available);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company ");
        l4.setBounds(460, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(630, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Available");
        l6.setBounds(740, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(10,180,1000,300);
        add(table);

        try{
            Conn conn = new Conn();
            String query = "Select * from driver";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){

            }
        }catch(Exception e){
            System.out.println(e);
        }

        submit = new JButton("Submit");
        submit.setBounds(350, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(530, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {

        new DriverInfo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String type = (String) carType.getSelectedItem();
            System.out.println(type);
            try{
                Conn conn = new Conn();
                String query = "Select * from driver where model = '"+type+" '";
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Reception().setVisible(true);
        }
    }
}